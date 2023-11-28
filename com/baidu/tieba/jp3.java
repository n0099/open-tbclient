package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.zp3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class jp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jp3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public sp3 a;
    public ConcurrentLinkedQueue<np3> b;
    public volatile boolean c;
    public xp3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xp3 b;
        public final /* synthetic */ jp3 c;

        public a(jp3 jp3Var, String str, xp3 xp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp3Var, str, xp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jp3Var;
            this.a = str;
            this.b = xp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wi4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zp3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp3 a;

        public b(jp3 jp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jp3Var;
        }

        @Override // com.baidu.tieba.zp3.b
        public void a(boolean z, byte[] bArr) {
            qp3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (dp3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = up3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (dp3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (tp3.a(this.a.a, f) != null) {
                                            if (dp3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            ip3.a("serverHello");
                                            while (true) {
                                                np3 np3Var = (np3) this.a.b.poll();
                                                if (np3Var != null) {
                                                    this.a.g(np3Var.b(), np3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (dp3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (dp3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        ip3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (dp3.a) {
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

    public jp3() {
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
        this.a = new sp3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, xp3 xp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, xp3Var) == null) && xp3Var != null) {
            xp3Var.f(i);
        }
    }

    public void p(String str, xp3 xp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, xp3Var) == null) {
            bj3.l(new a(this, str, xp3Var), "SessionController");
        }
    }

    public static jp3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (jp3.class) {
                    if (e == null) {
                        e = new jp3();
                    }
                }
            }
            return e;
        }
        return (jp3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xp3 xp3Var = this.d;
            if (xp3Var == null) {
                return false;
            }
            return xp3Var.c();
        }
        return invokeV.booleanValue;
    }

    public sp3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new sp3();
            }
            return this.a;
        }
        return (sp3) invokeV.objValue;
    }

    public final void g(String str, xp3 xp3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, xp3Var) == null) {
            if (xp3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(xp3Var.b(), "POST")) {
                o(-1, xp3Var);
            } else {
                if (dp3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(xp3Var.b(), "GET")) {
                    b2 = hp3.f().b(this.a, null);
                } else {
                    b2 = hp3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (dp3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    xp3Var.i(true);
                    this.d = xp3Var;
                    xp3Var.h(b2);
                    return;
                }
                o(-1, xp3Var);
            }
        }
    }

    public final void j(String str, xp3 xp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, xp3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new np3(str, xp3Var));
                    if (f03.c()) {
                        op3 op3Var = new op3();
                        long j = op3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(op3Var.getString("secretKey", "").getBytes());
                            this.a.t(op3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, xp3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, xp3Var);
                return;
            }
            i(str, xp3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (dp3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (dp3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = hp3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new zp3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, xp3 xp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xp3Var) == null) {
            if (xp3Var != null && TextUtils.equals(xp3Var.b(), "GET")) {
                if (dp3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                xp3Var.i(false);
                this.d = xp3Var;
                xp3Var.h(null);
            } else if (xp3Var != null && str != null) {
                if (dp3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                xp3Var.i(false);
                this.d = xp3Var;
                xp3Var.h(str.getBytes());
            } else {
                o(-1, xp3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (dp3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                np3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        xp3 a2 = poll.a();
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
