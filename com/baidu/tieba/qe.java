package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.me;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class qe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public volatile mf b;
    public volatile of c;
    public me.a d;
    public URI e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public oe m;
    public lf n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public ke s;

    public void B(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe a;

        public a(qe qeVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qeVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qeVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof kf) {
                    kf kfVar = (kf) obj;
                    if (this.a.m != null) {
                        this.a.m.a(kfVar.a);
                    }
                } else if (obj instanceof ef) {
                    ef efVar = (ef) obj;
                    if (this.a.m != null) {
                        this.a.m.d(efVar.a);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof se) {
                    se seVar = (se) obj;
                    if (this.a.m != null) {
                        this.a.m.f(seVar);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof bf) {
                    cf cfVar = new cf();
                    cfVar.a = ((bf) obj).a;
                    this.a.c.b(cfVar);
                } else if (obj instanceof cf) {
                    cf cfVar2 = (cf) obj;
                    if (this.a.m != null) {
                        this.a.m.e();
                    }
                } else {
                    String str = null;
                    if (obj instanceof ue) {
                        this.a.q(1, null);
                    } else if (obj instanceof Cif) {
                        Cif cif = (Cif) obj;
                        if (cif.a) {
                            if (this.a.m != null) {
                                this.a.m.onOpen(cif.b);
                                this.a.o = true;
                                this.a.p = false;
                                if (this.a.m != null) {
                                    this.a.m.c(null);
                                }
                                if (BdBaseApplication.getInst().isDebugMode()) {
                                    Log.d("TB-WebSocket", "建立连接：握手成功");
                                    return;
                                }
                                return;
                            }
                            this.a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof ve) {
                        SocketException socketException = ((ve) obj).a;
                        if (socketException != null) {
                            str = socketException.getMessage();
                        }
                        qe qeVar = this.a;
                        qeVar.q(3, "WebSockets connection lost = " + str);
                    } else if (obj instanceof df) {
                        WebSocketException webSocketException = ((df) obj).a;
                        if (webSocketException != null) {
                            str = webSocketException.getMessage();
                        }
                        qe qeVar2 = this.a;
                        qeVar2.q(4, "WebSockets protocol violation error = " + str);
                    } else if (obj instanceof xe) {
                        qe qeVar3 = this.a;
                        qeVar3.q(5, "WebSockets internal error (" + ((xe) obj).a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof hf) {
                        hf hfVar = (hf) obj;
                        qe qeVar4 = this.a;
                        qeVar4.q(6, "Server error " + hfVar.a + " (" + hfVar.b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof we) {
                        qe qeVar5 = this.a;
                        qeVar5.q(2, "WebSockets connot connect:" + ((we) obj).a);
                    } else if (obj instanceof jf) {
                        if (this.a.m != null) {
                            this.a.m.i(((jf) message.obj).a);
                        }
                    } else if (!(obj instanceof ye)) {
                        if (!(obj instanceof ff)) {
                            this.a.B(obj);
                            return;
                        }
                        this.a.s = null;
                        ke keVar = ((ff) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.g(2, keVar);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(keVar);
                        }
                    } else {
                        this.a.s = null;
                        ke keVar2 = ((ye) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.h(keVar2);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(keVar2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe a;

        public b(qe qeVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qeVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qeVar;
        }

        public /* synthetic */ b(qe qeVar, a aVar) {
            this(qeVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    me meVar = new me();
                    this.a.d = meVar.a(this.a.g, this.a.h, this.a.n, false);
                    if (this.a.q) {
                        this.a.C(new ue());
                        return;
                    }
                    try {
                        if (!this.a.d.isConnected()) {
                            this.a.C(new we(2, "cannot connect"));
                            return;
                        }
                        this.a.r = System.currentTimeMillis() - currentTimeMillis;
                        this.a.t();
                        this.a.u();
                        te teVar = new te(this.a.g + ":" + this.a.h);
                        teVar.b = this.a.i;
                        teVar.c = this.a.j;
                        teVar.e = this.a.k;
                        teVar.f = this.a.l;
                        this.a.c.b(teVar);
                        if (this.a.q) {
                            this.a.C(new ue());
                        }
                    } catch (Throwable th) {
                        if (this.a.y()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.C(new xe(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.a.C(new we(2, th2.getMessage()));
                }
            }
        }
    }

    public qe() {
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
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        s();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.s != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null) {
            this.b.a();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.c != null) {
            this.c.a();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = new mf(this.a, this.d, this.n, "WebSocketReader");
            this.b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.c = new of(handlerThread.getLooper(), this.a, this.d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.b != null) {
                return this.b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.c != null) {
                return this.c.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public final void C(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.obj = obj;
            this.a.sendMessage(obtainMessage);
        }
    }

    public boolean D(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, keVar)) == null) {
            if (keVar == null) {
                return false;
            }
            if (this.s == null && z()) {
                this.s = keVar;
                return E(keVar);
            }
            y();
            if (keVar != null) {
                keVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(ke keVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, keVar)) == null) {
            if (this.c == null) {
                C(new xe(new Exception("mWriter = null")));
                return false;
            }
            return this.c.b(new af(keVar));
        }
        return invokeL.booleanValue;
    }

    public void q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                Log.d("TB-WebSocket", "连接断开：[" + i + PreferencesUtil.RIGHT_MOUNT + str);
            }
            this.o = false;
            this.q = true;
            if (this.b != null) {
                this.b.p();
                this.b = null;
            }
            if (this.c != null) {
                this.c.i();
                this.c = null;
            }
            me.a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (y()) {
                        th.printStackTrace();
                    }
                }
                this.d = null;
            }
            oe oeVar = this.m;
            this.m = null;
            if (oeVar != null) {
                try {
                    oeVar.b(i, str);
                } catch (Exception e) {
                    if (y()) {
                        BdLog.d(e.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, oe oeVar, lf lfVar, List<BasicNameValuePair> list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, oeVar, lfVar, list) == null) {
            this.p = true;
            me.a aVar = this.d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.e = uri;
                if (!uri.getScheme().equals("ws") && !this.e.getScheme().equals("wss")) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.e.getScheme().equals("wss")) {
                    this.f = this.e.getScheme();
                    if (this.e.getPort() == -1) {
                        if (this.f.equals("ws")) {
                            this.h = 80;
                        } else {
                            this.h = 443;
                        }
                    } else {
                        this.h = this.e.getPort();
                    }
                    if (this.e.getHost() != null) {
                        this.g = this.e.getHost();
                        if (this.e.getPath() != null && !this.e.getPath().equals("")) {
                            this.i = this.e.getPath();
                            if (this.e.getQuery() != null && !this.e.getQuery().equals("")) {
                                this.j = this.e.getQuery();
                                this.k = strArr;
                                this.l = list;
                                this.m = oeVar;
                                this.n = new lf(lfVar);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = oeVar;
                            this.n = new lf(lfVar);
                            new b(this, null).start();
                            return;
                        }
                        this.i = "/";
                        if (this.e.getQuery() != null) {
                            this.j = this.e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = oeVar;
                            this.n = new lf(lfVar);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = oeVar;
                        this.n = new lf(lfVar);
                        new b(this, null).start();
                        return;
                    }
                    throw new WebSocketException("no host specified in WebSockets URI");
                }
                throw new WebSocketException("secure WebSockets not implemented");
            } catch (URISyntaxException unused) {
                throw new WebSocketException("invalid WebSockets URI");
            }
        }
    }
}
