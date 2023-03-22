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
public class kj0 implements sk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wj0 a;
    public int b;

    public kj0(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wj0Var};
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
        this.a = wj0Var;
    }

    @Override // com.baidu.tieba.sk0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) x01.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        jj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.sk0
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
            wj0 wj0Var = this.a;
            wj0Var.c = AdDownloadStatus.DOWNLOADING;
            wj0Var.h = file;
            wj0Var.q.e = j;
            jj0.b().f(adDownloadAction, this.a);
            nj0.b().update(this.a);
            nj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.sk0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            jj0.b().f(AdDownloadAction.PAUSE, this.a);
            fk0.f().i(this.a, "notify_type_pause");
            nj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.sk0
    public void d(@Nullable ek0 ek0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ek0Var) == null) {
            if (e(ek0Var)) {
                wj0 wj0Var = this.a;
                if (wj0Var.c == AdDownloadStatus.PAUSE) {
                    jj0.b().j(this.a);
                } else {
                    wj0Var.i = 0.0f;
                    wj0Var.j = 0.0f;
                    jj0.b().k(this.a);
                }
                this.b++;
            } else {
                wj0 wj0Var2 = this.a;
                wj0Var2.c = AdDownloadStatus.FAILED;
                wj0Var2.i = 0.0f;
                wj0Var2.j = 0.0f;
                jj0.b().g(AdDownloadAction.FAIL, this.a, ek0Var);
                fk0.f().i(this.a, "notify_type_stop");
            }
            nj0.b().e(this.a);
        }
    }

    public final boolean e(@Nullable ek0 ek0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ek0Var)) == null) {
            if (ek0Var == null || !ek0Var.c) {
                return false;
            }
            if (bm0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= bm0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (bm0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(hi0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sk0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                wj0 wj0Var = this.a;
                wj0Var.d = al0.b(wj0Var.h);
            }
            if (al0.f(this.a.h)) {
                PackageInfo packageArchiveInfo = hi0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    wj0 wj0Var2 = this.a;
                    wj0Var2.o = packageArchiveInfo.versionName;
                    wj0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                wj0 wj0Var3 = this.a;
                wj0Var3.c = AdDownloadStatus.COMPLETED;
                wj0Var3.i = 1.0f;
                wj0Var3.j = 1.0f;
                jj0.b().f(AdDownloadAction.COMPLETE, this.a);
                yk0.f().k(this.a);
                fk0.f().k(this.a);
                nj0.b().e(this.a);
                wj0 wj0Var4 = this.a;
                al0.e(wj0Var4.h, wj0Var4.a());
                return;
            }
            wj0 wj0Var5 = this.a;
            wj0Var5.c = AdDownloadStatus.FAILED;
            wj0Var5.i = 0.0f;
            wj0Var5.j = 0.0f;
            jj0.b().f(AdDownloadAction.FAIL, this.a);
            nj0.b().e(this.a);
        }
    }
}
