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
/* loaded from: classes6.dex */
public class n66 extends nn6<r66> {
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
    public r66 q;

    @Override // com.baidu.tieba.nn6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.ad_incentive_video_view : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n66(TbPageContext<?> tbPageContext) {
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
        x(h());
    }

    public final String r(r66 r66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, r66Var)) == null) {
            if (r66Var == null) {
                return "";
            }
            int i = r66Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(getContext() instanceof e95)) {
                return "";
            }
            return ((e95) getContext()).w0();
        }
        return (String) invokeL.objValue;
    }

    public final String t(r66 r66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, r66Var)) == null) {
            if (r66Var == null) {
                return "";
            }
            int i = r66Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(getContext() instanceof e95)) {
                return "";
            }
            return ((e95) getContext()).r1();
        }
        return (String) invokeL.objValue;
    }

    public final void u(r66 r66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r66Var) == null) && !r66Var.f()) {
            r66Var.l(true);
            int i = r66Var.b;
            if (i != 3 && i != 2) {
                if (i == 1) {
                    m66.i().m(2);
                    return;
                } else if (i == 4 || i == 5) {
                    m66.i().m(4);
                    return;
                } else {
                    return;
                }
            }
            m66.i().m(3);
        }
    }

    public final void A(r66 r66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, r66Var) != null) || r66Var == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        int i = r66Var.b;
        if (i != 3 && i != 2 && i != 1) {
            if (i == 4) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams2.leftMargin = wi.g(this.c, R.dimen.M_W_X007);
                layoutParams2.rightMargin = wi.g(this.c, R.dimen.M_W_X007);
                View view2 = this.j;
                view2.setPadding(view2.getPaddingLeft(), wi.g(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), wi.g(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(0);
                layoutParams3.height = wi.g(this.c, R.dimen.tbds16);
                this.p.setVisibility(8);
                return;
            } else if (i == 5) {
                layoutParams.leftMargin = wi.g(this.c, R.dimen.M_W_X021);
                layoutParams.rightMargin = wi.g(this.c, R.dimen.M_W_X007);
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                View view3 = this.j;
                view3.setPadding(view3.getPaddingLeft(), wi.g(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), wi.g(this.c, R.dimen.M_H_X004));
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
        view4.setPadding(view4.getPaddingLeft(), wi.g(this.c, R.dimen.M_H_X004), wi.g(this.c, R.dimen.M_H_X004), wi.g(this.c, R.dimen.M_H_X004));
        this.o.setVisibility(0);
        layoutParams3.height = wi.g(this.c, R.dimen.tbds21);
        this.p.setVisibility(8);
    }

    public final int s(r66 r66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, r66Var)) == null) {
            if (r66Var == null) {
                return 0;
            }
            int i = r66Var.b;
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

    @Override // com.baidu.tieba.nn6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            r66 r66Var = this.q;
            if (r66Var != null) {
                int i2 = r66Var.b;
                if (i2 != 3 && i2 != 2 && i2 != 1) {
                    p75.d(this.o).f(R.color.CAM_X0204);
                } else {
                    p75.d(this.o).f(R.color.transparent);
                }
            } else {
                p75.d(this.o).f(R.color.CAM_X0204);
            }
            p75.d(this.p).f(R.color.CAM_X0203);
            p75 d = p75.d(this.j);
            d.n(0);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            p75.d(this.l).x(R.color.CAM_X0107);
            p75.d(this.m).x(R.color.CAM_X0109);
            ma5 ma5Var = new ma5();
            ma5Var.t(R.color.CAM_X0304);
            this.n.setConfig(ma5Var);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            m66.i().v(this.q.b);
            m66.i().t();
            new GetIncentiveVideoTaskModel(this.c, this.q.b).c0();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", s(this.q)).param("fid", r(this.q)).param("tid", t(this.q)));
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
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
    @Override // com.baidu.tieba.nn6
    /* renamed from: y */
    public void i(r66 r66Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, r66Var) != null) || r66Var == null) {
            return;
        }
        this.q = r66Var;
        u(r66Var);
        z(r66Var);
        A(r66Var);
        this.l.setText(r66Var.getTitle());
        this.m.setText(r66Var.d());
        this.n.setText(r66Var.c());
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", s(r66Var)).param("fid", r(r66Var)).param("tid", t(r66Var)));
    }

    public final void z(r66 r66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, r66Var) == null) {
            this.k.setShowOval(true);
            this.k.setAutoChangeStyle(true);
            this.k.setStrokeWith(wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.k.setStrokeColorResId(R.color.CAM_X0401);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setPlaceHolder(1);
            this.k.N(r66Var.e(), 10, false);
        }
    }
}
