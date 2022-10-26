package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class kt2 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ SwanAppActionBar b;
        public final /* synthetic */ String c;

        public a(Context context, SwanAppActionBar swanAppActionBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, swanAppActionBar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = swanAppActionBar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kt2.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ SwanAppActionBar b;

        public b(JSONObject jSONObject, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            kt2.o(this.b, kt2.n(this.a));
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ t94 b;
        public final /* synthetic */ SwanAppActionBar c;
        public final /* synthetic */ String d;

        public c(Context context, t94 t94Var, SwanAppActionBar swanAppActionBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, t94Var, swanAppActionBar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = t94Var;
            this.c = swanAppActionBar;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            kt2.f(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes4.dex */
    public final class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ t94 b;
        public final /* synthetic */ SwanAppActionBar c;

        public d(JSONArray jSONArray, t94 t94Var, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, t94Var, swanAppActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONArray;
            this.b = t94Var;
            this.c = swanAppActionBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONArray jSONArray = this.a;
                if (jSONArray == null) {
                    length = 0;
                } else {
                    length = jSONArray.length();
                }
                if (length == 0) {
                    return;
                }
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = this.a.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.b.z(optJSONObject);
                        kt2.d(optJSONObject);
                    }
                }
                this.b.j();
                m33 b0 = m33.b0();
                if (b0 != null) {
                    kt2.o(this.c, b0.U().d("key_unread_counts_message", 0).intValue());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924544, "Lcom/baidu/tieba/kt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924544, "Lcom/baidu/tieba/kt2;");
                return;
            }
        }
        a = wj1.a;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return l33.K().q().U().d("key_unread_counts_message", 0).intValue();
        }
        return invokeV.intValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && m33.b0() != null) {
            m33.b0().U().i("key_unread_counts_message", 0);
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, swanAppActionBar, str) == null) && (c2 = tm2.i().c(context, str)) != null && swanAppActionBar != null) {
            l33.M().post(new b(c2, swanAppActionBar));
        }
    }

    public static void k(Context context, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, swanAppActionBar, str) == null) {
            fx2.e().d(new a(context, swanAppActionBar, str), "getRefreshTips", true);
        }
    }

    public static void m(JSONObject jSONObject, t94 t94Var, SwanAppActionBar swanAppActionBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, jSONObject, t94Var, swanAppActionBar) == null) {
            n(jSONObject);
            l33.M().post(new d(jSONObject.optJSONArray("un_read_list"), t94Var, swanAppActionBar));
        }
    }

    public static void f(Context context, t94 t94Var, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65542, null, context, t94Var, swanAppActionBar, str) == null) && (c2 = tm2.i().c(context, str)) != null && t94Var != null) {
            m(c2, t94Var, swanAppActionBar);
        }
    }

    public static void l(Context context, t94 t94Var, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, t94Var, swanAppActionBar, str) == null) {
            ExecutorUtilsExt.postOnElastic(new c(context, t94Var, swanAppActionBar, str), "getMenuToolRefreshTips", 1);
        }
    }

    public static void d(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || jSONObject == null || Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() <= 0) {
            return;
        }
        int optInt = jSONObject.optInt("pa_type");
        if (optInt != 7) {
            if (optInt != 666) {
                if (optInt != 888) {
                    if (optInt != 999) {
                        str = "";
                    } else {
                        str = "message";
                    }
                } else {
                    str = PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE;
                }
            } else {
                str = "notice";
            }
        } else {
            str = "customerService";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ct2.q(str, "1", "show");
    }

    public static void j(u94 u94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, u94Var) == null) && m33.b0() != null) {
            m33.b0().U().i("key_unread_counts_message", Integer.valueOf(Math.max((int) (m33.b0().U().d("key_unread_counts_message", 0).intValue() - u94Var.e()), 0)));
        }
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            m33 q = l33.K().q();
            if (q == null || q.W() == null || q.W().f0() == null) {
                return 0;
            }
            JSONObject c2 = tm2.i().c(context, q.W().f0().paNumber);
            if (c2 == null || (optJSONArray = c2.optJSONArray("un_read_list")) == null || optJSONArray.length() <= 0) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.optInt("pa_type") == 888) {
                    i += optJSONObject.optInt("pa_unread_sums");
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static int n(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("un_read_list")) == null || optJSONArray.length() == 0) {
                return 0;
            }
            int length = optJSONArray.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                int optInt = optJSONObject.optInt("pa_type");
                if (optInt == 7) {
                    i += optJSONObject.optInt("pa_unread_sums");
                }
                if (gh3.R() && (optInt == 27 || optInt == 17)) {
                    i += optJSONObject.optInt("pa_unread_sums");
                }
            }
            if (i == 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    int optInt2 = optJSONObject2.optInt("pa_type");
                    if (optInt2 == 888 || optInt2 == 666 || optInt2 == 999) {
                        i += optJSONObject2.optInt("pa_unread_sums");
                    }
                }
            }
            if (m33.b0() != null) {
                m33.b0().U().i("key_unread_counts_message", Integer.valueOf(i));
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void o(SwanAppActionBar swanAppActionBar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, swanAppActionBar, i) == null) {
            boolean z = false;
            if (tm2.y0().d()) {
                swanAppActionBar.setRightRedDotVisibility(false);
                return;
            }
            if (a) {
                Log.i("messageRefresh", "update_red_dots:" + i);
            }
            if (swanAppActionBar != null) {
                if (i > 0) {
                    z = true;
                }
                swanAppActionBar.setRightRedDotVisibility(z);
            }
        }
    }
}
