package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.bo3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class ln3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ln3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public un3 a;
    public ConcurrentLinkedQueue<pn3> b;
    public volatile boolean c;
    public zn3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zn3 b;
        public final /* synthetic */ ln3 c;

        public a(ln3 ln3Var, String str, zn3 zn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln3Var, str, zn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ln3Var;
            this.a = str;
            this.b = zn3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yg4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bo3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln3 a;

        public b(ln3 ln3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln3Var;
        }

        @Override // com.baidu.tieba.bo3.b
        public void a(boolean z, byte[] bArr) {
            sn3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (fn3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = wn3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (fn3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (vn3.a(this.a.a, f) != null) {
                                            if (fn3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            kn3.a("serverHello");
                                            while (true) {
                                                pn3 pn3Var = (pn3) this.a.b.poll();
                                                if (pn3Var != null) {
                                                    this.a.g(pn3Var.b(), pn3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (fn3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (fn3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        kn3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (fn3.a) {
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

    public ln3() {
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
        this.a = new un3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, zn3 zn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, zn3Var) == null) && zn3Var != null) {
            zn3Var.f(i);
        }
    }

    public void p(String str, zn3 zn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, zn3Var) == null) {
            dh3.l(new a(this, str, zn3Var), "SessionController");
        }
    }

    public static ln3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ln3.class) {
                    if (e == null) {
                        e = new ln3();
                    }
                }
            }
            return e;
        }
        return (ln3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            zn3 zn3Var = this.d;
            if (zn3Var == null) {
                return false;
            }
            return zn3Var.c();
        }
        return invokeV.booleanValue;
    }

    public un3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new un3();
            }
            return this.a;
        }
        return (un3) invokeV.objValue;
    }

    public final void g(String str, zn3 zn3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, zn3Var) == null) {
            if (zn3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(zn3Var.b(), "POST")) {
                o(-1, zn3Var);
            } else {
                if (fn3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(zn3Var.b(), "GET")) {
                    b2 = jn3.f().b(this.a, null);
                } else {
                    b2 = jn3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (fn3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    zn3Var.i(true);
                    this.d = zn3Var;
                    zn3Var.h(b2);
                    return;
                }
                o(-1, zn3Var);
            }
        }
    }

    public final void j(String str, zn3 zn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, zn3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new pn3(str, zn3Var));
                    if (hy2.c()) {
                        qn3 qn3Var = new qn3();
                        long j = qn3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(qn3Var.getString("secretKey", "").getBytes());
                            this.a.t(qn3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, zn3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, zn3Var);
                return;
            }
            i(str, zn3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (fn3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (fn3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = jn3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new bo3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, zn3 zn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, zn3Var) == null) {
            if (zn3Var != null && TextUtils.equals(zn3Var.b(), "GET")) {
                if (fn3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                zn3Var.i(false);
                this.d = zn3Var;
                zn3Var.h(null);
            } else if (zn3Var != null && str != null) {
                if (fn3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                zn3Var.i(false);
                this.d = zn3Var;
                zn3Var.h(str.getBytes());
            } else {
                o(-1, zn3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (fn3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                pn3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        zn3 a2 = poll.a();
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
