package com.bytedance.pangle.helper;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import java.io.File;
@Keep
/* loaded from: classes11.dex */
public class PluginDirHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VERSION_PREFIX = "version-";
    public static File sBaseDir;
    public static File sPluginDir;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(178012998, "Lcom/bytedance/pangle/helper/PluginDirHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(178012998, "Lcom/bytedance/pangle/helper/PluginDirHelper;");
        }
    }

    public PluginDirHelper() {
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

    public static String buildPath(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, strArr)) == null) {
            init();
            File file = sBaseDir;
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        file = new File(file, str);
                    }
                }
            }
            return ensureDirExists(file);
        }
        return (String) invokeL.objValue;
    }

    public static String ensureDirExists(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file != null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file.getPath();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getBaseDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            init();
            return sBaseDir.getPath();
        }
        return (String) invokeV.objValue;
    }

    public static String getDalvikCacheDir(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) ? buildPath(str, VERSION_PREFIX.concat(String.valueOf(i2)), "dalvik-cache") : (String) invokeLI.objValue;
    }

    public static String getDataDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? buildPath(str, "data") : (String) invokeL.objValue;
    }

    public static String getDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            Application appApplication = Zeus.getAppApplication();
            if (sPluginDir == null) {
                File filesDir = appApplication.getFilesDir();
                sPluginDir = new File(filesDir, "." + ZeusConstants.BASE_LIB_NAME + "_d");
            }
            return ensureDirExists(sPluginDir);
        }
        return (String) invokeV.objValue;
    }

    public static String getNativeLibraryDir(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) ? buildPath(str, VERSION_PREFIX.concat(String.valueOf(i2)), "lib") : (String) invokeLI.objValue;
    }

    public static String getPackageDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? buildPath(str) : (String) invokeL.objValue;
    }

    public static String getPackageVersionDir(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i2)) == null) ? buildPath(str, VERSION_PREFIX.concat(String.valueOf(i2))) : (String) invokeLI.objValue;
    }

    public static String getPushDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            Application appApplication = Zeus.getAppApplication();
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File externalFilesDir = appApplication.getExternalFilesDir("." + ZeusConstants.BASE_LIB_NAME + "_d");
                    if (externalFilesDir != null) {
                        return ensureDirExists(externalFilesDir);
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getSourceFile(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, str, i2)) == null) ? new File(buildPath(str, VERSION_PREFIX.concat(String.valueOf(i2)), "apk"), "base-1.apk").getPath() : (String) invokeLI.objValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, null) == null) && sBaseDir == null) {
            File filesDir = Zeus.getAppApplication().getFilesDir();
            File file = new File(filesDir, ZeusConstants.BASE_LIB_NAME + "_p");
            sBaseDir = file;
            ensureDirExists(file);
        }
    }

    public static boolean isPackageVersionDirExists(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, str, i2)) == null) {
            return new File(getBaseDir() + File.separator + str + File.separator + VERSION_PREFIX + i2).exists();
        }
        return invokeLI.booleanValue;
    }

    public static void setPluginDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, file) == null) {
            sPluginDir = file;
        }
    }
}
