package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.hp3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class ro3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ro3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ap3 a;
    public ConcurrentLinkedQueue<vo3> b;
    public volatile boolean c;
    public fp3 d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fp3 b;
        public final /* synthetic */ ro3 c;

        public a(ro3 ro3Var, String str, fp3 fp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro3Var, str, fp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ro3Var;
            this.a = str;
            this.b = fp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ei4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements hp3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro3 a;

        public b(ro3 ro3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro3Var;
        }

        @Override // com.baidu.tieba.hp3.b
        public void a(boolean z, byte[] bArr) {
            yo3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (lo3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = cp3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (lo3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (bp3.a(this.a.a, f) != null) {
                                            if (lo3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            qo3.a("serverHello");
                                            while (true) {
                                                vo3 vo3Var = (vo3) this.a.b.poll();
                                                if (vo3Var != null) {
                                                    this.a.g(vo3Var.b(), vo3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (lo3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (lo3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        qo3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (lo3.a) {
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

    public ro3() {
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
        this.a = new ap3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, fp3 fp3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, fp3Var) == null) && fp3Var != null) {
            fp3Var.f(i);
        }
    }

    public void p(String str, fp3 fp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, fp3Var) == null) {
            ji3.l(new a(this, str, fp3Var), "SessionController");
        }
    }

    public static ro3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ro3.class) {
                    if (e == null) {
                        e = new ro3();
                    }
                }
            }
            return e;
        }
        return (ro3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fp3 fp3Var = this.d;
            if (fp3Var == null) {
                return false;
            }
            return fp3Var.c();
        }
        return invokeV.booleanValue;
    }

    public ap3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ap3();
            }
            return this.a;
        }
        return (ap3) invokeV.objValue;
    }

    public final void g(String str, fp3 fp3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, fp3Var) == null) {
            if (fp3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(fp3Var.b(), "POST")) {
                o(-1, fp3Var);
            } else {
                if (lo3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(fp3Var.b(), "GET")) {
                    b2 = po3.f().b(this.a, null);
                } else {
                    b2 = po3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (lo3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    fp3Var.i(true);
                    this.d = fp3Var;
                    fp3Var.h(b2);
                    return;
                }
                o(-1, fp3Var);
            }
        }
    }

    public final void j(String str, fp3 fp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fp3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new vo3(str, fp3Var));
                    if (nz2.c()) {
                        wo3 wo3Var = new wo3();
                        long j = wo3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(wo3Var.getString("secretKey", "").getBytes());
                            this.a.t(wo3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, fp3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, fp3Var);
                return;
            }
            i(str, fp3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (lo3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (lo3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = po3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new hp3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, fp3 fp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, fp3Var) == null) {
            if (fp3Var != null && TextUtils.equals(fp3Var.b(), "GET")) {
                if (lo3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                fp3Var.i(false);
                this.d = fp3Var;
                fp3Var.h(null);
            } else if (fp3Var != null && str != null) {
                if (lo3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                fp3Var.i(false);
                this.d = fp3Var;
                fp3Var.h(str.getBytes());
            } else {
                o(-1, fp3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (lo3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                vo3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        fp3 a2 = poll.a();
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
