package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.mr3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class wq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wq3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public fr3 a;
    public ConcurrentLinkedQueue<ar3> b;
    public volatile boolean c;
    public kr3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kr3 b;
        public final /* synthetic */ wq3 c;

        public a(wq3 wq3Var, String str, kr3 kr3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq3Var, str, kr3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wq3Var;
            this.a = str;
            this.b = kr3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jk4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mr3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq3 a;

        public b(wq3 wq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wq3Var;
        }

        @Override // com.baidu.tieba.mr3.b
        public void a(boolean z, byte[] bArr) {
            dr3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (qq3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = hr3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (qq3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (gr3.a(this.a.a, f) != null) {
                                            if (qq3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            vq3.a("serverHello");
                                            while (true) {
                                                ar3 ar3Var = (ar3) this.a.b.poll();
                                                if (ar3Var != null) {
                                                    this.a.g(ar3Var.b(), ar3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (qq3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (qq3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        vq3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (qq3.a) {
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

    public wq3() {
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
        this.a = new fr3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, kr3 kr3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, kr3Var) == null) && kr3Var != null) {
            kr3Var.f(i);
        }
    }

    public void p(String str, kr3 kr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, kr3Var) == null) {
            ok3.l(new a(this, str, kr3Var), "SessionController");
        }
    }

    public static wq3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (wq3.class) {
                    if (e == null) {
                        e = new wq3();
                    }
                }
            }
            return e;
        }
        return (wq3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            kr3 kr3Var = this.d;
            if (kr3Var == null) {
                return false;
            }
            return kr3Var.c();
        }
        return invokeV.booleanValue;
    }

    public fr3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new fr3();
            }
            return this.a;
        }
        return (fr3) invokeV.objValue;
    }

    public final void g(String str, kr3 kr3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, kr3Var) == null) {
            if (kr3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(kr3Var.b(), "POST")) {
                o(-1, kr3Var);
            } else {
                if (qq3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(kr3Var.b(), "GET")) {
                    b2 = uq3.f().b(this.a, null);
                } else {
                    b2 = uq3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (qq3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    kr3Var.i(true);
                    this.d = kr3Var;
                    kr3Var.h(b2);
                    return;
                }
                o(-1, kr3Var);
            }
        }
    }

    public final void j(String str, kr3 kr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, kr3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ar3(str, kr3Var));
                    if (s13.c()) {
                        br3 br3Var = new br3();
                        long j = br3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(br3Var.getString("secretKey", "").getBytes());
                            this.a.t(br3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, kr3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, kr3Var);
                return;
            }
            i(str, kr3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (qq3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (qq3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = uq3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new mr3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, kr3 kr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, kr3Var) == null) {
            if (kr3Var != null && TextUtils.equals(kr3Var.b(), "GET")) {
                if (qq3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                kr3Var.i(false);
                this.d = kr3Var;
                kr3Var.h(null);
            } else if (kr3Var != null && str != null) {
                if (qq3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                kr3Var.i(false);
                this.d = kr3Var;
                kr3Var.h(str.getBytes());
            } else {
                o(-1, kr3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (qq3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                ar3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        kr3 a2 = poll.a();
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
