package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
/* loaded from: classes13.dex */
public final class StorageUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String TAG = "StorageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-67925524, "Lcom/baidu/wallet/base/iddetect/utils/StorageUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-67925524, "Lcom/baidu/wallet/base/iddetect/utils/StorageUtils;");
        }
    }

    public StorageUtils() {
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

    public static File getCacheDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            File file = new File(context.getCacheDir(), "idcard_cache");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static File getExternalCacheDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    LogUtil.d(TAG, "Unable to create external cache directory");
                    return null;
                }
                try {
                    new File(file, ".nomedia").createNewFile();
                } catch (IOException unused) {
                    LogUtil.d(TAG, "Can't create \".nomedia\" file in application external cache directory");
                }
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? PermissionManager.checkCallingPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") : invokeL.booleanValue;
    }

    public static File getCacheDirectory(Context context, boolean z) {
        String str;
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (NullPointerException unused) {
                str = "";
            }
            File externalCacheDir = (z && "mounted".equals(str) && hasExternalStoragePermission(context)) ? getExternalCacheDir(context) : null;
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir == null) {
                String str2 = "/data/data/" + context.getPackageName() + "/cache/";
                LogUtil.d(TAG, "Can't define system cache directory! " + str2 + "will be used.");
                return new File(str2);
            }
            return externalCacheDir;
        }
        return (File) invokeLZ.objValue;
    }
}
