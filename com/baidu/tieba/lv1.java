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
/* loaded from: classes7.dex */
public class lv1 extends ev1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ lv1 d;

        public a(lv1 lv1Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lv1Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lv1Var;
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
                wh3 A = lv1.A();
                if (A == null) {
                    k32.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new ly1(1001));
                    return;
                }
                if (this.b) {
                    j = A.r(this.c);
                } else {
                    j = A.j(this.c);
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
                    k32.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new ly1(1001));
                }
                this.d.d(this.a, new ly1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static wh3 A() {
        InterceptResult invokeV;
        s52 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            t52 W = xr2.V().W();
            if (W != null && (l = W.l()) != null) {
                return l.C3();
            }
            return null;
        }
        return (wh3) invokeV.objValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            t52 W = xr2.V().W();
            if (W != null && W.o() != null && W.o().k2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final ly1 B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (C()) {
                k32.c("TabBarApi", "fail not TabBar page");
                return new ly1(1001, "fail not TabBar page");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("TabBarApi", "callback is null");
                return new ly1(1001, "callback is null");
            }
            ek3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return ly1.f();
        }
        return (ly1) invokeLZ.objValue;
    }

    public ly1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#openTabBar", false);
            return B(str, true);
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            r("#closeTabBar", false);
            return B(str, false);
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#setTabBarItem", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (C()) {
                k32.c("TabBarApi", "fail not TabBar page");
                return new ly1(1001, "fail not TabBar page");
            }
            wh3 A = A();
            if (A == null) {
                k32.c("TabBarApi", "tabBarViewController is null");
                return new ly1(1001, "tabBarViewController is null");
            } else if (!A.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                k32.c("TabBarApi", "set tab bar item fail");
                return new ly1(1001, "set tab bar item fail");
            } else {
                return ly1.f();
            }
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#closeTabBarRedDot", false);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            int optInt = ((JSONObject) t.second).optInt("index");
            if (C()) {
                k32.c("TabBarApi", "fail not TabBar page");
                return new ly1(1001, "fail not TabBar page");
            }
            wh3 A = A();
            if (A == null) {
                k32.c("TabBarApi", "tabBarViewController is null");
                return new ly1(1001, "tabBarViewController is null");
            } else if (!A.k(optInt)) {
                k32.c("TabBarApi", "close red dot fail");
                return new ly1(1001, "close red dot fail");
            } else {
                return ly1.f();
            }
        }
        return (ly1) invokeL.objValue;
    }
}
