package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public final Handler c;

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xa xaVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xaVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xaVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.c.removeMessages(1);
                    BdLog.i("this is reconn time:" + this.a.b);
                    BdSocketLinkService.startService(true, "time to reconnStragety");
                    xa.c(this.a);
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (this.a.b >= uh.o().q("alert_im", 3)) {
                            BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                            bdStatisticsManager.alert("alert_im", "Socket_Reconnect_" + String.valueOf(this.a.b) + "_times");
                        }
                    }
                    int[] c = oa.c();
                    if (c != null && this.a.b < c.length) {
                        BdLog.i("Next will be delay:" + c[this.a.b]);
                        this.a.c.sendMessageDelayed(this.a.c.obtainMessage(1), (long) (c[this.a.b] * 1000));
                        return;
                    }
                    this.a.f("reconnStragety to the end");
                }
            }
        }
    }

    public xa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0;
        this.c = new a(this, Looper.getMainLooper());
    }

    public static /* synthetic */ int c(xa xaVar) {
        int i = xaVar.b;
        xaVar.b = i + 1;
        return i;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.a) {
            pa.a("reconn", 0, 0, "stop", BdSocketLinkService.STOP_RECONN, str);
            this.a = false;
            this.b = 0;
            BdLog.i("stop reconnStrategy");
            this.c.removeMessages(1);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (!BdSocketLinkService.isAvailable()) {
                f("online failed 5");
            } else if (!this.a) {
                this.a = true;
                this.c.removeMessages(1);
                if (yj.j().l()) {
                    BdLog.d("启动重连策略失败，  WebSocketClient opened");
                    f("in Opened");
                    return;
                }
                d();
                BdLog.d("启动重连策略");
                this.b = 0;
                int[] c = oa.c();
                if (c != null && c.length >= 1) {
                    BdLog.i("start reconnStrategy... the first will be delay" + c[0]);
                    int i = BdSocketLinkService.STOP_RECONN;
                    pa.a("reconn", 0, 0, "reconn", i, str + " retryTimes=" + String.valueOf(this.b));
                    Handler handler = this.c;
                    handler.sendMessageDelayed(handler.obtainMessage(1), (long) (c[0] * 1000));
                    return;
                }
                BdLog.i("don't have reconnStrategy!");
            } else {
                BdLog.d("重连策略正在运行中， 再次启动无效");
                pa.a("reconn", 0, 0, "start", BdSocketLinkService.ALLREADY, "have in Running,so invalid");
            }
        }
    }
}
