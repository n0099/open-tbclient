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
/* loaded from: classes6.dex */
public final class t02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ij3 a;
    @NonNull
    public ArrayMap<String, tz1> b;
    @NonNull
    public ArrayMap<String, List<tz1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127315, "Lcom/baidu/tieba/t02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127315, "Lcom/baidu/tieba/t02;");
                return;
            }
        }
        d = ok1.a;
    }

    public t02(@NonNull ij3 ij3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ij3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ij3Var;
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
            tz1 tz1Var = this.b.get(str);
            if (tz1Var == null) {
                e12.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return tz1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(tz1 tz1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tz1Var)) == null) {
            if (tz1Var == null) {
                x02.a("Component-Container", "insert component with a null component");
                return false;
            }
            uz1 n = tz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = tz1Var.o();
            SwanAppComponentContainerView m = tz1Var.m();
            if (m == null) {
                x02.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                e12.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                x02.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            ku2 ku2Var = n.h;
            if (ku2Var == null) {
                x02.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!ku2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                x02.a("Component-Container", sb.toString());
                n.h = new ku2();
            }
            if (!s02.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        e12.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        x02.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = s02.b(this, n, m);
                if (!b) {
                    x02.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, tz1Var);
                if (tz1Var.s(2)) {
                    e12.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<tz1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(tz1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        tz1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, tz1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull tz1 tz1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull uz1 uz1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, tz1Var, swanAppComponentContainerView, uz1Var)) == null) {
            String o = tz1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            ku2 ku2Var = uz1Var.h;
            if (ku2Var != null && ku2Var.h()) {
                if (s02.c(uz1Var) && !s02.e(this, uz1Var, swanAppComponentContainerView)) {
                    x02.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = uz1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, uz1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    e12.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, uz1Var.b());
                    return true;
                } else {
                    x02.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = uz1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            x02.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(tz1 tz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tz1Var)) == null) {
            boolean z = false;
            if (tz1Var == null) {
                x02.a("Component-Container", "remove component with a null component");
                return false;
            }
            uz1 n = tz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = tz1Var.o();
            SwanAppComponentContainerView m = tz1Var.m();
            if (m == null) {
                x02.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                x02.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!s02.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            e12.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            x02.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = s02.g(this, n, m);
                    if (!z) {
                        x02.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || tz1Var.s(1)) {
                    this.b.remove(str2);
                    if (tz1Var.s(2)) {
                        e12.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<tz1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(tz1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(tz1 tz1Var, @NonNull w02 w02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, tz1Var, w02Var)) == null) {
            if (tz1Var == null) {
                x02.a("Component-Container", "update component with a null component");
                return false;
            }
            uz1 n = tz1Var.n();
            String o = tz1Var.o();
            SwanAppComponentContainerView m = tz1Var.m();
            if (m == null) {
                x02.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                e12.c("Component-Container", "don't insert" + o);
            }
            if (tz1Var instanceof l02) {
                if (w02Var.a(7)) {
                    boolean d2 = s02.d(this, tz1Var, n, m, w02Var);
                    if (!d2) {
                        x02.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (w02Var.a(8)) {
                    s02.f(this, tz1Var, n, m, w02Var);
                }
            }
            if (w02Var.a(3) && !d(tz1Var, m, n)) {
                e12.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (tz1Var instanceof rz1) {
                rz1 rz1Var = (rz1) tz1Var;
                if (rz1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!rz1Var.M()) {
                        e12.c("Component-Container", o + " perform position update with animation fail");
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
