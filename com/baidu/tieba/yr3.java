package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.os3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class yr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yr3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public hs3 a;
    public ConcurrentLinkedQueue<cs3> b;
    public volatile boolean c;
    public ms3 d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ms3 b;
        public final /* synthetic */ yr3 c;

        public a(yr3 yr3Var, String str, ms3 ms3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr3Var, str, ms3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yr3Var;
            this.a = str;
            this.b = ms3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ll4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements os3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr3 a;

        public b(yr3 yr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr3Var;
        }

        @Override // com.baidu.tieba.os3.b
        public void a(boolean z, byte[] bArr) {
            fs3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (sr3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = js3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (sr3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (is3.a(this.a.a, f) != null) {
                                            if (sr3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            xr3.a("serverHello");
                                            while (true) {
                                                cs3 cs3Var = (cs3) this.a.b.poll();
                                                if (cs3Var != null) {
                                                    this.a.g(cs3Var.b(), cs3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (sr3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (sr3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        xr3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (sr3.a) {
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

    public yr3() {
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
        this.a = new hs3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, ms3Var) == null) && ms3Var != null) {
            ms3Var.f(i);
        }
    }

    public void p(String str, ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ms3Var) == null) {
            ql3.l(new a(this, str, ms3Var), "SessionController");
        }
    }

    public static yr3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (yr3.class) {
                    if (e == null) {
                        e = new yr3();
                    }
                }
            }
            return e;
        }
        return (yr3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ms3 ms3Var = this.d;
            if (ms3Var == null) {
                return false;
            }
            return ms3Var.c();
        }
        return invokeV.booleanValue;
    }

    public hs3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new hs3();
            }
            return this.a;
        }
        return (hs3) invokeV.objValue;
    }

    public final void g(String str, ms3 ms3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ms3Var) == null) {
            if (ms3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(ms3Var.b(), "POST")) {
                o(-1, ms3Var);
            } else {
                if (sr3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(ms3Var.b(), "GET")) {
                    b2 = wr3.f().b(this.a, null);
                } else {
                    b2 = wr3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (sr3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    ms3Var.i(true);
                    this.d = ms3Var;
                    ms3Var.h(b2);
                    return;
                }
                o(-1, ms3Var);
            }
        }
    }

    public final void j(String str, ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ms3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new cs3(str, ms3Var));
                    if (u23.c()) {
                        ds3 ds3Var = new ds3();
                        long j = ds3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ds3Var.getString("secretKey", "").getBytes());
                            this.a.t(ds3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, ms3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, ms3Var);
                return;
            }
            i(str, ms3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (sr3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (sr3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = wr3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new os3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ms3Var) == null) {
            if (ms3Var != null && TextUtils.equals(ms3Var.b(), "GET")) {
                if (sr3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ms3Var.i(false);
                this.d = ms3Var;
                ms3Var.h(null);
            } else if (ms3Var != null && str != null) {
                if (sr3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ms3Var.i(false);
                this.d = ms3Var;
                ms3Var.h(str.getBytes());
            } else {
                o(-1, ms3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (sr3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                cs3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        ms3 a2 = poll.a();
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
