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
/* loaded from: classes9.dex */
public final class z22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ol3 a;
    @NonNull
    public ArrayMap<String, a22> b;
    @NonNull
    public ArrayMap<String, List<a22>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307983, "Lcom/baidu/tieba/z22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307983, "Lcom/baidu/tieba/z22;");
                return;
            }
        }
        d = vm1.a;
    }

    public z22(@NonNull ol3 ol3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ol3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ol3Var;
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
            a22 a22Var = this.b.get(str);
            if (a22Var == null) {
                k32.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return a22Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(a22 a22Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a22Var)) == null) {
            if (a22Var == null) {
                d32.a("Component-Container", "insert component with a null component");
                return false;
            }
            b22 n = a22Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = a22Var.o();
            SwanAppComponentContainerView m = a22Var.m();
            if (m == null) {
                d32.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                k32.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                d32.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            qw2 qw2Var = n.h;
            if (qw2Var == null) {
                d32.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!qw2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                d32.a("Component-Container", sb.toString());
                n.h = new qw2();
            }
            if (!y22.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        k32.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        d32.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = y22.b(this, n, m);
                if (!b) {
                    d32.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, a22Var);
                if (a22Var.s(2)) {
                    k32.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<a22> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(a22Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        a22 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, a22> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.z();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull a22 a22Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b22 b22Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, a22Var, swanAppComponentContainerView, b22Var)) == null) {
            String o = a22Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            qw2 qw2Var = b22Var.h;
            if (qw2Var != null && qw2Var.h()) {
                if (y22.c(b22Var) && !y22.e(this, b22Var, swanAppComponentContainerView)) {
                    d32.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = b22Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, b22Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    k32.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, b22Var.b());
                    return true;
                } else {
                    d32.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = b22Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            d32.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(a22 a22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a22Var)) == null) {
            boolean z = false;
            if (a22Var == null) {
                d32.a("Component-Container", "remove component with a null component");
                return false;
            }
            b22 n = a22Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = a22Var.o();
            SwanAppComponentContainerView m = a22Var.m();
            if (m == null) {
                d32.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                d32.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!y22.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            k32.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            d32.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = y22.g(this, n, m);
                    if (!z) {
                        d32.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || a22Var.s(1)) {
                    this.b.remove(str2);
                    if (a22Var.s(2)) {
                        k32.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<a22> list = this.c.get(str);
                        if (list != null) {
                            list.remove(a22Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(a22 a22Var, @NonNull c32 c32Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, a22Var, c32Var)) == null) {
            if (a22Var == null) {
                d32.a("Component-Container", "update component with a null component");
                return false;
            }
            b22 n = a22Var.n();
            String o = a22Var.o();
            SwanAppComponentContainerView m = a22Var.m();
            if (m == null) {
                d32.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                k32.c("Component-Container", "don't insert" + o);
            }
            if (a22Var instanceof r22) {
                if (c32Var.a(7)) {
                    boolean d2 = y22.d(this, a22Var, n, m, c32Var);
                    if (!d2) {
                        d32.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (c32Var.a(8)) {
                    y22.f(this, a22Var, n, m, c32Var);
                }
            }
            if (c32Var.a(3) && !d(a22Var, m, n)) {
                k32.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (a22Var instanceof y12) {
                y12 y12Var = (y12) a22Var;
                if (y12Var.L()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!y12Var.O()) {
                        k32.c("Component-Container", o + " perform position update with animation fail");
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
