package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class tb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public RoundRelativeLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb6 a;

        public a(tb6 tb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tb6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                a96.b(this.a.a, null);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                int i2 = 1;
                statisticItem.param("obj_locate", 1);
                if (this.a.k) {
                    i = 5;
                } else {
                    i = 1;
                }
                statisticItem.param("obj_type", i);
                if (!this.a.k) {
                    i2 = 3;
                }
                statisticItem.param("obj_source", i2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public tb6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02cd, (ViewGroup) null);
        this.b = inflate;
        this.c = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f3f);
        this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f55);
        this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f5b);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091f5d);
        this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091f41);
        this.f = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09101d);
        this.g.setText(R.string.obfuscated_res_0x7f0f06df);
        this.h.setText(R.string.obfuscated_res_0x7f0f06db);
        this.b.setOnClickListener(new a(this));
        this.i = fj.f(this.a.getPageActivity(), R.dimen.tbds90);
        this.j = fj.f(this.a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.c;
        int i3 = this.i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i3, i3, i3, i3, i3, i3, i3, i3});
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.k = z;
        }
    }

    public void c(d96 d96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d96Var) == null) {
            if (d96Var.isTop()) {
                if (this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                    int i = marginLayoutParams.bottomMargin;
                    int i2 = this.j;
                    if (i != i2) {
                        marginLayoutParams.bottomMargin = i2;
                        this.c.requestLayout();
                    }
                }
            } else if (this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
                if (marginLayoutParams2.bottomMargin != 0) {
                    marginLayoutParams2.bottomMargin = 0;
                    this.c.requestLayout();
                }
            }
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0206);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.d, R.drawable.obfuscated_res_0x7f080653, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.e, R.drawable.pic_mask_square_circle);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080600, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}
