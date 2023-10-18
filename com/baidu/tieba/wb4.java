package com.baidu.tieba;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.rb4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wb4 implements ub4, bc4, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public yb4 e;
    public List<xb4> f;
    public List<xb4> g;
    public List<List<xb4>> h;
    public ub4 i;
    public bc4 j;
    public View.OnKeyListener k;
    public c l;
    public rb4 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes8.dex */
    public interface c {
        void a(wb4 wb4Var, boolean z);
    }

    public final boolean q(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, xb4Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb4 a;

        public a(wb4 wb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wb4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            wb4 wb4Var;
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cVar = (wb4Var = this.a).l) != null) {
                cVar.a(wb4Var, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements rb4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wb4 a;

        public b(wb4 wb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wb4Var;
        }

        @Override // com.baidu.tieba.rb4.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.k(i);
        }
    }

    public wb4(Context context, View view2, int i, rb4 rb4Var, @Nullable qb4 qb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), rb4Var, qb4Var};
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
        this.m = rb4Var;
        this.p = rb4Var.a();
        List<xb4> b2 = zb4.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        yb4 yb4Var = new yb4(this.c, view2, qb4Var);
        this.e = yb4Var;
        yb4Var.J(new a(this));
    }

    @Override // com.baidu.tieba.ub4
    public boolean b(View view2, xb4 xb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, xb4Var)) == null) {
            if (!xb4Var.i()) {
                return true;
            }
            if (q(xb4Var)) {
                g(true);
            }
            ub4 ub4Var = this.i;
            if (ub4Var == null) {
                return false;
            }
            return ub4Var.b(view2, xb4Var);
        }
        return invokeLL.booleanValue;
    }

    public void s(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            t(z, i, null, false);
        }
    }

    public final xb4 z(xb4 xb4Var, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, xb4Var, z)) == null) {
            if (xb4Var == null) {
                return null;
            }
            if (z) {
                i = R.string.obfuscated_res_0x7f0f0128;
            } else {
                i = R.string.obfuscated_res_0x7f0f012b;
            }
            xb4Var.q(i);
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f0800fd;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f080110;
            }
            xb4Var.m(i2);
            return xb4Var;
        }
        return (xb4) invokeLZ.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            z(h(5), z);
            u();
            this.e.U();
            j();
        }
    }

    @Override // com.baidu.tieba.bc4
    public boolean a(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xb4Var)) == null) {
            if (q(xb4Var) && !this.a) {
                g(true);
            }
            bc4 bc4Var = this.j;
            if (bc4Var == null) {
                return false;
            }
            return bc4Var.a(xb4Var);
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
            this.e.V(z);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public final void k(int i) {
        xb4 h;
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

    public void n(ub4 ub4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ub4Var) == null) {
            this.i = ub4Var;
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
        xb4 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            boolean z = false;
            for (xb4 xb4Var : this.f) {
                if (xb4Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = zb4.a(i)) == null) {
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
            yb4 yb4Var = this.e;
            if (yb4Var != null && yb4Var.y()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        yb4 yb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (yb4Var = this.e) != null) {
            yb4Var.Y();
        }
    }

    public xb4 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                xb4 xb4Var = this.f.get(i2);
                if (xb4Var != null && xb4Var.c() == i) {
                    xb4Var.n(0L);
                    xb4Var.p(this);
                    return xb4Var;
                }
            }
            return null;
        }
        return (xb4) invokeI.objValue;
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

    public final xb4 v(xb4 xb4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, xb4Var, i)) == null) {
            if (xb4Var == null) {
                return null;
            }
            if (i == 2) {
                xb4Var.q(R.string.obfuscated_res_0x7f0f0127);
                xb4Var.m(R.drawable.obfuscated_res_0x7f0800f7);
                return xb4Var;
            } else if (i == 1) {
                xb4Var.q(R.string.obfuscated_res_0x7f0f0129);
                xb4Var.m(R.drawable.obfuscated_res_0x7f0800ef);
                return xb4Var;
            } else if (i == 0) {
                return null;
            } else {
                return xb4Var;
            }
        }
        return (xb4) invokeLI.objValue;
    }

    public final void w(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || this.f == null) {
            return;
        }
        this.g.clear();
        k(41);
        xb4 v = v(h(38), i);
        if (v != null && v.j()) {
            this.g.add(v);
        }
        k(48);
        k(45);
        k(4);
        k(101);
        xb4 h = h(35);
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
        xb4 z2 = z(h(5), z);
        if (z2 != null && z2.j()) {
            this.g.add(z2);
        }
        k(46);
        k(47);
        k(51);
        k(49);
        k(50);
        rb4 rb4Var = this.m;
        if (rb4Var != null) {
            rb4Var.f(this.d, this.f, new b(this));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<xb4> b2 = zb4.b(this.d);
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
            for (xb4 xb4Var : this.g) {
                if (xb4Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + xb4Var.e());
                    if (valueOf.longValue() > 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    xb4Var.o(i2);
                    xb4Var.n(valueOf.longValue());
                }
            }
        }
    }
}
