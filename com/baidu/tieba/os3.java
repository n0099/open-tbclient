package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.et3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class os3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile os3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public xs3 a;
    public ConcurrentLinkedQueue<ss3> b;
    public volatile boolean c;
    public ct3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ct3 b;
        public final /* synthetic */ os3 c;

        public a(os3 os3Var, String str, ct3 ct3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os3Var, str, ct3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = os3Var;
            this.a = str;
            this.b = ct3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bm4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements et3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os3 a;

        public b(os3 os3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {os3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os3Var;
        }

        @Override // com.baidu.tieba.et3.b
        public void a(boolean z, byte[] bArr) {
            vs3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (is3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = zs3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (is3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (ys3.a(this.a.a, f) != null) {
                                            if (is3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            ns3.a("serverHello");
                                            while (true) {
                                                ss3 ss3Var = (ss3) this.a.b.poll();
                                                if (ss3Var != null) {
                                                    this.a.g(ss3Var.b(), ss3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (is3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (is3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        ns3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (is3.a) {
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

    public os3() {
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
        this.a = new xs3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, ct3 ct3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, ct3Var) == null) && ct3Var != null) {
            ct3Var.f(i);
        }
    }

    public void p(String str, ct3 ct3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ct3Var) == null) {
            gm3.l(new a(this, str, ct3Var), "SessionController");
        }
    }

    public static os3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (os3.class) {
                    if (e == null) {
                        e = new os3();
                    }
                }
            }
            return e;
        }
        return (os3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ct3 ct3Var = this.d;
            if (ct3Var == null) {
                return false;
            }
            return ct3Var.c();
        }
        return invokeV.booleanValue;
    }

    public xs3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new xs3();
            }
            return this.a;
        }
        return (xs3) invokeV.objValue;
    }

    public final void g(String str, ct3 ct3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ct3Var) == null) {
            if (ct3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(ct3Var.b(), "POST")) {
                o(-1, ct3Var);
            } else {
                if (is3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(ct3Var.b(), "GET")) {
                    b2 = ms3.f().b(this.a, null);
                } else {
                    b2 = ms3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (is3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    ct3Var.i(true);
                    this.d = ct3Var;
                    ct3Var.h(b2);
                    return;
                }
                o(-1, ct3Var);
            }
        }
    }

    public final void j(String str, ct3 ct3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ct3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ss3(str, ct3Var));
                    if (k33.c()) {
                        ts3 ts3Var = new ts3();
                        long j = ts3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ts3Var.getString("secretKey", "").getBytes());
                            this.a.t(ts3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, ct3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, ct3Var);
                return;
            }
            i(str, ct3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (is3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (is3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = ms3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new et3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, ct3 ct3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ct3Var) == null) {
            if (ct3Var != null && TextUtils.equals(ct3Var.b(), "GET")) {
                if (is3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ct3Var.i(false);
                this.d = ct3Var;
                ct3Var.h(null);
            } else if (ct3Var != null && str != null) {
                if (is3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ct3Var.i(false);
                this.d = ct3Var;
                ct3Var.h(str.getBytes());
            } else {
                o(-1, ct3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (is3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                ss3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        ct3 a2 = poll.a();
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
