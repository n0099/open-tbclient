package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vl1 extends yl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AuthnHelper s;
    public long t;
    public long u;
    public boolean v;

    /* loaded from: classes6.dex */
    public class a extends wl1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ vl1 e;

        public a(vl1 vl1Var, long j, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vl1Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                int optInt = jSONObject.optInt("resultCode", -1);
                if (!this.e.D(optInt, this.b) || (i = this.c) != 0) {
                    this.e.C(jSONObject, this.b);
                } else {
                    this.e.v(this.b, this.d, i + 1);
                }
                dm1.j().i();
                vl1 vl1Var = this.e;
                tm1.c(vl1Var.a, vl1Var.c, optInt, currentTimeMillis, this.d, "");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vl1 b;

        public b(vl1 vl1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vl1Var;
            this.a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) {
                return;
            }
            this.b.G(jSONObject, this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends ym1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ int c;
        public final /* synthetic */ vl1 d;

        public c(vl1 vl1Var, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vl1Var;
            this.b = jSONObject;
            this.c = i;
        }

        @Override // com.baidu.tieba.ym1
        public void b() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.b.optInt("resultCode", -1);
                    String optString = this.b.optString("authTypeDes", "");
                    if (optInt == 103000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.d.u = System.currentTimeMillis();
                        this.d.h = this.b.optString("token", "");
                        this.d.e(this.c, 0, 0, this.d.c, "preVerify success", 3);
                    } else if (optInt == 105312 && this.d.c != this.d.d) {
                        this.d.e(this.c, 3, 2002, this.d.c, "pre verify error, wrong sim operator", 3);
                    } else {
                        vl1 vl1Var = this.d;
                        int i = this.c;
                        int i2 = this.d.c;
                        vl1Var.e(i, 2, optInt, i2, "pre verify error." + optString, 3);
                    }
                } catch (Throwable th) {
                    dn1.d(th);
                    vl1 vl1Var2 = this.d;
                    int i3 = this.c;
                    int i4 = vl1Var2.c;
                    vl1Var2.e(i3, 3, 2009, i4, "cm on handle pre verify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ym1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ int c;
        public final /* synthetic */ vl1 d;

        public d(vl1 vl1Var, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vl1Var;
            this.b = jSONObject;
            this.c = i;
        }

        @Override // com.baidu.tieba.ym1
        public void b() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.b.optInt("resultCode", -1);
                    String optString = this.b.optString("desc", "");
                    if (optInt == 103000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.d.t = System.currentTimeMillis();
                        this.d.g = this.b.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.d.a(this.d.g));
                        this.d.e(this.c, 0, 0, this.d.c, jSONObject.toString(), 1);
                    } else if (optInt == 105312 && this.d.c != this.d.d) {
                        this.d.e(this.c, 3, 2002, this.d.c, "pre login error, wrong sim operator", 1);
                    } else {
                        vl1 vl1Var = this.d;
                        int i = this.c;
                        int i2 = this.d.c;
                        vl1Var.e(i, 2, optInt, i2, "pre login error." + optString, 1);
                    }
                } catch (Throwable th) {
                    dn1.d(th);
                    vl1 vl1Var2 = this.d;
                    int i3 = this.c;
                    int i4 = vl1Var2.c;
                    vl1Var2.e(i3, 3, 2009, i4, "cm on handle pre login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ym1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ int c;
        public final /* synthetic */ vl1 d;

        public e(vl1 vl1Var, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vl1Var;
            this.b = jSONObject;
            this.c = i;
        }

        @Override // com.baidu.tieba.ym1
        public void b() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.has("resultCode")) {
                        i = this.b.optInt("resultCode", -1);
                    } else {
                        i = -1;
                    }
                    if (i == 103000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.d.e = this.b.optString("token");
                        this.d.b(this.c);
                        return;
                    }
                    String optString = this.b.optString("resultDesc", "");
                    vl1 vl1Var = this.d;
                    int i2 = this.c;
                    int i3 = this.d.c;
                    vl1Var.d(i2, 2, i, i3, "error:" + optString);
                } catch (Throwable th) {
                    dn1.d(th);
                    vl1 vl1Var2 = this.d;
                    vl1Var2.d(this.c, 3, 2009, vl1Var2.c, "cm on handle login unknown error.");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends ym1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ vl1 c;

        public f(vl1 vl1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vl1Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.ym1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.c.g(this.b, this.c.c, this.c.h);
                } catch (Throwable th) {
                    dn1.d(th);
                    vl1 vl1Var = this.c;
                    vl1Var.n(this.b, 3, 2009, vl1Var.c, "cm on handle verify unknown error.");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vl1 b;

        public g(vl1 vl1Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl1Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vl1Var;
            this.a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) {
                return;
            }
            this.b.y(jSONObject, this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.c = 1;
    }

    public final void C(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i) == null) {
            an1.c().b(new d(this, jSONObject, i));
        }
    }

    public final void G(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, jSONObject, i) == null) {
            an1.c().b(new c(this, jSONObject, i));
        }
    }

    public final void y(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, jSONObject, i) == null) {
            an1.c().b(new e(this, jSONObject, i));
        }
    }

    @Override // com.baidu.tieba.yl1
    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.p(context, i, j);
            c(i, 4);
            E(i);
        }
    }

    public final void v(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) {
            this.s.getPhoneInfo(yl1.k, yl1.l, new a(this, System.currentTimeMillis(), i, i3, i2));
        }
    }

    public final boolean D(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            boolean c2 = nl1.g(this.a).c();
            boolean n = nl1.g(this.a).n("k_retry_code_cm", i);
            boolean h = sl1.j().h(i2);
            if (c2 && n && h) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            an1.c().b(new f(this, i));
        }
    }

    @Override // com.baidu.tieba.yl1
    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) {
            super.h(context, i);
            if (!nl1.g(this.a).d()) {
                e(i, 3, 997, this.c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i, 3, 2006, this.c, "pre verify error. cm has not valid config.", 3);
            } else if (nl1.g(this.a).q0()) {
                if (!this.v) {
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.mobileAuth(yl1.k, yl1.l, new b(this, i));
            } else {
                e(i, 3, 994, this.c, "pre verify error. cm sdk stop run.", 3);
            }
        }
    }

    @Override // com.baidu.tieba.yl1
    public void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, context, i, i2) == null) {
            super.i(context, i, i2);
            if (!nl1.g(this.a).d()) {
                e(i2, 3, 997, this.c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.c, "pre login error. cm has not valid config.", 1);
            } else if (nl1.g(this.a).q0()) {
                if (!this.v) {
                    System.currentTimeMillis();
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    AuthnHelper.setDebugMode(rl1.c());
                    this.v = true;
                }
                v(i2, i, 0);
            } else {
                e(i2, 3, 994, this.c, "pre login error. cm sdk stop run.", 1);
            }
        }
    }

    @Override // com.baidu.tieba.yl1
    public void j(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.j(context, i, j);
            c(i, 2);
            this.s.loginAuth(yl1.k, yl1.l, new g(this, i));
        }
    }

    @Override // com.baidu.tieba.yl1
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yl1
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (System.currentTimeMillis() - this.u > 115000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yl1
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = null;
        }
    }

    @Override // com.baidu.tieba.yl1
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h = null;
            this.u = 0L;
        }
    }
}
