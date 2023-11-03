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
import java.util.List;
/* loaded from: classes7.dex */
public class kl4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kl4 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final HashSet<String> b;
    public final HashSet<String> c;
    public final HashSet<String> d;
    public final HashSet<String> e;
    public final HashMap<String, String> f;
    public final HashMap<String, String> g;
    public final HashMap<String, ol4> h;
    public final HashSet<String> i;
    public int j;
    public int k;
    public int l;

    public kl4() {
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
        this.b = new HashSet<>();
        this.c = new HashSet<>();
        this.d = new HashSet<>();
        this.e = new HashSet<>();
        this.f = new HashMap<>();
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashSet<>();
    }

    public static kl4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == null) {
                synchronized (kl4.class) {
                    if (m == null) {
                        m = new kl4();
                    }
                }
            }
            return m;
        }
        return (kl4) invokeV.objValue;
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
            if (ll4.h().r()) {
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
                return this.g.get(str);
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
            ol4 ol4Var = this.h.get(str);
            if (ol4Var != null && ol4Var.b()) {
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
            ol4 ol4Var = this.h.get(str);
            if (ol4Var != null && ol4Var.c()) {
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
        am4.e().putInt("ubc_data_expire_time", i);
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || i < this.l) {
            return;
        }
        this.l = i;
        am4.e().putInt("ubc_database_limit", i);
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
            if (ll4.h().q() || TextUtils.isEmpty(str) || !this.f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f.get(str));
        }
        return invokeL.intValue;
    }

    public void k(jl4 jl4Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jl4Var, context) == null) {
            this.a = context;
            this.j = 360000;
            am4 e = am4.e();
            this.k = e.getInt("ubc_data_expire_time", 259200000);
            this.l = e.getInt("ubc_database_limit", 4000);
            jl4Var.e().w(this.b, this.e, this.c, this.d, this.f, this.g, this.h, this.i);
        }
    }

    public void q(List<nl4> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (nl4 nl4Var : list) {
                if ("0".equals(nl4Var.b)) {
                    this.b.add(nl4Var.a);
                } else {
                    this.b.remove(nl4Var.a);
                }
                if ("1".equals(nl4Var.c)) {
                    this.c.add(nl4Var.a);
                } else {
                    this.c.remove(nl4Var.a);
                }
                if ("1".equals(nl4Var.f)) {
                    this.d.add(nl4Var.a);
                } else {
                    this.d.remove(nl4Var.a);
                }
                int i2 = nl4Var.g;
                if (i2 >= 1 && i2 <= 100) {
                    this.f.put(nl4Var.a, String.valueOf(i2));
                } else {
                    this.f.remove(nl4Var.a);
                }
                if (!TextUtils.isEmpty(nl4Var.h)) {
                    this.g.put(nl4Var.a, nl4Var.h);
                } else {
                    this.g.remove(nl4Var.a);
                }
                int i3 = nl4Var.j;
                if (i3 != 0 && (i = nl4Var.i) != 0) {
                    ol4 ol4Var = new ol4(nl4Var.a, i3, i);
                    this.h.put(ol4Var.a(), ol4Var);
                }
                if (TextUtils.equals(nl4Var.k, "1")) {
                    this.i.add(nl4Var.a);
                } else {
                    this.i.remove(nl4Var.a);
                }
            }
        }
    }
}
