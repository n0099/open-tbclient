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
public class vk0 implements dm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hl0 a;
    public int b;

    public vk0(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hl0Var};
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
        this.a = hl0Var;
    }

    @Override // com.baidu.tieba.dm0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) j31.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        uk0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.dm0
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
            hl0 hl0Var = this.a;
            hl0Var.c = AdDownloadStatus.DOWNLOADING;
            hl0Var.h = file;
            il0 il0Var = hl0Var.q;
            il0Var.e = j;
            il0Var.v = true;
            uk0.c().g(adDownloadAction, this.a);
            yk0.b().update(this.a);
            yk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.dm0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            uk0.c().g(AdDownloadAction.PAUSE, this.a);
            if (this.a.q.w) {
                ql0.f().i(this.a, "notify_type_pause");
            }
            yk0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.dm0
    public void d(@Nullable pl0 pl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pl0Var) == null) {
            if (e(pl0Var)) {
                hl0 hl0Var = this.a;
                if (hl0Var.c == AdDownloadStatus.PAUSE) {
                    uk0.c().m(this.a, this);
                } else {
                    hl0Var.i = 0.0f;
                    hl0Var.j = 0.0f;
                    uk0.c().o(this.a, this);
                }
                this.b++;
            } else {
                hl0 hl0Var2 = this.a;
                hl0Var2.c = AdDownloadStatus.FAILED;
                hl0Var2.i = 0.0f;
                hl0Var2.j = 0.0f;
                uk0.c().h(AdDownloadAction.FAIL, this.a, pl0Var);
                if (this.a.q.w) {
                    ql0.f().i(this.a, "notify_type_stop");
                }
            }
            yk0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable pl0 pl0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, pl0Var)) == null) {
            if (pl0Var == null || !pl0Var.c) {
                return false;
            }
            if (tn0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= tn0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (tn0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(sj0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.dm0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                hl0 hl0Var = this.a;
                hl0Var.d = rm0.b(hl0Var.h);
            }
            if (rm0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = sj0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    hl0 hl0Var2 = this.a;
                    hl0Var2.o = packageArchiveInfo.versionName;
                    hl0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                hl0 hl0Var3 = this.a;
                hl0Var3.c = AdDownloadStatus.COMPLETED;
                hl0Var3.i = 1.0f;
                hl0Var3.j = 1.0f;
                uk0.c().g(AdDownloadAction.COMPLETE, this.a);
                jm0.f().k(this.a);
                ql0.f().k(this.a);
                yk0.b().e(this.a);
                hl0 hl0Var4 = this.a;
                rm0.e(hl0Var4.h, hl0Var4.a());
                return;
            }
            hl0 hl0Var5 = this.a;
            hl0Var5.c = AdDownloadStatus.FAILED;
            hl0Var5.i = 0.0f;
            hl0Var5.j = 0.0f;
            uk0.c().g(AdDownloadAction.FAIL, this.a);
            yk0.b().e(this.a);
        }
    }
}
