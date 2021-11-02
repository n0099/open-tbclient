package com.baidu.webkit.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import java.io.File;
/* loaded from: classes11.dex */
public class UtilsBlink implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEX_FILE_SUBFIX = ".dex";
    public static final String TAG = "UtilsBlink";
    public static final byte VER_TYPE_SEPARATOR = 45;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilsBlink() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean createDownloadLibPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            getDataPath(context).length();
            File file = new File(getDownloadLibPath(context));
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"SdCardPath"})
    public static String getDataPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                return filesDir.getParent();
            }
            return "/data/data/" + context.getPackageName() + "/";
        }
        return (String) invokeL.objValue;
    }

    public static String getDownloadLibPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String filesPath = getFilesPath(context);
            if (filesPath != null) {
                return filesPath + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"SdCardPath"})
    public static String getFilesPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                return filesDir.getAbsolutePath();
            }
            return "/data/data/" + context.getPackageName() + "/files/";
        }
        return (String) invokeL.objValue;
    }
}
