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
public class sf0 implements ah0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final eg0 a;
    public int b;

    public sf0(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eg0Var};
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
        this.a = eg0Var;
    }

    @Override // com.baidu.tieba.ah0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) != null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) wx0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        rf0.c().g(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.ah0
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
            eg0 eg0Var = this.a;
            eg0Var.c = AdDownloadStatus.DOWNLOADING;
            eg0Var.h = file;
            fg0 fg0Var = eg0Var.q;
            fg0Var.e = j;
            fg0Var.v = true;
            rf0.c().g(adDownloadAction, this.a);
            vf0.b().g(this.a);
            vf0.b().f(this.a);
        }
    }

    @Override // com.baidu.tieba.ah0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            rf0.c().g(AdDownloadAction.PAUSE, this.a);
            if (this.a.q.w) {
                ng0.f().i(this.a, "notify_type_pause");
            }
            vf0.b().f(this.a);
        }
    }

    @Override // com.baidu.tieba.ah0
    public void d(@Nullable mg0 mg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mg0Var) == null) {
            if (e(mg0Var)) {
                eg0 eg0Var = this.a;
                if (eg0Var.c == AdDownloadStatus.PAUSE) {
                    rf0.c().m(this.a, this);
                } else {
                    eg0Var.i = 0.0f;
                    eg0Var.j = 0.0f;
                    rf0.c().o(this.a, this);
                }
                this.b++;
            } else {
                eg0 eg0Var2 = this.a;
                eg0Var2.c = AdDownloadStatus.FAILED;
                eg0Var2.i = 0.0f;
                eg0Var2.j = 0.0f;
                rf0.c().h(AdDownloadAction.FAIL, this.a, mg0Var);
                if (this.a.q.w) {
                    ng0.f().i(this.a, "notify_type_stop");
                }
            }
            vf0.b().f(this.a);
        }
    }

    public final boolean e(@Nullable mg0 mg0Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mg0Var)) == null) {
            if (mg0Var == null || !mg0Var.c) {
                return false;
            }
            if (qi0.b().a().a("nad_failed_retry_switch", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b >= qi0.b().a().a("nad_failed_retry_count", 0)) {
                return false;
            }
            if (qi0.b().a().a("nad_failed_retry_without_wifi", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !NetWorkUtils.c(pe0.b())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ah0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                eg0 eg0Var = this.a;
                eg0Var.d = oh0.b(eg0Var.h);
            }
            if (oh0.g(this.a.h)) {
                PackageInfo packageArchiveInfo = pe0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    eg0 eg0Var2 = this.a;
                    eg0Var2.o = packageArchiveInfo.versionName;
                    eg0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                eg0 eg0Var3 = this.a;
                eg0Var3.c = AdDownloadStatus.COMPLETED;
                eg0Var3.i = 1.0f;
                eg0Var3.j = 1.0f;
                rf0.c().g(AdDownloadAction.COMPLETE, this.a);
                gh0.f().k(this.a);
                ng0.f().k(this.a);
                vf0.b().f(this.a);
                eg0 eg0Var4 = this.a;
                oh0.e(eg0Var4.h, eg0Var4.a());
                return;
            }
            eg0 eg0Var5 = this.a;
            eg0Var5.c = AdDownloadStatus.FAILED;
            eg0Var5.i = 0.0f;
            eg0Var5.j = 0.0f;
            rf0.c().g(AdDownloadAction.FAIL, this.a);
            vf0.b().f(this.a);
        }
    }
}
