package com.baidu.tieba;

import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class uq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public pq9 a;
    public final HashMap<String, List<mq9>> b;
    public rq9 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948219788, "Lcom/baidu/tieba/uq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948219788, "Lcom/baidu/tieba/uq9;");
                return;
            }
        }
        d = new a(null);
    }

    public /* synthetic */ uq9(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final uq9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a() : (uq9) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @JvmStatic
        public final uq9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.a();
            }
            return (uq9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final uq9 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-366543794, "Lcom/baidu/tieba/uq9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-366543794, "Lcom/baidu/tieba/uq9$b;");
                    return;
                }
            }
            a = new b();
            b = new uq9(null);
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final uq9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (uq9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends sx5<rq9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sx5
        /* renamed from: a */
        public rq9 doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xe<String> e = f55.e("tb.push_scene_group_cache");
                if (e != null) {
                    str = e.get("key_scene_group_cache");
                } else {
                    str = null;
                }
                return rq9.c.b(str);
            }
            return (rq9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends sx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            xe<String> e;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (e = f55.e("tb.push_scene_group_cache")) != null) {
                e.g("key_scene_group_cache", "");
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.sx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends sx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq9 a;

        public e(uq9 uq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uq9Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g = this.a.c.g();
                xe<String> e = f55.e("tb.push_scene_group_cache");
                if (e != null) {
                    e.g("key_scene_group_cache", g);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.sx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public uq9() {
        List<mq9> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        String dateStringDay = wi.getDateStringDay(new Date());
        Intrinsics.checkNotNullExpressionValue(dateStringDay, "getDateStringDay(Date())");
        this.c = new rq9(dateStringDay, new ArrayList());
        kl1<mq9> a2 = new nq9().a();
        if (a2 != null && (list = a2.getList()) != null) {
            for (mq9 check : list) {
                List<mq9> list2 = this.b.get(check.name());
                if (list2 != null) {
                    Intrinsics.checkNotNullExpressionValue(check, "check");
                    list2.add(check);
                } else {
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(check, "check");
                    arrayList.add(check);
                    this.b.put(check.name(), arrayList);
                }
            }
        }
    }

    public static final void k(final uq9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            wx5.b(new c(), new ww5() { // from class: com.baidu.tieba.fq9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ww5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        uq9.l(uq9.this, (rq9) obj);
                    }
                }
            });
        }
    }

    public static final void n(uq9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.e();
            wx5.b(new d(), null);
        }
    }

    public final sq9 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (sq9 sq9Var : this.c.b()) {
                if (sq9Var.a() == i) {
                    return sq9Var;
                }
            }
            return null;
        }
        return (sq9) invokeI.objValue;
    }

    public final long f(String scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            r95 p = r95.p();
            return p.r("key_scene_shown_prefix_" + scene, 0L);
        }
        return invokeL.longValue;
    }

    @MainThread
    public final void h(String scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scene) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            p(scene);
            if (this.a != null) {
                i(scene);
            }
        }
    }

    public final void i(String str) {
        qq9 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (c2 = c(str)) != null) {
            this.c.d(c2.b());
            o();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            r95 p = r95.p();
            p.H("key_scene_shown_prefix_" + str, System.currentTimeMillis());
        }
    }

    public final void q(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            this.a = pq9.c.a(json.optJSONObject("push_strategy_new"));
            j();
        }
    }

    public static final void l(uq9 this$0, rq9 rq9Var) {
        String dateStringDay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, rq9Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (rq9Var != null && !rq9Var.c()) {
                this$0.m();
                return;
            }
            rq9 rq9Var2 = this$0.c;
            if (rq9Var == null || (dateStringDay = rq9Var.a()) == null) {
                dateStringDay = wi.getDateStringDay(new Date());
                if (dateStringDay == null) {
                    dateStringDay = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dateStringDay, "BdStringHelper.getDateStringDay(Date()) ?: \"\"");
                }
            }
            rq9Var2.f(dateStringDay);
            rq9Var2.b().clear();
            if (rq9Var != null) {
                rq9Var2.b().addAll(rq9Var.b());
            }
        }
    }

    @MainThread
    public final boolean b(String scene) {
        InterceptResult invokeL;
        boolean z;
        sq9 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (!this.c.c()) {
                m();
            }
            List<mq9> list = this.b.get(scene);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            for (mq9 mq9Var : list) {
                if (!mq9Var.a()) {
                    return false;
                }
            }
            qq9 c2 = c(scene);
            if (c2 == null || (d2 = d(c2.b())) == null || d2.b() < c2.c()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final qq9 c(String str) {
        InterceptResult invokeL;
        List<qq9> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            pq9 pq9Var = this.a;
            if (pq9Var != null && (a2 = pq9Var.a()) != null) {
                for (qq9 qq9Var : a2) {
                    if (qq9Var.a().contains(str)) {
                        return qq9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (qq9) invokeL.objValue;
    }

    public final tq9 g(String scene) {
        InterceptResult invokeL;
        List<tq9> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            pq9 pq9Var = this.a;
            if (pq9Var != null && (b2 = pq9Var.b()) != null) {
                for (tq9 tq9Var : b2) {
                    if (Intrinsics.areEqual(tq9Var.c(), scene)) {
                        return tq9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (tq9) invokeL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ch.g(new Runnable() { // from class: com.baidu.tieba.hq9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        uq9.k(uq9.this);
                    }
                }
            });
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ch.g(new Runnable() { // from class: com.baidu.tieba.gq9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        uq9.n(uq9.this);
                    }
                }
            });
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            wx5.b(new e(this), null);
        }
    }
}
