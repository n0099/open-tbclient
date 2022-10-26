package com.baidu.tieba;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import java.util.Random;
/* loaded from: classes6.dex */
public class u99 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u99 s;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public long o;
    public boolean p;
    public t99 q;
    public va9 r;

    public u99() {
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
        this.e = 614400;
        this.f = 153600;
        this.g = 614400;
        this.h = 614400;
        this.i = 100;
        this.j = 180;
        this.k = false;
        this.l = 819200;
        this.m = 60;
        this.n = false;
        this.o = 0L;
        this.p = false;
        this.q = new t99();
        this.r = new va9();
    }

    public static u99 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (s == null) {
                synchronized (s99.class) {
                    if (s == null) {
                        s = new u99();
                    }
                }
            }
            return s;
        }
        return (u99) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ea9 i = pa9.i();
            if (i != null) {
                return i.m();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q.a.b;
        }
        return invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q.a.d;
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.q.a.c;
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public HashSet u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.q.d;
        }
        return (HashSet) invokeV.objValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.o;
        }
        return invokeV.longValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int C(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.q.n.containsKey(str) && (num = (Integer) this.q.n.get(str)) != null) {
                return num.intValue();
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HashMap hashMap = this.q.j;
            if (hashMap != null && hashMap.containsKey(str)) {
                return ((z99) this.q.j.get(str)).a();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            HashMap hashMap = this.q.j;
            if (hashMap != null && hashMap.containsKey(str)) {
                return ((z99) this.q.j.get(str)).b();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Context context = this.a;
            if (context == null || L(context) || !c(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean L(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return this.q.c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || i < 604800000) {
            return;
        }
        this.c = i;
        ya9.a().d("ubc_data_expire_time", i);
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048592, this, i) != null) || i < 10000) {
            return;
        }
        this.d = i;
        ya9.a().d("ubc_database_limit", i);
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048593, this, i) != null) || i < 153600) {
            return;
        }
        this.e = i;
        ya9.a().d("ubc_launch_upload_max_limit", i);
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048594, this, i) != null) || i < 153600) {
            return;
        }
        this.h = i;
        ya9.a().d("ubc_non_real_upload_max_limit", i);
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048595, this, i) != null) || i < 153600) {
            return;
        }
        this.g = i;
        ya9.a().d("ubc_real_upload_max_limit", i);
    }

    public void U(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048596, this, i) != null) || i < 30720) {
            return;
        }
        this.f = i;
        ya9.a().d("ubc_single_log_max_limit", i);
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048597, this, i) != null) || i < 1) {
            return;
        }
        this.b = i * 60000;
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048598, this, i) != null) || i <= 0) {
            return;
        }
        this.i = i;
        ya9.a().d("ubc_upload_trigger_num", i);
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048599, this, i) != null) || i <= 0) {
            return;
        }
        this.j = i;
        ya9.a().d("ubc_upload_trigger_time", i);
    }

    public void Z(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048601, this, j) == null) && this.o < j) {
            this.o = j;
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            return this.q.e.contains(str);
        }
        return invokeL.booleanValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (this.q.o.containsKey(str) && (num = (Integer) this.q.o.get(str)) != null) {
                return num.intValue();
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return this.q.g.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            if (C(str) == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (this.r.isUBCDebug() || this.q.c.contains(str)) {
                return true;
            }
            return this.q.a.b;
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            return this.q.l.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (this.q.b.contains(str)) {
                return false;
            }
            if (this.q.f.contains(str)) {
                return true;
            }
            return this.q.a.d;
        }
        return invokeL.booleanValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (this.q.i.containsKey(str)) {
                return (String) this.q.i.get(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public int n(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            if (this.q.m.containsKey(str) && (num = (Integer) this.q.m.get(str)) != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void D(q99 q99Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, q99Var, context) == null) {
            this.a = context;
            this.b = 60000;
            ya9 a = ya9.a();
            this.c = a.b("ubc_data_expire_time", 604800000);
            this.d = a.b("ubc_database_limit", 10000);
            q99Var.n().y(this.q);
            this.e = a.b("ubc_launch_upload_max_limit", 614400);
            this.f = a.b("ubc_single_log_max_limit", 153600);
            this.g = a.b("ubc_real_upload_max_limit", 614400);
            this.h = a.b("ubc_non_real_upload_max_limit", 614400);
            this.i = a.b("ubc_upload_trigger_num", 100);
            this.j = a.b("ubc_upload_trigger_time", 180);
            this.k = pa9.i().p();
            this.l = pa9.i().f();
            this.m = pa9.i().b();
            this.n = pa9.i().g();
            this.p = pa9.i().k();
        }
    }

    public void Y(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                x99 x99Var = (x99) it.next();
                String c = x99Var.c();
                if (!TextUtils.isEmpty(c)) {
                    if (!x99Var.s()) {
                        this.q.b.add(c);
                        this.q.f.remove(c);
                    } else {
                        this.q.b.remove(c);
                        this.q.f.add(c);
                    }
                    if (x99Var.o()) {
                        this.q.c.add(c);
                        this.q.d.remove(c);
                    } else {
                        this.q.c.remove(c);
                        this.q.d.add(c);
                    }
                    if (x99Var.k()) {
                        this.q.e.add(c);
                    } else {
                        this.q.e.remove(c);
                    }
                    if (x99Var.n()) {
                        this.q.g.add(c);
                    } else {
                        this.q.g.remove(c);
                    }
                    int g = x99Var.g();
                    if (g >= 1 && g <= 100) {
                        this.q.h.put(c, Integer.valueOf(g));
                    } else {
                        this.q.h.remove(c);
                    }
                    String a = x99Var.a();
                    if (!TextUtils.isEmpty(a)) {
                        this.q.i.put(c, a);
                    } else {
                        this.q.i.remove(c);
                    }
                    int d = x99Var.d();
                    int e = x99Var.e();
                    if (d != 0 && e != 0) {
                        this.q.j.put(c, new z99(c, e, d));
                    }
                    if (x99Var.m()) {
                        this.q.k.add(c);
                    } else {
                        this.q.k.remove(c);
                    }
                    if (x99Var.p()) {
                        this.q.l.add(c);
                    } else {
                        this.q.l.remove(c);
                    }
                    int b = x99Var.b();
                    if (x99Var.r()) {
                        this.q.m.put(c, Integer.valueOf(b));
                    } else {
                        this.q.m.remove(c);
                    }
                    if (x99Var.t()) {
                        this.q.n.remove(c);
                    } else {
                        this.q.n.put(c, Integer.valueOf(x99Var.i()));
                    }
                    int f = x99Var.f();
                    if (f != 2) {
                        this.q.o.put(c, Integer.valueOf(f));
                    } else {
                        this.q.o.remove(c);
                    }
                }
            }
        }
    }

    public boolean g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, str, i)) == null) {
            if (this.q.b.contains(str)) {
                return false;
            }
            if ((i & 16) == 0 && (i & 32) == 0) {
                if (this.q.f.contains(str)) {
                    return true;
                }
                return this.q.a.a;
            } else if (!this.q.f.contains(str)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (!E() && this.r.isUBCSample() && y(str) > 0) {
                if (new Random().nextInt(100) >= y(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int y(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && this.q.h.containsKey(str) && (num = (Integer) this.q.h.get(str)) != null) {
                return num.intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (this.q.k.contains(str) || TextUtils.equals(str, "1876") || TextUtils.equals(str, "2980")) {
                    return "1";
                }
                return "0";
            }
            return "0";
        }
        return (String) invokeL.objValue;
    }
}
