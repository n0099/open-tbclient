package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
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
import com.baidu.tieba.s55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class or6 {
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
    public lf a;
    public TbPageContext b;
    public View c;
    public boolean d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public Map<String, String> i;
    public int j;
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

    /* loaded from: classes7.dex */
    public interface e {
        void onDismiss();
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or6 a;

        public a(or6 or6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f()) {
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements kf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or6 a;

        public b(or6 or6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or6Var;
        }

        @Override // com.baidu.tieba.kf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.y;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.x;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.r;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.s;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.kf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            int dimensionPixelSize;
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                if (this.a.b == null) {
                    return null;
                }
                TextView textView = new TextView(this.a.b.getPageActivity());
                textView.setText(this.a.e);
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
                if (this.a.I != 0) {
                    dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(this.a.I);
                } else {
                    dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
                }
                textView.setTextSize(0, dimensionPixelSize);
                int i4 = this.a.D;
                if (i4 != 0) {
                    textView.setHeight(i4);
                } else {
                    textView.setHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
                }
                int i5 = this.a.E;
                if (i5 != 0) {
                    or6.O(textView, 0, i5);
                }
                int i6 = this.a.F;
                if (i6 != 0) {
                    textView.setWidth(i6);
                }
                or6 or6Var = this.a;
                textView.setPadding(or6Var.t, or6Var.u, or6Var.v, or6Var.w);
                textView.setLines(this.a.C);
                if (this.a.G) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                or6 or6Var2 = this.a;
                int i7 = or6Var2.K;
                if (i7 != 0) {
                    if (or6Var2.L) {
                        int i8 = or6Var2.H;
                        if (i8 != 0) {
                            i3 = i8;
                        }
                        drawable = WebPManager.getPureDrawable(this.a.K, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(i7);
                    }
                    int g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g, g);
                    textView.setCompoundDrawablePadding(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                or6 or6Var3 = this.a;
                int i9 = or6Var3.k;
                if (i9 != 0) {
                    SkinManager.setBackgroundResourceWithTintColor(textView, or6Var3.j, i9);
                } else {
                    SkinManager.setBackgroundResource(textView, or6Var3.j);
                }
                View.OnClickListener onClickListener = this.a.z;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                }
                return textView;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or6 a;

        public c(or6 or6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s55.a a;
        public final /* synthetic */ or6 b;

        public d(or6 or6Var, s55.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or6Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = or6Var;
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

    public or6(TbPageContext tbPageContext, View view2) {
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
        this.j = R.drawable.pic_sign_tip;
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
        this.b = tbPageContext;
        this.c = view2;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.t = dimensionPixelSize;
        this.u = dimensionPixelSize;
        this.v = dimensionPixelSize;
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070353);
    }

    public static void O(@NonNull View view2, int i, int i2) {
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

    public boolean U(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048595, this, str, str2, z)) == null) {
            return V(str, str2, z, false);
        }
        return invokeLLZ.booleanValue;
    }

    public void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
            U(str, str2, false);
        }
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f = str;
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
            this.j = i;
        }
    }

    public void M(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.B = z;
        }
    }

    public void P(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.F = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.r = i;
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.s = i;
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.e = str;
        wg.a().postDelayed(this.P, this.o);
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.y = i;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048609, this, i) == null) && i > 0) {
            this.p = i;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.x = i;
        }
    }

    public void p(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.D = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        }
    }

    public void q(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.E = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.G = z;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.M = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.N = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.L = z;
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.C = i;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i) == null) && i > 0) {
            this.n = i;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.A = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.q = z;
        }
    }

    public void z(@Nullable e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, eVar) == null) {
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
    public boolean V(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.d || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view2 = this.c) == null || view2.getVisibility() != 0) {
                return false;
            }
            this.e = str;
            this.f = str2;
            this.m = z2;
            int n = n95.m().n(str2, 0);
            this.l = n;
            if (n >= this.n && !this.m) {
                return false;
            }
            if (z) {
                j();
                this.d = true;
            }
            wg.a().postDelayed(this.P, this.o);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void W(String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.e = str;
            this.f = str2;
            k();
        }
    }

    public void c(String str, String str2, boolean z, boolean z2, @NonNull s55.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            if (!this.d && !StringUtils.isNull(str) && !StringUtils.isNull(str2) && (view2 = this.c) != null && view2.getVisibility() == 0) {
                this.e = str;
                this.f = str2;
                this.m = z2;
                int n = n95.m().n(str2, 0);
                this.l = n;
                if (n >= this.n) {
                    aVar.callback(false);
                    return;
                }
                if (z) {
                    j();
                    this.d = true;
                }
                wg.a().postDelayed(new d(this, aVar), this.o);
                return;
            }
            aVar.callback(false);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (n95.m().n(this.f, 0) >= this.n) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.a != null || StringUtils.isNull(this.e)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getVisibility() != 0 || this.c.getAlpha() < 0.4d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && !this.m) {
            n95.m().z(this.f, this.l + 1);
        }
    }

    public final void e(@NonNull s55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            if (this.a != null) {
                aVar.callback(false);
            } else if (StringUtils.isNull(this.e)) {
                aVar.callback(false);
            } else if (this.A && !g()) {
                aVar.callback(false);
            } else {
                aVar.callback(true);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            lf lfVar = this.a;
            if (lfVar != null) {
                lfVar.d();
                this.a = null;
            }
            wg.a().removeCallbacks(this.P);
            wg.a().removeCallbacks(this.Q);
            e eVar = this.O;
            if (eVar != null && this.g) {
                eVar.onDismiss();
            }
            this.g = false;
            this.b = null;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || this.b == null) {
            return;
        }
        mf mfVar = new mf();
        mfVar.k(this.c);
        mfVar.c(0);
        mfVar.j(true);
        mfVar.i(true);
        mfVar.d(this.M);
        mfVar.g(this.N);
        mfVar.a(new b(this));
        lf b2 = mfVar.b();
        this.a = b2;
        b2.k(false);
        this.a.l(this.B);
        this.a.n(this.b.getPageActivity(), this.q);
        this.d = true;
        j();
        this.g = true;
        wg.a().postDelayed(this.Q, this.p);
    }
}
