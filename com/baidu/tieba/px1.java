package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hr2;
import com.baidu.tieba.pb3;
import com.baidu.tieba.xb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class px1 extends kx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ px1 c;

        public a(px1 px1Var, String str, k63 k63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px1Var, str, k63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = px1Var;
            this.a = str;
            this.b = k63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    int b = nb3Var.b();
                    this.c.d(this.a, new ly1(b, ib3.f(b)));
                    return;
                }
                if (px1.f) {
                    Log.d("DesktopShortcutApi", "start add to desktop");
                }
                this.c.B(this.b.w(), this.b);
                this.c.d(this.a, new ly1(0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xb3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(px1 px1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.xb3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            px1.D(i);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948077312, "Lcom/baidu/tieba/px1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948077312, "Lcom/baidu/tieba/px1;");
                return;
            }
        }
        f = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            nd3 nd3Var = new nd3();
            j63 K = j63.K();
            String appId = K.getAppId();
            String n = dd3.n(K.k());
            nd3Var.f = appId;
            nd3Var.b = "api";
            nd3Var.a = n;
            nd3Var.e = "addshortcut";
            hr2.a X = K.q().X();
            if (X != null) {
                nd3Var.c = X.U();
            }
            nd3Var.a("appid", appId);
            nd3Var.a("resultstate", Integer.valueOf(i));
            tc3.b(nd3Var);
        }
    }

    public final void B(@NonNull Context context, @NonNull k63 k63Var) {
        hr2.a Z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, k63Var) != null) || (Z = k63Var.Z()) == null) {
            return;
        }
        xb3.k(context, Z, new b(this));
    }

    public ly1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#addToDesktop", false);
            if (f) {
                Log.d("DesktopShortcutApi", "#addToDesktop params = " + str);
            }
            Pair<ly1, JSONObject> t = t(str);
            JSONObject jSONObject = (JSONObject) t.second;
            if (((ly1) t.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new ly1(202, "cb is empty");
                }
                k63 c0 = k63.c0();
                Context i = i();
                if (!(i instanceof Activity) && (i = c0.w()) == null) {
                    return new ly1(1001, "the context is not an activity");
                }
                c0.f0().g(i, "scope_add_to_desktop", new a(this, optString, c0));
                return ly1.f();
            }
            return (ly1) t.first;
        }
        return (ly1) invokeL.objValue;
    }
}
