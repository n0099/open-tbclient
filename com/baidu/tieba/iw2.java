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
/* loaded from: classes6.dex */
public class iw2 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                iw2.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            iw2.o(this.b, iw2.n(this.a));
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ rc4 b;
        public final /* synthetic */ SwanAppActionBar c;
        public final /* synthetic */ String d;

        public c(Context context, rc4 rc4Var, SwanAppActionBar swanAppActionBar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, rc4Var, swanAppActionBar, str};
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
            this.b = rc4Var;
            this.c = swanAppActionBar;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            iw2.f(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ rc4 b;
        public final /* synthetic */ SwanAppActionBar c;

        public d(JSONArray jSONArray, rc4 rc4Var, SwanAppActionBar swanAppActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, rc4Var, swanAppActionBar};
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
            this.b = rc4Var;
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
                        this.b.y(optJSONObject);
                        iw2.d(optJSONObject);
                    }
                }
                this.b.j();
                k63 c0 = k63.c0();
                if (c0 != null) {
                    iw2.o(this.c, c0.V().d("key_unread_counts_message", 0).intValue());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867845, "Lcom/baidu/tieba/iw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867845, "Lcom/baidu/tieba/iw2;");
                return;
            }
        }
        a = vm1.a;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return j63.K().q().V().d("key_unread_counts_message", 0).intValue();
        }
        return invokeV.intValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && k63.c0() != null) {
            k63.c0().V().i("key_unread_counts_message", 0);
        }
    }

    public static void e(Context context, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, swanAppActionBar, str) == null) && (c2 = rp2.i().c(context, str)) != null && swanAppActionBar != null) {
            j63.M().post(new b(c2, swanAppActionBar));
        }
    }

    public static void k(Context context, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, swanAppActionBar, str) == null) {
            d03.e().d(new a(context, swanAppActionBar, str), "getRefreshTips", true);
        }
    }

    public static void m(JSONObject jSONObject, rc4 rc4Var, SwanAppActionBar swanAppActionBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, jSONObject, rc4Var, swanAppActionBar) == null) {
            n(jSONObject);
            j63.M().post(new d(jSONObject.optJSONArray("un_read_list"), rc4Var, swanAppActionBar));
        }
    }

    public static void f(Context context, rc4 rc4Var, SwanAppActionBar swanAppActionBar, String str) {
        JSONObject c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65542, null, context, rc4Var, swanAppActionBar, str) == null) && (c2 = rp2.i().c(context, str)) != null && rc4Var != null) {
            m(c2, rc4Var, swanAppActionBar);
        }
    }

    public static void l(Context context, rc4 rc4Var, SwanAppActionBar swanAppActionBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, rc4Var, swanAppActionBar, str) == null) {
            ExecutorUtilsExt.postOnElastic(new c(context, rc4Var, swanAppActionBar, str), "getMenuToolRefreshTips", 1);
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
        aw2.q(str, "1", "show");
    }

    public static void j(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, sc4Var) == null) && k63.c0() != null) {
            k63.c0().V().i("key_unread_counts_message", Integer.valueOf(Math.max((int) (k63.c0().V().d("key_unread_counts_message", 0).intValue() - sc4Var.e()), 0)));
        }
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            k63 q = j63.K().q();
            if (q == null || q.X() == null || q.X().g0() == null) {
                return 0;
            }
            JSONObject c2 = rp2.i().c(context, q.X().g0().paNumber);
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
                if (ek3.R() && (optInt == 27 || optInt == 17)) {
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
            if (k63.c0() != null) {
                k63.c0().V().i("key_unread_counts_message", Integer.valueOf(i));
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void o(SwanAppActionBar swanAppActionBar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, swanAppActionBar, i) == null) {
            boolean z = false;
            if (rp2.y0().d()) {
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
