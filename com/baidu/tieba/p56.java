package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.yv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public boolean M;
    public boolean N;
    @Nullable
    public e O;
    public Runnable P;
    public Runnable Q;
    public Handler a;
    public of b;
    public TbPageContext c;
    public View d;
    public boolean e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public Map<String, String> j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes5.dex */
    public interface e {
        void onDismiss();
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p56 a;

        public a(p56 p56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p56Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f()) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p56 a;

        public b(p56 p56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p56Var;
        }

        @Override // com.baidu.tieba.nf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.y;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.x;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.r;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.s;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.nf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            int dimensionPixelSize;
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                TextView textView = new TextView(this.a.c.getPageActivity());
                textView.setText(this.a.f);
                int i = this.a.J;
                if (i != 0) {
                    textView.setGravity(i);
                } else {
                    textView.setGravity(17);
                }
                int i2 = this.a.H;
                int i3 = R.color.CAM_X0101;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(textView, i2);
                } else {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                }
                p56 p56Var = this.a;
                if (p56Var.I != 0) {
                    dimensionPixelSize = p56Var.c.getResources().getDimensionPixelSize(this.a.I);
                } else {
                    dimensionPixelSize = p56Var.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
                }
                textView.setTextSize(0, dimensionPixelSize);
                p56 p56Var2 = this.a;
                int i4 = p56Var2.D;
                if (i4 != 0) {
                    textView.setHeight(i4);
                } else {
                    textView.setHeight(p56Var2.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
                }
                int i5 = this.a.E;
                if (i5 != 0) {
                    p56.N(textView, 0, i5);
                }
                int i6 = this.a.F;
                if (i6 != 0) {
                    textView.setWidth(i6);
                }
                p56 p56Var3 = this.a;
                textView.setPadding(p56Var3.t, p56Var3.u, p56Var3.v, p56Var3.w);
                textView.setLines(this.a.C);
                if (this.a.G) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                p56 p56Var4 = this.a;
                int i7 = p56Var4.K;
                if (i7 != 0) {
                    if (p56Var4.L) {
                        int i8 = p56Var4.H;
                        if (i8 != 0) {
                            i3 = i8;
                        }
                        drawable = WebPManager.getPureDrawable(this.a.K, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(i7);
                    }
                    int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g, g);
                    textView.setCompoundDrawablePadding(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                SkinManager.setBackgroundResource(textView, this.a.k);
                View.OnClickListener onClickListener = this.a.z;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                }
                return textView;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p56 a;

        public c(p56 p56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p56Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv4.a a;
        public final /* synthetic */ p56 b;

        public d(p56 p56Var, yv4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p56Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p56Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.e(this.a);
        }
    }

    public p56(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.k = R.drawable.pic_sign_tip;
        this.l = 0;
        this.m = false;
        this.n = 1;
        this.o = 1000;
        this.p = 3000;
        this.q = true;
        this.r = 5;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 48;
        this.y = 4;
        this.B = false;
        this.C = 1;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = false;
        this.M = true;
        this.P = new a(this);
        this.Q = new c(this);
        this.c = tbPageContext;
        this.d = view2;
        this.t = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.u = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.v = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.w = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
    }

    public static void N(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public boolean T(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048594, this, str, str2, z)) == null) {
            return U(str, str2, z, false);
        }
        return invokeLLZ.booleanValue;
    }

    public void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            T(str, str2, false);
        }
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.g = str;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0) {
            this.o = i;
        }
    }

    public void C(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.H = i;
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.K = i;
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.w = i;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.t = i;
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.v = i;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.u = i;
        }
    }

    public void J(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.I = i;
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.J = i;
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && i > 0) {
            this.k = i;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.B = z;
        }
    }

    public void O(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.F = this.c.getResources().getDimensionPixelSize(i);
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.r = i;
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.s = i;
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.f = str;
        if (this.a == null) {
            this.a = new Handler();
        }
        this.a.postDelayed(this.P, this.o);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.y = i;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && i > 0) {
            this.p = i;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.x = i;
        }
    }

    public void p(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.D = this.c.getResources().getDimensionPixelSize(i);
        }
    }

    public void q(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.E = this.c.getResources().getDimensionPixelSize(i);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.G = z;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.M = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.N = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.L = z;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.C = i;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048617, this, i) == null) && i > 0) {
            this.n = i;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.A = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.q = z;
        }
    }

    public void z(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, eVar) == null) {
            this.O = eVar;
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.t = i;
            this.u = i2;
            this.v = i3;
            this.w = i4;
        }
    }

    @Deprecated
    public boolean U(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.e || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view2 = this.d) == null || view2.getVisibility() != 0) {
                return false;
            }
            this.f = str;
            this.g = str2;
            this.m = z2;
            int l = ky4.k().l(str2, 0);
            this.l = l;
            if (l >= this.n && !this.m) {
                return false;
            }
            if (z) {
                j();
                this.e = true;
            }
            if (this.a == null) {
                this.a = new Handler();
            }
            this.a.postDelayed(this.P, this.o);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void V(String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f = str;
            this.g = str2;
            k();
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, @NonNull yv4.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            if (!this.e && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && (view2 = this.d) != null && view2.getVisibility() == 0) {
                this.f = str;
                this.g = str2;
                this.m = z2;
                int l = ky4.k().l(str2, 0);
                this.l = l;
                if (l >= this.n) {
                    aVar.a(false);
                    return;
                }
                if (z) {
                    j();
                    this.e = true;
                }
                if (this.a == null) {
                    this.a = new Handler();
                }
                this.a.postDelayed(new d(this, aVar), this.o);
                return;
            }
            aVar.a(false);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (ky4.k().l(this.g, 0) >= this.n) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.b != null || StringUtils.isNull(this.f)) {
                return false;
            }
            if (this.A && !g()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            View view2 = this.d;
            if (view2 == null || view2.getVisibility() != 0 || this.d.getAlpha() < 0.4d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && !this.m) {
            ky4.k().w(this.g, this.l + 1);
        }
    }

    public final void e(@NonNull yv4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            if (this.b != null) {
                aVar.a(false);
            } else if (StringUtils.isNull(this.f)) {
                aVar.a(false);
            } else if (this.A && !g()) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            of ofVar = this.b;
            if (ofVar != null) {
                ofVar.d();
                this.b = null;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacks(this.P);
                this.a.removeCallbacks(this.Q);
            }
            e eVar = this.O;
            if (eVar != null && this.h) {
                eVar.onDismiss();
            }
            this.h = false;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            pf pfVar = new pf();
            pfVar.k(this.d);
            pfVar.c(0);
            pfVar.j(true);
            pfVar.i(true);
            pfVar.d(this.M);
            pfVar.g(this.N);
            pfVar.a(new b(this));
            of b2 = pfVar.b();
            this.b = b2;
            b2.k(false);
            this.b.l(this.B);
            this.b.n(this.c.getPageActivity(), this.q);
            this.e = true;
            j();
            this.h = true;
            if (this.a == null) {
                this.a = new Handler();
            }
            this.a.postDelayed(this.Q, this.p);
        }
    }
}
