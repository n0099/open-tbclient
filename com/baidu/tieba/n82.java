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
public final class n82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public cr3 a;
    @NonNull
    public ArrayMap<String, n72> b;
    @NonNull
    public ArrayMap<String, List<n72>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947956257, "Lcom/baidu/tieba/n82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947956257, "Lcom/baidu/tieba/n82;");
                return;
            }
        }
        d = is1.a;
    }

    public n82(@NonNull cr3 cr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cr3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cr3Var;
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
            n72 n72Var = this.b.get(str);
            if (n72Var == null) {
                y82.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return n72Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(n72 n72Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n72Var)) == null) {
            if (n72Var == null) {
                r82.a("Component-Container", "insert component with a null component");
                return false;
            }
            o72 n = n72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = n72Var.o();
            SwanAppComponentContainerView m = n72Var.m();
            if (m == null) {
                r82.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                y82.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                r82.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            e23 e23Var = n.h;
            if (e23Var == null) {
                r82.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!e23Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                r82.a("Component-Container", sb.toString());
                n.h = new e23();
            }
            if (!m82.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        y82.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        r82.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = m82.b(this, n, m);
                if (!b) {
                    r82.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, n72Var);
                if (n72Var.s(2)) {
                    y82.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<n72> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(n72Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        n72 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, n72> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull n72 n72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull o72 o72Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, n72Var, swanAppComponentContainerView, o72Var)) == null) {
            String o = n72Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            e23 e23Var = o72Var.h;
            if (e23Var != null && e23Var.h()) {
                if (m82.c(o72Var) && !m82.e(this, o72Var, swanAppComponentContainerView)) {
                    r82.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = o72Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, o72Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    y82.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, o72Var.b());
                    return true;
                } else {
                    r82.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = o72Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            r82.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(n72 n72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, n72Var)) == null) {
            boolean z = false;
            if (n72Var == null) {
                r82.a("Component-Container", "remove component with a null component");
                return false;
            }
            o72 n = n72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = n72Var.o();
            SwanAppComponentContainerView m = n72Var.m();
            if (m == null) {
                r82.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                r82.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!m82.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            y82.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            r82.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = m82.g(this, n, m);
                    if (!z) {
                        r82.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || n72Var.s(1)) {
                    this.b.remove(str2);
                    if (n72Var.s(2)) {
                        y82.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<n72> list = this.c.get(str);
                        if (list != null) {
                            list.remove(n72Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(n72 n72Var, @NonNull q82 q82Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, n72Var, q82Var)) == null) {
            if (n72Var == null) {
                r82.a("Component-Container", "update component with a null component");
                return false;
            }
            o72 n = n72Var.n();
            String o = n72Var.o();
            SwanAppComponentContainerView m = n72Var.m();
            if (m == null) {
                r82.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                y82.c("Component-Container", "don't insert" + o);
            }
            if (n72Var instanceof f82) {
                if (q82Var.a(7)) {
                    boolean d2 = m82.d(this, n72Var, n, m, q82Var);
                    if (!d2) {
                        r82.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (q82Var.a(8)) {
                    m82.f(this, n72Var, n, m, q82Var);
                }
            }
            if (q82Var.a(3) && !d(n72Var, m, n)) {
                y82.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (n72Var instanceof l72) {
                l72 l72Var = (l72) n72Var;
                if (l72Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!l72Var.M()) {
                        y82.c("Component-Container", o + " perform position update with animation fail");
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
