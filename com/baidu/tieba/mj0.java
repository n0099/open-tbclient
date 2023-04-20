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
/* loaded from: classes5.dex */
public class mj0 implements uk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yj0 a;
    public int b;

    public mj0(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yj0Var};
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
        this.a = yj0Var;
    }

    @Override // com.baidu.tieba.uk0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) z01.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        lj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.uk0
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
            yj0 yj0Var = this.a;
            yj0Var.c = AdDownloadStatus.DOWNLOADING;
            yj0Var.h = file;
            yj0Var.q.e = j;
            lj0.b().f(adDownloadAction, this.a);
            pj0.b().update(this.a);
            pj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.uk0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            lj0.b().f(AdDownloadAction.PAUSE, this.a);
            hk0.f().i(this.a, "notify_type_pause");
            pj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.uk0
    public void d(@Nullable gk0 gk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gk0Var) == null) {
            if (e(gk0Var)) {
                yj0 yj0Var = this.a;
                if (yj0Var.c == AdDownloadStatus.PAUSE) {
                    lj0.b().j(this.a);
                } else {
                    yj0Var.i = 0.0f;
                    yj0Var.j = 0.0f;
                    lj0.b().k(this.a);
                }
                this.b++;
            } else {
                yj0 yj0Var2 = this.a;
                yj0Var2.c = AdDownloadStatus.FAILED;
                yj0Var2.i = 0.0f;
                yj0Var2.j = 0.0f;
                lj0.b().g(AdDownloadAction.FAIL, this.a, gk0Var);
                hk0.f().i(this.a, "notify_type_stop");
            }
            pj0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable gk0 gk0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gk0Var)) == null) {
            if (gk0Var == null || !gk0Var.c) {
                return false;
            }
            if (dm0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= dm0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (dm0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(ji0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.uk0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                yj0 yj0Var = this.a;
                yj0Var.d = cl0.b(yj0Var.h);
            }
            if (cl0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = ji0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    yj0 yj0Var2 = this.a;
                    yj0Var2.o = packageArchiveInfo.versionName;
                    yj0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                yj0 yj0Var3 = this.a;
                yj0Var3.c = AdDownloadStatus.COMPLETED;
                yj0Var3.i = 1.0f;
                yj0Var3.j = 1.0f;
                lj0.b().f(AdDownloadAction.COMPLETE, this.a);
                al0.f().k(this.a);
                hk0.f().k(this.a);
                pj0.b().e(this.a);
                yj0 yj0Var4 = this.a;
                cl0.e(yj0Var4.h, yj0Var4.a());
                return;
            }
            yj0 yj0Var5 = this.a;
            yj0Var5.c = AdDownloadStatus.FAILED;
            yj0Var5.i = 0.0f;
            yj0Var5.j = 0.0f;
            lj0.b().f(AdDownloadAction.FAIL, this.a);
            pj0.b().e(this.a);
        }
    }
}
