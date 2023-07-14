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
import com.baidu.tieba.ah3;
import com.baidu.tieba.og3;
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
/* loaded from: classes7.dex */
public class ng3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* loaded from: classes7.dex */
    public class b implements s33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ ng3 f;

        /* loaded from: classes7.dex */
        public class a implements oq3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vg3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.ng3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0415a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0415a(a aVar, Boolean bool) {
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
                        ng3 ng3Var = aVar.c.f;
                        vg3 vg3Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        ng3Var.P(vg3Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, vg3 vg3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, vg3Var, list};
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
                this.a = vg3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    pp3.a0(new RunnableC0415a(this, bool));
                }
            }
        }

        /* renamed from: com.baidu.tieba.ng3$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0416b implements oq3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vg3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.ng3$b$b$a */
            /* loaded from: classes7.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0416b a;

                public a(C0416b c0416b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0416b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0416b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0416b c0416b = this.a;
                        b bVar = c0416b.c;
                        bVar.f.P(c0416b.a, c0416b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0416b(b bVar, vg3 vg3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, vg3Var, list};
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
                this.a = vg3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    pp3.a0(new a(this));
                }
            }
        }

        public b(ng3 ng3Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, vb3 vb3Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, callbackHandler, str, jSONArray, vb3Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ng3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = vb3Var;
            this.e = activity;
        }

        @Override // com.baidu.tieba.s33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, vg3> g = t33.g(true);
                vg3 y = this.f.y(g, this.a, this.b);
                if (y == null) {
                    og3.b d = og3.d();
                    d.n(false);
                    d.o();
                    return;
                }
                List<vg3> w = this.f.w(g, this.c, this.a, this.b);
                if (w == null) {
                    return;
                }
                y.i(w);
                if (!this.d.N().e(this.e)) {
                    cv2.Z().a(this.e, new a(this, y, w));
                } else {
                    this.f.z(new C0416b(this, y, w));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ ng3 f;

        public a(ng3 ng3Var, CallbackHandler callbackHandler, String str, Context context, vb3 vb3Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, callbackHandler, str, context, vb3Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ng3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = vb3Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                og3.b d = og3.d();
                d.n(false);
                d.o();
                tg3.q(yg3Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements qg3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ vb3 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ ng3 g;

        public c(ng3 ng3Var, CallbackHandler callbackHandler, String str, boolean z, vb3 vb3Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, callbackHandler, str, Boolean.valueOf(z), vb3Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ng3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = vb3Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.baidu.tieba.qg3
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                v82.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    og3.b d = og3.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    tg3.o(10003, this.a, this.b);
                    return;
                }
                og3.b d2 = og3.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    og3.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (!z2) {
                    og3.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                } else {
                    this.g.K(this.f, this.e, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ng3 e;

        public d(ng3 ng3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.ng3.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                v82.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    og3.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                og3.b d = og3.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                tg3.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements oq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ng3 e;

        public e(ng3 ng3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements oq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ng3 e;

        public f(ng3 ng3Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng3Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    og3.b d = og3.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                og3.b d2 = og3.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                tg3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements oq3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ng3 e;

        public g(ng3 ng3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ng3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    og3.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                og3.b d = og3.d();
                d.m(false);
                d.n(false);
                d.o();
                tg3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(ng3 ng3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, callbackHandler, str};
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (yg3Var == null) {
                    tg3.o(10001, this.a, this.b);
                    og3.b d = og3.d();
                    d.n(false);
                    d.o();
                    oi3.r(10001, null);
                    return;
                }
                int b = yg3Var.b();
                v82.o("MultiAuthorize", "requestAuthorize " + yg3Var.a() + ",  code=" + b + ", data=" + yg3Var.a);
                if (b != 0) {
                    og3.b d2 = og3.d();
                    d2.n(false);
                    d2.o();
                    tg3.o(b, this.a, this.b);
                    return;
                }
                og3.b d3 = og3.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements hs1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(ng3 ng3Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng3Var, jVar};
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

        @Override // com.baidu.tieba.hs1
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
    public ng3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    public final boolean A(List<vg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (vg3 vg3Var : list) {
                    if (vg3Var != null && C(vg3Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean D(List<vg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (vg3 vg3Var : list) {
                if (vg3Var != null && !E(vg3Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(List<vg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (vg3 vg3Var : list) {
                if (vg3Var != null && C(vg3Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<vg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                og3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void K(List<vg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            cv2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void G(List<vg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull vb3 vb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, vb3Var) == null) {
            if (D(list)) {
                og3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(vb3Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull vb3 vb3Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, vb3Var, callbackHandler, jSONArray, str) == null) {
            r33.g().z(new b(this, callbackHandler, str, jSONArray, vb3Var, activity));
        }
    }

    public final boolean B(vg3 vg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg3Var)) == null) {
            if (!TextUtils.equals(vg3Var.b, "mapp_location") && !TextUtils.equals(vg3Var.b, "mapp_images") && !TextUtils.equals(vg3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(vg3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(vg3Var.b, "ppcert") && !TextUtils.equals(vg3Var.b, "mapp_i_face_verify") && !TextUtils.equals(vg3Var.b, "snsapi_userinfo") && !TextUtils.equals(vg3Var.b, "mapp_choose_address") && !TextUtils.equals(vg3Var.b, "mobile") && !TextUtils.equals(vg3Var.b, "mapp_choose_invoice") && !TextUtils.equals(vg3Var.b, "mapp_i_read_contacts") && !TextUtils.equals(vg3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean C(vg3 vg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vg3Var)) == null) {
            if (!TextUtils.equals(vg3Var.b, "ppcert") && !TextUtils.equals(vg3Var.b, "mapp_i_face_verify")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(oq3<String> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, oq3Var) == null) {
            cv2.Z().b(false, oq3Var);
        }
    }

    public final void z(oq3<String> oq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, oq3Var) == null) {
            cv2.Z().c(cv2.c(), oq3Var);
        }
    }

    public final boolean E(vg3 vg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vg3Var)) == null) {
            if (!TextUtils.equals(vg3Var.b, "mapp_location") && !TextUtils.equals(vg3Var.b, "mapp_images") && !TextUtils.equals(vg3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(vg3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(vg3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(boolean z, List<vg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                og3.b d2 = og3.d();
                d2.l(true);
                d2.i(true);
                v82.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            og3.d().l(false);
            v82.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<vg3> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            ah3 d2 = ub3.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void L(@NonNull vb3 vb3Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, vb3Var, activity, jVar) == null) {
            v(vb3Var, activity, jVar);
        }
    }

    public final void v(@NonNull vb3 vb3Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, vb3Var, activity, jVar) == null) {
            vb3Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final void N(@NonNull Activity activity, vg3 vg3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, vg3Var, str) == null) {
            String Z = ub3.K().q().Z();
            boolean equals = TextUtils.equals(str, "1");
            if (A(vg3Var.s)) {
                if (equals) {
                    vg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1536) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1535);
                    return;
                }
                vg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1538) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1535);
                return;
            }
            vg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1536) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1535);
        }
    }

    public final void O(@NonNull Activity activity, vg3 vg3Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, vg3Var, bool) == null) {
            String Z = ub3.K().q().Z();
            boolean D = D(vg3Var.s);
            boolean A = A(vg3Var.s);
            if (!bool.booleanValue() && !D) {
                vg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1537) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1535);
            } else if (A) {
                vg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1538) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1535);
            } else {
                vg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1536) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1535);
            }
        }
    }

    public final void P(vg3 vg3Var, List<vg3> list, boolean z, @NonNull Activity activity, @NonNull vb3 vb3Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{vg3Var, list, Boolean.valueOf(z), activity, vb3Var, callbackHandler, str}) == null) {
            tg3.u(activity, vb3Var, vg3Var, new JSONObject(), new c(this, callbackHandler, str, z, vb3Var, activity, list));
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (vb3Var != null && (context instanceof Activity)) {
                JSONObject a2 = sd3.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        og3.d().n(true);
                        vb3Var.e0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, vb3Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    og3.b d2 = og3.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                og3.b d3 = og3.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            og3.b d4 = og3.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<vg3> w(Map<String, vg3> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = vg3.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    vg3 vg3Var = map.get(c2);
                    if (map.containsKey(c2) && vg3Var != null && B(vg3Var)) {
                        if (vg3Var.d) {
                            tg3.o(10005, callbackHandler, str);
                            og3.b d2 = og3.d();
                            d2.n(false);
                            d2.o();
                            oi3.r(10005, vg3Var);
                            return null;
                        }
                        if (!arrayList.contains(vg3Var) && !vg3Var.a()) {
                            arrayList.add(vg3Var);
                        }
                        if (!vg3Var.a()) {
                            z = false;
                        }
                    } else {
                        tg3.o(10005, callbackHandler, str);
                        og3.b d3 = og3.d();
                        d3.n(false);
                        d3.o();
                        oi3.r(10005, vg3Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                og3.b d4 = og3.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            v82.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                og3.b d5 = og3.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public final vg3 y(Map<String, vg3> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            vg3 vg3Var = map.get("scope_multi_authorize");
            if (vg3Var == null) {
                tg3.o(10001, callbackHandler, str);
                oi3.r(10001, null);
                return null;
            } else if (vg3Var.d) {
                tg3.o(10005, callbackHandler, str);
                oi3.r(10005, vg3Var);
                return null;
            } else {
                return vg3Var;
            }
        }
        return (vg3) invokeLLL.objValue;
    }
}
