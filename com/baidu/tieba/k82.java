package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class k82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public zq3 a;
    @NonNull
    public ArrayMap<String, k72> b;
    @NonNull
    public ArrayMap<String, List<k72>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947866884, "Lcom/baidu/tieba/k82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947866884, "Lcom/baidu/tieba/k82;");
                return;
            }
        }
        d = fs1.a;
    }

    public k82(@NonNull zq3 zq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = zq3Var;
        this.b = new ArrayMap<>();
        this.c = new ArrayMap<>();
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            k72 k72Var = this.b.get(str);
            if (k72Var == null) {
                v82.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return k72Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(k72 k72Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k72Var)) == null) {
            if (k72Var == null) {
                o82.a("Component-Container", "insert component with a null component");
                return false;
            }
            l72 n = k72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = k72Var.o();
            SwanAppComponentContainerView m = k72Var.m();
            if (m == null) {
                o82.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                v82.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                o82.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            b23 b23Var = n.h;
            if (b23Var == null) {
                o82.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!b23Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                o82.a("Component-Container", sb.toString());
                n.h = new b23();
            }
            if (!j82.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        v82.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        o82.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = j82.b(this, n, m);
                if (!b) {
                    o82.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, k72Var);
                if (k72Var.s(2)) {
                    v82.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<k72> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(k72Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        k72 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, k72> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull k72 k72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull l72 l72Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, k72Var, swanAppComponentContainerView, l72Var)) == null) {
            String o = k72Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            b23 b23Var = l72Var.h;
            if (b23Var != null && b23Var.h()) {
                if (j82.c(l72Var) && !j82.e(this, l72Var, swanAppComponentContainerView)) {
                    o82.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = l72Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, l72Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    v82.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, l72Var.b());
                    return true;
                } else {
                    o82.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = l72Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            o82.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(k72 k72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k72Var)) == null) {
            boolean z = false;
            if (k72Var == null) {
                o82.a("Component-Container", "remove component with a null component");
                return false;
            }
            l72 n = k72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = k72Var.o();
            SwanAppComponentContainerView m = k72Var.m();
            if (m == null) {
                o82.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                o82.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!j82.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            v82.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            o82.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = j82.g(this, n, m);
                    if (!z) {
                        o82.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || k72Var.s(1)) {
                    this.b.remove(str2);
                    if (k72Var.s(2)) {
                        v82.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<k72> list = this.c.get(str);
                        if (list != null) {
                            list.remove(k72Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(k72 k72Var, @NonNull n82 n82Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k72Var, n82Var)) == null) {
            if (k72Var == null) {
                o82.a("Component-Container", "update component with a null component");
                return false;
            }
            l72 n = k72Var.n();
            String o = k72Var.o();
            SwanAppComponentContainerView m = k72Var.m();
            if (m == null) {
                o82.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                v82.c("Component-Container", "don't insert" + o);
            }
            if (k72Var instanceof c82) {
                if (n82Var.a(7)) {
                    boolean d2 = j82.d(this, k72Var, n, m, n82Var);
                    if (!d2) {
                        o82.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (n82Var.a(8)) {
                    j82.f(this, k72Var, n, m, n82Var);
                }
            }
            if (n82Var.a(3) && !d(k72Var, m, n)) {
                v82.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (k72Var instanceof i72) {
                i72 i72Var = (i72) k72Var;
                if (i72Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!i72Var.M()) {
                        v82.c("Component-Container", o + " perform position update with animation fail");
                        return false;
                    }
                    return true;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
