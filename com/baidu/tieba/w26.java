package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes8.dex */
public class w26 extends zk6<a36> {
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
    public a36 q;

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ad_incentive_video_view : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w26(TbPageContext<?> tbPageContext) {
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
        z(i());
    }

    public final String p(a36 a36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, a36Var)) == null) {
            if (a36Var == null) {
                return "";
            }
            int i = a36Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(c() instanceof i45)) {
                return "";
            }
            return ((i45) c()).i0();
        }
        return (String) invokeL.objValue;
    }

    public final String x(a36 a36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, a36Var)) == null) {
            if (a36Var == null) {
                return "";
            }
            int i = a36Var.b;
            if ((i != 3 && i != 2 && i != 4 && i != 5) || !(c() instanceof i45)) {
                return "";
            }
            return ((i45) c()).k1();
        }
        return (String) invokeL.objValue;
    }

    public final void y(a36 a36Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, a36Var) == null) && !a36Var.f()) {
            a36Var.l(true);
            int i = a36Var.b;
            if (i != 3 && i != 2) {
                if (i == 1) {
                    v26.i().m(2);
                    return;
                } else if (i == 4 || i == 5) {
                    v26.i().m(4);
                    return;
                } else {
                    return;
                }
            }
            v26.i().m(3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: A */
    public void k(a36 a36Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, a36Var) != null) || a36Var == null) {
            return;
        }
        this.q = a36Var;
        y(a36Var);
        B(a36Var);
        C(a36Var);
        this.l.setText(a36Var.getTitle());
        this.m.setText(a36Var.d());
        this.n.setText(a36Var.c());
        l(this.b, TbadkCoreApplication.getInst().getSkinType());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", r(a36Var)).param("fid", p(a36Var)).param("tid", x(a36Var)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            v26.i().v(this.q.b);
            v26.i().t();
            new GetIncentiveVideoTaskModel(this.c, this.q.b).W();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_CARD_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", r(this.q)).param("fid", p(this.q)).param("tid", x(this.q)));
        }
    }

    public final void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
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

    public final void B(a36 a36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a36Var) == null) {
            this.k.setShowOval(true);
            this.k.setAutoChangeStyle(true);
            this.k.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.k.setStrokeColorResId(R.color.CAM_X0401);
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setPlaceHolder(1);
            this.k.startLoad(a36Var.e(), 10, false);
        }
    }

    public final void C(a36 a36Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a36Var) != null) || a36Var == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        int i = a36Var.b;
        if (i != 3 && i != 2 && i != 1) {
            if (i == 4) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X007);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X007);
                View view2 = this.j;
                view2.setPadding(view2.getPaddingLeft(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004));
                this.o.setVisibility(0);
                layoutParams3.height = BdUtilHelper.getDimens(this.c, R.dimen.tbds16);
                this.p.setVisibility(8);
                return;
            } else if (i == 5) {
                layoutParams.leftMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X021);
                layoutParams.rightMargin = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X007);
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                View view3 = this.j;
                view3.setPadding(view3.getPaddingLeft(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), this.j.getPaddingRight(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004));
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
        view4.setPadding(view4.getPaddingLeft(), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004), BdUtilHelper.getDimens(this.c, R.dimen.M_H_X004));
        this.o.setVisibility(0);
        layoutParams3.height = BdUtilHelper.getDimens(this.c, R.dimen.tbds21);
        this.p.setVisibility(8);
    }

    public final int r(a36 a36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a36Var)) == null) {
            if (a36Var == null) {
                return 0;
            }
            int i = a36Var.b;
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

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            a36 a36Var = this.q;
            if (a36Var != null) {
                int i2 = a36Var.b;
                if (i2 != 3 && i2 != 2 && i2 != 1) {
                    EMManager.from(this.o).setBackGroundColor(R.color.CAM_X0204);
                } else {
                    EMManager.from(this.o).setBackGroundColor(R.color.transparent);
                }
            } else {
                EMManager.from(this.o).setBackGroundColor(R.color.CAM_X0204);
            }
            EMManager.from(this.p).setBackGroundColor(R.color.CAM_X0203);
            EMManager.from(this.j).setCardType(0).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.m).setTextColor(R.color.CAM_X0109);
            v55 v55Var = new v55();
            v55Var.u(R.color.CAM_X0304);
            this.n.setConfig(v55Var);
        }
    }
}
