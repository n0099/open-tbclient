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
public final class j42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ym3 a;
    @NonNull
    public ArrayMap<String, j32> b;
    @NonNull
    public ArrayMap<String, List<j32>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833249, "Lcom/baidu/tieba/j42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833249, "Lcom/baidu/tieba/j42;");
                return;
            }
        }
        d = eo1.a;
    }

    public j42(@NonNull ym3 ym3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ym3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ym3Var;
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
            j32 j32Var = this.b.get(str);
            if (j32Var == null) {
                u42.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return j32Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(j32 j32Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j32Var)) == null) {
            if (j32Var == null) {
                n42.a("Component-Container", "insert component with a null component");
                return false;
            }
            k32 n = j32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = j32Var.o();
            SwanAppComponentContainerView m = j32Var.m();
            if (m == null) {
                n42.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                u42.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                n42.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            ay2 ay2Var = n.h;
            if (ay2Var == null) {
                n42.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!ay2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                n42.a("Component-Container", sb.toString());
                n.h = new ay2();
            }
            if (!i42.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        u42.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        n42.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = i42.b(this, n, m);
                if (!b) {
                    n42.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, j32Var);
                if (j32Var.s(2)) {
                    u42.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<j32> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(j32Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        j32 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, j32> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull j32 j32Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull k32 k32Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, j32Var, swanAppComponentContainerView, k32Var)) == null) {
            String o = j32Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            ay2 ay2Var = k32Var.h;
            if (ay2Var != null && ay2Var.h()) {
                if (i42.c(k32Var) && !i42.e(this, k32Var, swanAppComponentContainerView)) {
                    n42.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = k32Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, k32Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    u42.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, k32Var.b());
                    return true;
                } else {
                    n42.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = k32Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            n42.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(j32 j32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, j32Var)) == null) {
            boolean z = false;
            if (j32Var == null) {
                n42.a("Component-Container", "remove component with a null component");
                return false;
            }
            k32 n = j32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = j32Var.o();
            SwanAppComponentContainerView m = j32Var.m();
            if (m == null) {
                n42.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                n42.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!i42.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            u42.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            n42.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = i42.g(this, n, m);
                    if (!z) {
                        n42.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || j32Var.s(1)) {
                    this.b.remove(str2);
                    if (j32Var.s(2)) {
                        u42.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<j32> list = this.c.get(str);
                        if (list != null) {
                            list.remove(j32Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(j32 j32Var, @NonNull m42 m42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, j32Var, m42Var)) == null) {
            if (j32Var == null) {
                n42.a("Component-Container", "update component with a null component");
                return false;
            }
            k32 n = j32Var.n();
            String o = j32Var.o();
            SwanAppComponentContainerView m = j32Var.m();
            if (m == null) {
                n42.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                u42.c("Component-Container", "don't insert" + o);
            }
            if (j32Var instanceof b42) {
                if (m42Var.a(7)) {
                    boolean d2 = i42.d(this, j32Var, n, m, m42Var);
                    if (!d2) {
                        n42.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (m42Var.a(8)) {
                    i42.f(this, j32Var, n, m, m42Var);
                }
            }
            if (m42Var.a(3) && !d(j32Var, m, n)) {
                u42.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (j32Var instanceof h32) {
                h32 h32Var = (h32) j32Var;
                if (h32Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!h32Var.M()) {
                        u42.c("Component-Container", o + " perform position update with animation fail");
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
