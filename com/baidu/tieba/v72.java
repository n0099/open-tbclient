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
/* loaded from: classes8.dex */
public final class v72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public kq3 a;
    @NonNull
    public ArrayMap<String, v62> b;
    @NonNull
    public ArrayMap<String, List<v62>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/v72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/v72;");
                return;
            }
        }
        d = qr1.a;
    }

    public v72(@NonNull kq3 kq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = kq3Var;
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
            v62 v62Var = this.b.get(str);
            if (v62Var == null) {
                g82.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return v62Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(v62 v62Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v62Var)) == null) {
            if (v62Var == null) {
                z72.a("Component-Container", "insert component with a null component");
                return false;
            }
            w62 n = v62Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = v62Var.o();
            SwanAppComponentContainerView m = v62Var.m();
            if (m == null) {
                z72.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                g82.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                z72.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            m13 m13Var = n.h;
            if (m13Var == null) {
                z72.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!m13Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                z72.a("Component-Container", sb.toString());
                n.h = new m13();
            }
            if (!u72.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        g82.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        z72.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = u72.b(this, n, m);
                if (!b) {
                    z72.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, v62Var);
                if (v62Var.s(2)) {
                    g82.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<v62> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(v62Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        v62 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, v62> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull v62 v62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull w62 w62Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, v62Var, swanAppComponentContainerView, w62Var)) == null) {
            String o = v62Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            m13 m13Var = w62Var.h;
            if (m13Var != null && m13Var.h()) {
                if (u72.c(w62Var) && !u72.e(this, w62Var, swanAppComponentContainerView)) {
                    z72.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = w62Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, w62Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    g82.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, w62Var.b());
                    return true;
                } else {
                    z72.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = w62Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            z72.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(v62 v62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v62Var)) == null) {
            boolean z = false;
            if (v62Var == null) {
                z72.a("Component-Container", "remove component with a null component");
                return false;
            }
            w62 n = v62Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = v62Var.o();
            SwanAppComponentContainerView m = v62Var.m();
            if (m == null) {
                z72.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                z72.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!u72.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            g82.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            z72.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = u72.g(this, n, m);
                    if (!z) {
                        z72.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || v62Var.s(1)) {
                    this.b.remove(str2);
                    if (v62Var.s(2)) {
                        g82.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<v62> list = this.c.get(str);
                        if (list != null) {
                            list.remove(v62Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(v62 v62Var, @NonNull y72 y72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, v62Var, y72Var)) == null) {
            if (v62Var == null) {
                z72.a("Component-Container", "update component with a null component");
                return false;
            }
            w62 n = v62Var.n();
            String o = v62Var.o();
            SwanAppComponentContainerView m = v62Var.m();
            if (m == null) {
                z72.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                g82.c("Component-Container", "don't insert" + o);
            }
            if (v62Var instanceof n72) {
                if (y72Var.a(7)) {
                    boolean d2 = u72.d(this, v62Var, n, m, y72Var);
                    if (!d2) {
                        z72.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (y72Var.a(8)) {
                    u72.f(this, v62Var, n, m, y72Var);
                }
            }
            if (y72Var.a(3) && !d(v62Var, m, n)) {
                g82.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (v62Var instanceof t62) {
                t62 t62Var = (t62) v62Var;
                if (t62Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!t62Var.M()) {
                        g82.c("Component-Container", o + " perform position update with animation fail");
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
