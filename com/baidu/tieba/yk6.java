package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yk6 extends qg6<ot4, ThreadCardViewHolder<ThreadData>> implements t16, pr6, go5, u16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public int n;
    public v16<ThreadData> o;

    /* loaded from: classes6.dex */
    public class a extends v16<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk6 b;

        public a(yk6 yk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, threadData, this.b.getType());
            }
            if ("c13010".equals(this.b.l)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0924b4 && view2.getId() != R.id.obfuscated_res_0x7f092486) {
                if (view2 instanceof TbImageView) {
                    if (this.b.o.a instanceof Boolean) {
                        if (((Boolean) this.b.o.a).booleanValue()) {
                            mr6.e(threadData, 1, this.b.mPageId, pr6.p0, this.b.t());
                        } else {
                            mr6.e(threadData, 3, this.b.mPageId, pr6.p0, this.b.t());
                        }
                    }
                    ys6.g(threadData, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mr6.e(threadData, 15, this.b.mPageId, pr6.p0, this.b.t());
                    if (this.b.b != null && this.b.b.getForum() != null) {
                        mr6.c(threadData, this.b.b.getForum().getId());
                    }
                } else {
                    mr6.e(threadData, 1, this.b.mPageId, pr6.p0, this.b.t());
                    if (this.b.b != null && this.b.b.getForum() != null) {
                        mr6.c(threadData, this.b.b.getForum().getId());
                    }
                }
            } else {
                mr6.e(threadData, 2, this.b.mPageId, pr6.p0, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09217e && threadData.isVideoThreadType()) {
                this.b.Z(threadData);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0924b4 && view2.getId() != R.id.obfuscated_res_0x7f092486) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090502) {
                    ys6.a(pr6.p0, threadData.getRecomReason());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.o.a instanceof Boolean) {
                        if (((Boolean) this.b.o.a).booleanValue()) {
                            or6.k().h(pr6.p0, threadData, 1);
                        } else {
                            or6.k().h(pr6.p0, threadData, 3);
                        }
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09054b) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092180) {
                    or6.k().h(pr6.p0, threadData, 5);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().W() != null && threadData.getTopAgreePost().W().B() != null && threadData.getTopAgreePost().W().B().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    or6.k().h(pr6.p0, threadData, i);
                } else {
                    or6.k().h(pr6.p0, threadData, 1);
                }
            } else {
                or6.k().h(pr6.p0, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(yk6 yk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(lq4 lq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, lq4Var, view2) == null) || lq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b4) {
                lq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092486) {
                lq4Var.objType = 4;
            } else {
                lq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk6 a;

        public c(yk6 yk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ot4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((ot4) cdo).t;
                threadData.objType = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((lq4) threadData, view2.getContext(), this.a.n, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yk6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.o = new a(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity(), true);
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.c(4280);
            jxVar.u(this.mPageId);
            jxVar.t(new b(this));
            if (this.k) {
                bVar.l().d(0);
                bVar.l().h(0);
            }
            bVar.o(jxVar);
            sy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.e);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            threadCardViewHolder.n(false);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qg6, com.baidu.tieba.qn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ot4 ot4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ot4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, ot4Var, threadCardViewHolder);
            if (ot4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.m);
            threadCardViewHolder.a().q(i);
            pg6.i(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                ot4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.k(ot4Var.t.showFollowBtn(), null);
            threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, null);
            if (!ot4Var.t.isBjh() && !ot4Var.t.isWorksInfo() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.l)) {
                threadCardViewHolder.r();
            } else {
                threadCardViewHolder.f();
            }
            threadCardViewHolder.e(ot4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.o);
            ot4Var.t.updateShowStatus();
            if (pr6.p0 != null) {
                FrsViewData frsViewData2 = this.b;
                ot4Var.t.statFloor = (ot4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            or6.k().c(pr6.p0, ot4Var.t);
            ot4Var.t.updateShowStatus();
            mr6.o(ot4Var.t, this.mPageId, pr6.p0, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                mr6.m(ot4Var.t, t());
                mr6.n(ot4Var.t, this.b.getForum().getId());
            }
            if (ot4Var != null) {
                ot4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void Z(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", u() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tieba.t16
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.pr6
    public nr6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? pr6.p0 : (nr6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u16
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.t16
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tieba.qg6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }
}
