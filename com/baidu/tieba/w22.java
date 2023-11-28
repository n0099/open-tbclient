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
public final class w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ll3 a;
    @NonNull
    public ArrayMap<String, x12> b;
    @NonNull
    public ArrayMap<String, List<x12>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218610, "Lcom/baidu/tieba/w22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218610, "Lcom/baidu/tieba/w22;");
                return;
            }
        }
        d = sm1.a;
    }

    public w22(@NonNull ll3 ll3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ll3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ll3Var;
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
            x12 x12Var = this.b.get(str);
            if (x12Var == null) {
                h32.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return x12Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(x12 x12Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x12Var)) == null) {
            if (x12Var == null) {
                a32.a("Component-Container", "insert component with a null component");
                return false;
            }
            y12 n = x12Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = x12Var.o();
            SwanAppComponentContainerView m = x12Var.m();
            if (m == null) {
                a32.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                h32.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                a32.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            nw2 nw2Var = n.h;
            if (nw2Var == null) {
                a32.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!nw2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                a32.a("Component-Container", sb.toString());
                n.h = new nw2();
            }
            if (!v22.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        h32.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        a32.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = v22.b(this, n, m);
                if (!b) {
                    a32.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, x12Var);
                if (x12Var.s(2)) {
                    h32.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<x12> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(x12Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        x12 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, x12> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.z();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull x12 x12Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull y12 y12Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, x12Var, swanAppComponentContainerView, y12Var)) == null) {
            String o = x12Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            nw2 nw2Var = y12Var.h;
            if (nw2Var != null && nw2Var.h()) {
                if (v22.c(y12Var) && !v22.e(this, y12Var, swanAppComponentContainerView)) {
                    a32.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = y12Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, y12Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    h32.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, y12Var.b());
                    return true;
                } else {
                    a32.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = y12Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            a32.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(x12 x12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, x12Var)) == null) {
            boolean z = false;
            if (x12Var == null) {
                a32.a("Component-Container", "remove component with a null component");
                return false;
            }
            y12 n = x12Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = x12Var.o();
            SwanAppComponentContainerView m = x12Var.m();
            if (m == null) {
                a32.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                a32.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!v22.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            h32.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            a32.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = v22.g(this, n, m);
                    if (!z) {
                        a32.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || x12Var.s(1)) {
                    this.b.remove(str2);
                    if (x12Var.s(2)) {
                        h32.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<x12> list = this.c.get(str);
                        if (list != null) {
                            list.remove(x12Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(x12 x12Var, @NonNull z22 z22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, x12Var, z22Var)) == null) {
            if (x12Var == null) {
                a32.a("Component-Container", "update component with a null component");
                return false;
            }
            y12 n = x12Var.n();
            String o = x12Var.o();
            SwanAppComponentContainerView m = x12Var.m();
            if (m == null) {
                a32.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                h32.c("Component-Container", "don't insert" + o);
            }
            if (x12Var instanceof o22) {
                if (z22Var.a(7)) {
                    boolean d2 = v22.d(this, x12Var, n, m, z22Var);
                    if (!d2) {
                        a32.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (z22Var.a(8)) {
                    v22.f(this, x12Var, n, m, z22Var);
                }
            }
            if (z22Var.a(3) && !d(x12Var, m, n)) {
                h32.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (x12Var instanceof v12) {
                v12 v12Var = (v12) x12Var;
                if (v12Var.L()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!v12Var.O()) {
                        h32.c("Component-Container", o + " perform position update with animation fail");
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
