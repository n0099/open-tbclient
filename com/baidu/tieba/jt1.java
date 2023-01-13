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
public class jt1 extends ct1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ms1
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
        public final /* synthetic */ jt1 d;

        public a(jt1 jt1Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jt1Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jt1Var;
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
                vf3 z = jt1.z();
                if (z == null) {
                    j12.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new jw1(1001));
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
                    j12.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new jw1(1001));
                }
                this.d.d(this.a, new jw1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jt1(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ks1) newInitContext.callArgs[0]);
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
            s32 V = wp2.U().V();
            if (V != null && V.o() != null && V.o().e2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static vf3 z() {
        InterceptResult invokeV;
        r32 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            s32 V = wp2.U().V();
            if (V != null && (l = V.l()) != null) {
                return l.v3();
            }
            return null;
        }
        return (vf3) invokeV.objValue;
    }

    public final jw1 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                j12.c("TabBarApi", "fail not TabBar page");
                return new jw1(1001, "fail not TabBar page");
            }
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j12.c("TabBarApi", "callback is null");
                return new jw1(1001, "callback is null");
            }
            di3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return jw1.f();
        }
        return (jw1) invokeLZ.objValue;
    }

    public jw1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (B()) {
                j12.c("TabBarApi", "fail not TabBar page");
                return new jw1(1001, "fail not TabBar page");
            }
            vf3 z = z();
            if (z == null) {
                j12.c("TabBarApi", "tabBarViewController is null");
                return new jw1(1001, "tabBarViewController is null");
            } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                j12.c("TabBarApi", "set tab bar item fail");
                return new jw1(1001, "set tab bar item fail");
            } else {
                return jw1.f();
            }
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            int optInt = ((JSONObject) s.second).optInt("index");
            if (B()) {
                j12.c("TabBarApi", "fail not TabBar page");
                return new jw1(1001, "fail not TabBar page");
            }
            vf3 z = z();
            if (z == null) {
                j12.c("TabBarApi", "tabBarViewController is null");
                return new jw1(1001, "tabBarViewController is null");
            } else if (!z.k(optInt)) {
                j12.c("TabBarApi", "close red dot fail");
                return new jw1(1001, "close red dot fail");
            } else {
                return jw1.f();
            }
        }
        return (jw1) invokeL.objValue;
    }
}
