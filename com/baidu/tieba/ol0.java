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
public class ol0 implements wm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final am0 a;
    public int b;

    public ol0(@NonNull am0 am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {am0Var};
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
        this.a = am0Var;
    }

    @Override // com.baidu.tieba.wm0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) b31.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        nl0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.wm0
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
            am0 am0Var = this.a;
            am0Var.c = AdDownloadStatus.DOWNLOADING;
            am0Var.h = file;
            am0Var.q.e = j;
            nl0.b().f(adDownloadAction, this.a);
            rl0.b().update(this.a);
            rl0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.wm0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            nl0.b().f(AdDownloadAction.PAUSE, this.a);
            jm0.f().i(this.a, "notify_type_pause");
            rl0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.wm0
    public void d(@Nullable im0 im0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, im0Var) == null) {
            if (e(im0Var)) {
                am0 am0Var = this.a;
                if (am0Var.c == AdDownloadStatus.PAUSE) {
                    nl0.b().j(this.a);
                } else {
                    am0Var.i = 0.0f;
                    am0Var.j = 0.0f;
                    nl0.b().k(this.a);
                }
                this.b++;
            } else {
                am0 am0Var2 = this.a;
                am0Var2.c = AdDownloadStatus.FAILED;
                am0Var2.i = 0.0f;
                am0Var2.j = 0.0f;
                nl0.b().g(AdDownloadAction.FAIL, this.a, im0Var);
                jm0.f().i(this.a, "notify_type_stop");
            }
            rl0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable im0 im0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, im0Var)) == null) {
            if (im0Var == null || !im0Var.c) {
                return false;
            }
            if (fo0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= fo0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (fo0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(lk0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wm0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                am0 am0Var = this.a;
                am0Var.d = en0.b(am0Var.h);
            }
            if (en0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = lk0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    am0 am0Var2 = this.a;
                    am0Var2.o = packageArchiveInfo.versionName;
                    am0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                am0 am0Var3 = this.a;
                am0Var3.c = AdDownloadStatus.COMPLETED;
                am0Var3.i = 1.0f;
                am0Var3.j = 1.0f;
                nl0.b().f(AdDownloadAction.COMPLETE, this.a);
                cn0.f().k(this.a);
                jm0.f().k(this.a);
                rl0.b().e(this.a);
                am0 am0Var4 = this.a;
                en0.e(am0Var4.h, am0Var4.a());
                return;
            }
            am0 am0Var5 = this.a;
            am0Var5.c = AdDownloadStatus.FAILED;
            am0Var5.i = 0.0f;
            am0Var5.j = 0.0f;
            nl0.b().f(AdDownloadAction.FAIL, this.a);
            rl0.b().e(this.a);
        }
    }
}
