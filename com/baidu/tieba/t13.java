package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class t13 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
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
                t13.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
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
            t13.o(this.b, t13.n(this.a));
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ci4 b;
        public final /* synthetic */ SwanAppActionBar c;
        public final /* synthetic */ String d;

        public c(Context context, ci4 ci4Var, SwanAppActionBar swanAppActionBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, ci4Var, swanAppActionBar, str};
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
            this.b = ci4Var;
            this.c = swanAppActionBar;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            t13.f(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ ci4 b;
        public final /* synthetic */ SwanAppActionBar c;

        public d(JSONArray jSONArray, ci4 ci4Var, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, ci4Var, swanAppActionBar};
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
            this.b = ci4Var;
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
                        t13.d(optJSONObject);
                    }
                }
                this.b.j();
                vb3 b0 = vb3.b0();
                if (b0 != null) {
                    t13.o(this.c, b0.U().d("key_unread_counts_message", 0).intValue());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948128307, "Lcom/baidu/tieba/t13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948128307, "Lcom/baidu/tieba/t13;");
                return;
            }
        }
        a = fs1.a;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return ub3.K().q().U().d("key_unread_counts_message", 0).intValue();
        }
        return invokeV.intValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && vb3.b0() != null) {
            vb3.b0().U().i("key_unread_counts_message", 0);
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, swanAppActionBar, str) == null) && (c2 = cv2.i().c(context, str)) != null && swanAppActionBar != null) {
            ub3.M().post(new b(c2, swanAppActionBar));
        }
    }

    public static void k(Context context, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, swanAppActionBar, str) == null) {
            o53.e().d(new a(context, swanAppActionBar, str), "getRefreshTips", true);
        }
    }

    public static void m(JSONObject jSONObject, ci4 ci4Var, SwanAppActionBar swanAppActionBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, jSONObject, ci4Var, swanAppActionBar) == null) {
            n(jSONObject);
            ub3.M().post(new d(jSONObject.optJSONArray("un_read_list"), ci4Var, swanAppActionBar));
        }
    }

    public static void f(Context context, ci4 ci4Var, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65542, null, context, ci4Var, swanAppActionBar, str) == null) && (c2 = cv2.i().c(context, str)) != null && ci4Var != null) {
            m(c2, ci4Var, swanAppActionBar);
        }
    }

    public static void l(Context context, ci4 ci4Var, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, ci4Var, swanAppActionBar, str) == null) {
            ExecutorUtilsExt.postOnElastic(new c(context, ci4Var, swanAppActionBar, str), "getMenuToolRefreshTips", 1);
        }
    }

    public static void d(JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || jSONObject == null || Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() <= 0) {
            return;
        }
        int optInt = jSONObject.optInt(Constants.EXTRA_PA_TYPE);
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
        l13.q(str, "1", "show");
    }

    public static void j(di4 di4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, di4Var) == null) && vb3.b0() != null) {
            vb3.b0().U().i("key_unread_counts_message", Integer.valueOf(Math.max((int) (vb3.b0().U().d("key_unread_counts_message", 0).intValue() - di4Var.e()), 0)));
        }
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            vb3 q = ub3.K().q();
            if (q == null || q.W() == null || q.W().f0() == null) {
                return 0;
            }
            JSONObject c2 = cv2.i().c(context, q.W().f0().paNumber);
            if (c2 == null || (optJSONArray = c2.optJSONArray("un_read_list")) == null || optJSONArray.length() <= 0) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null && optJSONObject.optInt(Constants.EXTRA_PA_TYPE) == 888) {
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
                int optInt = optJSONObject.optInt(Constants.EXTRA_PA_TYPE);
                if (optInt == 7) {
                    i += optJSONObject.optInt("pa_unread_sums");
                }
                if (pp3.R() && (optInt == 27 || optInt == 17)) {
                    i += optJSONObject.optInt("pa_unread_sums");
                }
            }
            if (i == 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    int optInt2 = optJSONObject2.optInt(Constants.EXTRA_PA_TYPE);
                    if (optInt2 == 888 || optInt2 == 666 || optInt2 == 999) {
                        i += optJSONObject2.optInt("pa_unread_sums");
                    }
                }
            }
            if (vb3.b0() != null) {
                vb3.b0().U().i("key_unread_counts_message", Integer.valueOf(i));
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void o(SwanAppActionBar swanAppActionBar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, swanAppActionBar, i) == null) {
            boolean z = false;
            if (cv2.y0().d()) {
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
