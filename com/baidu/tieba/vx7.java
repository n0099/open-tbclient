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
/* loaded from: classes6.dex */
public class vx7 extends ay7<pr4, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jv7 g;
    public int h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vx7(t28 t28Var, BdUniqueId bdUniqueId) {
        super(t28Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t28Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((t28) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void u(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbBjhRecommendViewHolder) == null) || pbBjhRecommendViewHolder == null) {
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
            hv4.d(pbBjhRecommendViewHolder.h).i(R.color.CAM_X0205, R.color.CAM_X0204);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(ej.f(this.a.P(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.m);
        }
        pbBjhRecommendViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public PbBjhRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d015d, (ViewGroup) null), this.a.P());
            u(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ay7, com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, pr4 pr4Var, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pr4Var, pbBjhRecommendViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, pr4Var, pbBjhRecommendViewHolder);
            if (pr4Var == null) {
                return null;
            }
            u(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.g(pr4Var);
            pbBjhRecommendViewHolder.h(this.h);
            pbBjhRecommendViewHolder.l(this.i);
            jv7 jv7Var = this.g;
            if (jv7Var != null) {
                pbBjhRecommendViewHolder.k(jv7Var.Q());
                pbBjhRecommendViewHolder.j(this.g.u0());
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
                if (pr4Var.threadType == 40) {
                    StatisticItem.make("c13536").param("tid", pr4Var.getTid()).param("fid", pr4Var.getFid()).param("obj_source", i3).param("obj_locate", pr4Var.c()).param("obj_id", this.g.Q()).param("obj_type", pr4Var.isBjhDynamicThread() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", pr4Var.getTid()).param("fid", pr4Var.getFid()).param("obj_source", i3).param("obj_locate", pr4Var.c()).param("obj_id", this.g.Q()).eventStat();
                }
                if (this.g.u0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (pr4Var.getForumData() != null) {
                        statisticItem.param("fid", pr4Var.getForumData().d());
                    }
                    statisticItem.param("tid", pr4Var.getTid());
                    statisticItem.param("obj_param1", pr4Var.mRecomWeight);
                    statisticItem.param("obj_source", pr4Var.mRecomSource);
                    statisticItem.param("obj_locate", pr4Var.c());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.g.Q());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (pr4Var.getThreadData().getBaijiahaoData() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, pr4Var.getThreadData().getBaijiahaoData().oriUgcNid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, pr4Var.getThreadData().getBaijiahaoData().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, pr4Var.getVideoRecStaticticType());
                    statisticItem.param("ab_tag", pr4Var.mRecomAbTag);
                    statisticItem.param("extra", pr4Var.mRecomExtra);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
        }
    }

    public void y(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jv7Var) == null) {
            this.g = jv7Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }
}
