package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class zn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final View b;
    public final int c;
    public final int d;
    public final xn9 e;
    public LinearLayout f;
    public RelativeLayout g;
    public LinearLayout h;
    public RelativeLayout i;
    public ImageView j;
    public ImageView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public TbCheckBox q;
    public NavigationBar r;
    public ImageView s;
    public ArrayList<yn9> t;

    /* loaded from: classes7.dex */
    public static final class a implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public a() {
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
            this.a = true;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }
    }

    public zn9(TbPageContext<?> mPageContext, View mRootView, int i, int i2, xn9 mPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPageContext, mRootView, Integer.valueOf(i), Integer.valueOf(i2), mPresenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mPageContext, "mPageContext");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.a = mPageContext;
        this.b = mRootView;
        this.c = i;
        this.d = i2;
        this.e = mPresenter;
        this.t = new ArrayList<>();
        n();
    }

    public static final void o(zn9 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e.h();
        }
    }

    public static final void p(zn9 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.e.K0(this$0.h().d());
            if (this$0.c == 2) {
                TiebaStatic.log(new StatisticItem("c14366"));
            } else {
                TiebaStatic.log(new StatisticItem("c14365"));
            }
        }
    }

    public final void b(int i, String title) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, title) == null) {
            Intrinsics.checkNotNullParameter(title, "title");
            yn9 yn9Var = new yn9(this.a.getPageActivity());
            yn9Var.e(title);
            yn9Var.d(i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds77);
            d().addView(yn9Var.b(), layoutParams);
            this.t.add(yn9Var);
        }
    }

    public final void A(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.m = eMTextView;
        }
    }

    public final void B(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.j = imageView;
        }
    }

    public final void C(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.n = eMTextView;
        }
    }

    public final void D(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.l = eMTextView;
        }
    }

    public final void E(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.k = imageView;
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a.getPageActivity());
            bdTopToast.h(false);
            bdTopToast.g(str);
            bdTopToast.i(e());
        }
    }

    public final void r(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.s = imageView;
        }
    }

    public final void s(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.g = relativeLayout;
        }
    }

    public final void t(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.h = linearLayout;
        }
    }

    public final void u(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.i = relativeLayout;
        }
    }

    public final void v(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.f = linearLayout;
        }
    }

    public final void w(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, navigationBar) == null) {
            Intrinsics.checkNotNullParameter(navigationBar, "<set-?>");
            this.r = navigationBar;
        }
    }

    public final void x(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.o = eMTextView;
        }
    }

    public final void y(TbCheckBox tbCheckBox) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, tbCheckBox) == null) {
            Intrinsics.checkNotNullParameter(tbCheckBox, "<set-?>");
            this.q = tbCheckBox;
        }
    }

    public final void z(EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eMTextView) == null) {
            Intrinsics.checkNotNullParameter(eMTextView, "<set-?>");
            this.p = eMTextView;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d().removeAllViews();
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f08bf);
            Intrinsics.checkNotNullExpressionValue(string, "mPageContext.getString(R…ng.guide_upgrde_item_one)");
            b(R.drawable.obfuscated_res_0x7f080891, string);
            String string2 = this.a.getString(R.string.obfuscated_res_0x7f0f08c1);
            Intrinsics.checkNotNullExpressionValue(string2, "mPageContext.getString(R…ng.guide_upgrde_item_two)");
            b(R.drawable.obfuscated_res_0x7f08088d, string2);
            String string3 = this.a.getString(R.string.obfuscated_res_0x7f0f08c0);
            Intrinsics.checkNotNullExpressionValue(string3, "mPageContext.getString(R….guide_upgrde_item_three)");
            b(R.drawable.obfuscated_res_0x7f08085d, string3);
            String string4 = this.a.getString(R.string.obfuscated_res_0x7f0f08be);
            Intrinsics.checkNotNullExpressionValue(string4, "mPageContext.getString(R…g.guide_upgrde_item_four)");
            b(R.drawable.obfuscated_res_0x7f08085a, string4);
        }
    }

    public final ImageView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageView imageView = this.s;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mLineView");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUpgradeItemConten");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final RelativeLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUpgradeMain");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final LinearLayout f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mUpgradeTop");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final NavigationBar g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            NavigationBar navigationBar = this.r;
            if (navigationBar != null) {
                return navigationBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final TbCheckBox h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TbCheckBox tbCheckBox = this.q;
            if (tbCheckBox != null) {
                return tbCheckBox;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectOfficeCkb");
            return null;
        }
        return (TbCheckBox) invokeV.objValue;
    }

    public final EMTextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            EMTextView eMTextView = this.p;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeBottomTip");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final EMTextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            EMTextView eMTextView = this.m;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeHasOpen");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final ImageView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ImageView imageView = this.j;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeIcon");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final EMTextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            EMTextView eMTextView = this.n;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeOpenBtn");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final EMTextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            EMTextView eMTextView = this.l;
            if (eMTextView != null) {
                return eMTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("upgradeTip");
            return null;
        }
        return (EMTextView) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f0925d5);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.upgrade_main)");
            u((RelativeLayout) findViewById);
            View findViewById2 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.upgrade_top)");
            v((LinearLayout) findViewById2);
            View findViewById3 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d2);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.upgrade_icon)");
            B((ImageView) findViewById3);
            View findViewById4 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d3);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.upgrade_icon_title)");
            E((ImageView) findViewById4);
            View findViewById5 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d6);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.upgrade_tip)");
            D((EMTextView) findViewById5);
            View findViewById6 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d1);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.upgrade_has_open)");
            A((EMTextView) findViewById6);
            View findViewById7 = this.b.findViewById(R.id.obfuscated_res_0x7f091f84);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.select_office_ckb)");
            y((TbCheckBox) findViewById7);
            View findViewById8 = this.b.findViewById(R.id.obfuscated_res_0x7f091f85);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R.id.select_office_number)");
            x((EMTextView) findViewById8);
            View findViewById9 = this.b.findViewById(R.id.obfuscated_res_0x7f0925cf);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.upgrade_bottom_tip)");
            z((EMTextView) findViewById9);
            View findViewById10 = this.b.findViewById(R.id.obfuscated_res_0x7f09047f);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.btn_upgrade_open)");
            C((EMTextView) findViewById10);
            View findViewById11 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d0);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R.id.upgrade_content)");
            s((RelativeLayout) findViewById11);
            View findViewById12 = this.b.findViewById(R.id.obfuscated_res_0x7f0925d4);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R.id.upgrade_item)");
            t((LinearLayout) findViewById12);
            View findViewById13 = this.b.findViewById(R.id.line_view);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R.id.line_view)");
            r((ImageView) findViewById13);
            View findViewById14 = this.b.findViewById(R.id.obfuscated_res_0x7f092364);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R.id.title_bar)");
            w((NavigationBar) findViewById14);
            g().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.vn9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        zn9.o(zn9.this, view2);
                    }
                }
            });
            g().getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0622), null));
            h().setTagData(new a());
            int j = ej.j(this.a.getPageActivity());
            if (ej.l(this.a.getPageActivity()) == 1080 && j == 1920) {
                ViewGroup.LayoutParams layoutParams = f().getLayoutParams();
                if (layoutParams != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                    ViewGroup.LayoutParams layoutParams2 = f().getLayoutParams();
                    if (layoutParams2 != null) {
                        ((RelativeLayout.LayoutParams) layoutParams2).bottomMargin = 0;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            h().setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f080a52, R.drawable.obfuscated_res_0x7f080a51);
            l().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wn9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        zn9.p(zn9.this, view2);
                    }
                }
            });
            if (this.c != 2) {
                j().setVisibility(8);
            } else {
                l().setText(this.a.getString(R.string.obfuscated_res_0x7f0f08bc));
            }
            if (this.d == WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE) {
                i().setVisibility(0);
            } else {
                i().setVisibility(8);
            }
            a();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            p15 d = p15.d(m());
            d.z(R.dimen.T_X08);
            d.A(R.string.F_X01);
            d.w(R.dimen.M_T_X002);
            p15 d2 = p15.d(i());
            d2.z(R.dimen.T_X09);
            d2.w(R.dimen.M_T_X002);
            p15 d3 = p15.d(l());
            d3.z(R.dimen.T_X05);
            d3.n(R.string.J_X01);
            d3.g(SkinManager.getColor(0, (int) R.color.CAM_X0321));
            h().b();
            Iterator<yn9> it = this.t.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            k().setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08093c, false));
            c().setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08093b, false));
            e().setBackgroundResource(R.drawable.obfuscated_res_0x7f08093a);
        }
    }
}
