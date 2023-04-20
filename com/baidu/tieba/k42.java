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
public final class k42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public zm3 a;
    @NonNull
    public ArrayMap<String, k32> b;
    @NonNull
    public ArrayMap<String, List<k32>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863040, "Lcom/baidu/tieba/k42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863040, "Lcom/baidu/tieba/k42;");
                return;
            }
        }
        d = fo1.a;
    }

    public k42(@NonNull zm3 zm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zm3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = zm3Var;
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
            k32 k32Var = this.b.get(str);
            if (k32Var == null) {
                v42.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return k32Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(k32 k32Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k32Var)) == null) {
            if (k32Var == null) {
                o42.a("Component-Container", "insert component with a null component");
                return false;
            }
            l32 n = k32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = k32Var.o();
            SwanAppComponentContainerView m = k32Var.m();
            if (m == null) {
                o42.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                v42.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                o42.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            by2 by2Var = n.h;
            if (by2Var == null) {
                o42.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!by2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                o42.a("Component-Container", sb.toString());
                n.h = new by2();
            }
            if (!j42.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        v42.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        o42.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = j42.b(this, n, m);
                if (!b) {
                    o42.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, k32Var);
                if (k32Var.s(2)) {
                    v42.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<k32> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(k32Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        k32 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, k32> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull k32 k32Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull l32 l32Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, k32Var, swanAppComponentContainerView, l32Var)) == null) {
            String o = k32Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            by2 by2Var = l32Var.h;
            if (by2Var != null && by2Var.h()) {
                if (j42.c(l32Var) && !j42.e(this, l32Var, swanAppComponentContainerView)) {
                    o42.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = l32Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, l32Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    v42.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, l32Var.b());
                    return true;
                } else {
                    o42.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = l32Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            o42.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k32Var)) == null) {
            boolean z = false;
            if (k32Var == null) {
                o42.a("Component-Container", "remove component with a null component");
                return false;
            }
            l32 n = k32Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = k32Var.o();
            SwanAppComponentContainerView m = k32Var.m();
            if (m == null) {
                o42.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                o42.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!j42.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            v42.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            o42.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = j42.g(this, n, m);
                    if (!z) {
                        o42.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || k32Var.s(1)) {
                    this.b.remove(str2);
                    if (k32Var.s(2)) {
                        v42.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<k32> list = this.c.get(str);
                        if (list != null) {
                            list.remove(k32Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(k32 k32Var, @NonNull n42 n42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k32Var, n42Var)) == null) {
            if (k32Var == null) {
                o42.a("Component-Container", "update component with a null component");
                return false;
            }
            l32 n = k32Var.n();
            String o = k32Var.o();
            SwanAppComponentContainerView m = k32Var.m();
            if (m == null) {
                o42.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                v42.c("Component-Container", "don't insert" + o);
            }
            if (k32Var instanceof c42) {
                if (n42Var.a(7)) {
                    boolean d2 = j42.d(this, k32Var, n, m, n42Var);
                    if (!d2) {
                        o42.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (n42Var.a(8)) {
                    j42.f(this, k32Var, n, m, n42Var);
                }
            }
            if (n42Var.a(3) && !d(k32Var, m, n)) {
                v42.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (k32Var instanceof i32) {
                i32 i32Var = (i32) k32Var;
                if (i32Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!i32Var.M()) {
                        v42.c("Component-Container", o + " perform position update with animation fail");
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
