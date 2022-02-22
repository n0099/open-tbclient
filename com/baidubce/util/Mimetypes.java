package com.baidubce.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/* loaded from: classes3.dex */
public class Mimetypes {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static Mimetypes mimetypes;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> extensionToMimetypeMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-677395017, "Lcom/baidubce/util/Mimetypes;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-677395017, "Lcom/baidubce/util/Mimetypes;");
        }
    }

    public Mimetypes() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.extensionToMimetypeMap = new HashMap<>();
    }

    public static synchronized Mimetypes getInstance() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (Mimetypes.class) {
                if (mimetypes != null) {
                    return mimetypes;
                }
                Mimetypes mimetypes2 = new Mimetypes();
                mimetypes = mimetypes2;
                InputStream resourceAsStream = mimetypes2.getClass().getResourceAsStream("/mime.types");
                if (resourceAsStream != null) {
                    BLog.debug("Loading mime types from file in the classpath: mime.types");
                    try {
                        mimetypes.loadAndReplaceMimetypes(resourceAsStream);
                    } catch (IOException e2) {
                        BLog.error("Failed to load mime types from file in the classpath: mime.types", (Throwable) e2);
                        try {
                            resourceAsStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            str = "";
                            BLog.debug(str, (Throwable) e);
                            return mimetypes;
                        }
                    }
                    try {
                        resourceAsStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        str = "";
                        BLog.debug(str, (Throwable) e);
                        return mimetypes;
                    }
                } else {
                    BLog.warn("Unable to find 'mime.types' file in classpath");
                }
                return mimetypes;
            }
        }
        return (Mimetypes) invokeV.objValue;
    }

    public String getMimetype(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf > 0 && (i2 = lastIndexOf + 1) < str.length()) {
                String lowerCase = str.substring(i2).toLowerCase();
                if (this.extensionToMimetypeMap.keySet().contains(lowerCase)) {
                    String str2 = this.extensionToMimetypeMap.get(lowerCase);
                    BLog.debug("Recognised extension '" + lowerCase + "', mimetype is: '" + str2 + "'");
                    return str2;
                }
                BLog.debug("Extension '" + lowerCase + "' is unrecognized in mime type listing, using default mime type: 'application/octet-stream'");
            } else {
                BLog.debug("File name has no extension, mime type cannot be recognised for: " + str);
            }
            return "application/octet-stream";
        }
        return (String) invokeL.objValue;
    }

    public void loadAndReplaceMimetypes(InputStream inputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) != null) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            String trim = readLine.trim();
            if (!trim.startsWith("#") && trim.length() != 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(trim, " \t");
                if (stringTokenizer.countTokens() > 1) {
                    String nextToken = stringTokenizer.nextToken();
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken2 = stringTokenizer.nextToken();
                        this.extensionToMimetypeMap.put(nextToken2.toLowerCase(), nextToken);
                        BLog.debug("Setting mime type for extension '" + nextToken2.toLowerCase() + "' to '" + nextToken + "'");
                    }
                } else {
                    BLog.debug("Ignoring mimetype with no associated file extensions: '" + trim + "'");
                }
            }
        }
    }

    public String getMimetype(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? getMimetype(file.getName()) : (String) invokeL.objValue;
    }
}
