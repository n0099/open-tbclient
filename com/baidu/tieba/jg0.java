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
/* loaded from: classes6.dex */
public class jg0 implements rh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vg0 a;
    public int b;

    public jg0(@NonNull vg0 vg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vg0Var};
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
        this.a = vg0Var;
    }

    @Override // com.baidu.tieba.rh0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) ny0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        ig0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.rh0
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
            vg0 vg0Var = this.a;
            vg0Var.c = AdDownloadStatus.DOWNLOADING;
            vg0Var.h = file;
            wg0 wg0Var = vg0Var.q;
            wg0Var.e = j;
            wg0Var.v = true;
            ig0.c().g(adDownloadAction, this.a);
            mg0.b().g(this.a);
            mg0.b().f(this.a);
        }
    }

    @Override // com.baidu.tieba.rh0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            ig0.c().g(AdDownloadAction.PAUSE, this.a);
            if (this.a.q.w) {
                eh0.f().i(this.a, "notify_type_pause");
            }
            mg0.b().f(this.a);
        }
    }

    @Override // com.baidu.tieba.rh0
    public void d(@Nullable dh0 dh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dh0Var) == null) {
            if (e(dh0Var)) {
                vg0 vg0Var = this.a;
                if (vg0Var.c == AdDownloadStatus.PAUSE) {
                    ig0.c().m(this.a, this);
                } else {
                    vg0Var.i = 0.0f;
                    vg0Var.j = 0.0f;
                    ig0.c().o(this.a, this);
                }
                this.b++;
            } else {
                vg0 vg0Var2 = this.a;
                vg0Var2.c = AdDownloadStatus.FAILED;
                vg0Var2.i = 0.0f;
                vg0Var2.j = 0.0f;
                ig0.c().h(AdDownloadAction.FAIL, this.a, dh0Var);
                if (this.a.q.w) {
                    eh0.f().i(this.a, "notify_type_stop");
                }
            }
            mg0.b().f(this.a);
        }
    }

    public final boolean e(@Nullable dh0 dh0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dh0Var)) == null) {
            if (dh0Var == null || !dh0Var.c) {
                return false;
            }
            if (hj0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= hj0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (hj0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(gf0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rh0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                vg0 vg0Var = this.a;
                vg0Var.d = fi0.b(vg0Var.h);
            }
            if (fi0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = gf0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    vg0 vg0Var2 = this.a;
                    vg0Var2.o = packageArchiveInfo.versionName;
                    vg0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                vg0 vg0Var3 = this.a;
                vg0Var3.c = AdDownloadStatus.COMPLETED;
                vg0Var3.i = 1.0f;
                vg0Var3.j = 1.0f;
                ig0.c().g(AdDownloadAction.COMPLETE, this.a);
                xh0.f().k(this.a);
                eh0.f().k(this.a);
                mg0.b().f(this.a);
                vg0 vg0Var4 = this.a;
                fi0.e(vg0Var4.h, vg0Var4.a());
                return;
            }
            vg0 vg0Var5 = this.a;
            vg0Var5.c = AdDownloadStatus.FAILED;
            vg0Var5.i = 0.0f;
            vg0Var5.j = 0.0f;
            ig0.c().g(AdDownloadAction.FAIL, this.a);
            mg0.b().f(this.a);
        }
    }
}
