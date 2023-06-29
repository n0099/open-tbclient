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
/* loaded from: classes7.dex */
public class rl0 implements zm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dm0 a;
    public int b;

    public rl0(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dm0Var};
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
        this.a = dm0Var;
    }

    @Override // com.baidu.tieba.zm0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) e31.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        ql0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.zm0
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
            dm0 dm0Var = this.a;
            dm0Var.c = AdDownloadStatus.DOWNLOADING;
            dm0Var.h = file;
            dm0Var.q.e = j;
            ql0.b().f(adDownloadAction, this.a);
            ul0.b().update(this.a);
            ul0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.zm0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            ql0.b().f(AdDownloadAction.PAUSE, this.a);
            mm0.f().i(this.a, "notify_type_pause");
            ul0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.zm0
    public void d(@Nullable lm0 lm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lm0Var) == null) {
            if (e(lm0Var)) {
                dm0 dm0Var = this.a;
                if (dm0Var.c == AdDownloadStatus.PAUSE) {
                    ql0.b().j(this.a);
                } else {
                    dm0Var.i = 0.0f;
                    dm0Var.j = 0.0f;
                    ql0.b().k(this.a);
                }
                this.b++;
            } else {
                dm0 dm0Var2 = this.a;
                dm0Var2.c = AdDownloadStatus.FAILED;
                dm0Var2.i = 0.0f;
                dm0Var2.j = 0.0f;
                ql0.b().g(AdDownloadAction.FAIL, this.a, lm0Var);
                mm0.f().i(this.a, "notify_type_stop");
            }
            ul0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable lm0 lm0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lm0Var)) == null) {
            if (lm0Var == null || !lm0Var.c) {
                return false;
            }
            if (io0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= io0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (io0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(ok0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zm0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                dm0 dm0Var = this.a;
                dm0Var.d = hn0.b(dm0Var.h);
            }
            if (hn0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = ok0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    dm0 dm0Var2 = this.a;
                    dm0Var2.o = packageArchiveInfo.versionName;
                    dm0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                dm0 dm0Var3 = this.a;
                dm0Var3.c = AdDownloadStatus.COMPLETED;
                dm0Var3.i = 1.0f;
                dm0Var3.j = 1.0f;
                ql0.b().f(AdDownloadAction.COMPLETE, this.a);
                fn0.f().k(this.a);
                mm0.f().k(this.a);
                ul0.b().e(this.a);
                dm0 dm0Var4 = this.a;
                hn0.e(dm0Var4.h, dm0Var4.a());
                return;
            }
            dm0 dm0Var5 = this.a;
            dm0Var5.c = AdDownloadStatus.FAILED;
            dm0Var5.i = 0.0f;
            dm0Var5.j = 0.0f;
            ql0.b().f(AdDownloadAction.FAIL, this.a);
            ul0.b().e(this.a);
        }
    }
}
