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
public class yz1 extends rz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
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
        public final /* synthetic */ yz1 d;

        public a(yz1 yz1Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz1Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yz1Var;
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
                km3 z = yz1.z();
                if (z == null) {
                    y72.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new y22(1001));
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
                    y72.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new y22(1001));
                }
                this.d.d(this.a, new y22(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yz1(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
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
            ha2 U = lw2.T().U();
            if (U != null && U.o() != null && U.o().g2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static km3 z() {
        InterceptResult invokeV;
        ga2 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ha2 U = lw2.T().U();
            if (U != null && (l = U.l()) != null) {
                return l.x3();
            }
            return null;
        }
        return (km3) invokeV.objValue;
    }

    public final y22 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                y72.c("TabBarApi", "fail not TabBar page");
                return new y22(1001, "fail not TabBar page");
            }
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y72.c("TabBarApi", "callback is null");
                return new y22(1001, "callback is null");
            }
            so3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return y22.f();
        }
        return (y22) invokeLZ.objValue;
    }

    public y22 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (y22) invokeL.objValue;
    }

    public y22 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (y22) invokeL.objValue;
    }

    public y22 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (B()) {
                y72.c("TabBarApi", "fail not TabBar page");
                return new y22(1001, "fail not TabBar page");
            }
            km3 z = z();
            if (z == null) {
                y72.c("TabBarApi", "tabBarViewController is null");
                return new y22(1001, "tabBarViewController is null");
            } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                y72.c("TabBarApi", "set tab bar item fail");
                return new y22(1001, "set tab bar item fail");
            } else {
                return y22.f();
            }
        }
        return (y22) invokeL.objValue;
    }

    public y22 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            int optInt = ((JSONObject) s.second).optInt("index");
            if (B()) {
                y72.c("TabBarApi", "fail not TabBar page");
                return new y22(1001, "fail not TabBar page");
            }
            km3 z = z();
            if (z == null) {
                y72.c("TabBarApi", "tabBarViewController is null");
                return new y22(1001, "tabBarViewController is null");
            } else if (!z.k(optInt)) {
                y72.c("TabBarApi", "close red dot fail");
                return new y22(1001, "close red dot fail");
            } else {
                return y22.f();
            }
        }
        return (y22) invokeL.objValue;
    }
}
