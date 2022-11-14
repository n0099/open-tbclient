package com.baidu.tieba;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.ha4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ma4 implements ka4, ra4, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public Context c;
    public int d;
    public oa4 e;
    public List<na4> f;
    public List<na4> g;
    public List<List<na4>> h;
    public ka4 i;
    public ra4 j;
    public View.OnKeyListener k;
    public c l;
    public ha4 m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes5.dex */
    public interface c {
        void a(ma4 ma4Var, boolean z);
    }

    public final boolean q(na4 na4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, na4Var)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma4 a;

        public a(ma4 ma4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma4Var;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            ma4 ma4Var;
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cVar = (ma4Var = this.a).l) != null) {
                cVar.a(ma4Var, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ha4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma4 a;

        public b(ma4 ma4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma4Var;
        }

        @Override // com.baidu.tieba.ha4.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.k(i);
        }
    }

    public ma4(Context context, View view2, int i, ha4 ha4Var, @Nullable ga4 ga4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, Integer.valueOf(i), ha4Var, ga4Var};
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
        this.m = ha4Var;
        this.p = ha4Var.a();
        List<na4> b2 = pa4.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        oa4 oa4Var = new oa4(this.c, view2, ga4Var);
        this.e = oa4Var;
        oa4Var.I(new a(this));
    }

    public final na4 A(na4 na4Var, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, na4Var, z)) == null) {
            if (na4Var == null) {
                return null;
            }
            if (z) {
                i = R.string.obfuscated_res_0x7f0f00f9;
            } else {
                i = R.string.obfuscated_res_0x7f0f00fc;
            }
            na4Var.q(i);
            if (z) {
                i2 = R.drawable.obfuscated_res_0x7f0800e2;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0800f5;
            }
            na4Var.m(i2);
            return na4Var;
        }
        return (na4) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.ka4
    public boolean b(View view2, na4 na4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, na4Var)) == null) {
            if (!na4Var.i()) {
                return true;
            }
            if (q(na4Var)) {
                g(true);
            }
            ka4 ka4Var = this.i;
            if (ka4Var == null) {
                return false;
            }
            return ka4Var.b(view2, na4Var);
        }
        return invokeLL.booleanValue;
    }

    public void t(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            u(z, i, null, false);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            A(h(5), z);
            v();
            this.e.S();
            j();
        }
    }

    @Override // com.baidu.tieba.ra4
    public boolean a(na4 na4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, na4Var)) == null) {
            if (q(na4Var) && !this.a) {
                g(true);
            }
            ra4 ra4Var = this.j;
            if (ra4Var == null) {
                return false;
            }
            return ra4Var.a(na4Var);
        }
        return invokeL.booleanValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d = i;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.e.T(z);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public final void k(int i) {
        na4 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (h = h(i)) != null && h.j()) {
            this.g.add(h);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.e.W(i);
        }
    }

    public void n(ka4 ka4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ka4Var) == null) {
            this.i = ka4Var;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b = i;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            t(z, 0);
        }
    }

    public void d(int i, int i2) {
        na4 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            boolean z = false;
            for (na4 na4Var : this.f) {
                if (na4Var.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = pa4.a(i)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g(true);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            oa4 oa4Var = this.e;
            if (oa4Var != null && oa4Var.x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        oa4 oa4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (oa4Var = this.e) != null) {
            oa4Var.V();
        }
    }

    public na4 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                na4 na4Var = this.f.get(i2);
                if (na4Var != null && na4Var.c() == i) {
                    na4Var.n(0L);
                    na4Var.p(this);
                    return na4Var;
                }
            }
            return null;
        }
        return (na4) invokeI.objValue;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.f == null) {
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
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048592, this, view2, i, keyEvent)) == null) {
            View.OnKeyListener onKeyListener = this.k;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view2, i, keyEvent);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void u(boolean z, int i, View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), view2, Boolean.valueOf(z2)}) == null) {
            if (i()) {
                g(true);
                return;
            }
            x(z, i);
            v();
            this.e.X(this.h, view2, z2, this.b);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, true);
            }
        }
    }

    public final void v() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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

    public final na4 w(na4 na4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, na4Var, i)) == null) {
            if (na4Var == null) {
                return null;
            }
            if (i == 2) {
                na4Var.q(R.string.obfuscated_res_0x7f0f00f8);
                na4Var.m(R.drawable.obfuscated_res_0x7f0800dc);
                return na4Var;
            } else if (i == 1) {
                na4Var.q(R.string.obfuscated_res_0x7f0f00fa);
                na4Var.m(R.drawable.obfuscated_res_0x7f0800d4);
                return na4Var;
            } else if (i == 0) {
                return null;
            } else {
                return na4Var;
            }
        }
        return (na4) invokeLI.objValue;
    }

    public final void x(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || this.f == null) {
            return;
        }
        this.g.clear();
        k(41);
        na4 w = w(h(38), i);
        if (w != null && w.j()) {
            this.g.add(w);
        }
        k(48);
        k(45);
        k(4);
        k(101);
        na4 h = h(35);
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
        na4 A = A(h(5), z);
        if (A != null && A.j()) {
            this.g.add(A);
        }
        k(46);
        k(47);
        k(51);
        k(49);
        k(50);
        ha4 ha4Var = this.m;
        if (ha4Var != null) {
            ha4Var.f(this.d, this.f, new b(this));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.m == null) {
            return;
        }
        this.f.clear();
        List<na4> b2 = pa4.b(this.d);
        this.f = b2;
        this.m.d(this.d, b2);
        this.m.e(this.d, this.f);
        if (this.m.a()) {
            this.m.c(this.d, this.f);
        }
        v();
        j();
    }

    public void z(JSONObject jSONObject) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("pa_type");
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
            for (na4 na4Var : this.g) {
                if (na4Var.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + na4Var.e());
                    if (valueOf.longValue() > 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    na4Var.o(i2);
                    na4Var.n(valueOf.longValue());
                }
            }
        }
    }
}
