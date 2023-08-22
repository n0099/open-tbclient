package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.tieba.aw2;
import com.baidu.tieba.ma2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public kh4 a;
    public SwanAppMenuHeaderView b;
    public ja2 c;
    public Context d;

    /* loaded from: classes8.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public class a implements ih4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t03 a;

        public a(t03 t03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t03Var;
        }

        @Override // com.baidu.tieba.ih4
        public boolean b(View view2, lh4 lh4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, lh4Var)) == null) {
                return this.a.v(lh4Var);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t03 a;

        public b(t03 t03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t03Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.f();
                this.a.A();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t03 a;

        public c(t03 t03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t03Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.f();
                this.a.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t03 a;

        public d(t03 t03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t03Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.a.f();
                return this.a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements xm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t03 a;

        public e(t03 t03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t03Var;
        }

        @Override // com.baidu.tieba.xm2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
                va3 f = va3.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0140);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.xm2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                va3 f = va3.f(this.a.d, R.string.obfuscated_res_0x7f0f1580);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.xm2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                va3 f = va3.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0141);
                f.l(2);
                f.G();
                this.a.C();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements wm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t03 b;

        public f(t03 t03Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t03Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t03Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.wm2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                va3 f = va3.f(this.b.d, R.string.obfuscated_res_0x7f0f1580);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.wm2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && !z) {
                va3 f = va3.f(this.b.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0189);
                f.l(2);
                f.G();
            }
        }

        @Override // com.baidu.tieba.wm2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                bi2.t();
                if (t03.k(this.b.c.getActivity())) {
                    t03.p("addmyswan", this.a);
                    return;
                }
                va3 g = va3.g(this.b.d, ku2.l0().f(this.b.d));
                g.l(2);
                g.q(2);
                g.G();
                this.b.C();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements wm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ h b;

        public g(Activity activity, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = hVar;
        }

        @Override // com.baidu.tieba.wm2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                va3 f = va3.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f1580);
                f.l(2);
                f.G();
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.baidu.tieba.wm2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    va3 f = va3.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0189);
                    f.l(2);
                    f.G();
                }
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.baidu.tieba.wm2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                bi2.t();
                if (t03.k(this.a)) {
                    h hVar = this.b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.a.getApplicationContext();
                va3 g = va3.g(applicationContext, ku2.l0().f(applicationContext));
                g.l(2);
                g.q(2);
                g.G();
                h hVar2 = this.b;
                if (hVar2 != null) {
                    hVar2.onSuccess();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127346, "Lcom/baidu/tieba/t03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127346, "Lcom/baidu/tieba/t03;");
                return;
            }
        }
        e = nr1.a;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setAttentionBtnStates(bi2.n(cb3.K().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            yo3.b(this.d).c(d13.b(xo3.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.O2();
            o("share");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String O = cb3.K().q().O();
            if (TextUtils.isEmpty(O)) {
                return;
            }
            if (bi2.n(O)) {
                m(O);
            } else {
                l(O);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o(Headers.REFRESH);
            lo3.a(qw2.T().getActivity());
            d82.k("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "restart");
            }
            Context context = this.d;
            if (context == null) {
                return;
            }
            lo3.a((SwanAppActivity) context);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t03(kh4 kh4Var, ja2 ja2Var) {
        this(kh4Var, ja2Var, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kh4Var, ja2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((kh4) objArr2[0], (ja2) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public t03(kh4 kh4Var, ja2 ja2Var, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kh4Var, ja2Var, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = kh4Var;
        this.b = swanAppMenuHeaderView;
        this.c = ja2Var;
        if (ja2Var != null) {
            this.d = ja2Var.getContext();
        }
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) {
            return ku2.l0().a(activity);
        }
        return invokeL.booleanValue;
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            p(str, null);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).y().D());
            if (activity != null) {
                mn3.j(activity);
            }
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            yk2 l = yk2.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String O = cb3.K().q().O();
            if (TextUtils.isEmpty(O) && hVar != null) {
                hVar.onFail();
            }
            if (!bi2.n(O)) {
                SwanFavorDataManager.h().b(O, new g(activity, hVar));
            } else if (hVar != null) {
                hVar.onSuccess();
            }
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, activity) != null) || activity == null) {
            return;
        }
        if (e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = ku2.M().a();
        ku2.M().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).y(ku2.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).E();
        }
        if (a2) {
            va3 f2 = va3.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f013c);
            f2.m(R.drawable.obfuscated_res_0x7f080158);
            f2.l(2);
            f2.B();
        } else {
            va3 f3 = va3.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f013d);
            f3.m(R.drawable.obfuscated_res_0x7f0801bc);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public boolean v(lh4 lh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, lh4Var)) == null) {
            if (this.c != null && this.d != null) {
                int c2 = lh4Var.c();
                if (c2 != 4) {
                    if (c2 != 5) {
                        if (c2 != 35) {
                            if (c2 != 49) {
                                if (c2 != 42) {
                                    if (c2 != 43) {
                                        switch (c2) {
                                            case 37:
                                                B();
                                                return true;
                                            case 38:
                                                u();
                                                return true;
                                            case 39:
                                                x();
                                                return true;
                                            default:
                                                return ku2.K().j(lh4Var);
                                        }
                                    }
                                    xo3.d();
                                    return true;
                                }
                                y();
                                return true;
                            }
                            s();
                            return true;
                        }
                        i();
                        return true;
                    }
                    j(this.c.getActivity());
                    return true;
                }
                n();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            q(str, str2, null);
        }
    }

    public static void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            r(str, str2, str3, null, null);
        }
    }

    public static void r(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65552, null, str, str2, str3, str4, str5) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        gi3 gi3Var = new gi3();
        gi3Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            gi3Var.a("page", str2);
            gi3Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            gi3Var.b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            gi3Var.a(str4, str5);
        }
        SwanAppActivity activity = qw2.T().getActivity();
        if (activity != null) {
            activity.N(gi3Var);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            ma2 U = qw2.T().U();
            if (U == null) {
                va3.f(this.d, R.string.obfuscated_res_0x7f0f01d3).G();
                return;
            }
            ma2.b i = U.i("navigateTo");
            i.n(ma2.g, ma2.i);
            i.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startSettingFragment");
            }
            ma2 N1 = this.c.N1();
            if (N1 == null) {
                va3.f(this.d, R.string.obfuscated_res_0x7f0f01d3).G();
                return;
            }
            ma2.b i = N1.i("navigateTo");
            i.n(ma2.g, ma2.i);
            i.k("authority", null).a();
            o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    public final void i() {
        aw2.a S;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c73.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                va3.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f015c).G();
                return;
            }
            if (e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (db3.b0() != null) {
                S = db3.b0().W();
            } else {
                S = ((SwanAppActivity) this.c.getActivity()).S();
            }
            qg3.i(this.c.getContext(), S);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (c73.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                va3.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f015b).G();
                return;
            }
            String e2 = xo3.n().e();
            SwanFavorDataManager.h().b(str, new f(this, e2));
            p("addmyswan", e2);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ma2 N1 = this.c.N1();
            if (N1 == null) {
                va3.f(this.d, R.string.obfuscated_res_0x7f0f01d3).G();
                return;
            }
            ma2.b i = N1.i("navigateTo");
            i.n(ma2.g, ma2.i);
            i.k(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, null).a();
            o("set");
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.c != null && this.d != null) {
                if (D()) {
                    string = this.d.getString(R.string.obfuscated_res_0x7f0f15a1);
                } else {
                    string = this.d.getString(R.string.obfuscated_res_0x7f0f15a0);
                }
                va3 g2 = va3.g(this.d, string);
                g2.l(2);
                g2.G();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        db3 q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.a == null || this.c == null || this.d == null || (q = cb3.K().q()) == null) {
            return;
        }
        q.w();
        this.a.n(new a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.b.setAttentionBtnShow(ku2.t().b());
            this.b.setOnAttentionBtnClickListener(new c(this));
            if (!q.w0()) {
                this.b.setOnMenuHeaderLongClickListener(new d(this));
            }
        }
    }
}
