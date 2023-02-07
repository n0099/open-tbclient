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
/* loaded from: classes5.dex */
public final class l52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ao3 a;
    @NonNull
    public ArrayMap<String, l42> b;
    @NonNull
    public ArrayMap<String, List<l42>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947893792, "Lcom/baidu/tieba/l52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947893792, "Lcom/baidu/tieba/l52;");
                return;
            }
        }
        d = gp1.a;
    }

    public l52(@NonNull ao3 ao3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ao3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ao3Var;
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
            l42 l42Var = this.b.get(str);
            if (l42Var == null) {
                w52.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return l42Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(l42 l42Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l42Var)) == null) {
            if (l42Var == null) {
                p52.a("Component-Container", "insert component with a null component");
                return false;
            }
            m42 n = l42Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = l42Var.o();
            SwanAppComponentContainerView m = l42Var.m();
            if (m == null) {
                p52.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                w52.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                p52.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            cz2 cz2Var = n.h;
            if (cz2Var == null) {
                p52.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!cz2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                p52.a("Component-Container", sb.toString());
                n.h = new cz2();
            }
            if (!k52.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        w52.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        p52.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = k52.b(this, n, m);
                if (!b) {
                    p52.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, l42Var);
                if (l42Var.s(2)) {
                    w52.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<l42> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(l42Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        l42 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, l42> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull l42 l42Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull m42 m42Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, l42Var, swanAppComponentContainerView, m42Var)) == null) {
            String o = l42Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            cz2 cz2Var = m42Var.h;
            if (cz2Var != null && cz2Var.h()) {
                if (k52.c(m42Var) && !k52.e(this, m42Var, swanAppComponentContainerView)) {
                    p52.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = m42Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, m42Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    w52.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, m42Var.b());
                    return true;
                } else {
                    p52.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = m42Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            p52.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(l42 l42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l42Var)) == null) {
            boolean z = false;
            if (l42Var == null) {
                p52.a("Component-Container", "remove component with a null component");
                return false;
            }
            m42 n = l42Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = l42Var.o();
            SwanAppComponentContainerView m = l42Var.m();
            if (m == null) {
                p52.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                p52.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!k52.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            w52.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            p52.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = k52.g(this, n, m);
                    if (!z) {
                        p52.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || l42Var.s(1)) {
                    this.b.remove(str2);
                    if (l42Var.s(2)) {
                        w52.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<l42> list = this.c.get(str);
                        if (list != null) {
                            list.remove(l42Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(l42 l42Var, @NonNull o52 o52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, l42Var, o52Var)) == null) {
            if (l42Var == null) {
                p52.a("Component-Container", "update component with a null component");
                return false;
            }
            m42 n = l42Var.n();
            String o = l42Var.o();
            SwanAppComponentContainerView m = l42Var.m();
            if (m == null) {
                p52.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                w52.c("Component-Container", "don't insert" + o);
            }
            if (l42Var instanceof d52) {
                if (o52Var.a(7)) {
                    boolean d2 = k52.d(this, l42Var, n, m, o52Var);
                    if (!d2) {
                        p52.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (o52Var.a(8)) {
                    k52.f(this, l42Var, n, m, o52Var);
                }
            }
            if (o52Var.a(3) && !d(l42Var, m, n)) {
                w52.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (l42Var instanceof j42) {
                j42 j42Var = (j42) l42Var;
                if (j42Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!j42Var.M()) {
                        w52.c("Component-Container", o + " perform position update with animation fail");
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
