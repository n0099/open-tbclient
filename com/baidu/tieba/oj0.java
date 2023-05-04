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
public class oj0 implements wk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ak0 a;
    public int b;

    public oj0(@NonNull ak0 ak0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ak0Var};
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
        this.a = ak0Var;
    }

    @Override // com.baidu.tieba.wk0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) b11.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        nj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.wk0
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
            ak0 ak0Var = this.a;
            ak0Var.c = AdDownloadStatus.DOWNLOADING;
            ak0Var.h = file;
            ak0Var.q.e = j;
            nj0.b().f(adDownloadAction, this.a);
            rj0.b().update(this.a);
            rj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.wk0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            nj0.b().f(AdDownloadAction.PAUSE, this.a);
            jk0.f().i(this.a, "notify_type_pause");
            rj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.wk0
    public void d(@Nullable ik0 ik0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ik0Var) == null) {
            if (e(ik0Var)) {
                ak0 ak0Var = this.a;
                if (ak0Var.c == AdDownloadStatus.PAUSE) {
                    nj0.b().j(this.a);
                } else {
                    ak0Var.i = 0.0f;
                    ak0Var.j = 0.0f;
                    nj0.b().k(this.a);
                }
                this.b++;
            } else {
                ak0 ak0Var2 = this.a;
                ak0Var2.c = AdDownloadStatus.FAILED;
                ak0Var2.i = 0.0f;
                ak0Var2.j = 0.0f;
                nj0.b().g(AdDownloadAction.FAIL, this.a, ik0Var);
                jk0.f().i(this.a, "notify_type_stop");
            }
            rj0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable ik0 ik0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ik0Var)) == null) {
            if (ik0Var == null || !ik0Var.c) {
                return false;
            }
            if (fm0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= fm0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (fm0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(li0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wk0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                ak0 ak0Var = this.a;
                ak0Var.d = el0.b(ak0Var.h);
            }
            if (el0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = li0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    ak0 ak0Var2 = this.a;
                    ak0Var2.o = packageArchiveInfo.versionName;
                    ak0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                ak0 ak0Var3 = this.a;
                ak0Var3.c = AdDownloadStatus.COMPLETED;
                ak0Var3.i = 1.0f;
                ak0Var3.j = 1.0f;
                nj0.b().f(AdDownloadAction.COMPLETE, this.a);
                cl0.f().k(this.a);
                jk0.f().k(this.a);
                rj0.b().e(this.a);
                ak0 ak0Var4 = this.a;
                el0.e(ak0Var4.h, ak0Var4.a());
                return;
            }
            ak0 ak0Var5 = this.a;
            ak0Var5.c = AdDownloadStatus.FAILED;
            ak0Var5.i = 0.0f;
            ak0Var5.j = 0.0f;
            nj0.b().f(AdDownloadAction.FAIL, this.a);
            rj0.b().e(this.a);
        }
    }
}
