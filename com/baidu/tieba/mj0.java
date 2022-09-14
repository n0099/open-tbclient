package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class mj0 implements uk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yj0 a;

    public mj0(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yj0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yj0Var;
    }

    @Override // com.baidu.tieba.uk0
    public void a(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || j < 0 || j2 <= 0 || j > j2) {
            return;
        }
        this.a.i = (float) mz0.a(j, j2);
        this.a.c = AdDownloadStatus.DOWNLOADING;
        lj0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
    }

    @Override // com.baidu.tieba.uk0
    public void b(long j, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, file) == null) {
            AdDownloadAction adDownloadAction = this.a.c == AdDownloadStatus.PAUSE ? AdDownloadAction.RESUME : AdDownloadAction.START;
            this.a.l = System.currentTimeMillis();
            yj0 yj0Var = this.a;
            yj0Var.c = AdDownloadStatus.DOWNLOADING;
            yj0Var.h = file;
            yj0Var.q.e = j;
            lj0.b().f(adDownloadAction, this.a);
            pj0.b().update(this.a);
            pj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.uk0
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c = AdDownloadStatus.PAUSE;
            lj0.b().f(AdDownloadAction.PAUSE, this.a);
            hk0.f().i(this.a, "notify_type_pause");
            pj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.uk0
    public void d(@Nullable gk0 gk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gk0Var) == null) {
            yj0 yj0Var = this.a;
            yj0Var.c = AdDownloadStatus.FAILED;
            yj0Var.i = 0.0f;
            yj0Var.j = 0.0f;
            lj0.b().g(AdDownloadAction.FAIL, this.a, gk0Var);
            hk0.f().i(this.a, "notify_type_stop");
            pj0.b().e(this.a);
        }
    }

    @Override // com.baidu.tieba.uk0
    public void onSuccess(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.m = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.a.d)) {
                yj0 yj0Var = this.a;
                yj0Var.d = cl0.a(yj0Var.h);
            }
            if (cl0.e(this.a.h)) {
                PackageInfo packageArchiveInfo = mi0.b().getPackageManager().getPackageArchiveInfo(this.a.h.getAbsolutePath(), 128);
                if (packageArchiveInfo != null) {
                    yj0 yj0Var2 = this.a;
                    yj0Var2.o = packageArchiveInfo.versionName;
                    yj0Var2.n = packageArchiveInfo.versionCode;
                }
                AdAppStateManager.instance().register(this.a);
                yj0 yj0Var3 = this.a;
                yj0Var3.c = AdDownloadStatus.COMPLETED;
                yj0Var3.i = 1.0f;
                yj0Var3.j = 1.0f;
                lj0.b().f(AdDownloadAction.COMPLETE, this.a);
                al0.f().k(this.a);
                hk0.f().k(this.a);
                pj0.b().e(this.a);
                yj0 yj0Var4 = this.a;
                cl0.d(yj0Var4.h, yj0Var4.a());
                return;
            }
            yj0 yj0Var5 = this.a;
            yj0Var5.c = AdDownloadStatus.FAILED;
            yj0Var5.i = 0.0f;
            yj0Var5.j = 0.0f;
            lj0.b().f(AdDownloadAction.FAIL, this.a);
            pj0.b().e(this.a);
        }
    }
}
