package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.pr3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class zq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zq3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ir3 a;
    public ConcurrentLinkedQueue<dr3> b;
    public volatile boolean c;
    public nr3 d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nr3 b;
        public final /* synthetic */ zq3 c;

        public a(zq3 zq3Var, String str, nr3 nr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq3Var, str, nr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zq3Var;
            this.a = str;
            this.b = nr3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mk4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pr3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zq3 a;

        public b(zq3 zq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zq3Var;
        }

        @Override // com.baidu.tieba.pr3.b
        public void a(boolean z, byte[] bArr) {
            gr3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (tq3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = kr3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (tq3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (jr3.a(this.a.a, f) != null) {
                                            if (tq3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            yq3.a("serverHello");
                                            while (true) {
                                                dr3 dr3Var = (dr3) this.a.b.poll();
                                                if (dr3Var != null) {
                                                    this.a.g(dr3Var.b(), dr3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (tq3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (tq3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        yq3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (tq3.a) {
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

    public zq3() {
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
        this.a = new ir3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, nr3 nr3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, nr3Var) == null) && nr3Var != null) {
            nr3Var.f(i);
        }
    }

    public void p(String str, nr3 nr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, nr3Var) == null) {
            rk3.l(new a(this, str, nr3Var), "SessionController");
        }
    }

    public static zq3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (zq3.class) {
                    if (e == null) {
                        e = new zq3();
                    }
                }
            }
            return e;
        }
        return (zq3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            nr3 nr3Var = this.d;
            if (nr3Var == null) {
                return false;
            }
            return nr3Var.c();
        }
        return invokeV.booleanValue;
    }

    public ir3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ir3();
            }
            return this.a;
        }
        return (ir3) invokeV.objValue;
    }

    public final void g(String str, nr3 nr3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, nr3Var) == null) {
            if (nr3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(nr3Var.b(), "POST")) {
                o(-1, nr3Var);
            } else {
                if (tq3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(nr3Var.b(), "GET")) {
                    b2 = xq3.f().b(this.a, null);
                } else {
                    b2 = xq3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (tq3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    nr3Var.i(true);
                    this.d = nr3Var;
                    nr3Var.h(b2);
                    return;
                }
                o(-1, nr3Var);
            }
        }
    }

    public final void j(String str, nr3 nr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, nr3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new dr3(str, nr3Var));
                    if (v13.c()) {
                        er3 er3Var = new er3();
                        long j = er3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(er3Var.getString("secretKey", "").getBytes());
                            this.a.t(er3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, nr3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, nr3Var);
                return;
            }
            i(str, nr3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (tq3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (tq3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = xq3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new pr3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, nr3 nr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, nr3Var) == null) {
            if (nr3Var != null && TextUtils.equals(nr3Var.b(), "GET")) {
                if (tq3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                nr3Var.i(false);
                this.d = nr3Var;
                nr3Var.h(null);
            } else if (nr3Var != null && str != null) {
                if (tq3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                nr3Var.i(false);
                this.d = nr3Var;
                nr3Var.h(str.getBytes());
            } else {
                o(-1, nr3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (tq3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                dr3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        nr3 a2 = poll.a();
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
