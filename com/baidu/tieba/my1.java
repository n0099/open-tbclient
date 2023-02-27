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
/* loaded from: classes5.dex */
public class my1 extends fy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ my1 d;

        public a(my1 my1Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {my1Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = my1Var;
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
                yk3 z = my1.z();
                if (z == null) {
                    m62.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new m12(1001));
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
                    m62.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new m12(1001));
                }
                this.d.d(this.a, new m12(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my1(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nx1) newInitContext.callArgs[0]);
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
            v82 V = zu2.U().V();
            if (V != null && V.o() != null && V.o().e2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static yk3 z() {
        InterceptResult invokeV;
        u82 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            v82 V = zu2.U().V();
            if (V != null && (l = V.l()) != null) {
                return l.v3();
            }
            return null;
        }
        return (yk3) invokeV.objValue;
    }

    public final m12 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                m62.c("TabBarApi", "fail not TabBar page");
                return new m12(1001, "fail not TabBar page");
            }
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m62.c("TabBarApi", "callback is null");
                return new m12(1001, "callback is null");
            }
            gn3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return m12.f();
        }
        return (m12) invokeLZ.objValue;
    }

    public m12 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (m12) invokeL.objValue;
    }

    public m12 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (m12) invokeL.objValue;
    }

    public m12 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (B()) {
                m62.c("TabBarApi", "fail not TabBar page");
                return new m12(1001, "fail not TabBar page");
            }
            yk3 z = z();
            if (z == null) {
                m62.c("TabBarApi", "tabBarViewController is null");
                return new m12(1001, "tabBarViewController is null");
            } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                m62.c("TabBarApi", "set tab bar item fail");
                return new m12(1001, "set tab bar item fail");
            } else {
                return m12.f();
            }
        }
        return (m12) invokeL.objValue;
    }

    public m12 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            int optInt = ((JSONObject) s.second).optInt("index");
            if (B()) {
                m62.c("TabBarApi", "fail not TabBar page");
                return new m12(1001, "fail not TabBar page");
            }
            yk3 z = z();
            if (z == null) {
                m62.c("TabBarApi", "tabBarViewController is null");
                return new m12(1001, "tabBarViewController is null");
            } else if (!z.k(optInt)) {
                m62.c("TabBarApi", "close red dot fail");
                return new m12(1001, "close red dot fail");
            } else {
                return m12.f();
            }
        }
        return (m12) invokeL.objValue;
    }
}
