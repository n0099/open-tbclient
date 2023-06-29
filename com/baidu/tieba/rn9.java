package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public RelativeLayout c;
    public View d;
    public TextView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public pha i;
    public UserData j;
    public int k;
    public boolean l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn9 a;

        public a(rn9 rn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i == null) {
                    if (this.a.a != null) {
                        this.a.a.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                vm9 vm9Var = new vm9();
                vm9Var.a = 8;
                this.a.i.a(view2, vm9Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn9 a;

        public b(rn9 rn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "1"));
                vm9 vm9Var = new vm9();
                vm9Var.a = 40;
                Bundle bundle = new Bundle();
                vm9Var.b = bundle;
                bundle.putSerializable(UserData.TYPE_USER, this.a.j);
                if (this.a.i != null) {
                    this.a.i.a(view2, vm9Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn9 a;

        public c(rn9 rn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "2"));
            if (this.a.i != null) {
                vm9 vm9Var = new vm9();
                vm9Var.a = 9;
                this.a.i.a(view2, vm9Var);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public rn9(TbPageContext tbPageContext, View view2, View view3, boolean z) {
        this(tbPageContext, view2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, view3, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = UtilHelper.getStatusBarHeight();
        this.b = view3;
        d();
    }

    public rn9(TbPageContext tbPageContext, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.l = z;
        this.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b66);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091b64);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b68);
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b63);
        this.f = imageView;
        imageView.setOnClickListener(new a(this));
        ImageView imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b65);
        this.g = imageView2;
        imageView2.setOnClickListener(new b(this));
        ImageView imageView3 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b67);
        this.h = imageView3;
        imageView3.setOnClickListener(new c(this));
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(0);
        }
    }

    public void j(pha phaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, phaVar) == null) {
            this.i = phaVar;
        }
    }

    public void k(PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, personStatus) == null) {
            n();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            layoutParams.height = this.k;
            this.b.setLayoutParams(layoutParams);
            return;
        }
        this.b.setVisibility(8);
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public void g(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            View view2 = this.b;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            }
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
            if (this.d.getAlpha() > 0.5f) {
                z = true;
            } else {
                z = false;
            }
            m(z);
        }
    }

    public void h(float f) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            float f3 = 0.0f;
            if (f >= 0.0f || f <= 1.0f) {
                View view2 = this.b;
                if (view2 != null) {
                    view2.setAlpha(f);
                }
                this.d.setAlpha(f);
                this.e.setAlpha(f);
            }
            if (f < 0.5f) {
                f2 = 1.0f - (f * 2.0f);
            } else {
                f2 = (f * 2.0f) - 1.0f;
            }
            if (f2 > 1.0f) {
                f3 = 1.0f;
            } else if (f2 >= 0.0f) {
                f3 = f2;
            }
            this.f.setAlpha(f3);
            this.h.setAlpha(f3);
            this.g.setAlpha(f3);
        }
    }

    public void l(dm9 dm9Var, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dm9Var, personStatus) == null) {
            if (dm9Var != null && dm9Var.j() != null) {
                UserData j = dm9Var.j();
                this.j = j;
                this.e.setText(j.getName_show());
            }
            n();
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || this.f == null) {
            return;
        }
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l) {
                this.h.setVisibility(8);
                this.g.setVisibility(8);
            } else if (TbadkCoreApplication.isLogin()) {
                this.g.setVisibility(0);
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
                this.g.setVisibility(8);
            }
        }
    }
}
