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
public class uk0 implements cm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gl0 a;
    public int b;

    public uk0(@NonNull gl0 gl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gl0Var};
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
        this.a = gl0Var;
    }

    @Override // com.baidu.tieba.cm0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) h21.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        tk0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.cm0
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
            gl0 gl0Var = this.a;
            gl0Var.c = AdDownloadStatus.DOWNLOADING;
            gl0Var.h = file;
            gl0Var.q.e = j;
            tk0.b().f(adDownloadAction, this.a);
            xk0.b().update(this.a);
            xk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.cm0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            tk0.b().f(AdDownloadAction.PAUSE, this.a);
            pl0.f().i(this.a, "notify_type_pause");
            xk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.cm0
    public void d(@Nullable ol0 ol0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ol0Var) == null) {
            if (e(ol0Var)) {
                gl0 gl0Var = this.a;
                if (gl0Var.c == AdDownloadStatus.PAUSE) {
                    tk0.b().j(this.a);
                } else {
                    gl0Var.i = 0.0f;
                    gl0Var.j = 0.0f;
                    tk0.b().k(this.a);
                }
                this.b++;
            } else {
                gl0 gl0Var2 = this.a;
                gl0Var2.c = AdDownloadStatus.FAILED;
                gl0Var2.i = 0.0f;
                gl0Var2.j = 0.0f;
                tk0.b().g(AdDownloadAction.FAIL, this.a, ol0Var);
                pl0.f().i(this.a, "notify_type_stop");
            }
            xk0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable ol0 ol0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ol0Var)) == null) {
            if (ol0Var == null || !ol0Var.c) {
                return false;
            }
            if (ln0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= ln0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (ln0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(rj0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cm0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                gl0 gl0Var = this.a;
                gl0Var.d = km0.b(gl0Var.h);
            }
            if (km0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = rj0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    gl0 gl0Var2 = this.a;
                    gl0Var2.o = packageArchiveInfo.versionName;
                    gl0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                gl0 gl0Var3 = this.a;
                gl0Var3.c = AdDownloadStatus.COMPLETED;
                gl0Var3.i = 1.0f;
                gl0Var3.j = 1.0f;
                tk0.b().f(AdDownloadAction.COMPLETE, this.a);
                im0.f().k(this.a);
                pl0.f().k(this.a);
                xk0.b().e(this.a);
                gl0 gl0Var4 = this.a;
                km0.e(gl0Var4.h, gl0Var4.a());
                return;
            }
            gl0 gl0Var5 = this.a;
            gl0Var5.c = AdDownloadStatus.FAILED;
            gl0Var5.i = 0.0f;
            gl0Var5.j = 0.0f;
            tk0.b().f(AdDownloadAction.FAIL, this.a);
            xk0.b().e(this.a);
        }
    }
}
