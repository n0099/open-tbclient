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
/* loaded from: classes8.dex */
public class v02 extends s02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ v02 d;

        public a(v02 v02Var, fb2 fb2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v02Var, fb2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v02Var;
            this.a = fb2Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fb2 fb2Var = this.a;
                boolean z = true;
                if (!((fb2Var == null || !fb2Var.y2(this.b, true)) ? false : false)) {
                    z82.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new z32(1001));
                }
                this.d.d(this.c, new z32(0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ v02 f;

        public b(v02 v02Var, fb2 fb2Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v02Var, fb2Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = v02Var;
            this.a = fb2Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fb2 fb2Var = this.a;
                if (fb2Var != null && fb2Var.G2(this.b, true)) {
                    if (!this.a.w2(SwanAppConfigData.t(this.d), true)) {
                        z82.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new z32(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.u2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        z82.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new z32(0));
                    return;
                }
                z82.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new z32(1001));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ v02 d;

        public c(v02 v02Var, fb2 fb2Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v02Var, fb2Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v02Var;
            this.a = fb2Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean U1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fb2 fb2Var = this.a;
                if (fb2Var == null) {
                    z82.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new z32(1001));
                    return;
                }
                if (this.c) {
                    U1 = fb2Var.P2();
                } else {
                    U1 = fb2Var.U1();
                }
                if (!U1) {
                    if (this.c) {
                        str = "show";
                    } else {
                        str = "hide";
                    }
                    z82.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new z32(1001));
                    return;
                }
                this.d.d(this.b, new z32(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v02(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public z32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            zb3 b0 = zb3.b0();
            if (b0 != null && b0.n0()) {
                return new z32(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (z32) invokeL.objValue;
    }

    public z32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return new z32(1001);
            }
            String optString = jSONObject.optString("title");
            ib2 U = mx2.T().U();
            if (U == null) {
                z82.c("NavigationBarApi", "manager is null");
                return new z32(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                p("cb is empty", null, true);
                return new z32(1001, "cb is empty");
            }
            tp3.e0(new a(this, U.m(), optString, optString2));
            return z32.f();
        }
        return (z32) invokeL.objValue;
    }

    public z32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            ib2 U = mx2.T().U();
            if (U == null) {
                z82.c("NavigationBarApi", "manager is null");
                return new z32(1001);
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new z32(1001, "cb is empty");
            }
            tp3.e0(new b(this, U.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObject.optJSONObject("animation")));
            return z32.f();
        }
        return (z32) invokeL.objValue;
    }

    public final z32 x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            ib2 U = mx2.T().U();
            if (U == null) {
                z82.c("NavigationBarApi", "manager is null");
                return new z32(1001);
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("cb is empty", null, true);
                return new z32(1001, "cb is empty");
            }
            tp3.e0(new c(this, U.m(), optString, z));
            return z32.f();
        }
        return (z32) invokeLZ.objValue;
    }

    public z32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (z32) invokeL.objValue;
    }
}
