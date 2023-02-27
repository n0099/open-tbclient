package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vl0 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gl0 a;
    public float b;
    public final float c;
    public final float d;
    public final float e;
    public boolean f;

    public vl0(@NonNull gl0 gl0Var) {
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
        this.b = -1.0f;
        this.f = false;
        this.c = (float) ln0.b().a().b("nad_fake_progress", 0.5950000286102295d);
        this.b = (float) ln0.b().a().b("nad_fake_max_progress_time", 0.0d);
        this.d = (float) ln0.b().a().b("nad_fake_speed", 768000.0d);
        this.e = (float) ln0.b().a().b("nad_fake_progress_step", 0.009999999776482582d);
        this.a = gl0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                d();
            } else if (this.a.q.g == 1) {
                this.f = false;
            } else if (!NetUtil.a(rj0.b())) {
                d();
            } else {
                gl0 gl0Var = this.a;
                if (gl0Var.c != AdDownloadStatus.DOWNLOADING) {
                    d();
                    return;
                }
                float f = gl0Var.j;
                if (f >= this.c) {
                    d();
                    return;
                }
                this.f = true;
                gl0Var.j = Math.max(gl0Var.i, f) + this.e;
                tk0.b().f(AdDownloadAction.PROGRESS_UPDATE, this.a);
                c();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(false);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            sendMessageDelayed(obtain, (this.b / (this.c / this.e)) * 1000.0f);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            removeMessages(1);
            this.f = false;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.f && !z) {
                return;
            }
            d();
            long j = this.a.q.e;
            if (j > 0) {
                float f = this.d;
                if (f > 0.0f) {
                    this.b = (((float) j) * this.c) / f;
                }
            }
            if (this.b <= 0.0f) {
                this.f = false;
            } else if (this.e <= 0.0f) {
                this.f = false;
            } else {
                this.f = true;
                Message obtain = Message.obtain();
                obtain.what = 1;
                sendMessage(obtain);
            }
        }
    }
}
