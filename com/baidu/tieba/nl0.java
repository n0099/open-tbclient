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
public class nl0 implements vm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zl0 a;
    public int b;

    public nl0(@NonNull zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zl0Var};
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
        this.a = zl0Var;
    }

    @Override // com.baidu.tieba.vm0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) a31.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        ml0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.vm0
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
            zl0 zl0Var = this.a;
            zl0Var.c = AdDownloadStatus.DOWNLOADING;
            zl0Var.h = file;
            zl0Var.q.e = j;
            ml0.b().f(adDownloadAction, this.a);
            ql0.b().update(this.a);
            ql0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.vm0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            ml0.b().f(AdDownloadAction.PAUSE, this.a);
            im0.f().i(this.a, "notify_type_pause");
            ql0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.vm0
    public void d(@Nullable hm0 hm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hm0Var) == null) {
            if (e(hm0Var)) {
                zl0 zl0Var = this.a;
                if (zl0Var.c == AdDownloadStatus.PAUSE) {
                    ml0.b().j(this.a);
                } else {
                    zl0Var.i = 0.0f;
                    zl0Var.j = 0.0f;
                    ml0.b().k(this.a);
                }
                this.b++;
            } else {
                zl0 zl0Var2 = this.a;
                zl0Var2.c = AdDownloadStatus.FAILED;
                zl0Var2.i = 0.0f;
                zl0Var2.j = 0.0f;
                ml0.b().g(AdDownloadAction.FAIL, this.a, hm0Var);
                im0.f().i(this.a, "notify_type_stop");
            }
            ql0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable hm0 hm0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hm0Var)) == null) {
            if (hm0Var == null || !hm0Var.c) {
                return false;
            }
            if (eo0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= eo0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (eo0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(kk0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vm0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                zl0 zl0Var = this.a;
                zl0Var.d = dn0.b(zl0Var.h);
            }
            if (dn0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = kk0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    zl0 zl0Var2 = this.a;
                    zl0Var2.o = packageArchiveInfo.versionName;
                    zl0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                zl0 zl0Var3 = this.a;
                zl0Var3.c = AdDownloadStatus.COMPLETED;
                zl0Var3.i = 1.0f;
                zl0Var3.j = 1.0f;
                ml0.b().f(AdDownloadAction.COMPLETE, this.a);
                bn0.f().k(this.a);
                im0.f().k(this.a);
                ql0.b().e(this.a);
                zl0 zl0Var4 = this.a;
                dn0.e(zl0Var4.h, zl0Var4.a());
                return;
            }
            zl0 zl0Var5 = this.a;
            zl0Var5.c = AdDownloadStatus.FAILED;
            zl0Var5.i = 0.0f;
            zl0Var5.j = 0.0f;
            ml0.b().f(AdDownloadAction.FAIL, this.a);
            ql0.b().e(this.a);
        }
    }
}
