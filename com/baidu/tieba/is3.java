package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.ys3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class is3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile is3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public rs3 a;
    public ConcurrentLinkedQueue<ms3> b;
    public volatile boolean c;
    public ws3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ws3 b;
        public final /* synthetic */ is3 c;

        public a(is3 is3Var, String str, ws3 ws3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {is3Var, str, ws3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = is3Var;
            this.a = str;
            this.b = ws3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vl4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ys3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ is3 a;

        public b(is3 is3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {is3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = is3Var;
        }

        @Override // com.baidu.tieba.ys3.b
        public void a(boolean z, byte[] bArr) {
            ps3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (cs3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = ts3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (cs3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (ss3.a(this.a.a, f) != null) {
                                            if (cs3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            hs3.a("serverHello");
                                            while (true) {
                                                ms3 ms3Var = (ms3) this.a.b.poll();
                                                if (ms3Var != null) {
                                                    this.a.g(ms3Var.b(), ms3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (cs3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (cs3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        hs3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (cs3.a) {
                            e.printStackTrace();
                            Log.d("BDTLS", "exception=" + e.getMessage());
                        }
                    }
                    this.a.n(str);
                } finally {
                    this.a.c = false;
                }
            }
        }
    }

    public is3() {
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
        this.a = new rs3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, ws3Var) == null) && ws3Var != null) {
            ws3Var.f(i);
        }
    }

    public void p(String str, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ws3Var) == null) {
            am3.l(new a(this, str, ws3Var), "SessionController");
        }
    }

    public static is3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (is3.class) {
                    if (e == null) {
                        e = new is3();
                    }
                }
            }
            return e;
        }
        return (is3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ws3 ws3Var = this.d;
            if (ws3Var == null) {
                return false;
            }
            return ws3Var.c();
        }
        return invokeV.booleanValue;
    }

    public rs3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new rs3();
            }
            return this.a;
        }
        return (rs3) invokeV.objValue;
    }

    public final void g(String str, ws3 ws3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ws3Var) == null) {
            if (ws3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(ws3Var.b(), "POST")) {
                o(-1, ws3Var);
            } else {
                if (cs3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(ws3Var.b(), "GET")) {
                    b2 = gs3.f().b(this.a, null);
                } else {
                    b2 = gs3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (cs3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    ws3Var.i(true);
                    this.d = ws3Var;
                    ws3Var.h(b2);
                    return;
                }
                o(-1, ws3Var);
            }
        }
    }

    public final void j(String str, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ws3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ms3(str, ws3Var));
                    if (e33.c()) {
                        ns3 ns3Var = new ns3();
                        long j = ns3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ns3Var.getString("secretKey", "").getBytes());
                            this.a.t(ns3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, ws3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, ws3Var);
                return;
            }
            i(str, ws3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (cs3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (cs3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = gs3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new ys3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, ws3 ws3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ws3Var) == null) {
            if (ws3Var != null && TextUtils.equals(ws3Var.b(), "GET")) {
                if (cs3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ws3Var.i(false);
                this.d = ws3Var;
                ws3Var.h(null);
            } else if (ws3Var != null && str != null) {
                if (cs3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ws3Var.i(false);
                this.d = ws3Var;
                ws3Var.h(str.getBytes());
            } else {
                o(-1, ws3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (cs3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                ms3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        ws3 a2 = poll.a();
                        if (a2 != null) {
                            if (TextUtils.isEmpty(str)) {
                                str2 = "connect fail";
                            } else {
                                str2 = str;
                            }
                            a2.e(new IOException(str2));
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }
}
