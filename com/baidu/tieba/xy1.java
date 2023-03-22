package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gd3;
import com.baidu.tieba.qs2;
import com.baidu.tieba.yc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xy1 extends sy1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements mm3<wc3<yc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t73 b;
        public final /* synthetic */ xy1 c;

        public a(xy1 xy1Var, String str, t73 t73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy1Var, str, t73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xy1Var;
            this.a = str;
            this.b = t73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<yc3.e> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (!rc3.h(wc3Var)) {
                    int b = wc3Var.b();
                    this.c.d(this.a, new tz1(b, rc3.f(b)));
                    return;
                }
                if (xy1.f) {
                    Log.d("DesktopShortcutApi", "start add to desktop");
                }
                this.c.A(this.b.w(), this.b);
                this.c.d(this.a, new tz1(0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements gd3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xy1 xy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.gd3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            xy1.C(i);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948316601, "Lcom/baidu/tieba/xy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948316601, "Lcom/baidu/tieba/xy1;");
                return;
            }
        }
        f = do1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            we3 we3Var = new we3();
            s73 K = s73.K();
            String appId = K.getAppId();
            String n = me3.n(K.k());
            we3Var.f = appId;
            we3Var.b = "api";
            we3Var.a = n;
            we3Var.e = "addshortcut";
            qs2.a W = K.q().W();
            if (W != null) {
                we3Var.c = W.T();
            }
            we3Var.a("appid", appId);
            we3Var.a("resultstate", Integer.valueOf(i));
            ce3.b(we3Var);
        }
    }

    public final void A(@NonNull Context context, @NonNull t73 t73Var) {
        qs2.a Y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, t73Var) != null) || (Y = t73Var.Y()) == null) {
            return;
        }
        gd3.k(context, Y, new b(this));
    }

    public tz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#addToDesktop", false);
            if (f) {
                Log.d("DesktopShortcutApi", "#addToDesktop params = " + str);
            }
            Pair<tz1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((tz1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new tz1(202, "cb is empty");
                }
                t73 b0 = t73.b0();
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    return new tz1(1001, "the context is not an activity");
                }
                b0.e0().g(context, "scope_add_to_desktop", new a(this, optString, b0));
                return tz1.f();
            }
            return (tz1) s.first;
        }
        return (tz1) invokeL.objValue;
    }
}
