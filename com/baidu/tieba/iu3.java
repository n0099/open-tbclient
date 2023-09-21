package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.yu3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class iu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iu3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ru3 a;
    public ConcurrentLinkedQueue<mu3> b;
    public volatile boolean c;
    public wu3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wu3 b;
        public final /* synthetic */ iu3 c;

        public a(iu3 iu3Var, String str, wu3 wu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu3Var, str, wu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iu3Var;
            this.a = str;
            this.b = wu3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vn4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yu3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu3 a;

        public b(iu3 iu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu3Var;
        }

        @Override // com.baidu.tieba.yu3.b
        public void a(boolean z, byte[] bArr) {
            pu3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (cu3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = tu3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (cu3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (su3.a(this.a.a, f) != null) {
                                            if (cu3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            hu3.a("serverHello");
                                            while (true) {
                                                mu3 mu3Var = (mu3) this.a.b.poll();
                                                if (mu3Var != null) {
                                                    this.a.g(mu3Var.b(), mu3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (cu3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (cu3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        hu3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (cu3.a) {
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

    public iu3() {
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
        this.a = new ru3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, wu3 wu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, wu3Var) == null) && wu3Var != null) {
            wu3Var.f(i);
        }
    }

    public void p(String str, wu3 wu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, wu3Var) == null) {
            ao3.l(new a(this, str, wu3Var), "SessionController");
        }
    }

    public static iu3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (iu3.class) {
                    if (e == null) {
                        e = new iu3();
                    }
                }
            }
            return e;
        }
        return (iu3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wu3 wu3Var = this.d;
            if (wu3Var == null) {
                return false;
            }
            return wu3Var.c();
        }
        return invokeV.booleanValue;
    }

    public ru3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ru3();
            }
            return this.a;
        }
        return (ru3) invokeV.objValue;
    }

    public final void g(String str, wu3 wu3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, wu3Var) == null) {
            if (wu3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(wu3Var.b(), "POST")) {
                o(-1, wu3Var);
            } else {
                if (cu3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(wu3Var.b(), "GET")) {
                    b2 = gu3.f().b(this.a, null);
                } else {
                    b2 = gu3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (cu3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    wu3Var.i(true);
                    this.d = wu3Var;
                    wu3Var.h(b2);
                    return;
                }
                o(-1, wu3Var);
            }
        }
    }

    public final void j(String str, wu3 wu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wu3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new mu3(str, wu3Var));
                    if (e53.c()) {
                        nu3 nu3Var = new nu3();
                        long j = nu3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(nu3Var.getString("secretKey", "").getBytes());
                            this.a.t(nu3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, wu3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, wu3Var);
                return;
            }
            i(str, wu3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (cu3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (cu3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = gu3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new yu3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, wu3 wu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wu3Var) == null) {
            if (wu3Var != null && TextUtils.equals(wu3Var.b(), "GET")) {
                if (cu3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                wu3Var.i(false);
                this.d = wu3Var;
                wu3Var.h(null);
            } else if (wu3Var != null && str != null) {
                if (cu3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                wu3Var.i(false);
                this.d = wu3Var;
                wu3Var.h(str.getBytes());
            } else {
                o(-1, wu3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (cu3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                mu3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        wu3 a2 = poll.a();
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
