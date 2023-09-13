package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.zu3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class ju3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ju3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public su3 a;
    public ConcurrentLinkedQueue<nu3> b;
    public volatile boolean c;
    public xu3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xu3 b;
        public final /* synthetic */ ju3 c;

        public a(ju3 ju3Var, String str, xu3 xu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju3Var, str, xu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ju3Var;
            this.a = str;
            this.b = xu3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wn4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zu3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju3 a;

        public b(ju3 ju3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju3Var;
        }

        @Override // com.baidu.tieba.zu3.b
        public void a(boolean z, byte[] bArr) {
            qu3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (du3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = uu3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (du3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (tu3.a(this.a.a, f) != null) {
                                            if (du3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            iu3.a("serverHello");
                                            while (true) {
                                                nu3 nu3Var = (nu3) this.a.b.poll();
                                                if (nu3Var != null) {
                                                    this.a.g(nu3Var.b(), nu3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (du3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (du3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        iu3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (du3.a) {
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

    public ju3() {
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
        this.a = new su3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, xu3Var) == null) && xu3Var != null) {
            xu3Var.f(i);
        }
    }

    public void p(String str, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, xu3Var) == null) {
            bo3.l(new a(this, str, xu3Var), "SessionController");
        }
    }

    public static ju3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ju3.class) {
                    if (e == null) {
                        e = new ju3();
                    }
                }
            }
            return e;
        }
        return (ju3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            xu3 xu3Var = this.d;
            if (xu3Var == null) {
                return false;
            }
            return xu3Var.c();
        }
        return invokeV.booleanValue;
    }

    public su3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new su3();
            }
            return this.a;
        }
        return (su3) invokeV.objValue;
    }

    public final void g(String str, xu3 xu3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, xu3Var) == null) {
            if (xu3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(xu3Var.b(), "POST")) {
                o(-1, xu3Var);
            } else {
                if (du3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(xu3Var.b(), "GET")) {
                    b2 = hu3.f().b(this.a, null);
                } else {
                    b2 = hu3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (du3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    xu3Var.i(true);
                    this.d = xu3Var;
                    xu3Var.h(b2);
                    return;
                }
                o(-1, xu3Var);
            }
        }
    }

    public final void j(String str, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, xu3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new nu3(str, xu3Var));
                    if (f53.c()) {
                        ou3 ou3Var = new ou3();
                        long j = ou3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ou3Var.getString("secretKey", "").getBytes());
                            this.a.t(ou3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, xu3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, xu3Var);
                return;
            }
            i(str, xu3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (du3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (du3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = hu3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new zu3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, xu3 xu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xu3Var) == null) {
            if (xu3Var != null && TextUtils.equals(xu3Var.b(), "GET")) {
                if (du3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                xu3Var.i(false);
                this.d = xu3Var;
                xu3Var.h(null);
            } else if (xu3Var != null && str != null) {
                if (du3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                xu3Var.i(false);
                this.d = xu3Var;
                xu3Var.h(str.getBytes());
            } else {
                o(-1, xu3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (du3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                nu3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        xu3 a2 = poll.a();
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
