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
import com.baidu.tieba.ig3;
import com.baidu.tieba.wf3;
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
/* loaded from: classes8.dex */
public class vf3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface j {
        void a(boolean z, int i);
    }

    /* loaded from: classes8.dex */
    public class b implements a33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ vf3 f;

        /* loaded from: classes8.dex */
        public class a implements wp3<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dg3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.vf3$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0497a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Boolean a;
                public final /* synthetic */ a b;

                public RunnableC0497a(a aVar, Boolean bool) {
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
                        vf3 vf3Var = aVar.c.f;
                        dg3 dg3Var = aVar.a;
                        List list = aVar.b;
                        boolean booleanValue = this.a.booleanValue();
                        b bVar = this.b.c;
                        vf3Var.P(dg3Var, list, booleanValue, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public a(b bVar, dg3 dg3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dg3Var, list};
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
                this.a = dg3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    b bVar = this.c;
                    bVar.f.O(bVar.e, this.a, bool);
                    xo3.a0(new RunnableC0497a(this, bool));
                }
            }
        }

        /* renamed from: com.baidu.tieba.vf3$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0498b implements wp3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dg3 a;
            public final /* synthetic */ List b;
            public final /* synthetic */ b c;

            /* renamed from: com.baidu.tieba.vf3$b$b$a */
            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0498b a;

                public a(C0498b c0498b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0498b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0498b;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        C0498b c0498b = this.a;
                        b bVar = c0498b.c;
                        bVar.f.P(c0498b.a, c0498b.b, false, bVar.e, bVar.d, bVar.a, bVar.b);
                    }
                }
            }

            public C0498b(b bVar, dg3 dg3Var, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dg3Var, list};
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
                this.a = dg3Var;
                this.b = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    b bVar = this.c;
                    bVar.f.N(bVar.e, this.a, str);
                    xo3.a0(new a(this));
                }
            }
        }

        public b(vf3 vf3Var, CallbackHandler callbackHandler, String str, JSONArray jSONArray, db3 db3Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, callbackHandler, str, jSONArray, db3Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONArray;
            this.d = db3Var;
            this.e = activity;
        }

        @Override // com.baidu.tieba.a33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, dg3> g = b33.g(true);
                dg3 y = this.f.y(g, this.a, this.b);
                if (y == null) {
                    wf3.b d = wf3.d();
                    d.n(false);
                    d.o();
                    return;
                }
                List<dg3> w = this.f.w(g, this.c, this.a, this.b);
                if (w == null) {
                    return;
                }
                y.i(w);
                if (!this.d.N().e(this.e)) {
                    ku2.Z().a(this.e, new a(this, y, w));
                } else {
                    this.f.z(new C0498b(this, y, w));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ JSONArray e;
        public final /* synthetic */ vf3 f;

        public a(vf3 vf3Var, CallbackHandler callbackHandler, String str, Context context, db3 db3Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, callbackHandler, str, context, db3Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = db3Var;
            this.e = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.f.x((Activity) this.c, this.d, this.a, this.e, this.b);
                    return;
                }
                wf3.b d = wf3.d();
                d.n(false);
                d.o();
                bg3.q(gg3Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements yf3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ db3 d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ List f;
        public final /* synthetic */ vf3 g;

        public c(vf3 vf3Var, CallbackHandler callbackHandler, String str, boolean z, db3 db3Var, Activity activity, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, callbackHandler, str, Boolean.valueOf(z), db3Var, activity, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vf3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = z;
            this.d = db3Var;
            this.e = activity;
            this.f = list;
        }

        @Override // com.baidu.tieba.yf3
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d82.i("MultiAuthorize", "showAuthDialog " + z);
                if (!z) {
                    wf3.b d = wf3.d();
                    d.i(false);
                    d.h(false);
                    d.o();
                    bg3.o(10003, this.a, this.b);
                    return;
                }
                wf3.b d2 = wf3.d();
                d2.i(true);
                d2.h(true);
                boolean z2 = this.c;
                if (this.d.N().e(this.e)) {
                    wf3.d().m(true);
                    this.g.H(this.f, this.e, this.a, this.b);
                } else if (!z2) {
                    wf3.d().m(false);
                    this.g.G(this.f, this.e, this.a, this.b, this.d);
                } else {
                    this.g.K(this.f, this.e, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vf3 e;

        public d(vf3 vf3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vf3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // com.baidu.tieba.vf3.j
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                d82.i("MultiAuthorize", "login result:" + i);
                if (z) {
                    wf3.d().k(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                wf3.b d = wf3.d();
                d.k(false);
                d.n(true);
                d.i(false);
                d.o();
                bg3.o(10004, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements wp3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vf3 e;

        public e(vf3 vf3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vf3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.e.I(TextUtils.equals(str, "1"), this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements wp3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ List b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vf3 e;

        public f(vf3 vf3Var, Activity activity, List list, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, activity, list, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vf3Var;
            this.a = activity;
            this.b = list;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (!TextUtils.isEmpty(str)) {
                    wf3.b d = wf3.d();
                    d.j(true);
                    d.i(true);
                    this.e.J(this.a, this.b, this.c, this.d);
                    return;
                }
                wf3.b d2 = wf3.d();
                d2.j(false);
                d2.i(false);
                d2.o();
                bg3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements wp3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ vf3 e;

        public g(vf3 vf3Var, List list, Activity activity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, list, activity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vf3Var;
            this.a = list;
            this.b = activity;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 0) {
                    wf3.d().m(true);
                    this.e.H(this.a, this.b, this.c, this.d);
                    return;
                }
                wf3.b d = wf3.d();
                d.m(false);
                d.n(false);
                d.o();
                bg3.o(10003, this.c, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public h(vf3 vf3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, callbackHandler, str};
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (gg3Var == null) {
                    bg3.o(10001, this.a, this.b);
                    wf3.b d = wf3.d();
                    d.n(false);
                    d.o();
                    wh3.r(10001, null);
                    return;
                }
                int b = gg3Var.b();
                d82.o("MultiAuthorize", "requestAuthorize " + gg3Var.a() + ",  code=" + b + ", data=" + gg3Var.a);
                if (b != 0) {
                    wf3.b d2 = wf3.d();
                    d2.n(false);
                    d2.o();
                    bg3.o(b, this.a, this.b);
                    return;
                }
                wf3.b d3 = wf3.d();
                d3.n(true);
                d3.o();
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements pr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public i(vf3 vf3Var, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf3Var, jVar};
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

        @Override // com.baidu.tieba.pr1
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
    public vf3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/multiAuthorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    public final boolean A(List<dg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (dg3 dg3Var : list) {
                    if (dg3Var != null && C(dg3Var)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean D(List<dg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            boolean z = true;
            for (dg3 dg3Var : list) {
                if (dg3Var != null && !E(dg3Var)) {
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(List<dg3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (dg3 dg3Var : list) {
                if (dg3Var != null && C(dg3Var)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void H(List<dg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, list, activity, callbackHandler, str) == null) {
            if (F(list)) {
                wf3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            z(new e(this, list, activity, callbackHandler, str));
        }
    }

    public final void K(List<dg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, list, activity, callbackHandler, str) == null) {
            ku2.Z().d(new g(this, list, activity, callbackHandler, str));
        }
    }

    public final void G(List<dg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull db3 db3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, list, activity, callbackHandler, str, db3Var) == null) {
            if (D(list)) {
                wf3.d().i(true);
                J(activity, list, callbackHandler, str);
                return;
            }
            L(db3Var, activity, new d(this, list, activity, callbackHandler, str));
        }
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull db3 db3Var, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048595, this, activity, db3Var, callbackHandler, jSONArray, str) == null) {
            z23.g().z(new b(this, callbackHandler, str, jSONArray, db3Var, activity));
        }
    }

    public final boolean B(dg3 dg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dg3Var)) == null) {
            if (!TextUtils.equals(dg3Var.b, "mapp_location") && !TextUtils.equals(dg3Var.b, "mapp_images") && !TextUtils.equals(dg3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(dg3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(dg3Var.b, "ppcert") && !TextUtils.equals(dg3Var.b, "mapp_i_face_verify") && !TextUtils.equals(dg3Var.b, "snsapi_userinfo") && !TextUtils.equals(dg3Var.b, "mapp_choose_address") && !TextUtils.equals(dg3Var.b, "mobile") && !TextUtils.equals(dg3Var.b, "mapp_choose_invoice") && !TextUtils.equals(dg3Var.b, "mapp_i_read_contacts") && !TextUtils.equals(dg3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean C(dg3 dg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dg3Var)) == null) {
            if (!TextUtils.equals(dg3Var.b, "ppcert") && !TextUtils.equals(dg3Var.b, "mapp_i_face_verify")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(wp3<String> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, wp3Var) == null) {
            ku2.Z().b(false, wp3Var);
        }
    }

    public final void z(wp3<String> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, wp3Var) == null) {
            ku2.Z().c(ku2.c(), wp3Var);
        }
    }

    public final boolean E(dg3 dg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dg3Var)) == null) {
            if (!TextUtils.equals(dg3Var.b, "mapp_location") && !TextUtils.equals(dg3Var.b, "mapp_images") && !TextUtils.equals(dg3Var.b, PermissionProxy.SCOPE_ID_RECORD) && !TextUtils.equals(dg3Var.b, PermissionProxy.SCOPE_ID_CAMERA) && !TextUtils.equals(dg3Var.b, "scope_calendar")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(boolean z, List<dg3> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, activity, callbackHandler, str}) == null) {
            if (z) {
                wf3.b d2 = wf3.d();
                d2.l(true);
                d2.i(true);
                d82.i("MultiAuthorize", "onCallback: real name success");
                J(activity, list, callbackHandler, str);
                return;
            }
            wf3.d().l(false);
            d82.i("MultiAuthorize", "onCallback: real name fail");
            M(new f(this, activity, list, callbackHandler, str));
        }
    }

    public final void J(@NonNull Activity activity, @NonNull List<dg3> list, @NonNull CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, activity, list, callbackHandler, str) == null) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = list.get(i2).b;
            }
            ig3 d2 = cb3.K().x().a().b().d(activity, false, true, strArr, null, true);
            d2.o(new h(this, callbackHandler, str));
            d2.call();
        }
    }

    public final void L(@NonNull db3 db3Var, @NonNull Activity activity, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, db3Var, activity, jVar) == null) {
            v(db3Var, activity, jVar);
        }
    }

    public final void v(@NonNull db3 db3Var, @NonNull Activity activity, @NonNull j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, db3Var, activity, jVar) == null) {
            db3Var.N().f(activity, null, new i(this, jVar));
        }
    }

    public final void N(@NonNull Activity activity, dg3 dg3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, dg3Var, str) == null) {
            String Z = cb3.K().q().Z();
            boolean equals = TextUtils.equals(str, "1");
            if (A(dg3Var.s)) {
                if (equals) {
                    dg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1548) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1547);
                    return;
                }
                dg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f154a) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1547);
                return;
            }
            dg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1548) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1547);
        }
    }

    public final void O(@NonNull Activity activity, dg3 dg3Var, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, dg3Var, bool) == null) {
            String Z = cb3.K().q().Z();
            boolean D = D(dg3Var.s);
            boolean A = A(dg3Var.s);
            if (!bool.booleanValue() && !D) {
                dg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1549) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1547);
            } else if (A) {
                dg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f154a) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1547);
            } else {
                dg3Var.r = activity.getString(R.string.obfuscated_res_0x7f0f1548) + Z + activity.getString(R.string.obfuscated_res_0x7f0f1547);
            }
        }
    }

    public final void P(dg3 dg3Var, List<dg3> list, boolean z, @NonNull Activity activity, @NonNull db3 db3Var, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{dg3Var, list, Boolean.valueOf(z), activity, db3Var, callbackHandler, str}) == null) {
            bg3.u(activity, db3Var, dg3Var, new JSONObject(), new c(this, callbackHandler, str, z, db3Var, activity, list));
        }
    }

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (db3Var != null && (context instanceof Activity)) {
                JSONObject a2 = ad3.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.has("scopes")) {
                    JSONArray optJSONArray = a2.optJSONArray("scopes");
                    if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                        wf3.d().n(true);
                        db3Var.e0().g(context, "scope_multi_authorize", new a(this, callbackHandler, a2.optString("cb"), context, db3Var, optJSONArray));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                    wf3.b d2 = wf3.d();
                    d2.n(false);
                    d2.o();
                    return false;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
                wf3.b d3 = wf3.d();
                d3.n(false);
                d3.o();
                return false;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
            wf3.b d4 = wf3.d();
            d4.n(false);
            d4.o();
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<dg3> w(Map<String, dg3> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048594, this, map, jSONArray, callbackHandler, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                String c2 = dg3.c(jSONArray.optString(i2));
                if (!TextUtils.isEmpty(c2)) {
                    dg3 dg3Var = map.get(c2);
                    if (map.containsKey(c2) && dg3Var != null && B(dg3Var)) {
                        if (dg3Var.d) {
                            bg3.o(10005, callbackHandler, str);
                            wf3.b d2 = wf3.d();
                            d2.n(false);
                            d2.o();
                            wh3.r(10005, dg3Var);
                            return null;
                        }
                        if (!arrayList.contains(dg3Var) && !dg3Var.a()) {
                            arrayList.add(dg3Var);
                        }
                        if (!dg3Var.a()) {
                            z = false;
                        }
                    } else {
                        bg3.o(10005, callbackHandler, str);
                        wf3.b d3 = wf3.d();
                        d3.n(false);
                        d3.o();
                        wh3.r(10005, dg3Var);
                        return null;
                    }
                }
            }
            if (z) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                wf3.b d4 = wf3.d();
                d4.i(true);
                d4.n(true);
                d4.o();
                return null;
            }
            d82.i("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
            if (arrayList.isEmpty()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
                wf3.b d5 = wf3.d();
                d5.n(true);
                d5.o();
                return null;
            }
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public final dg3 y(Map<String, dg3> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, map, callbackHandler, str)) == null) {
            dg3 dg3Var = map.get("scope_multi_authorize");
            if (dg3Var == null) {
                bg3.o(10001, callbackHandler, str);
                wh3.r(10001, null);
                return null;
            } else if (dg3Var.d) {
                bg3.o(10005, callbackHandler, str);
                wh3.r(10005, dg3Var);
                return null;
            } else {
                return dg3Var;
            }
        }
        return (dg3) invokeLLL.objValue;
    }
}
