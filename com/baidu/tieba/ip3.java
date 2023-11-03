package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.yp3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class ip3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ip3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public rp3 a;
    public ConcurrentLinkedQueue<mp3> b;
    public volatile boolean c;
    public wp3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wp3 b;
        public final /* synthetic */ ip3 c;

        public a(ip3 ip3Var, String str, wp3 wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip3Var, str, wp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ip3Var;
            this.a = str;
            this.b = wp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vi4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yp3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ip3 a;

        public b(ip3 ip3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ip3Var;
        }

        @Override // com.baidu.tieba.yp3.b
        public void a(boolean z, byte[] bArr) {
            pp3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (cp3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = tp3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (cp3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (sp3.a(this.a.a, f) != null) {
                                            if (cp3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            hp3.a("serverHello");
                                            while (true) {
                                                mp3 mp3Var = (mp3) this.a.b.poll();
                                                if (mp3Var != null) {
                                                    this.a.g(mp3Var.b(), mp3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (cp3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (cp3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        hp3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (cp3.a) {
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

    public ip3() {
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
        this.a = new rp3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, wp3 wp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, wp3Var) == null) && wp3Var != null) {
            wp3Var.f(i);
        }
    }

    public void p(String str, wp3 wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, wp3Var) == null) {
            aj3.l(new a(this, str, wp3Var), "SessionController");
        }
    }

    public static ip3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ip3.class) {
                    if (e == null) {
                        e = new ip3();
                    }
                }
            }
            return e;
        }
        return (ip3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wp3 wp3Var = this.d;
            if (wp3Var == null) {
                return false;
            }
            return wp3Var.c();
        }
        return invokeV.booleanValue;
    }

    public rp3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new rp3();
            }
            return this.a;
        }
        return (rp3) invokeV.objValue;
    }

    public final void g(String str, wp3 wp3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, wp3Var) == null) {
            if (wp3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(wp3Var.b(), "POST")) {
                o(-1, wp3Var);
            } else {
                if (cp3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(wp3Var.b(), "GET")) {
                    b2 = gp3.f().b(this.a, null);
                } else {
                    b2 = gp3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (cp3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    wp3Var.i(true);
                    this.d = wp3Var;
                    wp3Var.h(b2);
                    return;
                }
                o(-1, wp3Var);
            }
        }
    }

    public final void j(String str, wp3 wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wp3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new mp3(str, wp3Var));
                    if (e03.c()) {
                        np3 np3Var = new np3();
                        long j = np3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(np3Var.getString("secretKey", "").getBytes());
                            this.a.t(np3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, wp3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, wp3Var);
                return;
            }
            i(str, wp3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (cp3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (cp3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = gp3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new yp3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, wp3 wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, wp3Var) == null) {
            if (wp3Var != null && TextUtils.equals(wp3Var.b(), "GET")) {
                if (cp3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                wp3Var.i(false);
                this.d = wp3Var;
                wp3Var.h(null);
            } else if (wp3Var != null && str != null) {
                if (cp3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                wp3Var.i(false);
                this.d = wp3Var;
                wp3Var.h(str.getBytes());
            } else {
                o(-1, wp3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (cp3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                mp3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        wp3 a2 = poll.a();
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
