package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rk9 extends vk9<n15, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yh9 g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk9(aq9 aq9Var, BdUniqueId bdUniqueId) {
        super(aq9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aq9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((aq9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yh9Var) == null) {
            this.g = yh9Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: x */
    public PbBjhRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0179, (ViewGroup) null), this.a.d0());
            u(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.h = i;
        }
    }

    public final void u(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, pbBjhRecommendViewHolder) != null) || pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.h, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.q, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.s, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.l, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.n.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.o, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.t, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.u, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.g, R.color.CAM_X0302, R.color.CAM_X0204, skinType);
            EMManager.from(pbBjhRecommendViewHolder.g).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0204);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(BdUtilHelper.getDimens(this.a.d0(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.k);
        }
        pbBjhRecommendViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vk9, com.baidu.tieba.om
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n15 n15Var, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n15Var, pbBjhRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) n15Var, (n15) pbBjhRecommendViewHolder);
            if (n15Var == null) {
                return null;
            }
            u(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.g(n15Var);
            pbBjhRecommendViewHolder.h(this.h);
            yh9 yh9Var = this.g;
            if (yh9Var != null) {
                pbBjhRecommendViewHolder.k(yh9Var.Q());
                pbBjhRecommendViewHolder.j(this.g.x0());
                if (this.g.O() != null && this.g.O().getBaijiahaoData() != null) {
                    pbBjhRecommendViewHolder.i(this.g.O().getBaijiahaoData().oriUgcNid);
                }
                int i2 = this.h;
                int i3 = 3;
                if (i2 == 2) {
                    i3 = 1;
                } else if (i2 == 1) {
                    i3 = 2;
                } else if (i2 != 3) {
                    i3 = 4;
                }
                if (n15Var.threadType == 40) {
                    StatisticItem.make("c13536").param("tid", n15Var.getTid()).param("fid", n15Var.getFid()).param("obj_source", i3).param("obj_locate", n15Var.c()).param("obj_id", this.g.Q()).param("obj_type", n15Var.isBjhDynamicThread() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", n15Var.getTid()).param("fid", n15Var.getFid()).param("obj_source", i3).param("obj_locate", n15Var.c()).param("obj_id", this.g.Q()).eventStat();
                }
                if (this.g.x0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (n15Var.getForumData() != null) {
                        statisticItem.param("fid", n15Var.getForumData().b());
                    }
                    statisticItem.param("tid", n15Var.getTid());
                    statisticItem.param("obj_param1", n15Var.mRecomWeight);
                    statisticItem.param("obj_source", n15Var.mRecomSource);
                    statisticItem.param("obj_locate", n15Var.c());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.g.Q());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (n15Var.getThreadData().getBaijiahaoData() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, n15Var.getThreadData().getBaijiahaoData().oriUgcNid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, n15Var.getThreadData().getBaijiahaoData().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, n15Var.getVideoRecStaticticType());
                    statisticItem.param("ab_tag", n15Var.mRecomAbTag);
                    statisticItem.param("extra", n15Var.mRecomExtra);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
