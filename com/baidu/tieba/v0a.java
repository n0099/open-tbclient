package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v0a extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public BaseFragment a;
    public View b;
    public FlowLayout c;
    public EMTextView d;
    public EMTextView e;
    public EMTextView f;
    public EMTextView g;
    public EMTextView h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public LinearLayout r;
    public TextSizeSeekBar s;
    public EMTextView t;
    public View u;
    public View.OnClickListener v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188354, "Lcom/baidu/tieba/v0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188354, "Lcom/baidu/tieba/v0a;");
                return;
            }
        }
        B = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    public TextView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.p;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.n;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (TextView) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.t;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.h;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0a(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = null;
        this.v = null;
        this.a = baseFragment;
        this.v = onClickListener;
        N();
    }

    public void W(boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.w = z2;
            EMTextView eMTextView = this.o;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
            if (z2) {
                this.o.setText(R.string.group_info_intro_more);
            } else {
                this.o.setText(R.string.view_host);
            }
            h0(this.o, z2, R.drawable.obfuscated_res_0x7f080bb2, R.drawable.obfuscated_res_0x7f080bc3);
        }
    }

    public void Z(boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.y = z2;
            EMTextView eMTextView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
            if (z2) {
                this.m.setText(R.string.obfuscated_res_0x7f0f1017);
            } else {
                this.m.setText(R.string.commit_good);
            }
            h0(this.m, z2, R.drawable.obfuscated_res_0x7f080bb5, R.drawable.obfuscated_res_0x7f080bb4);
        }
    }

    public void a0(boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.x = z2;
            EMTextView eMTextView = this.j;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
            if (z2) {
                this.j.setText(R.string.obfuscated_res_0x7f0f1018);
            } else {
                this.j.setText(R.string.obfuscated_res_0x7f0f1719);
            }
            h0(this.j, z2, R.drawable.obfuscated_res_0x7f080bd3, R.drawable.obfuscated_res_0x7f080bd2);
        }
    }

    public void e0(boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
            if (z2) {
                this.k.setText(R.string.view_reverse);
            } else {
                this.k.setText(R.string.default_sort);
            }
            this.k.setText(R.string.sort_selector);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07dd, (ViewGroup) null);
            this.b = inflate;
            this.c = (FlowLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091bf7);
            EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c05);
            this.o = eMTextView;
            eMTextView.setOnClickListener(this.v);
            EMTextView eMTextView2 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c0c);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this.v);
            EMTextView eMTextView3 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c06);
            this.d = eMTextView3;
            eMTextView3.setOnClickListener(this.v);
            EMTextView eMTextView4 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c09);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(this.v);
            EMTextView eMTextView5 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c07);
            this.e = eMTextView5;
            eMTextView5.setOnClickListener(this.v);
            EMTextView eMTextView6 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c01);
            this.f = eMTextView6;
            eMTextView6.setOnClickListener(this.v);
            EMTextView eMTextView7 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c0b);
            this.n = eMTextView7;
            eMTextView7.setOnClickListener(this.v);
            EMTextView eMTextView8 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c00);
            this.g = eMTextView8;
            eMTextView8.setOnClickListener(this.v);
            EMTextView eMTextView9 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c02);
            this.h = eMTextView9;
            eMTextView9.setOnClickListener(this.v);
            EMTextView eMTextView10 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c03);
            this.i = eMTextView10;
            eMTextView10.setOnClickListener(this.v);
            EMTextView eMTextView11 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c08);
            this.j = eMTextView11;
            eMTextView11.setOnClickListener(this.v);
            EMTextView eMTextView12 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091bff);
            this.m = eMTextView12;
            eMTextView12.setOnClickListener(this.v);
            EMTextView eMTextView13 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c0a);
            this.p = eMTextView13;
            eMTextView13.setOnClickListener(this.v);
            EMTextView eMTextView14 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c04);
            this.q = eMTextView14;
            eMTextView14.setOnClickListener(this.v);
            this.s = (TextSizeSeekBar) this.b.findViewById(R.id.obfuscated_res_0x7f091bfc);
            this.r = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09231d);
            EMTextView eMTextView15 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091bf6);
            this.t = eMTextView15;
            eMTextView15.setOnClickListener(this.v);
            this.u = this.b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
            if (!O()) {
                X();
            }
        }
    }

    public void Q() {
        int i;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0213);
            EMManager.from(this.r).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.u, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.t, R.color.CAM_X0213);
            SkinManager.setViewTextColorSelector(this.t, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getBaseFragmentActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (O()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.c.setHorizontalSpacing(i);
            g0(this.d, R.drawable.obfuscated_res_0x7f080bc5);
            EMTextView eMTextView = this.n;
            int i2 = R.drawable.icon_pure_pb_recommend_report30;
            g0(eMTextView, R.drawable.icon_pure_pb_recommend_report30);
            g0(this.e, R.drawable.obfuscated_res_0x7f080bc4);
            g0(this.f, R.drawable.obfuscated_res_0x7f080bc0);
            EMTextView eMTextView2 = this.f;
            if (TbSingleton.getInstance().mCanCallFans) {
                f = 1.0f;
            } else {
                f = 0.33f;
            }
            eMTextView2.setAlpha(f);
            g0(this.g, R.drawable.icon_pure_pb_shield30);
            EMTextView eMTextView3 = this.h;
            if (!this.A) {
                i2 = R.drawable.icon_pure_pb_recommend_delete30;
            }
            g0(eMTextView3, i2);
            g0(this.i, R.drawable.icon_pure_pb_recommend_block30);
            g0(this.p, R.drawable.obfuscated_res_0x7f080bcc);
            g0(this.q, R.drawable.obfuscated_res_0x7f080bc1);
            g0(this.k, R.drawable.obfuscated_res_0x7f080bd1);
            h0(this.o, this.w, R.drawable.obfuscated_res_0x7f080bb2, R.drawable.obfuscated_res_0x7f080bc3);
            h0(this.j, this.x, R.drawable.obfuscated_res_0x7f080bd3, R.drawable.obfuscated_res_0x7f080bd2);
            h0(this.m, this.y, R.drawable.obfuscated_res_0x7f080bb5, R.drawable.obfuscated_res_0x7f080bb4);
            h0(this.l, this.z, R.drawable.obfuscated_res_0x7f080bbb, R.drawable.obfuscated_res_0x7f080bc8);
            TextSizeSeekBar textSizeSeekBar = this.s;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.e();
            }
        }
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.a.getBaseFragmentActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i % 160 != 0 && (i * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            EMTextView eMTextView = this.g;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void S(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            EMTextView eMTextView = this.f;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void T(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            EMTextView eMTextView = this.h;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void U(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            EMTextView eMTextView = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void Y(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            EMTextView eMTextView = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void c0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            EMTextView eMTextView = this.p;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void d0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            EMTextView eMTextView = this.n;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void f0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            EMTextView eMTextView = this.d;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void i0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            TextSizeSeekBar textSizeSeekBar = this.s;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textSizeSeekBar.setVisibility(i);
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            MaskView.c(this.m, z);
            MaskView.c(this.j, z);
            MaskView.c(this.f, z);
        }
    }

    public void V(boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            EMTextView eMTextView = this.q;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
            if (z2) {
                this.q.setText(R.string.heating_thread);
            } else {
                this.q.setText(R.string.help_heating_thread);
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.o.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.d.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.e.getLayoutParams().width = 201;
            this.f.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.g.getLayoutParams().width = 201;
            this.h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            this.q.getLayoutParams().width = 201;
        }
    }

    public void b0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.z = z2;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            int i = 8;
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                EMTextView eMTextView = this.l;
                if (z) {
                    i = 0;
                }
                eMTextView.setVisibility(i);
                if (z2) {
                    this.l.setText(R.string.normal_mode);
                } else {
                    this.l.setText(R.string.eyeshield_mode);
                }
                h0(this.l, z2, R.drawable.obfuscated_res_0x7f080bbb, R.drawable.obfuscated_res_0x7f080bc8);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public final void g0(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048608, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = B;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public final void h0(TextView textView, boolean z, @DrawableRes int i, @DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{textView, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            if (!z) {
                i = i2;
            }
            g0(textView, i);
        }
    }
}
