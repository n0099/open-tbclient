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
public final class u02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public jj3 a;
    @NonNull
    public ArrayMap<String, uz1> b;
    @NonNull
    public ArrayMap<String, List<uz1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948157106, "Lcom/baidu/tieba/u02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948157106, "Lcom/baidu/tieba/u02;");
                return;
            }
        }
        d = pk1.a;
    }

    public u02(@NonNull jj3 jj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jj3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jj3Var;
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
            uz1 uz1Var = this.b.get(str);
            if (uz1Var == null) {
                f12.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return uz1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(uz1 uz1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uz1Var)) == null) {
            if (uz1Var == null) {
                y02.a("Component-Container", "insert component with a null component");
                return false;
            }
            vz1 n = uz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = uz1Var.o();
            SwanAppComponentContainerView m = uz1Var.m();
            if (m == null) {
                y02.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                f12.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                y02.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            lu2 lu2Var = n.h;
            if (lu2Var == null) {
                y02.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!lu2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                y02.a("Component-Container", sb.toString());
                n.h = new lu2();
            }
            if (!t02.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        f12.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        y02.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = t02.b(this, n, m);
                if (!b) {
                    y02.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, uz1Var);
                if (uz1Var.s(2)) {
                    f12.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<uz1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(uz1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        uz1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, uz1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull uz1 uz1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull vz1 vz1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uz1Var, swanAppComponentContainerView, vz1Var)) == null) {
            String o = uz1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            lu2 lu2Var = vz1Var.h;
            if (lu2Var != null && lu2Var.h()) {
                if (t02.c(vz1Var) && !t02.e(this, vz1Var, swanAppComponentContainerView)) {
                    y02.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = vz1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, vz1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    f12.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, vz1Var.b());
                    return true;
                } else {
                    y02.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = vz1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            y02.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(uz1 uz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uz1Var)) == null) {
            boolean z = false;
            if (uz1Var == null) {
                y02.a("Component-Container", "remove component with a null component");
                return false;
            }
            vz1 n = uz1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = uz1Var.o();
            SwanAppComponentContainerView m = uz1Var.m();
            if (m == null) {
                y02.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                y02.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!t02.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            f12.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            y02.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = t02.g(this, n, m);
                    if (!z) {
                        y02.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || uz1Var.s(1)) {
                    this.b.remove(str2);
                    if (uz1Var.s(2)) {
                        f12.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<uz1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(uz1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(uz1 uz1Var, @NonNull x02 x02Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uz1Var, x02Var)) == null) {
            if (uz1Var == null) {
                y02.a("Component-Container", "update component with a null component");
                return false;
            }
            vz1 n = uz1Var.n();
            String o = uz1Var.o();
            SwanAppComponentContainerView m = uz1Var.m();
            if (m == null) {
                y02.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                f12.c("Component-Container", "don't insert" + o);
            }
            if (uz1Var instanceof m02) {
                if (x02Var.a(7)) {
                    boolean d2 = t02.d(this, uz1Var, n, m, x02Var);
                    if (!d2) {
                        y02.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (x02Var.a(8)) {
                    t02.f(this, uz1Var, n, m, x02Var);
                }
            }
            if (x02Var.a(3) && !d(uz1Var, m, n)) {
                f12.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (uz1Var instanceof sz1) {
                sz1 sz1Var = (sz1) uz1Var;
                if (sz1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (!sz1Var.M()) {
                        f12.c("Component-Container", o + " perform position update with animation fail");
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
