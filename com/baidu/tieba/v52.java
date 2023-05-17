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
public final class v52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ko3 a;
    @NonNull
    public ArrayMap<String, v42> b;
    @NonNull
    public ArrayMap<String, List<v42>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948191702, "Lcom/baidu/tieba/v52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948191702, "Lcom/baidu/tieba/v52;");
                return;
            }
        }
        d = qp1.a;
    }

    public v52(@NonNull ko3 ko3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ko3Var;
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
            v42 v42Var = this.b.get(str);
            if (v42Var == null) {
                g62.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return v42Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(v42 v42Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v42Var)) == null) {
            if (v42Var == null) {
                z52.a("Component-Container", "insert component with a null component");
                return false;
            }
            w42 n = v42Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = v42Var.o();
            SwanAppComponentContainerView m = v42Var.m();
            if (m == null) {
                z52.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                g62.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                z52.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            mz2 mz2Var = n.h;
            if (mz2Var == null) {
                z52.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!mz2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                z52.a("Component-Container", sb.toString());
                n.h = new mz2();
            }
            if (!u52.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        g62.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        z52.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = u52.b(this, n, m);
                if (!b) {
                    z52.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, v42Var);
                if (v42Var.s(2)) {
                    g62.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<v42> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(v42Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        v42 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, v42> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull v42 v42Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull w42 w42Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, v42Var, swanAppComponentContainerView, w42Var)) == null) {
            String o = v42Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            mz2 mz2Var = w42Var.h;
            if (mz2Var != null && mz2Var.h()) {
                if (u52.c(w42Var) && !u52.e(this, w42Var, swanAppComponentContainerView)) {
                    z52.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = w42Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, w42Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    g62.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, w42Var.b());
                    return true;
                } else {
                    z52.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = w42Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            z52.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(v42 v42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v42Var)) == null) {
            boolean z = false;
            if (v42Var == null) {
                z52.a("Component-Container", "remove component with a null component");
                return false;
            }
            w42 n = v42Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = v42Var.o();
            SwanAppComponentContainerView m = v42Var.m();
            if (m == null) {
                z52.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                z52.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!u52.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            g62.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            z52.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = u52.g(this, n, m);
                    if (!z) {
                        z52.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || v42Var.s(1)) {
                    this.b.remove(str2);
                    if (v42Var.s(2)) {
                        g62.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<v42> list = this.c.get(str);
                        if (list != null) {
                            list.remove(v42Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(v42 v42Var, @NonNull y52 y52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, v42Var, y52Var)) == null) {
            if (v42Var == null) {
                z52.a("Component-Container", "update component with a null component");
                return false;
            }
            w42 n = v42Var.n();
            String o = v42Var.o();
            SwanAppComponentContainerView m = v42Var.m();
            if (m == null) {
                z52.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                g62.c("Component-Container", "don't insert" + o);
            }
            if (v42Var instanceof n52) {
                if (y52Var.a(7)) {
                    boolean d2 = u52.d(this, v42Var, n, m, y52Var);
                    if (!d2) {
                        z52.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (y52Var.a(8)) {
                    u52.f(this, v42Var, n, m, y52Var);
                }
            }
            if (y52Var.a(3) && !d(v42Var, m, n)) {
                g62.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (v42Var instanceof t42) {
                t42 t42Var = (t42) v42Var;
                if (t42Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!t42Var.M()) {
                        g62.c("Component-Container", o + " perform position update with animation fail");
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
