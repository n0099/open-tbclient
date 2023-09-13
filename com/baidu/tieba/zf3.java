package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tieba.ag3;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zf3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* loaded from: classes9.dex */
    public class b implements e33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ hb3 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ zf3 f;

        /* loaded from: classes9.dex */
        public class a implements aq3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hg3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.zf3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class RunnableC0542a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0542a(a aVar, Boolean bool) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, bool};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        a aVar = this.b;
                        zf3 zf3Var = aVar.c.f;
                        hg3 hg3Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        zf3Var.P(hg3Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, hg3 hg3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, hg3Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = hg3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    bp3.a0(new RunnableC0542a(this, bool));
                }
            }
        }

        /* renamed from: com.baidu.tieba.zf3$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0543b implements aq3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hg3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.zf3$b$b$a */
            /* loaded from: classes9.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0543b a;

                public a(C0543b c0543b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0543b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0543b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0543b c0543b = this.a;
                        b bVar = c0543b.c;
                        bVar.f.P(c0543b.a, c0543b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0543b(b bVar, hg3 hg3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, hg3Var, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = hg3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    bp3.a0(new a(this));
                }
            }
        }

        public b(zf3 zf3Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, hb3 hb3Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, callbackHandler, str, jSONArray, hb3Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = hb3Var;
            this.e = activity;
        }

        @Override // com.baidu.tieba.e33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, hg3> g = f33.g(true);
                hg3 y = this.f.y(g, this.a, this.b);
                if (y == null) {
                    ag3.b d = ag3.d();
                    d.n(false);
                    d.o();
                    return;
                }
                List<hg3> w = this.f.w(g, this.c, this.a, this.b);
                if (w == null) {
                    return;
                }
                y.i(w);
                if (!this.d.N().e(this.e)) {
                    ou2.Z().a(this.e, new a(this, y, w));
                } else {
                    this.f.z(new C0543b(this, y, w));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ hb3 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ zf3 f;

        public a(zf3 zf3Var, CallbackHandler callbackHandler, String str, Context context, hb3 hb3Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, callbackHandler, str, context, hb3Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = hb3Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                ag3.b d = ag3.d();
                d.n(false);
                d.o();
                fg3.q(kg3Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements cg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ hb3 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ zf3 g;

        public c(zf3 zf3Var, CallbackHandler callbackHandler, String str, boolean z, hb3 hb3Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, callbackHandler, str, Boolean.valueOf(z), hb3Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = hb3Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.baidu.tieba.cg3
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                h82.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    ag3.b d = ag3.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    fg3.o(10003, this.a, this.b);
                    return;
                }
                ag3.b d2 = ag3.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    ag3.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (!z2) {
                    ag3.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                } else {
                    this.g.K(this.f, this.e, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zf3 e;

        public d(zf3 zf3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zf3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.zf3.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                h82.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    ag3.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                ag3.b d = ag3.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                fg3.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements aq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zf3 e;

        public e(zf3 zf3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zf3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements aq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zf3 e;

        public f(zf3 zf3Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zf3Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    ag3.b d = ag3.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                ag3.b d2 = ag3.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                fg3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements aq3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zf3 e;

        public g(zf3 zf3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zf3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    ag3.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                ag3.b d = ag3.d();
                d.m(false);
                d.n(false);
                d.o();
                fg3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(zf3 zf3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (kg3Var == null) {
                    fg3.o(10001, this.a, this.b);
                    ag3.b d = ag3.d();
                    d.n(false);
                    d.o();
                    ai3.r(10001, null);
                    return;
                }
                int b = kg3Var.b();
                h82.o("MultiAuthorize", "requestAuthorize " + kg3Var.a() + ",  code=" + b + ", data=" + kg3Var.a);
                if (b != 0) {
                    ag3.b d2 = ag3.d();
                    d2.n(false);
                    d2.o();
                    fg3.o(b, this.a, this.b);
                    return;
                }
                ag3.b d3 = ag3.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(zf3 zf3Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf3Var, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    this.a.a(false, i);
                } else {
                    this.a.a(true, i);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zf3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(List<hg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (hg3 hg3Var : list) {
                    if (hg3Var != null && C(hg3Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean D(List<hg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (hg3 hg3Var : list) {
                if (hg3Var != null && !E(hg3Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(List<hg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (hg3 hg3Var : list) {
                if (hg3Var != null && C(hg3Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<hg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                ag3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void K(List<hg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            ou2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void G(List<hg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull hb3 hb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, hb3Var) == null) {
            if (D(list)) {
                ag3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(hb3Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull hb3 hb3Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, hb3Var, callbackHandler, jSONArray, str) == null) {
            d33.g().z(new b(this, callbackHandler, str, jSONArray, hb3Var, activity));
        }
    }

    public final boolean B(hg3 hg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hg3Var)) == null) {
            if (!TextUtils.equals(hg3Var.b, "mapp_location") && !TextUtils.equals(hg3Var.b, "mapp_images") && !TextUtils.equals(hg3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(hg3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(hg3Var.b, "ppcert") && !TextUtils.equals(hg3Var.b, "mapp_i_face_verify") && !TextUtils.equals(hg3Var.b, "snsapi_userinfo") && !TextUtils.equals(hg3Var.b, "mapp_choose_address") && !TextUtils.equals(hg3Var.b, "mobile") && !TextUtils.equals(hg3Var.b, "mapp_choose_invoice") && !TextUtils.equals(hg3Var.b, "mapp_i_read_contacts") && !TextUtils.equals(hg3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean C(hg3 hg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hg3Var)) == null) {
            if (!TextUtils.equals(hg3Var.b, "ppcert") && !TextUtils.equals(hg3Var.b, "mapp_i_face_verify")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(aq3<String> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aq3Var) == null) {
            ou2.Z().b(false, aq3Var);
        }
    }

    public final void z(aq3<String> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aq3Var) == null) {
            ou2.Z().c(ou2.c(), aq3Var);
        }
    }

    public final boolean E(hg3 hg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hg3Var)) == null) {
            if (!TextUtils.equals(hg3Var.b, "mapp_location") && !TextUtils.equals(hg3Var.b, "mapp_images") && !TextUtils.equals(hg3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(hg3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(hg3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(boolean z, List<hg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                ag3.b d2 = ag3.d();
                d2.l(true);
                d2.i(true);
                h82.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            ag3.d().l(false);
            h82.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<hg3> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            mg3 d2 = gb3.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void L(@NonNull hb3 hb3Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, hb3Var, activity, jVar) == null) {
            v(hb3Var, activity, jVar);
        }
    }

    public final void v(@NonNull hb3 hb3Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, hb3Var, activity, jVar) == null) {
            hb3Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final void N(@NonNull Activity activity, hg3 hg3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, hg3Var, str) == null) {
            String Z = gb3.K().q().Z();
            boolean equals = TextUtils.equals(str, "1");
            if (A(hg3Var.s)) {
                if (equals) {
                    hg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1561) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1560);
                    return;
                }
                hg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1563) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1560);
                return;
            }
            hg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1561) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1560);
        }
    }

    public final void O(@NonNull Activity activity, hg3 hg3Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, hg3Var, bool) == null) {
            String Z = gb3.K().q().Z();
            boolean D = D(hg3Var.s);
            boolean A = A(hg3Var.s);
            if (!bool.booleanValue() && !D) {
                hg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1562) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1560);
            } else if (A) {
                hg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1563) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1560);
            } else {
                hg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1561) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1560);
            }
        }
    }

    public final void P(hg3 hg3Var, List<hg3> list, boolean z, @NonNull Activity activity, @NonNull hb3 hb3Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{hg3Var, list, Boolean.valueOf(z), activity, hb3Var, callbackHandler, str}) == null) {
            fg3.u(activity, hb3Var, hg3Var, new JSONObject(), new c(this, callbackHandler, str, z, hb3Var, activity, list));
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var != null && (context instanceof Activity)) {
                JSONObject a2 = ed3.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        ag3.d().n(true);
                        hb3Var.e0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, hb3Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    ag3.b d2 = ag3.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                ag3.b d3 = ag3.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            ag3.b d4 = ag3.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<hg3> w(Map<String, hg3> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = hg3.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    hg3 hg3Var = map.get(c2);
                    if (map.containsKey(c2) && hg3Var != null && B(hg3Var)) {
                        if (hg3Var.d) {
                            fg3.o(10005, callbackHandler, str);
                            ag3.b d2 = ag3.d();
                            d2.n(false);
                            d2.o();
                            ai3.r(10005, hg3Var);
                            return null;
                        }
                        if (!arrayList.contains(hg3Var) && !hg3Var.a()) {
                            arrayList.add(hg3Var);
                        }
                        if (!hg3Var.a()) {
                            z = false;
                        }
                    } else {
                        fg3.o(10005, callbackHandler, str);
                        ag3.b d3 = ag3.d();
                        d3.n(false);
                        d3.o();
                        ai3.r(10005, hg3Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                ag3.b d4 = ag3.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            h82.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                ag3.b d5 = ag3.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public final hg3 y(Map<String, hg3> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            hg3 hg3Var = map.get("scope_multi_authorize");
            if (hg3Var == null) {
                fg3.o(10001, callbackHandler, str);
                ai3.r(10001, null);
                return null;
            } else if (hg3Var.d) {
                fg3.o(10005, callbackHandler, str);
                ai3.r(10005, hg3Var);
                return null;
            } else {
                return hg3Var;
            }
        }
        return (hg3) invokeLLL.objValue;
    }
}
