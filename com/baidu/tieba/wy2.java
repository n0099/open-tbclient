package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class wy2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wy2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, xy2> a;
    public HashMap<String, xy2> b;
    public HashMap<String, xy2> c;

    public wy2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static wy2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (wy2.class) {
                    if (d == null) {
                        d = new wy2();
                    }
                }
            }
            return d;
        }
        return (wy2) invokeV.objValue;
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (wy2.class) {
                if (d != null) {
                    d.e();
                    d = null;
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                this.a = new HashMap<>();
            }
            if (this.b == null) {
                this.b = new HashMap<>();
            }
            if (this.c == null) {
                this.c = new HashMap<>();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HashMap<String, xy2> hashMap = this.a;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, xy2> hashMap2 = this.b;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            HashMap<String, xy2> hashMap3 = this.c;
            if (hashMap3 != null) {
                hashMap3.clear();
            }
        }
    }

    public final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048576, this, str, j) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 767526192) {
            if (hashCode != 1331686101) {
                if (hashCode == 1390184462 && str.equals("PageUpdateRender")) {
                    c = 2;
                }
            } else if (str.equals("PageInitRender")) {
                c = 1;
            }
        } else if (str.equals("PageSwitchCost")) {
            c = 0;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    bg3.f.update((ag3<Long>) Long.valueOf(j));
                    return;
                }
                return;
            }
            bg3.e.update((ag3<Long>) Long.valueOf(j));
            return;
        }
        bg3.d.update((ag3<Long>) Long.valueOf(j));
    }

    public void d(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j)}) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j >= 0) {
            c();
            char c = 65535;
            switch (str2.hashCode()) {
                case -1880922749:
                    if (str2.equals("pageUpdateEnd")) {
                        c = 5;
                        break;
                    }
                    break;
                case -964566145:
                    if (str2.equals("pageSwitchStart")) {
                        c = 0;
                        break;
                    }
                    break;
                case -410083667:
                    if (str2.equals("pageInitRenderStart")) {
                        c = 1;
                        break;
                    }
                    break;
                case 4028902:
                    if (str2.equals("pageInitRenderEnd")) {
                        c = 4;
                        break;
                    }
                    break;
                case 627578634:
                    if (str2.equals("pageUpdateStart")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1719651128:
                    if (str2.equals("pageSwitchEnd")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c != 0 && c != 1 && c != 2) {
                if (c == 3 || c == 4 || c == 5) {
                    g(str, str2, j);
                    return;
                }
                return;
            }
            h(str, str2, j);
        }
    }

    public final void g(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)}) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            xy2 xy2Var = null;
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1880922749) {
                if (hashCode != 4028902) {
                    if (hashCode == 1719651128 && str2.equals("pageSwitchEnd")) {
                        c = 0;
                    }
                } else if (str2.equals("pageInitRenderEnd")) {
                    c = 1;
                }
            } else if (str2.equals("pageUpdateEnd")) {
                c = 2;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        xy2Var = this.c.remove(str);
                    }
                } else {
                    xy2Var = this.b.remove(str);
                }
            } else {
                xy2Var = this.a.remove(str);
            }
            if (xy2Var == null) {
                return;
            }
            xy2Var.b(j);
            a(xy2Var.getType(), xy2Var.a());
        }
    }

    public final void h(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Long.valueOf(j)}) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            xy2 xy2Var = null;
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -964566145) {
                if (hashCode != -410083667) {
                    if (hashCode == 627578634 && str2.equals("pageUpdateStart")) {
                        c = 2;
                    }
                } else if (str2.equals("pageInitRenderStart")) {
                    c = 1;
                }
            } else if (str2.equals("pageSwitchStart")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2 && (xy2Var = this.c.get(str)) == null) {
                        xy2Var = new vy2();
                        this.c.put(str, xy2Var);
                    }
                } else {
                    xy2Var = this.b.get(str);
                    if (xy2Var == null) {
                        xy2Var = new ty2();
                        this.b.put(str, xy2Var);
                    }
                }
            } else {
                xy2Var = this.a.get(str);
                if (xy2Var == null) {
                    xy2Var = new uy2();
                    this.a.put(str, xy2Var);
                }
            }
            if (xy2Var != null) {
                xy2Var.c(j);
            }
        }
    }
}
