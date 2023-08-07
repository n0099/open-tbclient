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
public class sk0 implements am0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final el0 a;
    public int b;

    public sk0(@NonNull el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {el0Var};
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
        this.a = el0Var;
    }

    @Override // com.baidu.tieba.am0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) d31.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        rk0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.am0
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
            el0 el0Var = this.a;
            el0Var.c = AdDownloadStatus.DOWNLOADING;
            el0Var.h = file;
            fl0 fl0Var = el0Var.q;
            fl0Var.e = j;
            fl0Var.v = true;
            rk0.c().g(adDownloadAction, this.a);
            vk0.b().update(this.a);
            vk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.am0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            rk0.c().g(AdDownloadAction.PAUSE, this.a);
            nl0.f().i(this.a, "notify_type_pause");
            vk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.am0
    public void d(@Nullable ml0 ml0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ml0Var) == null) {
            if (e(ml0Var)) {
                el0 el0Var = this.a;
                if (el0Var.c == AdDownloadStatus.PAUSE) {
                    rk0.c().l(this.a);
                } else {
                    el0Var.i = 0.0f;
                    el0Var.j = 0.0f;
                    rk0.c().m(this.a);
                }
                this.b++;
            } else {
                el0 el0Var2 = this.a;
                el0Var2.c = AdDownloadStatus.FAILED;
                el0Var2.i = 0.0f;
                el0Var2.j = 0.0f;
                rk0.c().h(AdDownloadAction.FAIL, this.a, ml0Var);
                nl0.f().i(this.a, "notify_type_stop");
            }
            vk0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable ml0 ml0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ml0Var)) == null) {
            if (ml0Var == null || !ml0Var.c) {
                return false;
            }
            if (qn0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= qn0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (qn0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(pj0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.am0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                el0 el0Var = this.a;
                el0Var.d = om0.b(el0Var.h);
            }
            if (om0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = pj0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    el0 el0Var2 = this.a;
                    el0Var2.o = packageArchiveInfo.versionName;
                    el0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                el0 el0Var3 = this.a;
                el0Var3.c = AdDownloadStatus.COMPLETED;
                el0Var3.i = 1.0f;
                el0Var3.j = 1.0f;
                rk0.c().g(AdDownloadAction.COMPLETE, this.a);
                gm0.f().k(this.a);
                nl0.f().k(this.a);
                vk0.b().e(this.a);
                el0 el0Var4 = this.a;
                om0.e(el0Var4.h, el0Var4.a());
                return;
            }
            el0 el0Var5 = this.a;
            el0Var5.c = AdDownloadStatus.FAILED;
            el0Var5.i = 0.0f;
            el0Var5.j = 0.0f;
            rk0.c().g(AdDownloadAction.FAIL, this.a);
            vk0.b().e(this.a);
        }
    }
}
