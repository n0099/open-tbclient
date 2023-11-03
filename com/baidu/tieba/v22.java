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
public final class v22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public kl3 a;
    @NonNull
    public ArrayMap<String, w12> b;
    @NonNull
    public ArrayMap<String, List<w12>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188819, "Lcom/baidu/tieba/v22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188819, "Lcom/baidu/tieba/v22;");
                return;
            }
        }
        d = rm1.a;
    }

    public v22(@NonNull kl3 kl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kl3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = kl3Var;
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
            w12 w12Var = this.b.get(str);
            if (w12Var == null) {
                g32.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return w12Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(w12 w12Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w12Var)) == null) {
            if (w12Var == null) {
                z22.a("Component-Container", "insert component with a null component");
                return false;
            }
            x12 n = w12Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = w12Var.o();
            SwanAppComponentContainerView m = w12Var.m();
            if (m == null) {
                z22.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                g32.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                z22.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            mw2 mw2Var = n.h;
            if (mw2Var == null) {
                z22.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!mw2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                z22.a("Component-Container", sb.toString());
                n.h = new mw2();
            }
            if (!u22.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        g32.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        z22.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = u22.b(this, n, m);
                if (!b) {
                    z22.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, w12Var);
                if (w12Var.s(2)) {
                    g32.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<w12> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(w12Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        w12 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, w12> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.z();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull w12 w12Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull x12 x12Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, w12Var, swanAppComponentContainerView, x12Var)) == null) {
            String o = w12Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            mw2 mw2Var = x12Var.h;
            if (mw2Var != null && mw2Var.h()) {
                if (u22.c(x12Var) && !u22.e(this, x12Var, swanAppComponentContainerView)) {
                    z22.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = x12Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, x12Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    g32.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, x12Var.b());
                    return true;
                } else {
                    z22.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = x12Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            z22.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(w12 w12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, w12Var)) == null) {
            boolean z = false;
            if (w12Var == null) {
                z22.a("Component-Container", "remove component with a null component");
                return false;
            }
            x12 n = w12Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = w12Var.o();
            SwanAppComponentContainerView m = w12Var.m();
            if (m == null) {
                z22.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                z22.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!u22.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            g32.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            z22.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = u22.g(this, n, m);
                    if (!z) {
                        z22.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || w12Var.s(1)) {
                    this.b.remove(str2);
                    if (w12Var.s(2)) {
                        g32.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<w12> list = this.c.get(str);
                        if (list != null) {
                            list.remove(w12Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(w12 w12Var, @NonNull y22 y22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, w12Var, y22Var)) == null) {
            if (w12Var == null) {
                z22.a("Component-Container", "update component with a null component");
                return false;
            }
            x12 n = w12Var.n();
            String o = w12Var.o();
            SwanAppComponentContainerView m = w12Var.m();
            if (m == null) {
                z22.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                g32.c("Component-Container", "don't insert" + o);
            }
            if (w12Var instanceof n22) {
                if (y22Var.a(7)) {
                    boolean d2 = u22.d(this, w12Var, n, m, y22Var);
                    if (!d2) {
                        z22.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (y22Var.a(8)) {
                    u22.f(this, w12Var, n, m, y22Var);
                }
            }
            if (y22Var.a(3) && !d(w12Var, m, n)) {
                g32.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (w12Var instanceof u12) {
                u12 u12Var = (u12) w12Var;
                if (u12Var.L()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!u12Var.O()) {
                        g32.c("Component-Container", o + " perform position update with animation fail");
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
