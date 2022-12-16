package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.ad.incentivevideo.net.GetIncentiveVideoTaskModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class is5 extends h46<ms5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public View j;
    public BarImageView k;
    public TextView l;
    public TextView m;
    public TBSpecificationBtn n;
    public View o;
    public View p;
    public ms5 q;

    @Override // com.baidu.tieba.h46
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ad_incentive_video_view : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        v(h());
    }

    public final String r(ms5 ms5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ms5Var)) == null) {
            if (ms5Var == null) {
                return "";
            }
            int i = ms5Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(getContext() instanceof hy4)) {
                return "";
            }
            return ((hy4) getContext()).f0();
        }
        return (String) invokeL.objValue;
    }

    public final String t(ms5 ms5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ms5Var)) == null) {
            if (ms5Var == null) {
                return "";
            }
            int i = ms5Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(getContext() instanceof hy4)) {
                return "";
            }
            return ((hy4) getContext()).K0();
        }
        return (String) invokeL.objValue;
    }

    public final void u(ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ms5Var) == null) && !ms5Var.i()) {
            ms5Var.p(true);
            int i = ms5Var.b;
            if (i != 3 && i != 2) {
                if (i == 1) {
                    hs5.i().m(2);
                    return;
                } else if (i == 4 || i == 5) {
                    hs5.i().m(4);
                    return;
                } else {
                    return;
                }
            }
            hs5.i().m(3);
        }
    }

    public final int s(ms5 ms5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ms5Var)) == null) {
            if (ms5Var == null) {
                return 0;
            }
            int i = ms5Var.b;
            if (i == 1) {
                return 1;
            }
            if (i != 3 && i != 2) {
                if (i != 4 && i != 5) {
                    return 0;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.h46
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            ms5 ms5Var = this.q;
            if (ms5Var != null) {
                int i2 = ms5Var.b;
                if (i2 != 3 && i2 != 2 && i2 != 1) {
                    rw4.d(this.o).f(R.color.CAM_X0204);
                } else {
                    rw4.d(this.o).f(R.color.transparent);
                }
            } else {
                rw4.d(this.o).f(R.color.CAM_X0204);
            }
            rw4.d(this.p).f(R.color.CAM_X0203);
            rw4 d = rw4.d(this.j);
            d.m(0);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            rw4.d(this.l).v(R.color.CAM_X0107);
            rw4.d(this.m).v(R.color.CAM_X0109);
            pz4 pz4Var = new pz4();
            pz4Var.r(R.color.CAM_X0304);
            this.n.setConfig(pz4Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            hs5.i().v(this.q.b);
            hs5.i().t();
            new GetIncentiveVideoTaskModel(this.c, this.q.b).O();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", s(this.q)).param("fid", r(this.q)).param("tid", t(this.q)));
        }
    }

    public final void v(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            this.o = view2.findViewById(R.id.ad_incentive_video_divide_top);
            this.p = view2.findViewById(R.id.ad_incentive_video_divide_bottom);
            this.i = view2.findViewById(R.id.ad_incentive_video_layout);
            this.j = view2.findViewById(R.id.ad_incentive_video_content_layout);
            this.k = (BarImageView) view2.findViewById(R.id.ad_incentive_video_icon);
            this.l = (TextView) view2.findViewById(R.id.ad_incentive_video_title);
            this.m = (TextView) view2.findViewById(R.id.ad_incentive_video_content);
            this.n = (TBSpecificationBtn) view2.findViewById(R.id.ad_incentive_video_btn);
            this.i.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h46
    /* renamed from: w */
    public void i(ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, ms5Var) != null) || ms5Var == null) {
            return;
        }
        this.q = ms5Var;
        u(ms5Var);
        x(ms5Var);
        y(ms5Var);
        this.l.setText(ms5Var.getTitle());
        this.m.setText(ms5Var.f());
        this.n.setText(ms5Var.c());
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", s(ms5Var)).param("fid", r(ms5Var)).param("tid", t(ms5Var)));
    }

    public final void x(ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ms5Var) == null) {
            this.k.setShowOval(true);
            this.k.setAutoChangeStyle(true);
            this.k.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.k.setStrokeColorResId(R.color.CAM_X0401);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setPlaceHolder(1);
            this.k.K(ms5Var.g(), 10, false);
        }
    }

    public final void y(ms5 ms5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ms5Var) != null) || ms5Var == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        int i = ms5Var.b;
        if (i != 3 && i != 2 && i != 1) {
            if (i == 4) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams2.leftMargin = yi.g(this.c, R.dimen.M_W_X007);
                layoutParams2.rightMargin = yi.g(this.c, R.dimen.M_W_X007);
                View view2 = this.j;
                view2.setPadding(view2.getPaddingLeft(), yi.g(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), yi.g(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(0);
                layoutParams3.height = yi.g(this.c, R.dimen.tbds16);
                this.p.setVisibility(8);
                return;
            } else if (i == 5) {
                layoutParams.leftMargin = yi.g(this.c, R.dimen.M_W_X021);
                layoutParams.rightMargin = yi.g(this.c, R.dimen.M_W_X007);
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                View view3 = this.j;
                view3.setPadding(view3.getPaddingLeft(), yi.g(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), yi.g(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(8);
                this.p.setVisibility(0);
                return;
            } else {
                return;
            }
        }
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        View view4 = this.j;
        view4.setPadding(view4.getPaddingLeft(), yi.g(this.c, R.dimen.M_H_X004), yi.g(this.c, R.dimen.M_H_X004), yi.g(this.c, R.dimen.M_H_X004));
        this.o.setVisibility(0);
        layoutParams3.height = yi.g(this.c, R.dimen.tbds21);
        this.p.setVisibility(8);
    }
}
