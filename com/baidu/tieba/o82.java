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
public final class o82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public dr3 a;
    @NonNull
    public ArrayMap<String, o72> b;
    @NonNull
    public ArrayMap<String, List<o72>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986048, "Lcom/baidu/tieba/o82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986048, "Lcom/baidu/tieba/o82;");
                return;
            }
        }
        d = js1.a;
    }

    public o82(@NonNull dr3 dr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dr3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dr3Var;
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
            o72 o72Var = this.b.get(str);
            if (o72Var == null) {
                z82.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return o72Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(o72 o72Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o72Var)) == null) {
            if (o72Var == null) {
                s82.a("Component-Container", "insert component with a null component");
                return false;
            }
            p72 n = o72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = o72Var.o();
            SwanAppComponentContainerView m = o72Var.m();
            if (m == null) {
                s82.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                z82.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                s82.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            f23 f23Var = n.h;
            if (f23Var == null) {
                s82.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!f23Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                s82.a("Component-Container", sb.toString());
                n.h = new f23();
            }
            if (!n82.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        z82.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        s82.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = n82.b(this, n, m);
                if (!b) {
                    s82.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, o72Var);
                if (o72Var.s(2)) {
                    z82.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<o72> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(o72Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        o72 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, o72> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull o72 o72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull p72 p72Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, o72Var, swanAppComponentContainerView, p72Var)) == null) {
            String o = o72Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            f23 f23Var = p72Var.h;
            if (f23Var != null && f23Var.h()) {
                if (n82.c(p72Var) && !n82.e(this, p72Var, swanAppComponentContainerView)) {
                    s82.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = p72Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, p72Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    z82.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, p72Var.b());
                    return true;
                } else {
                    s82.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = p72Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            s82.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(o72 o72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, o72Var)) == null) {
            boolean z = false;
            if (o72Var == null) {
                s82.a("Component-Container", "remove component with a null component");
                return false;
            }
            p72 n = o72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = o72Var.o();
            SwanAppComponentContainerView m = o72Var.m();
            if (m == null) {
                s82.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                s82.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!n82.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            z82.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            s82.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = n82.g(this, n, m);
                    if (!z) {
                        s82.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || o72Var.s(1)) {
                    this.b.remove(str2);
                    if (o72Var.s(2)) {
                        z82.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<o72> list = this.c.get(str);
                        if (list != null) {
                            list.remove(o72Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(o72 o72Var, @NonNull r82 r82Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, o72Var, r82Var)) == null) {
            if (o72Var == null) {
                s82.a("Component-Container", "update component with a null component");
                return false;
            }
            p72 n = o72Var.n();
            String o = o72Var.o();
            SwanAppComponentContainerView m = o72Var.m();
            if (m == null) {
                s82.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                z82.c("Component-Container", "don't insert" + o);
            }
            if (o72Var instanceof g82) {
                if (r82Var.a(7)) {
                    boolean d2 = n82.d(this, o72Var, n, m, r82Var);
                    if (!d2) {
                        s82.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (r82Var.a(8)) {
                    n82.f(this, o72Var, n, m, r82Var);
                }
            }
            if (r82Var.a(3) && !d(o72Var, m, n)) {
                z82.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (o72Var instanceof m72) {
                m72 m72Var = (m72) o72Var;
                if (m72Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!m72Var.M()) {
                        z82.c("Component-Container", o + " perform position update with animation fail");
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
