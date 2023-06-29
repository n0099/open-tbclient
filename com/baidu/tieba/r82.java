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
public final class r82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public gr3 a;
    @NonNull
    public ArrayMap<String, r72> b;
    @NonNull
    public ArrayMap<String, List<r72>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075421, "Lcom/baidu/tieba/r82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075421, "Lcom/baidu/tieba/r82;");
                return;
            }
        }
        d = ms1.a;
    }

    public r82(@NonNull gr3 gr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gr3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = gr3Var;
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
            r72 r72Var = this.b.get(str);
            if (r72Var == null) {
                c92.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return r72Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(r72 r72Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r72Var)) == null) {
            if (r72Var == null) {
                v82.a("Component-Container", "insert component with a null component");
                return false;
            }
            s72 n = r72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = r72Var.o();
            SwanAppComponentContainerView m = r72Var.m();
            if (m == null) {
                v82.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                c92.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                v82.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            i23 i23Var = n.h;
            if (i23Var == null) {
                v82.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!i23Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                v82.a("Component-Container", sb.toString());
                n.h = new i23();
            }
            if (!q82.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        c92.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        v82.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = q82.b(this, n, m);
                if (!b) {
                    v82.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, r72Var);
                if (r72Var.s(2)) {
                    c92.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<r72> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(r72Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        r72 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, r72> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull r72 r72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull s72 s72Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, r72Var, swanAppComponentContainerView, s72Var)) == null) {
            String o = r72Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            i23 i23Var = s72Var.h;
            if (i23Var != null && i23Var.h()) {
                if (q82.c(s72Var) && !q82.e(this, s72Var, swanAppComponentContainerView)) {
                    v82.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = s72Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, s72Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    c92.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, s72Var.b());
                    return true;
                } else {
                    v82.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = s72Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            v82.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(r72 r72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, r72Var)) == null) {
            boolean z = false;
            if (r72Var == null) {
                v82.a("Component-Container", "remove component with a null component");
                return false;
            }
            s72 n = r72Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = r72Var.o();
            SwanAppComponentContainerView m = r72Var.m();
            if (m == null) {
                v82.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                v82.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!q82.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            c92.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            v82.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = q82.g(this, n, m);
                    if (!z) {
                        v82.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || r72Var.s(1)) {
                    this.b.remove(str2);
                    if (r72Var.s(2)) {
                        c92.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<r72> list = this.c.get(str);
                        if (list != null) {
                            list.remove(r72Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(r72 r72Var, @NonNull u82 u82Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, r72Var, u82Var)) == null) {
            if (r72Var == null) {
                v82.a("Component-Container", "update component with a null component");
                return false;
            }
            s72 n = r72Var.n();
            String o = r72Var.o();
            SwanAppComponentContainerView m = r72Var.m();
            if (m == null) {
                v82.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                c92.c("Component-Container", "don't insert" + o);
            }
            if (r72Var instanceof j82) {
                if (u82Var.a(7)) {
                    boolean d2 = q82.d(this, r72Var, n, m, u82Var);
                    if (!d2) {
                        v82.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (u82Var.a(8)) {
                    q82.f(this, r72Var, n, m, u82Var);
                }
            }
            if (u82Var.a(3) && !d(r72Var, m, n)) {
                c92.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (r72Var instanceof p72) {
                p72 p72Var = (p72) r72Var;
                if (p72Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!p72Var.M()) {
                        c92.c("Component-Container", o + " perform position update with animation fail");
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
