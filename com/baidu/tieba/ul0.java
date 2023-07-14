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
public class ul0 implements cn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gm0 a;
    public int b;

    public ul0(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gm0Var};
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
        this.a = gm0Var;
    }

    @Override // com.baidu.tieba.cn0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) a41.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        tl0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.cn0
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
            gm0 gm0Var = this.a;
            gm0Var.c = AdDownloadStatus.DOWNLOADING;
            gm0Var.h = file;
            hm0 hm0Var = gm0Var.q;
            hm0Var.e = j;
            hm0Var.v = true;
            tl0.c().g(adDownloadAction, this.a);
            xl0.b().update(this.a);
            xl0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.cn0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            tl0.c().g(AdDownloadAction.PAUSE, this.a);
            pm0.f().i(this.a, "notify_type_pause");
            xl0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.cn0
    public void d(@Nullable om0 om0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, om0Var) == null) {
            if (e(om0Var)) {
                gm0 gm0Var = this.a;
                if (gm0Var.c == AdDownloadStatus.PAUSE) {
                    tl0.c().l(this.a);
                } else {
                    gm0Var.i = 0.0f;
                    gm0Var.j = 0.0f;
                    tl0.c().m(this.a);
                }
                this.b++;
            } else {
                gm0 gm0Var2 = this.a;
                gm0Var2.c = AdDownloadStatus.FAILED;
                gm0Var2.i = 0.0f;
                gm0Var2.j = 0.0f;
                tl0.c().h(AdDownloadAction.FAIL, this.a, om0Var);
                pm0.f().i(this.a, "notify_type_stop");
            }
            xl0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable om0 om0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, om0Var)) == null) {
            if (om0Var == null || !om0Var.c) {
                return false;
            }
            if (so0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= so0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (so0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(rk0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cn0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                gm0 gm0Var = this.a;
                gm0Var.d = qn0.b(gm0Var.h);
            }
            if (qn0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = rk0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    gm0 gm0Var2 = this.a;
                    gm0Var2.o = packageArchiveInfo.versionName;
                    gm0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                gm0 gm0Var3 = this.a;
                gm0Var3.c = AdDownloadStatus.COMPLETED;
                gm0Var3.i = 1.0f;
                gm0Var3.j = 1.0f;
                tl0.c().g(AdDownloadAction.COMPLETE, this.a);
                in0.f().k(this.a);
                pm0.f().k(this.a);
                xl0.b().e(this.a);
                gm0 gm0Var4 = this.a;
                qn0.e(gm0Var4.h, gm0Var4.a());
                return;
            }
            gm0 gm0Var5 = this.a;
            gm0Var5.c = AdDownloadStatus.FAILED;
            gm0Var5.i = 0.0f;
            gm0Var5.j = 0.0f;
            tl0.c().g(AdDownloadAction.FAIL, this.a);
            xl0.b().e(this.a);
        }
    }
}
