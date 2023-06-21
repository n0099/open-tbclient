package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class z02 extends s02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ z02 d;

        public a(z02 z02Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z02Var;
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ln3 z = z02.z();
                if (z == null) {
                    z82.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new z32(1001));
                    return;
                }
                if (this.b) {
                    j = z.r(this.c);
                } else {
                    j = z.j(this.c);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    if (this.b) {
                        str = "open";
                    } else {
                        str = "close";
                    }
                    sb.append(str);
                    sb.append("bottom bar fail");
                    z82.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new z32(1001));
                }
                this.d.d(this.a, new z32(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z02(@NonNull a02 a02Var) {
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

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ib2 U = mx2.T().U();
            if (U != null && U.o() != null && U.o().g2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static ln3 z() {
        InterceptResult invokeV;
        hb2 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ib2 U = mx2.T().U();
            if (U != null && (l = U.l()) != null) {
                return l.x3();
            }
            return null;
        }
        return (ln3) invokeV.objValue;
    }

    public final z32 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                z82.c("TabBarApi", "fail not TabBar page");
                return new z32(1001, "fail not TabBar page");
            }
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                z82.c("TabBarApi", "callback is null");
                return new z32(1001, "callback is null");
            }
            tp3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return z32.f();
        }
        return (z32) invokeLZ.objValue;
    }

    public z32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (z32) invokeL.objValue;
    }

    public z32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (z32) invokeL.objValue;
    }

    public z32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (B()) {
                z82.c("TabBarApi", "fail not TabBar page");
                return new z32(1001, "fail not TabBar page");
            }
            ln3 z = z();
            if (z == null) {
                z82.c("TabBarApi", "tabBarViewController is null");
                return new z32(1001, "tabBarViewController is null");
            } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                z82.c("TabBarApi", "set tab bar item fail");
                return new z32(1001, "set tab bar item fail");
            } else {
                return z32.f();
            }
        }
        return (z32) invokeL.objValue;
    }

    public z32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<z32, JSONObject> s = s(str);
            z32 z32Var = (z32) s.first;
            if (!z32Var.isSuccess()) {
                return z32Var;
            }
            int optInt = ((JSONObject) s.second).optInt("index");
            if (B()) {
                z82.c("TabBarApi", "fail not TabBar page");
                return new z32(1001, "fail not TabBar page");
            }
            ln3 z = z();
            if (z == null) {
                z82.c("TabBarApi", "tabBarViewController is null");
                return new z32(1001, "tabBarViewController is null");
            } else if (!z.k(optInt)) {
                z82.c("TabBarApi", "close red dot fail");
                return new z32(1001, "close red dot fail");
            } else {
                return z32.f();
            }
        }
        return (z32) invokeL.objValue;
    }
}
