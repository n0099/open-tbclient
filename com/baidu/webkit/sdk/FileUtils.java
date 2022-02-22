package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
/* loaded from: classes3.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FileUtils";
    public static String sFileRwErrorDetail;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2038722630, "Lcom/baidu/webkit/sdk/FileUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2038722630, "Lcom/baidu/webkit/sdk/FileUtils;");
                return;
            }
        }
        try {
            System.loadLibrary("zeuslzma");
        } catch (Throwable th) {
            Log.e("FileUtils", "failed to load lzma library: ".concat(String.valueOf(th)));
        }
        sFileRwErrorDetail = "none";
    }

    public FileUtils() {
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

    public static String checkTimestamp(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            if (str == null) {
                return str2;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo == null) {
                    return str2;
                }
                return checkTimestamp(str, str2, packageInfo.versionCode + "-" + packageInfo.lastUpdateTime);
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return str2;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String checkTimestamp(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            String str4 = str2 + str3;
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (list = file.list(new FilenameFilter(str2) { // from class: com.baidu.webkit.sdk.FileUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$prefix;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$prefix = str2;
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str5) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, str5)) == null) ? str5.startsWith(this.val$prefix) : invokeLL.booleanValue;
                }
            })) != null) {
                for (int i2 = 0; i2 < list.length; i2++) {
                    if (str4.equals(list[i2])) {
                        return null;
                    }
                    new File(file, list[i2]).delete();
                }
                return str4;
            }
            return str4;
        }
        return (String) invokeLLL.objValue;
    }

    public static void clearTimestamp(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2) == null) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String[] list = file.list(new FilenameFilter(str2) { // from class: com.baidu.webkit.sdk.FileUtils.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$prefix;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$prefix = str2;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str3) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, str3)) == null) ? str3.startsWith(this.val$prefix) : invokeLL.booleanValue;
                    }
                });
                for (String str3 : list) {
                    new File(file, str3).delete();
                }
            }
        }
    }

    public static boolean copyFile(String str, String str2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65541, null, str, str2)) != null) {
            return invokeLL.booleanValue;
        }
        byte[] bArr = new byte[4096];
        if (str == null || str2 == null) {
            setFileRwErrorDetail("copy file fail, from = " + str + ", to = " + str2);
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && !file.isDirectory() && !file2.isDirectory()) {
                if (!file2.exists() && (parentFile = file2.getParentFile()) != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    setFileRwErrorDetail("cannot mkdirs, path = " + parentFile.getAbsolutePath());
                    return false;
                }
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                    while (true) {
                        try {
                            int read = fileInputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable th) {
                            fileInputStream = fileInputStream2;
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            try {
                                setFileRwErrorDetail(th.toString());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return false;
                                    } catch (Throwable unused2) {
                                        return false;
                                    }
                                }
                                return false;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                            }
                        }
                    }
                    fileInputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable unused5) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                }
            }
            setFileRwErrorDetail("copy file fail, fileFrom.exists = " + file.exists() + ", fileFrom.isDirectory = " + file.isDirectory() + ", fileTo.isDirectory = " + file2.isDirectory());
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean deleteDir(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, file, file2)) == null) {
            if (file == null) {
                return false;
            }
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    if (!deleteDir(new File(file, str), file2)) {
                        return false;
                    }
                }
            }
            if (file.equals(file2)) {
                return true;
            }
            return file.delete();
        }
        return invokeLL.booleanValue;
    }

    public static String getFileRwErrorDetailAndReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = sFileRwErrorDetail;
            sFileRwErrorDetail = "none";
            return str == null ? "none" : str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean link(String str, String str2) {
        InterceptResult invokeLL;
        File parentFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            File file = new File(str2);
            return (file.isDirectory() || str2 == null || ((parentFile = file.getParentFile()) != null && !parentFile.exists() && !parentFile.mkdirs()) || nativeSymlink(str, str2) != 0) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static native int nativeSymlink(String str, String str2);

    public static void setFileRwErrorDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            sFileRwErrorDetail = str;
        }
    }
}
