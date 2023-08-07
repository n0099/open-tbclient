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
/* loaded from: classes7.dex */
public final class n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public cq3 a;
    @NonNull
    public ArrayMap<String, n62> b;
    @NonNull
    public ArrayMap<String, List<n62>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955296, "Lcom/baidu/tieba/n72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955296, "Lcom/baidu/tieba/n72;");
                return;
            }
        }
        d = ir1.a;
    }

    public n72(@NonNull cq3 cq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cq3Var;
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
            n62 n62Var = this.b.get(str);
            if (n62Var == null) {
                y72.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return n62Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(n62 n62Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n62Var)) == null) {
            if (n62Var == null) {
                r72.a("Component-Container", "insert component with a null component");
                return false;
            }
            o62 n = n62Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = n62Var.o();
            SwanAppComponentContainerView m = n62Var.m();
            if (m == null) {
                r72.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                y72.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                r72.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            e13 e13Var = n.h;
            if (e13Var == null) {
                r72.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!e13Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                r72.a("Component-Container", sb.toString());
                n.h = new e13();
            }
            if (!m72.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        y72.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        r72.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = m72.b(this, n, m);
                if (!b) {
                    r72.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, n62Var);
                if (n62Var.s(2)) {
                    y72.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<n62> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(n62Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        n62 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, n62> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull n62 n62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull o62 o62Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, n62Var, swanAppComponentContainerView, o62Var)) == null) {
            String o = n62Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            e13 e13Var = o62Var.h;
            if (e13Var != null && e13Var.h()) {
                if (m72.c(o62Var) && !m72.e(this, o62Var, swanAppComponentContainerView)) {
                    r72.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = o62Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, o62Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    y72.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, o62Var.b());
                    return true;
                } else {
                    r72.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = o62Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            r72.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(n62 n62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, n62Var)) == null) {
            boolean z = false;
            if (n62Var == null) {
                r72.a("Component-Container", "remove component with a null component");
                return false;
            }
            o62 n = n62Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = n62Var.o();
            SwanAppComponentContainerView m = n62Var.m();
            if (m == null) {
                r72.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                r72.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!m72.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            y72.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            r72.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = m72.g(this, n, m);
                    if (!z) {
                        r72.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || n62Var.s(1)) {
                    this.b.remove(str2);
                    if (n62Var.s(2)) {
                        y72.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<n62> list = this.c.get(str);
                        if (list != null) {
                            list.remove(n62Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(n62 n62Var, @NonNull q72 q72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, n62Var, q72Var)) == null) {
            if (n62Var == null) {
                r72.a("Component-Container", "update component with a null component");
                return false;
            }
            o62 n = n62Var.n();
            String o = n62Var.o();
            SwanAppComponentContainerView m = n62Var.m();
            if (m == null) {
                r72.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                y72.c("Component-Container", "don't insert" + o);
            }
            if (n62Var instanceof f72) {
                if (q72Var.a(7)) {
                    boolean d2 = m72.d(this, n62Var, n, m, q72Var);
                    if (!d2) {
                        r72.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (q72Var.a(8)) {
                    m72.f(this, n62Var, n, m, q72Var);
                }
            }
            if (q72Var.a(3) && !d(n62Var, m, n)) {
                y72.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (n62Var instanceof l62) {
                l62 l62Var = (l62) n62Var;
                if (l62Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!l62Var.M()) {
                        y72.c("Component-Container", o + " perform position update with animation fail");
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
