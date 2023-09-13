package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.connect.NetWorkUtils;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class wk0 implements em0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final il0 a;
    public int b;

    public wk0(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {il0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = il0Var;
    }

    @Override // com.baidu.tieba.em0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) k31.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        vk0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.em0
    public void b(long j, File file) {
        AdDownloadAction adDownloadAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            if (this.a.c == AdDownloadStatus.PAUSE) {
                adDownloadAction = AdDownloadAction.RESUME;
            } else {
                adDownloadAction = AdDownloadAction.START;
            }
            this.a.l = System.currentTimeMillis();
            il0 il0Var = this.a;
            il0Var.c = AdDownloadStatus.DOWNLOADING;
            il0Var.h = file;
            jl0 jl0Var = il0Var.q;
            jl0Var.e = j;
            jl0Var.v = true;
            vk0.c().g(adDownloadAction, this.a);
            zk0.b().update(this.a);
            zk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.em0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            vk0.c().g(AdDownloadAction.PAUSE, this.a);
            if (this.a.q.w) {
                rl0.f().i(this.a, "notify_type_pause");
            }
            zk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.em0
    public void d(@Nullable ql0 ql0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ql0Var) == null) {
            if (e(ql0Var)) {
                il0 il0Var = this.a;
                if (il0Var.c == AdDownloadStatus.PAUSE) {
                    vk0.c().m(this.a, this);
                } else {
                    il0Var.i = 0.0f;
                    il0Var.j = 0.0f;
                    vk0.c().o(this.a, this);
                }
                this.b++;
            } else {
                il0 il0Var2 = this.a;
                il0Var2.c = AdDownloadStatus.FAILED;
                il0Var2.i = 0.0f;
                il0Var2.j = 0.0f;
                vk0.c().h(AdDownloadAction.FAIL, this.a, ql0Var);
                if (this.a.q.w) {
                    rl0.f().i(this.a, "notify_type_stop");
                }
            }
            zk0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable ql0 ql0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ql0Var)) == null) {
            if (ql0Var == null || !ql0Var.c) {
                return false;
            }
            if (un0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= un0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (un0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(tj0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.em0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                il0 il0Var = this.a;
                il0Var.d = sm0.b(il0Var.h);
            }
            if (sm0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = tj0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    il0 il0Var2 = this.a;
                    il0Var2.o = packageArchiveInfo.versionName;
                    il0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                il0 il0Var3 = this.a;
                il0Var3.c = AdDownloadStatus.COMPLETED;
                il0Var3.i = 1.0f;
                il0Var3.j = 1.0f;
                vk0.c().g(AdDownloadAction.COMPLETE, this.a);
                km0.f().k(this.a);
                rl0.f().k(this.a);
                zk0.b().e(this.a);
                il0 il0Var4 = this.a;
                sm0.e(il0Var4.h, il0Var4.a());
                return;
            }
            il0 il0Var5 = this.a;
            il0Var5.c = AdDownloadStatus.FAILED;
            il0Var5.i = 0.0f;
            il0Var5.j = 0.0f;
            vk0.c().g(AdDownloadAction.FAIL, this.a);
            zk0.b().e(this.a);
        }
    }
}
