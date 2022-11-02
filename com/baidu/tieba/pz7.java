package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes5.dex */
public class pz7 extends uz7<is4, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dx7 g;
    public int h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pz7(o48 o48Var, BdUniqueId bdUniqueId) {
        super(o48Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o48Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((o48) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public PbBjhRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d015f, (ViewGroup) null), this.a.P());
            u(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
        }
    }

    public void y(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dx7Var) == null) {
            this.g = dx7Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public final void u(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbBjhRecommendViewHolder) != null) || pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.i, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.x, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.s, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.u, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.n, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.p.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.q, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.w, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.h, R.color.CAM_X0302, R.color.CAM_X0204, skinType);
            kw4.d(pbBjhRecommendViewHolder.h).i(R.color.CAM_X0205, R.color.CAM_X0204);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(xi.g(this.a.P(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.m);
        }
        pbBjhRecommendViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uz7, com.baidu.tieba.jn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, is4 is4Var, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, is4Var, pbBjhRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, is4Var, pbBjhRecommendViewHolder);
            if (is4Var == null) {
                return null;
            }
            u(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.g(is4Var);
            pbBjhRecommendViewHolder.h(this.h);
            pbBjhRecommendViewHolder.l(this.i);
            dx7 dx7Var = this.g;
            if (dx7Var != null) {
                pbBjhRecommendViewHolder.k(dx7Var.S());
                pbBjhRecommendViewHolder.j(this.g.y0());
                if (this.g.Q() != null && this.g.Q().getBaijiahaoData() != null) {
                    pbBjhRecommendViewHolder.i(this.g.Q().getBaijiahaoData().oriUgcNid);
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
                if (is4Var.threadType == 40) {
                    StatisticItem.make("c13536").param("tid", is4Var.getTid()).param("fid", is4Var.getFid()).param("obj_source", i3).param("obj_locate", is4Var.c()).param("obj_id", this.g.S()).param("obj_type", is4Var.isBjhDynamicThread() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", is4Var.getTid()).param("fid", is4Var.getFid()).param("obj_source", i3).param("obj_locate", is4Var.c()).param("obj_id", this.g.S()).eventStat();
                }
                if (this.g.y0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (is4Var.getForumData() != null) {
                        statisticItem.param("fid", is4Var.getForumData().b());
                    }
                    statisticItem.param("tid", is4Var.getTid());
                    statisticItem.param("obj_param1", is4Var.mRecomWeight);
                    statisticItem.param("obj_source", is4Var.mRecomSource);
                    statisticItem.param("obj_locate", is4Var.c());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.g.S());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (is4Var.getThreadData().getBaijiahaoData() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, is4Var.getThreadData().getBaijiahaoData().oriUgcNid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, is4Var.getThreadData().getBaijiahaoData().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, is4Var.getVideoRecStaticticType());
                    statisticItem.param("ab_tag", is4Var.mRecomAbTag);
                    statisticItem.param("extra", is4Var.mRecomExtra);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
