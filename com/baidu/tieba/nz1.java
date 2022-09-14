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
public final class nz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ci3 a;
    @NonNull
    public ArrayMap<String, ny1> b;
    @NonNull
    public ArrayMap<String, List<ny1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948019652, "Lcom/baidu/tieba/nz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948019652, "Lcom/baidu/tieba/nz1;");
                return;
            }
        }
        d = ij1.a;
    }

    public nz1(@NonNull ci3 ci3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ci3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ci3Var;
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
            ny1 ny1Var = this.b.get(str);
            if (ny1Var == null) {
                yz1.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return ny1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(ny1 ny1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ny1Var)) == null) {
            if (ny1Var == null) {
                rz1.a("Component-Container", "insert component with a null component");
                return false;
            }
            oy1 n = ny1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = ny1Var.o();
            SwanAppComponentContainerView m = ny1Var.m();
            if (m == null) {
                rz1.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                yz1.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                rz1.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            et2 et2Var = n.h;
            if (et2Var == null) {
                rz1.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!et2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                rz1.a("Component-Container", sb.toString());
                n.h = new et2();
            }
            if (!mz1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        yz1.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        rz1.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = mz1.b(this, n, m);
                if (!b) {
                    rz1.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, ny1Var);
                if (ny1Var.s(2)) {
                    yz1.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<ny1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(ny1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        ny1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, ny1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull ny1 ny1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull oy1 oy1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ny1Var, swanAppComponentContainerView, oy1Var)) == null) {
            String o = ny1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            et2 et2Var = oy1Var.h;
            if (et2Var != null && et2Var.h()) {
                if (mz1.c(oy1Var) && !mz1.e(this, oy1Var, swanAppComponentContainerView)) {
                    rz1.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = oy1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, oy1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    yz1.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, oy1Var.b());
                    return true;
                } else {
                    rz1.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = oy1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            rz1.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(ny1 ny1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ny1Var)) == null) {
            boolean z = false;
            if (ny1Var == null) {
                rz1.a("Component-Container", "remove component with a null component");
                return false;
            }
            oy1 n = ny1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = ny1Var.o();
            SwanAppComponentContainerView m = ny1Var.m();
            if (m == null) {
                rz1.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                rz1.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!mz1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            yz1.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            rz1.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = mz1.g(this, n, m);
                    if (!z) {
                        rz1.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || ny1Var.s(1)) {
                    this.b.remove(str2);
                    if (ny1Var.s(2)) {
                        yz1.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<ny1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(ny1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(ny1 ny1Var, @NonNull qz1 qz1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, ny1Var, qz1Var)) == null) {
            if (ny1Var == null) {
                rz1.a("Component-Container", "update component with a null component");
                return false;
            }
            oy1 n = ny1Var.n();
            String o = ny1Var.o();
            SwanAppComponentContainerView m = ny1Var.m();
            if (m == null) {
                rz1.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                yz1.c("Component-Container", "don't insert" + o);
            }
            if (ny1Var instanceof fz1) {
                if (qz1Var.a(7)) {
                    boolean d2 = mz1.d(this, ny1Var, n, m, qz1Var);
                    if (!d2) {
                        rz1.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (qz1Var.a(8)) {
                    mz1.f(this, ny1Var, n, m, qz1Var);
                }
            }
            if (qz1Var.a(3) && !d(ny1Var, m, n)) {
                yz1.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (ny1Var instanceof ly1) {
                ly1 ly1Var = (ly1) ny1Var;
                if (ly1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (ly1Var.M()) {
                        return true;
                    }
                    yz1.c("Component-Container", o + " perform position update with animation fail");
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
