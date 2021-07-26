package com.bytedance.sdk.component.image;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class CacheConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f28828a;

    /* renamed from: b  reason: collision with root package name */
    public int f28829b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28830c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28831d;

    /* renamed from: e  reason: collision with root package name */
    public File f28832e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheConfig(int i2, long j, File file) {
        this(i2, j, i2 != 0, j != 0, file);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Long) objArr2[1]).longValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), (File) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    public static CacheConfig getDefault(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? new CacheConfig(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, Math.max(a() / 16, (long) Config.FULL_TRACE_LOG_LIMIT), new File(context.getFilesDir(), "image")) : (CacheConfig) invokeL.objValue;
    }

    public File getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28832e : (File) invokeV.objValue;
    }

    public long getFileCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28828a : invokeV.longValue;
    }

    public int getMemoryCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28829b : invokeV.intValue;
    }

    public boolean isDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28831d : invokeV.booleanValue;
    }

    public boolean isMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28830c : invokeV.booleanValue;
    }

    public void setCacheDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, file) == null) {
            this.f28832e = file;
        }
    }

    public void setDiskCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f28831d = z;
        }
    }

    public void setFileCacheSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f28828a = j;
        }
    }

    public void setMemoryCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f28830c = z;
        }
    }

    public void setMemoryCacheSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f28829b = i2;
        }
    }

    public CacheConfig(int i2, long j, boolean z, boolean z2, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28828a = j;
        this.f28829b = i2;
        this.f28830c = z;
        this.f28831d = z2;
        this.f28832e = file;
    }
}
