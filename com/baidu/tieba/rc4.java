package com.baidu.tieba;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.mc4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class rc4 implements pc4, wc4, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public tc4 e;
    public List<sc4> f;
    public List<sc4> g;
    public List<List<sc4>> h;
    public pc4 i;
    public wc4 j;
    public View.OnKeyListener k;
    public c l;
    public mc4 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes8.dex */
    public interface c {
        void a(rc4 rc4Var, boolean z);
    }

    public final boolean q(sc4 sc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, sc4Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc4 a;

        public a(rc4 rc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            rc4 rc4Var;
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cVar = (rc4Var = this.a).l) != null) {
                cVar.a(rc4Var, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mc4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc4 a;

        public b(rc4 rc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc4Var;
        }

        @Override // com.baidu.tieba.mc4.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.k(i);
        }
    }

    public rc4(Context context, View view2, int i, mc4 mc4Var, @Nullable lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), mc4Var, lc4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.o = -1;
        this.p = false;
        if (i < 0) {
            return;
        }
        this.c = context;
        this.d = i;
        this.m = mc4Var;
        this.p = mc4Var.a();
        List<sc4> b2 = uc4.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        tc4 tc4Var = new tc4(this.c, view2, lc4Var);
        this.e = tc4Var;
        tc4Var.K(new a(this));
    }

    @Override // com.baidu.tieba.pc4
    public boolean b(View view2, sc4 sc4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, sc4Var)) == null) {
            if (!sc4Var.i()) {
                return true;
            }
            if (q(sc4Var)) {
                g(true);
            }
            pc4 pc4Var = this.i;
            if (pc4Var == null) {
                return false;
            }
            return pc4Var.b(view2, sc4Var);
        }
        return invokeLL.booleanValue;
    }

    public void s(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            t(z, i, null, false);
        }
    }

    public final sc4 z(sc4 sc4Var, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, sc4Var, z)) == null) {
            if (sc4Var == null) {
                return null;
            }
            if (z) {
                i = R.string.obfuscated_res_0x7f0f0130;
            } else {
                i = R.string.obfuscated_res_0x7f0f0133;
            }
            sc4Var.q(i);
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f080102;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f080115;
            }
            sc4Var.m(i2);
            return sc4Var;
        }
        return (sc4) invokeLZ.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            z(h(5), z);
            u();
            this.e.V();
            j();
        }
    }

    @Override // com.baidu.tieba.wc4
    public boolean a(sc4 sc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sc4Var)) == null) {
            if (q(sc4Var) && !this.a) {
                g(true);
            }
            wc4 wc4Var = this.j;
            if (wc4Var == null) {
                return false;
            }
            return wc4Var.a(sc4Var);
        }
        return invokeL.booleanValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e.W(z);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public final void k(int i) {
        sc4 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (h = h(i)) != null && h.j()) {
            this.g.add(h);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.e.Z(i);
        }
    }

    public void n(pc4 pc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pc4Var) == null) {
            this.i = pc4Var;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b = i;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.n = z;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            s(z, 0);
        }
    }

    public void d(int i, int i2) {
        sc4 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            boolean z = false;
            for (sc4 sc4Var : this.f) {
                if (sc4Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = uc4.a(i)) == null) {
                return;
            }
            int size = this.f.size();
            if (i2 <= 0) {
                i2 = 0;
            } else if (i2 >= size) {
                i2 = size;
            }
            this.f.add(i2, a2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g(true);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            tc4 tc4Var = this.e;
            if (tc4Var != null && tc4Var.z()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        tc4 tc4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tc4Var = this.e) != null) {
            tc4Var.Y();
        }
    }

    public sc4 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                sc4 sc4Var = this.f.get(i2);
                if (sc4Var != null && sc4Var.c() == i) {
                    sc4Var.n(0L);
                    sc4Var.p(this);
                    return sc4Var;
                }
            }
            return null;
        }
        return (sc4) invokeI.objValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || this.f == null) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            if (this.f.get(i3).c() == i) {
                i2 = i3;
            }
        }
        if (i2 > -1) {
            this.f.remove(i2);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048591, this, view2, i, keyEvent)) == null) {
            View.OnKeyListener onKeyListener = this.k;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view2, i, keyEvent);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void t(boolean z, int i, View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), view2, Boolean.valueOf(z2)}) == null) {
            if (i()) {
                g(true);
                return;
            }
            w(z, i);
            u();
            this.e.a0(this.h, view2, z2, this.b);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, true);
            }
        }
    }

    public final void u() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.h.clear();
            if (this.m.a()) {
                this.h.add(this.g);
                return;
            }
            int size = this.g.size();
            int i2 = 5;
            if (size > 0 && size <= 5) {
                this.h.add(this.g);
            } else if (size > 5 && size <= 10) {
                if (!this.a) {
                    i2 = this.o;
                }
                this.h.add(this.g.subList(0, i2));
                this.h.add(this.g.subList(i2, size));
            } else if (size > 10) {
                if (this.a) {
                    i = (int) Math.ceil(size / 2.0f);
                } else {
                    i = this.o;
                }
                this.h.add(this.g.subList(0, i));
                this.h.add(this.g.subList(i, size));
            }
        }
    }

    public final sc4 v(sc4 sc4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, sc4Var, i)) == null) {
            if (sc4Var == null) {
                return null;
            }
            if (i == 2) {
                sc4Var.q(R.string.obfuscated_res_0x7f0f012f);
                sc4Var.m(R.drawable.obfuscated_res_0x7f0800fc);
                return sc4Var;
            } else if (i == 1) {
                sc4Var.q(R.string.obfuscated_res_0x7f0f0131);
                sc4Var.m(R.drawable.obfuscated_res_0x7f0800f4);
                return sc4Var;
            } else if (i == 0) {
                return null;
            } else {
                return sc4Var;
            }
        }
        return (sc4) invokeLI.objValue;
    }

    public final void w(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || this.f == null) {
            return;
        }
        this.g.clear();
        k(41);
        sc4 v = v(h(38), i);
        if (v != null && v.j()) {
            this.g.add(v);
        }
        k(48);
        k(45);
        k(4);
        k(101);
        sc4 h = h(35);
        if (h != null && h.j()) {
            this.g.add(h);
        }
        k(39);
        k(42);
        k(9);
        if (!this.a) {
            this.o = this.g.size() - 1;
        }
        k(37);
        if (this.n) {
            k(43);
        }
        sc4 z2 = z(h(5), z);
        if (z2 != null && z2.j()) {
            this.g.add(z2);
        }
        k(46);
        k(47);
        k(51);
        k(49);
        k(50);
        mc4 mc4Var = this.m;
        if (mc4Var != null) {
            mc4Var.f(this.d, this.f, new b(this));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<sc4> b2 = uc4.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        u();
        j();
    }

    public void y(JSONObject jSONObject) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jSONObject) == null) {
            int optInt = jSONObject.optInt(Constants.EXTRA_PA_TYPE);
            Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
            if (optInt != 7) {
                if (optInt != 666) {
                    if (optInt != 888) {
                        if (optInt != 999) {
                            i = -1;
                        } else {
                            i = 48;
                        }
                    } else {
                        i = 47;
                    }
                } else {
                    i = 46;
                }
            } else {
                i = 45;
            }
            if (i < 0) {
                return;
            }
            for (sc4 sc4Var : this.g) {
                if (sc4Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + sc4Var.e());
                    if (valueOf.longValue() > 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    sc4Var.o(i2);
                    sc4Var.n(valueOf.longValue());
                }
            }
        }
    }
}
