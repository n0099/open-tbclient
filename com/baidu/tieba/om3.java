package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.en3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class om3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile om3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public xm3 a;
    public ConcurrentLinkedQueue b;
    public volatile boolean c;
    public cn3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cn3 b;
        public final /* synthetic */ om3 c;

        public a(om3 om3Var, String str, cn3 cn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, str, cn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om3Var;
            this.a = str;
            this.b = cn3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bg4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements en3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om3 a;

        public b(om3 om3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om3Var;
        }

        @Override // com.baidu.tieba.en3.b
        public void a(boolean z, byte[] bArr) {
            vm3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (im3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = zm3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (im3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (ym3.a(this.a.a, f) != null) {
                                            if (im3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            nm3.a("serverHello");
                                            while (true) {
                                                sm3 sm3Var = (sm3) this.a.b.poll();
                                                if (sm3Var != null) {
                                                    this.a.g(sm3Var.b(), sm3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (im3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (im3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        nm3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (im3.a) {
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

    public om3() {
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
        this.a = new xm3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue();
    }

    public final void o(int i, cn3 cn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, cn3Var) == null) && cn3Var != null) {
            cn3Var.f(i);
        }
    }

    public void p(String str, cn3 cn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cn3Var) == null) {
            gg3.l(new a(this, str, cn3Var), "SessionController");
        }
    }

    public static om3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (om3.class) {
                    if (e == null) {
                        e = new om3();
                    }
                }
            }
            return e;
        }
        return (om3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cn3 cn3Var = this.d;
            if (cn3Var == null) {
                return false;
            }
            return cn3Var.c();
        }
        return invokeV.booleanValue;
    }

    public xm3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new xm3();
            }
            return this.a;
        }
        return (xm3) invokeV.objValue;
    }

    public final void g(String str, cn3 cn3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cn3Var) == null) {
            if (cn3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(cn3Var.b(), "POST")) {
                o(-1, cn3Var);
            } else {
                if (im3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(cn3Var.b(), "GET")) {
                    b2 = mm3.f().b(this.a, null);
                } else {
                    b2 = mm3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (im3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    cn3Var.i(true);
                    this.d = cn3Var;
                    cn3Var.h(b2);
                    return;
                }
                o(-1, cn3Var);
            }
        }
    }

    public final void j(String str, cn3 cn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cn3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue();
                    }
                    this.b.offer(new sm3(str, cn3Var));
                    if (kx2.c()) {
                        tm3 tm3Var = new tm3();
                        long j = tm3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(tm3Var.getString("secretKey", "").getBytes());
                            this.a.t(tm3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, cn3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, cn3Var);
                return;
            }
            i(str, cn3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (im3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (im3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = mm3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new en3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, cn3 cn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cn3Var) == null) {
            if (cn3Var != null && TextUtils.equals(cn3Var.b(), "GET")) {
                if (im3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                cn3Var.i(false);
                this.d = cn3Var;
                cn3Var.h(null);
            } else if (cn3Var != null && str != null) {
                if (im3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                cn3Var.i(false);
                this.d = cn3Var;
                cn3Var.h(str.getBytes());
            } else {
                o(-1, cn3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (im3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                sm3 sm3Var = (sm3) this.b.poll();
                if (sm3Var != null) {
                    if (i == 2) {
                        i(sm3Var.b(), sm3Var.a());
                    } else {
                        cn3 a2 = sm3Var.a();
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
