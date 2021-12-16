package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.f.p;
@SuppressLint({"NewApi"})
/* loaded from: classes13.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (p.a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS")) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return -1L;
        }
        return invokeV.longValue;
    }
}
