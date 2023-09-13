package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ew2;
import com.baidu.tieba.mg3;
import com.baidu.tieba.ug3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l22 extends g22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ l22 c;

        public a(l22 l22Var, String str, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l22Var, str, hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l22Var;
            this.a = str;
            this.b = hb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    int b = kg3Var.b();
                    this.c.d(this.a, new h32(b, fg3.f(b)));
                    return;
                }
                if (l22.f) {
                    Log.d("DesktopShortcutApi", "start add to desktop");
                }
                this.c.A(this.b.w(), this.b);
                this.c.d(this.a, new h32(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ug3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(l22 l22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ug3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            l22.C(i);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890909, "Lcom/baidu/tieba/l22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890909, "Lcom/baidu/tieba/l22;");
                return;
            }
        }
        f = rr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l22(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            ki3 ki3Var = new ki3();
            gb3 K = gb3.K();
            String appId = K.getAppId();
            String n = ai3.n(K.k());
            ki3Var.f = appId;
            ki3Var.b = "api";
            ki3Var.a = n;
            ki3Var.e = "addshortcut";
            ew2.a W = K.q().W();
            if (W != null) {
                ki3Var.c = W.T();
            }
            ki3Var.a("appid", appId);
            ki3Var.a("resultstate", Integer.valueOf(i));
            qh3.b(ki3Var);
        }
    }

    public final void A(@NonNull Context context, @NonNull hb3 hb3Var) {
        ew2.a Y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, hb3Var) != null) || (Y = hb3Var.Y()) == null) {
            return;
        }
        ug3.k(context, Y, new b(this));
    }

    public h32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#addToDesktop", false);
            if (f) {
                Log.d("DesktopShortcutApi", "#addToDesktop params = " + str);
            }
            Pair<h32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((h32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(202, "cb is empty");
                }
                hb3 b0 = hb3.b0();
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    return new h32(1001, "the context is not an activity");
                }
                b0.e0().g(context, "scope_add_to_desktop", new a(this, optString, b0));
                return h32.f();
            }
            return (h32) s.first;
        }
        return (h32) invokeL.objValue;
    }
}
