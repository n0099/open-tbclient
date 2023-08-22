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
/* loaded from: classes9.dex */
public final class zz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public uz9 a;
    public final HashMap<String, List<rz9>> b;
    public wz9 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377392, "Lcom/baidu/tieba/zz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377392, "Lcom/baidu/tieba/zz9;");
                return;
            }
        }
        d = new a(null);
    }

    public /* synthetic */ zz9(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final zz9 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a() : (zz9) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
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
        public final zz9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.a();
            }
            return (zz9) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final zz9 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-215086350, "Lcom/baidu/tieba/zz9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-215086350, "Lcom/baidu/tieba/zz9$b;");
                    return;
                }
            }
            a = new b();
            b = new zz9(null);
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

        public final zz9 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (zz9) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends bx5<wz9> {
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
        @Override // com.baidu.tieba.bx5
        /* renamed from: a */
        public wz9 doInBackground() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ne<String> l = r45.l("tb.push_scene_group_cache");
                if (l != null) {
                    str = l.get("key_scene_group_cache");
                } else {
                    str = null;
                }
                return wz9.c.b(str);
            }
            return (wz9) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d extends bx5<Unit> {
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
            ne<String> l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (l = r45.l("tb.push_scene_group_cache")) != null) {
                l.g("key_scene_group_cache", "");
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e extends bx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz9 a;

        public e(zz9 zz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz9Var;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String g = this.a.c.g();
                ne<String> l = r45.l("tb.push_scene_group_cache");
                if (l != null) {
                    l.g("key_scene_group_cache", g);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public zz9() {
        List<rz9> list;
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
        String dateStringDay = di.getDateStringDay(new Date());
        Intrinsics.checkNotNullExpressionValue(dateStringDay, "getDateStringDay(Date())");
        this.c = new wz9(dateStringDay, new ArrayList());
        lk1<rz9> a2 = new sz9().a();
        if (a2 != null && (list = a2.getList()) != null) {
            for (rz9 check : list) {
                List<rz9> list2 = this.b.get(check.name());
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

    public static final void k(final zz9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            fx5.b(new c(), new gw5() { // from class: com.baidu.tieba.kz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.gw5
                public final void onReturnDataInUI(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        zz9.l(zz9.this, (wz9) obj);
                    }
                }
            });
        }
    }

    public static final void n(zz9 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.e();
            fx5.b(new d(), null);
        }
    }

    public final xz9 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            for (xz9 xz9Var : this.c.b()) {
                if (xz9Var.a() == i) {
                    return xz9Var;
                }
            }
            return null;
        }
        return (xz9) invokeI.objValue;
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
        vz9 c2;
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
            this.a = uz9.c.a(json.optJSONObject("push_strategy_new"));
            j();
        }
    }

    public static final void l(zz9 this$0, wz9 wz9Var) {
        String dateStringDay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, wz9Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (wz9Var != null && !wz9Var.c()) {
                this$0.m();
                return;
            }
            wz9 wz9Var2 = this$0.c;
            if (wz9Var == null || (dateStringDay = wz9Var.a()) == null) {
                dateStringDay = di.getDateStringDay(new Date());
                if (dateStringDay == null) {
                    dateStringDay = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(dateStringDay, "BdStringHelper.getDateStringDay(Date()) ?: \"\"");
                }
            }
            wz9Var2.f(dateStringDay);
            wz9Var2.b().clear();
            if (wz9Var != null) {
                wz9Var2.b().addAll(wz9Var.b());
            }
        }
    }

    @MainThread
    public final boolean b(String scene) {
        InterceptResult invokeL;
        boolean z;
        xz9 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            if (!this.c.c()) {
                m();
            }
            List<rz9> list = this.b.get(scene);
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
            for (rz9 rz9Var : list) {
                if (!rz9Var.a()) {
                    return false;
                }
            }
            vz9 c2 = c(scene);
            if (c2 == null || (d2 = d(c2.b())) == null || d2.b() < c2.c()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final vz9 c(String str) {
        InterceptResult invokeL;
        List<vz9> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            uz9 uz9Var = this.a;
            if (uz9Var != null && (a2 = uz9Var.a()) != null) {
                for (vz9 vz9Var : a2) {
                    if (vz9Var.a().contains(str)) {
                        return vz9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (vz9) invokeL.objValue;
    }

    public final yz9 g(String scene) {
        InterceptResult invokeL;
        List<yz9> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, scene)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            uz9 uz9Var = this.a;
            if (uz9Var != null && (b2 = uz9Var.b()) != null) {
                for (yz9 yz9Var : b2) {
                    if (Intrinsics.areEqual(yz9Var.c(), scene)) {
                        return yz9Var;
                    }
                }
                return null;
            }
            return null;
        }
        return (yz9) invokeL.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            lg.g(new Runnable() { // from class: com.baidu.tieba.mz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zz9.k(zz9.this);
                    }
                }
            });
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            lg.g(new Runnable() { // from class: com.baidu.tieba.lz9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zz9.n(zz9.this);
                    }
                }
            });
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            fx5.b(new e(this), null);
        }
    }
}
