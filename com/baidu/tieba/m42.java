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
public final class m42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public bn3 a;
    @NonNull
    public ArrayMap<String, m32> b;
    @NonNull
    public ArrayMap<String, List<m32>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947922622, "Lcom/baidu/tieba/m42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947922622, "Lcom/baidu/tieba/m42;");
                return;
            }
        }
        d = ho1.a;
    }

    public m42(@NonNull bn3 bn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bn3Var;
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
            m32 m32Var = this.b.get(str);
            if (m32Var == null) {
                x42.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return m32Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(m32 m32Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m32Var)) == null) {
            if (m32Var == null) {
                q42.a("Component-Container", "insert component with a null component");
                return false;
            }
            n32 n = m32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = m32Var.o();
            SwanAppComponentContainerView m = m32Var.m();
            if (m == null) {
                q42.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                x42.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                q42.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            dy2 dy2Var = n.h;
            if (dy2Var == null) {
                q42.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!dy2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                q42.a("Component-Container", sb.toString());
                n.h = new dy2();
            }
            if (!l42.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        x42.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        q42.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = l42.b(this, n, m);
                if (!b) {
                    q42.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, m32Var);
                if (m32Var.s(2)) {
                    x42.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<m32> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(m32Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        m32 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, m32> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull m32 m32Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull n32 n32Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, m32Var, swanAppComponentContainerView, n32Var)) == null) {
            String o = m32Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            dy2 dy2Var = n32Var.h;
            if (dy2Var != null && dy2Var.h()) {
                if (l42.c(n32Var) && !l42.e(this, n32Var, swanAppComponentContainerView)) {
                    q42.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = n32Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, n32Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    x42.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, n32Var.b());
                    return true;
                } else {
                    q42.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = n32Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            q42.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(m32 m32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, m32Var)) == null) {
            boolean z = false;
            if (m32Var == null) {
                q42.a("Component-Container", "remove component with a null component");
                return false;
            }
            n32 n = m32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = m32Var.o();
            SwanAppComponentContainerView m = m32Var.m();
            if (m == null) {
                q42.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                q42.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!l42.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            x42.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            q42.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = l42.g(this, n, m);
                    if (!z) {
                        q42.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || m32Var.s(1)) {
                    this.b.remove(str2);
                    if (m32Var.s(2)) {
                        x42.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<m32> list = this.c.get(str);
                        if (list != null) {
                            list.remove(m32Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(m32 m32Var, @NonNull p42 p42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, m32Var, p42Var)) == null) {
            if (m32Var == null) {
                q42.a("Component-Container", "update component with a null component");
                return false;
            }
            n32 n = m32Var.n();
            String o = m32Var.o();
            SwanAppComponentContainerView m = m32Var.m();
            if (m == null) {
                q42.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                x42.c("Component-Container", "don't insert" + o);
            }
            if (m32Var instanceof e42) {
                if (p42Var.a(7)) {
                    boolean d2 = l42.d(this, m32Var, n, m, p42Var);
                    if (!d2) {
                        q42.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (p42Var.a(8)) {
                    l42.f(this, m32Var, n, m, p42Var);
                }
            }
            if (p42Var.a(3) && !d(m32Var, m, n)) {
                x42.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (m32Var instanceof k32) {
                k32 k32Var = (k32) m32Var;
                if (k32Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!k32Var.M()) {
                        x42.c("Component-Container", o + " perform position update with animation fail");
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
