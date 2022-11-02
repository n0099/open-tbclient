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
public class zj0 implements hl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lk0 a;
    public int b;

    public zj0(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lk0Var};
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
        this.a = lk0Var;
    }

    @Override // com.baidu.tieba.hl0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) r01.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        yj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.hl0
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
            lk0 lk0Var = this.a;
            lk0Var.c = AdDownloadStatus.DOWNLOADING;
            lk0Var.h = file;
            lk0Var.q.e = j;
            yj0.b().f(adDownloadAction, this.a);
            ck0.b().update(this.a);
            ck0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.hl0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            yj0.b().f(AdDownloadAction.PAUSE, this.a);
            uk0.f().i(this.a, "notify_type_pause");
            ck0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.hl0
    public void d(@Nullable tk0 tk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tk0Var) == null) {
            if (e(tk0Var)) {
                lk0 lk0Var = this.a;
                if (lk0Var.c == AdDownloadStatus.PAUSE) {
                    yj0.b().j(this.a);
                } else {
                    lk0Var.i = 0.0f;
                    lk0Var.j = 0.0f;
                    yj0.b().k(this.a);
                }
                this.b++;
            } else {
                lk0 lk0Var2 = this.a;
                lk0Var2.c = AdDownloadStatus.FAILED;
                lk0Var2.i = 0.0f;
                lk0Var2.j = 0.0f;
                yj0.b().g(AdDownloadAction.FAIL, this.a, tk0Var);
                uk0.f().i(this.a, "notify_type_stop");
            }
            ck0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable tk0 tk0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tk0Var)) == null) {
            if (tk0Var == null || !tk0Var.c) {
                return false;
            }
            if (qm0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= qm0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (qm0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(zi0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.hl0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                lk0 lk0Var = this.a;
                lk0Var.d = pl0.b(lk0Var.h);
            }
            if (pl0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = zi0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    lk0 lk0Var2 = this.a;
                    lk0Var2.o = packageArchiveInfo.versionName;
                    lk0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                lk0 lk0Var3 = this.a;
                lk0Var3.c = AdDownloadStatus.COMPLETED;
                lk0Var3.i = 1.0f;
                lk0Var3.j = 1.0f;
                yj0.b().f(AdDownloadAction.COMPLETE, this.a);
                nl0.f().k(this.a);
                uk0.f().k(this.a);
                ck0.b().e(this.a);
                lk0 lk0Var4 = this.a;
                pl0.e(lk0Var4.h, lk0Var4.a());
                return;
            }
            lk0 lk0Var5 = this.a;
            lk0Var5.c = AdDownloadStatus.FAILED;
            lk0Var5.i = 0.0f;
            lk0Var5.j = 0.0f;
            yj0.b().f(AdDownloadAction.FAIL, this.a);
            ck0.b().e(this.a);
        }
    }
}
