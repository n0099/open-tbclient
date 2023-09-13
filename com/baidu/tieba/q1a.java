package com.baidu.tieba;

import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes7.dex */
public final class q1a {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public l1a a;
    public final HashMap<String, List<i1a>> b;
    public n1a c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040360, "Lcom/baidu/tieba/q1a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040360, "Lcom/baidu/tieba/q1a;");
                return;
            }
        }
        d = new a(null);
    }

    public /* synthetic */ q1a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final q1a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a() : (q1a) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
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
        public final q1a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.a();
            }
            return (q1a) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final q1a b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-538974102, "Lcom/baidu/tieba/q1a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-538974102, "Lcom/baidu/tieba/q1a$b;");
                    return;
                }
            }
            a = new b();
            b = new q1a(null);
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

        public final q1a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (q1a) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends xx5<n1a> {
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
        @Override // com.baidu.tieba.xx5
        /* renamed from: a */
        public n1a doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                oe<String> l = x45.l("tb.push_scene_group_cache");
                if (l != null) {
                    str = l.get("key_scene_group_cache");
                } else {
                    str = null;
                }
                return n1a.c.b(str);
            }
            return (n1a) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends xx5<Unit> {
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
            oe<String> l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l = x45.l("tb.push_scene_group_cache")) != null) {
                l.g("key_scene_group_cache", "");
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.xx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends xx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q1a a;

        public e(q1a q1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q1aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g = this.a.c.g();
                oe<String> l = x45.l("tb.push_scene_group_cache");
                if (l != null) {
                    l.g("key_scene_group_cache", g);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.xx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public q1a() {
        List<i1a> list;
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
        String dateStringDay = ei.getDateStringDay(new Date());
        Intrinsics.checkNotNullExpressionValue(dateStringDay, "getDateStringDay(Date())");
        this.c = new n1a(dateStringDay, new ArrayList());
        pk1<i1a> a2 = new j1a().a();
        if (a2 != null && (list = a2.getList()) != null) {
            for (i1a check : list) {
                List<i1a> list2 = this.b.get(check.name());
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

    public static final void k(final q1a this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            by5.b(new c(), new cx5() { // from class: com.baidu.tieba.b1a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.cx5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        q1a.l(q1a.this, (n1a) obj);
                    }
                }
            });
        }
    }

    public static final void n(q1a this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.e();
            by5.b(new d(), null);
        }
    }

    public final o1a d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (o1a o1aVar : this.c.b()) {
                if (o1aVar.a() == i) {
                    return o1aVar;
                }
            }
            return null;
        }
        return (o1a) invokeI.objValue;
    }

    public final long f(String scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            return sharedPrefHelper.getLong("key_scene_shown_prefix_" + scene, 0L);
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
        m1a c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (c2 = c(str)) != null) {
            this.c.d(c2.b());
            o();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putLong("key_scene_shown_prefix_" + str, System.currentTimeMillis());
        }
    }

    public final void q(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            this.a = l1a.c.a(json.optJSONObject("push_strategy_new"));
            j();
        }
    }

    public static final void l(q1a this$0, n1a n1aVar) {
        String dateStringDay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, n1aVar) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (n1aVar != null && !n1aVar.c()) {
                this$0.m();
                return;
            }
            n1a n1aVar2 = this$0.c;
            if (n1aVar == null || (dateStringDay = n1aVar.a()) == null) {
                dateStringDay = ei.getDateStringDay(new Date());
                if (dateStringDay == null) {
                    dateStringDay = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dateStringDay, "BdStringHelper.getDateStringDay(Date()) ?: \"\"");
                }
            }
            n1aVar2.f(dateStringDay);
            n1aVar2.b().clear();
            if (n1aVar != null) {
                n1aVar2.b().addAll(n1aVar.b());
            }
        }
    }

    @MainThread
    public final boolean b(String scene) {
        InterceptResult invokeL;
        boolean z;
        o1a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (!this.c.c()) {
                m();
            }
            List<i1a> list = this.b.get(scene);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            for (i1a i1aVar : list) {
                if (!i1aVar.a()) {
                    return false;
                }
            }
            m1a c2 = c(scene);
            if (c2 == null || (d2 = d(c2.b())) == null || d2.b() < c2.c()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final m1a c(String str) {
        InterceptResult invokeL;
        List<m1a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            l1a l1aVar = this.a;
            if (l1aVar != null && (a2 = l1aVar.a()) != null) {
                for (m1a m1aVar : a2) {
                    if (m1aVar.a().contains(str)) {
                        return m1aVar;
                    }
                }
                return null;
            }
            return null;
        }
        return (m1a) invokeL.objValue;
    }

    public final p1a g(String scene) {
        InterceptResult invokeL;
        List<p1a> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            l1a l1aVar = this.a;
            if (l1aVar != null && (b2 = l1aVar.b()) != null) {
                for (p1a p1aVar : b2) {
                    if (Intrinsics.areEqual(p1aVar.c(), scene)) {
                        return p1aVar;
                    }
                }
                return null;
            }
            return null;
        }
        return (p1a) invokeL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            mg.g(new Runnable() { // from class: com.baidu.tieba.d1a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q1a.k(q1a.this);
                    }
                }
            });
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            mg.g(new Runnable() { // from class: com.baidu.tieba.c1a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        q1a.n(q1a.this);
                    }
                }
            });
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            by5.b(new e(this), null);
        }
    }
}
