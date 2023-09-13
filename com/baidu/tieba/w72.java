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
public final class w72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public lq3 a;
    @NonNull
    public ArrayMap<String, w62> b;
    @NonNull
    public ArrayMap<String, List<w62>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223415, "Lcom/baidu/tieba/w72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223415, "Lcom/baidu/tieba/w72;");
                return;
            }
        }
        d = rr1.a;
    }

    public w72(@NonNull lq3 lq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = lq3Var;
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
            w62 w62Var = this.b.get(str);
            if (w62Var == null) {
                h82.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return w62Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(w62 w62Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w62Var)) == null) {
            if (w62Var == null) {
                a82.a("Component-Container", "insert component with a null component");
                return false;
            }
            x62 n = w62Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = w62Var.o();
            SwanAppComponentContainerView m = w62Var.m();
            if (m == null) {
                a82.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                h82.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                a82.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            n13 n13Var = n.h;
            if (n13Var == null) {
                a82.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!n13Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                a82.a("Component-Container", sb.toString());
                n.h = new n13();
            }
            if (!v72.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        h82.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        a82.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = v72.b(this, n, m);
                if (!b) {
                    a82.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, w62Var);
                if (w62Var.s(2)) {
                    h82.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<w62> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(w62Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        w62 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, w62> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull w62 w62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull x62 x62Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, w62Var, swanAppComponentContainerView, x62Var)) == null) {
            String o = w62Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            n13 n13Var = x62Var.h;
            if (n13Var != null && n13Var.h()) {
                if (v72.c(x62Var) && !v72.e(this, x62Var, swanAppComponentContainerView)) {
                    a82.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = x62Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, x62Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    h82.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, x62Var.b());
                    return true;
                } else {
                    a82.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = x62Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            a82.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(w62 w62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, w62Var)) == null) {
            boolean z = false;
            if (w62Var == null) {
                a82.a("Component-Container", "remove component with a null component");
                return false;
            }
            x62 n = w62Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = w62Var.o();
            SwanAppComponentContainerView m = w62Var.m();
            if (m == null) {
                a82.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                a82.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!v72.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            h82.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            a82.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = v72.g(this, n, m);
                    if (!z) {
                        a82.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || w62Var.s(1)) {
                    this.b.remove(str2);
                    if (w62Var.s(2)) {
                        h82.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<w62> list = this.c.get(str);
                        if (list != null) {
                            list.remove(w62Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(w62 w62Var, @NonNull z72 z72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, w62Var, z72Var)) == null) {
            if (w62Var == null) {
                a82.a("Component-Container", "update component with a null component");
                return false;
            }
            x62 n = w62Var.n();
            String o = w62Var.o();
            SwanAppComponentContainerView m = w62Var.m();
            if (m == null) {
                a82.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                h82.c("Component-Container", "don't insert" + o);
            }
            if (w62Var instanceof o72) {
                if (z72Var.a(7)) {
                    boolean d2 = v72.d(this, w62Var, n, m, z72Var);
                    if (!d2) {
                        a82.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (z72Var.a(8)) {
                    v72.f(this, w62Var, n, m, z72Var);
                }
            }
            if (z72Var.a(3) && !d(w62Var, m, n)) {
                h82.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (w62Var instanceof u62) {
                u62 u62Var = (u62) w62Var;
                if (u62Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!u62Var.M()) {
                        h82.c("Component-Container", o + " perform position update with animation fail");
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
