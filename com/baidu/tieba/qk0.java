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
public class qk0 implements yl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final cl0 a;
    public int b;

    public qk0(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cl0Var};
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
        this.a = cl0Var;
    }

    @Override // com.baidu.tieba.yl0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) a21.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        pk0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.yl0
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
            cl0 cl0Var = this.a;
            cl0Var.c = AdDownloadStatus.DOWNLOADING;
            cl0Var.h = file;
            cl0Var.q.e = j;
            pk0.b().f(adDownloadAction, this.a);
            tk0.b().update(this.a);
            tk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.yl0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            pk0.b().f(AdDownloadAction.PAUSE, this.a);
            ll0.f().i(this.a, "notify_type_pause");
            tk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.yl0
    public void d(@Nullable kl0 kl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kl0Var) == null) {
            if (e(kl0Var)) {
                cl0 cl0Var = this.a;
                if (cl0Var.c == AdDownloadStatus.PAUSE) {
                    pk0.b().j(this.a);
                } else {
                    cl0Var.i = 0.0f;
                    cl0Var.j = 0.0f;
                    pk0.b().k(this.a);
                }
                this.b++;
            } else {
                cl0 cl0Var2 = this.a;
                cl0Var2.c = AdDownloadStatus.FAILED;
                cl0Var2.i = 0.0f;
                cl0Var2.j = 0.0f;
                pk0.b().g(AdDownloadAction.FAIL, this.a, kl0Var);
                ll0.f().i(this.a, "notify_type_stop");
            }
            tk0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable kl0 kl0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, kl0Var)) == null) {
            if (kl0Var == null || !kl0Var.c) {
                return false;
            }
            if (hn0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= hn0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (hn0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(nj0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yl0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                cl0 cl0Var = this.a;
                cl0Var.d = gm0.b(cl0Var.h);
            }
            if (gm0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = nj0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    cl0 cl0Var2 = this.a;
                    cl0Var2.o = packageArchiveInfo.versionName;
                    cl0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                cl0 cl0Var3 = this.a;
                cl0Var3.c = AdDownloadStatus.COMPLETED;
                cl0Var3.i = 1.0f;
                cl0Var3.j = 1.0f;
                pk0.b().f(AdDownloadAction.COMPLETE, this.a);
                em0.f().k(this.a);
                ll0.f().k(this.a);
                tk0.b().e(this.a);
                cl0 cl0Var4 = this.a;
                gm0.e(cl0Var4.h, cl0Var4.a());
                return;
            }
            cl0 cl0Var5 = this.a;
            cl0Var5.c = AdDownloadStatus.FAILED;
            cl0Var5.i = 0.0f;
            cl0Var5.j = 0.0f;
            pk0.b().f(AdDownloadAction.FAIL, this.a);
            tk0.b().e(this.a);
        }
    }
}
