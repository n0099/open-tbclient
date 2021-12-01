package com.baidubce.util;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.Protocol;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes12.dex */
public class HttpUtils {
    public static /* synthetic */ Interceptable $ic;
    public static boolean HTTP_VERBOSE;
    public static String[] PERCENT_ENCODED_STRINGS;
    public static BitSet URI_UNRESERVED_CHARACTERS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1493063155, "Lcom/baidubce/util/HttpUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1493063155, "Lcom/baidubce/util/HttpUtils;");
                return;
            }
        }
        URI_UNRESERVED_CHARACTERS = new BitSet();
        PERCENT_ENCODED_STRINGS = new String[256];
        HTTP_VERBOSE = Boolean.parseBoolean(System.getProperty("bce.sdk.http", "false"));
        for (int i2 = 97; i2 <= 122; i2++) {
            URI_UNRESERVED_CHARACTERS.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            URI_UNRESERVED_CHARACTERS.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            URI_UNRESERVED_CHARACTERS.set(i4);
        }
        URI_UNRESERVED_CHARACTERS.set(45);
        URI_UNRESERVED_CHARACTERS.set(46);
        URI_UNRESERVED_CHARACTERS.set(95);
        URI_UNRESERVED_CHARACTERS.set(126);
        int i5 = 0;
        while (true) {
            String[] strArr = PERCENT_ENCODED_STRINGS;
            if (i5 >= strArr.length) {
                return;
            }
            strArr[i5] = String.format("%%%02X", Integer.valueOf(i5));
            i5++;
        }
    }

    public HttpUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static URI appendUri(URI uri, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uri, strArr)) == null) {
            StringBuilder sb = new StringBuilder(uri.toASCIIString());
            for (String str : strArr) {
                if (str != null && str.length() > 0) {
                    String normalizePath = normalizePath(str);
                    if (normalizePath.startsWith("/")) {
                        if (sb.charAt(sb.length() - 1) == '/') {
                            sb.setLength(sb.length() - 1);
                        }
                    } else if (sb.charAt(sb.length() - 1) != '/') {
                        sb.append('/');
                    }
                    sb.append(normalizePath);
                }
            }
            try {
                return new URI(sb.toString());
            } catch (URISyntaxException e2) {
                throw new RuntimeException("Unexpected error", e2);
            }
        }
        return (URI) invokeLL.objValue;
    }

    public static String generateHostHeader(URI uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            String host = uri.getHost();
            if (isUsingNonDefaultPort(uri)) {
                return host + ":" + uri.getPort();
            }
            return host;
        }
        return (String) invokeL.objValue;
    }

    public static String getCanonicalQueryString(Map<String, String> map, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, map, z)) == null) {
            if (map.isEmpty()) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!z || !"Authorization".equalsIgnoreCase(entry.getKey())) {
                    String key = entry.getKey();
                    CheckUtils.isNotNull(key, "parameter key should not be null");
                    String value = entry.getValue();
                    if (value != null) {
                        arrayList.add(normalize(key) + a.f31351h + normalize(value));
                    } else if (z) {
                        arrayList.add(normalize(key) + a.f31351h);
                    } else {
                        arrayList.add(normalize(key));
                    }
                }
            }
            Collections.sort(arrayList);
            return JoinerUtils.on("&", arrayList);
        }
        return (String) invokeLZ.objValue;
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            String lowerCase = uri.getScheme().toLowerCase();
            int port = uri.getPort();
            if (port <= 0) {
                return false;
            }
            return lowerCase.equals(Protocol.HTTP.toString()) ? port != Protocol.HTTP.getDefaultPort() : lowerCase.equals(Protocol.HTTPS.toString()) && port != Protocol.HTTPS.getDefaultPort();
        }
        return invokeL.booleanValue;
    }

    public static String normalize(String str) {
        InterceptResult invokeL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (StringUtils.isEmpty(str)) {
                return "";
            }
            try {
                StringBuilder sb = new StringBuilder();
                for (byte b2 : str.getBytes("UTF-8")) {
                    int i2 = b2 & 255;
                    if (URI_UNRESERVED_CHARACTERS.get(i2)) {
                        sb.append((char) b2);
                    } else {
                        sb.append(PERCENT_ENCODED_STRINGS[i2]);
                    }
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String normalizePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? normalize(str).replace("%2F", "/") : (String) invokeL.objValue;
    }

    public static void printRequest(Request request) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, request) == null) && HTTP_VERBOSE) {
            BLog.info("\n-------------> ");
            BLog.info(request.method() + " " + request.url() + "");
            Headers headers = request.headers();
            for (int i2 = 0; i2 < headers.size(); i2++) {
                BLog.info(headers.name(i2) + ":" + headers.value(i2));
            }
        }
    }

    public static void printResponse(Response response) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, response) == null) && HTTP_VERBOSE) {
            BLog.info("\n<------------- ");
            BLog.info(response.code() + " - " + response.message());
            Headers headers = response.headers();
            for (int i2 = 0; i2 < headers.size(); i2++) {
                BLog.info(headers.name(i2) + ":" + headers.value(i2));
            }
        }
    }
}
