package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.nv3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class xu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xu3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public gv3 a;
    public ConcurrentLinkedQueue<bv3> b;
    public volatile boolean c;
    public lv3 d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lv3 b;
        public final /* synthetic */ xu3 c;

        public a(xu3 xu3Var, String str, lv3 lv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu3Var, str, lv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xu3Var;
            this.a = str;
            this.b = lv3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ko4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements nv3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu3 a;

        public b(xu3 xu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xu3Var;
        }

        @Override // com.baidu.tieba.nv3.b
        public void a(boolean z, byte[] bArr) {
            ev3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (ru3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = iv3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (ru3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (hv3.a(this.a.a, f) != null) {
                                            if (ru3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            wu3.a("serverHello");
                                            while (true) {
                                                bv3 bv3Var = (bv3) this.a.b.poll();
                                                if (bv3Var != null) {
                                                    this.a.g(bv3Var.b(), bv3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (ru3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (ru3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        wu3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (ru3.a) {
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

    public xu3() {
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
        this.a = new gv3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, lv3 lv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, lv3Var) == null) && lv3Var != null) {
            lv3Var.f(i);
        }
    }

    public void p(String str, lv3 lv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, lv3Var) == null) {
            po3.l(new a(this, str, lv3Var), "SessionController");
        }
    }

    public static xu3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (xu3.class) {
                    if (e == null) {
                        e = new xu3();
                    }
                }
            }
            return e;
        }
        return (xu3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            lv3 lv3Var = this.d;
            if (lv3Var == null) {
                return false;
            }
            return lv3Var.c();
        }
        return invokeV.booleanValue;
    }

    public gv3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new gv3();
            }
            return this.a;
        }
        return (gv3) invokeV.objValue;
    }

    public final void g(String str, lv3 lv3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, lv3Var) == null) {
            if (lv3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(lv3Var.b(), "POST")) {
                o(-1, lv3Var);
            } else {
                if (ru3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(lv3Var.b(), "GET")) {
                    b2 = vu3.f().b(this.a, null);
                } else {
                    b2 = vu3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (ru3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    lv3Var.i(true);
                    this.d = lv3Var;
                    lv3Var.h(b2);
                    return;
                }
                o(-1, lv3Var);
            }
        }
    }

    public final void j(String str, lv3 lv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, lv3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new bv3(str, lv3Var));
                    if (t53.c()) {
                        cv3 cv3Var = new cv3();
                        long j = cv3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(cv3Var.getString("secretKey", "").getBytes());
                            this.a.t(cv3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, lv3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, lv3Var);
                return;
            }
            i(str, lv3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ru3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (ru3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = vu3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new nv3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, lv3 lv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, lv3Var) == null) {
            if (lv3Var != null && TextUtils.equals(lv3Var.b(), "GET")) {
                if (ru3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                lv3Var.i(false);
                this.d = lv3Var;
                lv3Var.h(null);
            } else if (lv3Var != null && str != null) {
                if (ru3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                lv3Var.i(false);
                this.d = lv3Var;
                lv3Var.h(str.getBytes());
            } else {
                o(-1, lv3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (ru3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                bv3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        lv3 a2 = poll.a();
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
