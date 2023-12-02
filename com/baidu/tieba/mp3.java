package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.cq3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class mp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mp3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public vp3 a;
    public ConcurrentLinkedQueue<qp3> b;
    public volatile boolean c;
    public aq3 d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ aq3 b;
        public final /* synthetic */ mp3 c;

        public a(mp3 mp3Var, String str, aq3 aq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var, str, aq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mp3Var;
            this.a = str;
            this.b = aq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zi4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cq3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp3 a;

        public b(mp3 mp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp3Var;
        }

        @Override // com.baidu.tieba.cq3.b
        public void a(boolean z, byte[] bArr) {
            tp3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (gp3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = xp3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (gp3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (wp3.a(this.a.a, f) != null) {
                                            if (gp3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            lp3.a("serverHello");
                                            while (true) {
                                                qp3 qp3Var = (qp3) this.a.b.poll();
                                                if (qp3Var != null) {
                                                    this.a.g(qp3Var.b(), qp3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (gp3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (gp3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        lp3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (gp3.a) {
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

    public mp3() {
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
        this.a = new vp3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, aq3Var) == null) && aq3Var != null) {
            aq3Var.f(i);
        }
    }

    public void p(String str, aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, aq3Var) == null) {
            ej3.l(new a(this, str, aq3Var), "SessionController");
        }
    }

    public static mp3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (mp3.class) {
                    if (e == null) {
                        e = new mp3();
                    }
                }
            }
            return e;
        }
        return (mp3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            aq3 aq3Var = this.d;
            if (aq3Var == null) {
                return false;
            }
            return aq3Var.c();
        }
        return invokeV.booleanValue;
    }

    public vp3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new vp3();
            }
            return this.a;
        }
        return (vp3) invokeV.objValue;
    }

    public final void g(String str, aq3 aq3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aq3Var) == null) {
            if (aq3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(aq3Var.b(), "POST")) {
                o(-1, aq3Var);
            } else {
                if (gp3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(aq3Var.b(), "GET")) {
                    b2 = kp3.f().b(this.a, null);
                } else {
                    b2 = kp3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (gp3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    aq3Var.i(true);
                    this.d = aq3Var;
                    aq3Var.h(b2);
                    return;
                }
                o(-1, aq3Var);
            }
        }
    }

    public final void j(String str, aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aq3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new qp3(str, aq3Var));
                    if (i03.c()) {
                        rp3 rp3Var = new rp3();
                        long j = rp3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(rp3Var.getString("secretKey", "").getBytes());
                            this.a.t(rp3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, aq3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, aq3Var);
                return;
            }
            i(str, aq3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (gp3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (gp3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = kp3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new cq3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aq3Var) == null) {
            if (aq3Var != null && TextUtils.equals(aq3Var.b(), "GET")) {
                if (gp3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                aq3Var.i(false);
                this.d = aq3Var;
                aq3Var.h(null);
            } else if (aq3Var != null && str != null) {
                if (gp3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                aq3Var.i(false);
                this.d = aq3Var;
                aq3Var.h(str.getBytes());
            } else {
                o(-1, aq3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (gp3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                qp3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        aq3 a2 = poll.a();
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
