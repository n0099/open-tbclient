package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mu1 extends ju1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ mu1 d;

        public a(mu1 mu1Var, v42 v42Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu1Var, v42Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mu1Var;
            this.a = v42Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v42 v42Var = this.a;
                boolean z = true;
                if (!((v42Var == null || !v42Var.D2(this.b, true)) ? false : false)) {
                    p22.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new qx1(1001));
                }
                this.d.d(this.c, new qx1(0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ mu1 f;

        public b(mu1 mu1Var, v42 v42Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu1Var, v42Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mu1Var;
            this.a = v42Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v42 v42Var = this.a;
                if (v42Var != null && v42Var.L2(this.b, true)) {
                    if (!this.a.B2(SwanAppConfigData.t(this.d), true)) {
                        p22.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new qx1(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.z2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        p22.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new qx1(0));
                    return;
                }
                p22.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new qx1(1001));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v42 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ mu1 d;

        public c(mu1 mu1Var, v42 v42Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu1Var, v42Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mu1Var;
            this.a = v42Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean Z1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v42 v42Var = this.a;
                if (v42Var == null) {
                    p22.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new qx1(1001));
                    return;
                }
                if (this.c) {
                    Z1 = v42Var.U2();
                } else {
                    Z1 = v42Var.Z1();
                }
                if (!Z1) {
                    if (this.c) {
                        str = "show";
                    } else {
                        str = "hide";
                    }
                    p22.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new qx1(1001));
                    return;
                }
                this.d.d(this.b, new qx1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qx1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#showNavigationBarLoading", false);
            p53 c0 = p53.c0();
            if (c0 != null && c0.o0()) {
                return new qx1(1001, "ui operation does not supported when app is invisible.");
            }
            return y(str, true);
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#setNavigationBarColor", false);
            y42 W = cr2.V().W();
            if (W == null) {
                p22.c("NavigationBarApi", "manager is null");
                return new qx1(1001);
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("cb is empty", null, true);
                return new qx1(1001, "cb is empty");
            }
            jj3.e0(new b(this, W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObject.optJSONObject("animation")));
            return qx1.f();
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#setNavigationBarTitle", false);
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                return new qx1(1001);
            }
            String optString = jSONObject.optString("title");
            y42 W = cr2.V().W();
            if (W == null) {
                p22.c("NavigationBarApi", "manager is null");
                return new qx1(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                q("cb is empty", null, true);
                return new qx1(1001, "cb is empty");
            }
            jj3.e0(new a(this, W.m(), optString, optString2));
            return qx1.f();
        }
        return (qx1) invokeL.objValue;
    }

    public final qx1 y(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            y42 W = cr2.V().W();
            if (W == null) {
                p22.c("NavigationBarApi", "manager is null");
                return new qx1(1001);
            }
            Pair<qx1, JSONObject> t = t(str);
            qx1 qx1Var = (qx1) t.first;
            if (!qx1Var.isSuccess()) {
                return qx1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                q("cb is empty", null, true);
                return new qx1(1001, "cb is empty");
            }
            jj3.e0(new c(this, W.m(), optString, z));
            return qx1.f();
        }
        return (qx1) invokeLZ.objValue;
    }

    public qx1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#hideNavigationBarLoading", false);
            return y(str, false);
        }
        return (qx1) invokeL.objValue;
    }
}
