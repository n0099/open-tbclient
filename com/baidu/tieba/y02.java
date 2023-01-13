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
public final class y02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public nj3 a;
    @NonNull
    public ArrayMap<String, yz1> b;
    @NonNull
    public ArrayMap<String, List<yz1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276270, "Lcom/baidu/tieba/y02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276270, "Lcom/baidu/tieba/y02;");
                return;
            }
        }
        d = tk1.a;
    }

    public y02(@NonNull nj3 nj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nj3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = nj3Var;
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
            yz1 yz1Var = this.b.get(str);
            if (yz1Var == null) {
                j12.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return yz1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(yz1 yz1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yz1Var)) == null) {
            if (yz1Var == null) {
                c12.a("Component-Container", "insert component with a null component");
                return false;
            }
            zz1 n = yz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = yz1Var.o();
            SwanAppComponentContainerView m = yz1Var.m();
            if (m == null) {
                c12.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                j12.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                c12.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            pu2 pu2Var = n.h;
            if (pu2Var == null) {
                c12.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!pu2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                c12.a("Component-Container", sb.toString());
                n.h = new pu2();
            }
            if (!x02.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        j12.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        c12.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = x02.b(this, n, m);
                if (!b) {
                    c12.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, yz1Var);
                if (yz1Var.s(2)) {
                    j12.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<yz1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(yz1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        yz1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, yz1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull yz1 yz1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull zz1 zz1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, yz1Var, swanAppComponentContainerView, zz1Var)) == null) {
            String o = yz1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            pu2 pu2Var = zz1Var.h;
            if (pu2Var != null && pu2Var.h()) {
                if (x02.c(zz1Var) && !x02.e(this, zz1Var, swanAppComponentContainerView)) {
                    c12.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = zz1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, zz1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    j12.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, zz1Var.b());
                    return true;
                } else {
                    c12.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = zz1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            c12.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(yz1 yz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yz1Var)) == null) {
            boolean z = false;
            if (yz1Var == null) {
                c12.a("Component-Container", "remove component with a null component");
                return false;
            }
            zz1 n = yz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = yz1Var.o();
            SwanAppComponentContainerView m = yz1Var.m();
            if (m == null) {
                c12.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                c12.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!x02.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            j12.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            c12.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = x02.g(this, n, m);
                    if (!z) {
                        c12.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || yz1Var.s(1)) {
                    this.b.remove(str2);
                    if (yz1Var.s(2)) {
                        j12.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<yz1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(yz1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(yz1 yz1Var, @NonNull b12 b12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, yz1Var, b12Var)) == null) {
            if (yz1Var == null) {
                c12.a("Component-Container", "update component with a null component");
                return false;
            }
            zz1 n = yz1Var.n();
            String o = yz1Var.o();
            SwanAppComponentContainerView m = yz1Var.m();
            if (m == null) {
                c12.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                j12.c("Component-Container", "don't insert" + o);
            }
            if (yz1Var instanceof q02) {
                if (b12Var.a(7)) {
                    boolean d2 = x02.d(this, yz1Var, n, m, b12Var);
                    if (!d2) {
                        c12.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (b12Var.a(8)) {
                    x02.f(this, yz1Var, n, m, b12Var);
                }
            }
            if (b12Var.a(3) && !d(yz1Var, m, n)) {
                j12.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (yz1Var instanceof wz1) {
                wz1 wz1Var = (wz1) yz1Var;
                if (wz1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!wz1Var.M()) {
                        j12.c("Component-Container", o + " perform position update with animation fail");
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
