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
public class v02 extends o02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
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
        public final /* synthetic */ v02 d;

        public a(v02 v02Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v02Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
                hn3 z = v02.z();
                if (z == null) {
                    v82.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new v32(1001));
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
                    v82.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new v32(1001));
                }
                this.d.d(this.a, new v32(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v02(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
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
            eb2 U = ix2.T().U();
            if (U != null && U.o() != null && U.o().g2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static hn3 z() {
        InterceptResult invokeV;
        db2 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            eb2 U = ix2.T().U();
            if (U != null && (l = U.l()) != null) {
                return l.x3();
            }
            return null;
        }
        return (hn3) invokeV.objValue;
    }

    public final v32 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                v82.c("TabBarApi", "fail not TabBar page");
                return new v32(1001, "fail not TabBar page");
            }
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v82.c("TabBarApi", "callback is null");
                return new v32(1001, "callback is null");
            }
            pp3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return v32.f();
        }
        return (v32) invokeLZ.objValue;
    }

    public v32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (v32) invokeL.objValue;
    }

    public v32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (v32) invokeL.objValue;
    }

    public v32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (B()) {
                v82.c("TabBarApi", "fail not TabBar page");
                return new v32(1001, "fail not TabBar page");
            }
            hn3 z = z();
            if (z == null) {
                v82.c("TabBarApi", "tabBarViewController is null");
                return new v32(1001, "tabBarViewController is null");
            } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                v82.c("TabBarApi", "set tab bar item fail");
                return new v32(1001, "set tab bar item fail");
            } else {
                return v32.f();
            }
        }
        return (v32) invokeL.objValue;
    }

    public v32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            int optInt = ((JSONObject) s.second).optInt("index");
            if (B()) {
                v82.c("TabBarApi", "fail not TabBar page");
                return new v32(1001, "fail not TabBar page");
            }
            hn3 z = z();
            if (z == null) {
                v82.c("TabBarApi", "tabBarViewController is null");
                return new v32(1001, "tabBarViewController is null");
            } else if (!z.k(optInt)) {
                v82.c("TabBarApi", "close red dot fail");
                return new v32(1001, "close red dot fail");
            } else {
                return v32.f();
            }
        }
        return (v32) invokeL.objValue;
    }
}
