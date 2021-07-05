package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public final class bd extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bc f23358a;

    public bd(bc bcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23358a = bcVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        Timer timer;
        Timer timer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Message message = new Message();
            message.what = 3;
            handler = this.f23358a.f23357a.r;
            handler.sendMessage(message);
            timer = this.f23358a.f23357a.q;
            timer.cancel();
            timer2 = this.f23358a.f23357a.q;
            timer2.purge();
        }
    }
}
