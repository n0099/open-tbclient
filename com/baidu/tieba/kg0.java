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
public class kg0 implements sh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wg0 a;
    public int b;

    public kg0(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wg0Var};
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
        this.a = wg0Var;
    }

    @Override // com.baidu.tieba.sh0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) qy0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        jg0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.sh0
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
            wg0 wg0Var = this.a;
            wg0Var.c = AdDownloadStatus.DOWNLOADING;
            wg0Var.h = file;
            xg0 xg0Var = wg0Var.q;
            xg0Var.e = j;
            xg0Var.v = true;
            jg0.c().g(adDownloadAction, this.a);
            ng0.b().g(this.a);
            ng0.b().f(this.a);
        }
    }

    @Override // com.baidu.tieba.sh0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            jg0.c().g(AdDownloadAction.PAUSE, this.a);
            if (this.a.q.w) {
                fh0.f().i(this.a, "notify_type_pause");
            }
            ng0.b().f(this.a);
        }
    }

    @Override // com.baidu.tieba.sh0
    public void d(@Nullable eh0 eh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eh0Var) == null) {
            if (e(eh0Var)) {
                wg0 wg0Var = this.a;
                if (wg0Var.c == AdDownloadStatus.PAUSE) {
                    jg0.c().m(this.a, this);
                } else {
                    wg0Var.i = 0.0f;
                    wg0Var.j = 0.0f;
                    jg0.c().o(this.a, this);
                }
                this.b++;
            } else {
                wg0 wg0Var2 = this.a;
                wg0Var2.c = AdDownloadStatus.FAILED;
                wg0Var2.i = 0.0f;
                wg0Var2.j = 0.0f;
                jg0.c().h(AdDownloadAction.FAIL, this.a, eh0Var);
                if (this.a.q.w) {
                    fh0.f().i(this.a, "notify_type_stop");
                }
            }
            ng0.b().f(this.a);
        }
    }

    public final boolean e(@Nullable eh0 eh0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eh0Var)) == null) {
            if (eh0Var == null || !eh0Var.c) {
                return false;
            }
            if (ij0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= ij0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (ij0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(hf0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sh0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                wg0 wg0Var = this.a;
                wg0Var.d = gi0.b(wg0Var.h);
            }
            if (gi0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = hf0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    wg0 wg0Var2 = this.a;
                    wg0Var2.o = packageArchiveInfo.versionName;
                    wg0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                wg0 wg0Var3 = this.a;
                wg0Var3.c = AdDownloadStatus.COMPLETED;
                wg0Var3.i = 1.0f;
                wg0Var3.j = 1.0f;
                jg0.c().g(AdDownloadAction.COMPLETE, this.a);
                yh0.f().k(this.a);
                fh0.f().k(this.a);
                ng0.b().f(this.a);
                wg0 wg0Var4 = this.a;
                gi0.e(wg0Var4.h, wg0Var4.a());
                return;
            }
            wg0 wg0Var5 = this.a;
            wg0Var5.c = AdDownloadStatus.FAILED;
            wg0Var5.i = 0.0f;
            wg0Var5.j = 0.0f;
            jg0.c().g(AdDownloadAction.FAIL, this.a);
            ng0.b().f(this.a);
        }
    }
}
