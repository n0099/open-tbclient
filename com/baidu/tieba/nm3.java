package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.dn3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class nm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nm3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public wm3 a;
    public ConcurrentLinkedQueue<rm3> b;
    public volatile boolean c;
    public bn3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bn3 b;
        public final /* synthetic */ nm3 c;

        public a(nm3 nm3Var, String str, bn3 bn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm3Var, str, bn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nm3Var;
            this.a = str;
            this.b = bn3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ag4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dn3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm3 a;

        public b(nm3 nm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm3Var;
        }

        @Override // com.baidu.tieba.dn3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            um3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (hm3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = ym3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (hm3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (hm3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (hm3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        mm3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (xm3.a(this.a.a, f) != null) {
                                        if (hm3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        mm3.a("serverHello");
                                        while (true) {
                                            rm3 rm3Var = (rm3) this.a.b.poll();
                                            if (rm3Var == null) {
                                                return;
                                            }
                                            this.a.g(rm3Var.b(), rm3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (hm3.a) {
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

    public nm3() {
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
        this.a = new wm3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static nm3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (nm3.class) {
                    if (e == null) {
                        e = new nm3();
                    }
                }
            }
            return e;
        }
        return (nm3) invokeV.objValue;
    }

    public final void g(String str, bn3 bn3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, bn3Var) == null) {
            if (bn3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(bn3Var.b(), "POST")) {
                o(-1, bn3Var);
            } else {
                if (hm3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(bn3Var.b(), "GET")) {
                    b2 = lm3.f().b(this.a, null);
                } else {
                    b2 = lm3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (hm3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    bn3Var.i(true);
                    this.d = bn3Var;
                    bn3Var.h(b2);
                    return;
                }
                o(-1, bn3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (hm3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (hm3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = lm3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new dn3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, bn3 bn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bn3Var) == null) {
            if (bn3Var != null && TextUtils.equals(bn3Var.b(), "GET")) {
                if (hm3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                bn3Var.i(false);
                this.d = bn3Var;
                bn3Var.h(null);
            } else if (bn3Var != null && str != null) {
                if (hm3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                bn3Var.i(false);
                this.d = bn3Var;
                bn3Var.h(str.getBytes());
            } else {
                o(-1, bn3Var);
            }
        }
    }

    public final void j(String str, bn3 bn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bn3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new rm3(str, bn3Var));
                    if (jx2.c()) {
                        sm3 sm3Var = new sm3();
                        long j = sm3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(sm3Var.getString("secretKey", "").getBytes());
                            this.a.t(sm3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, bn3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, bn3Var);
                return;
            }
            i(str, bn3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            bn3 bn3Var = this.d;
            if (bn3Var == null) {
                return false;
            }
            return bn3Var.c();
        }
        return invokeV.booleanValue;
    }

    public wm3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new wm3();
            }
            return this.a;
        }
        return (wm3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (hm3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            rm3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                bn3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, bn3 bn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, bn3Var) == null) || bn3Var == null) {
            return;
        }
        bn3Var.f(i);
    }

    public void p(String str, bn3 bn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bn3Var) == null) {
            fg3.l(new a(this, str, bn3Var), "SessionController");
        }
    }
}
