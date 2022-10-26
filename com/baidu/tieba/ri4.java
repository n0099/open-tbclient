package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ri4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ri4 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final HashSet b;
    public final HashSet c;
    public final HashSet d;
    public final HashSet e;
    public final HashMap f;
    public final HashMap g;
    public final HashMap h;
    public final HashSet i;
    public int j;
    public int k;
    public int l;

    public ri4() {
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
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new HashSet();
    }

    public static ri4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == null) {
                synchronized (ri4.class) {
                    if (m == null) {
                        m = new ri4();
                    }
                }
            }
            return m;
        }
        return (ri4) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.d.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (si4.g().r()) {
                return true;
            }
            return this.c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.g.containsKey(str)) {
                return (String) this.g.get(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.i.contains(str)) {
                return "1";
            }
            return "0";
        }
        return (String) invokeL.objValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            vi4 vi4Var = (vi4) this.h.get(str);
            if (vi4Var != null && vi4Var.b()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            vi4 vi4Var = (vi4) this.h.get(str);
            if (vi4Var != null && vi4Var.c()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || i < this.k) {
            return;
        }
        this.k = i;
        hj4.f().putInt("ubc_data_expire_time", i);
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || i < this.l) {
            return;
        }
        this.l = i;
        hj4.f().putInt("ubc_database_limit", i);
    }

    public void p(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048590, this, i) != null) || (i2 = i * 60000) < this.j) {
            return;
        }
        this.j = i2;
    }

    public boolean c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            if (this.b.contains(str)) {
                return false;
            }
            if ((i & 16) == 0 && (i & 32) == 0) {
                return true;
            }
            return this.e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (si4.g().q() || TextUtils.isEmpty(str) || !this.f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt((String) this.f.get(str));
        }
        return invokeL.intValue;
    }

    public void k(qi4 qi4Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, qi4Var, context) == null) {
            this.a = context;
            this.j = 360000;
            hj4 f = hj4.f();
            this.k = f.getInt("ubc_data_expire_time", 259200000);
            this.l = f.getInt("ubc_database_limit", 4000);
            qi4Var.e().w(this.b, this.e, this.c, this.d, this.f, this.g, this.h, this.i);
        }
    }

    public void q(List list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ui4 ui4Var = (ui4) it.next();
                if ("0".equals(ui4Var.b)) {
                    this.b.add(ui4Var.a);
                } else {
                    this.b.remove(ui4Var.a);
                }
                if ("1".equals(ui4Var.c)) {
                    this.c.add(ui4Var.a);
                } else {
                    this.c.remove(ui4Var.a);
                }
                if ("1".equals(ui4Var.f)) {
                    this.d.add(ui4Var.a);
                } else {
                    this.d.remove(ui4Var.a);
                }
                int i2 = ui4Var.g;
                if (i2 >= 1 && i2 <= 100) {
                    this.f.put(ui4Var.a, String.valueOf(i2));
                } else {
                    this.f.remove(ui4Var.a);
                }
                if (!TextUtils.isEmpty(ui4Var.h)) {
                    this.g.put(ui4Var.a, ui4Var.h);
                } else {
                    this.g.remove(ui4Var.a);
                }
                int i3 = ui4Var.j;
                if (i3 != 0 && (i = ui4Var.i) != 0) {
                    vi4 vi4Var = new vi4(ui4Var.a, i3, i);
                    this.h.put(vi4Var.a(), vi4Var);
                }
                if (TextUtils.equals(ui4Var.k, "1")) {
                    this.i.add(ui4Var.a);
                } else {
                    this.i.remove(ui4Var.a);
                }
            }
        }
    }
}
