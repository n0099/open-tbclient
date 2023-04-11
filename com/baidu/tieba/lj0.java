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
public class lj0 implements tk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xj0 a;
    public int b;

    public lj0(@NonNull xj0 xj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xj0Var};
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
        this.a = xj0Var;
    }

    @Override // com.baidu.tieba.tk0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) y01.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        kj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.tk0
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
            xj0 xj0Var = this.a;
            xj0Var.c = AdDownloadStatus.DOWNLOADING;
            xj0Var.h = file;
            xj0Var.q.e = j;
            kj0.b().f(adDownloadAction, this.a);
            oj0.b().update(this.a);
            oj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.tk0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            kj0.b().f(AdDownloadAction.PAUSE, this.a);
            gk0.f().i(this.a, "notify_type_pause");
            oj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.tk0
    public void d(@Nullable fk0 fk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fk0Var) == null) {
            if (e(fk0Var)) {
                xj0 xj0Var = this.a;
                if (xj0Var.c == AdDownloadStatus.PAUSE) {
                    kj0.b().j(this.a);
                } else {
                    xj0Var.i = 0.0f;
                    xj0Var.j = 0.0f;
                    kj0.b().k(this.a);
                }
                this.b++;
            } else {
                xj0 xj0Var2 = this.a;
                xj0Var2.c = AdDownloadStatus.FAILED;
                xj0Var2.i = 0.0f;
                xj0Var2.j = 0.0f;
                kj0.b().g(AdDownloadAction.FAIL, this.a, fk0Var);
                gk0.f().i(this.a, "notify_type_stop");
            }
            oj0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable fk0 fk0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fk0Var)) == null) {
            if (fk0Var == null || !fk0Var.c) {
                return false;
            }
            if (cm0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= cm0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (cm0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(ii0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.tk0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                xj0 xj0Var = this.a;
                xj0Var.d = bl0.b(xj0Var.h);
            }
            if (bl0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = ii0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    xj0 xj0Var2 = this.a;
                    xj0Var2.o = packageArchiveInfo.versionName;
                    xj0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                xj0 xj0Var3 = this.a;
                xj0Var3.c = AdDownloadStatus.COMPLETED;
                xj0Var3.i = 1.0f;
                xj0Var3.j = 1.0f;
                kj0.b().f(AdDownloadAction.COMPLETE, this.a);
                zk0.f().k(this.a);
                gk0.f().k(this.a);
                oj0.b().e(this.a);
                xj0 xj0Var4 = this.a;
                bl0.e(xj0Var4.h, xj0Var4.a());
                return;
            }
            xj0 xj0Var5 = this.a;
            xj0Var5.c = AdDownloadStatus.FAILED;
            xj0Var5.i = 0.0f;
            xj0Var5.j = 0.0f;
            kj0.b().f(AdDownloadAction.FAIL, this.a);
            oj0.b().e(this.a);
        }
    }
}
