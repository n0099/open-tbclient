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
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pn6 extends gj6<wu4, ThreadCardViewHolder<ThreadData>> implements j46, eu6, lq5, k46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public int n;
    public l46<ThreadData> o;

    @Override // com.baidu.tieba.j46
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.k46
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends l46<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pn6 b;

        public a(pn6 pn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, threadData, this.b.getType());
                }
                if ("c13010".equals(this.b.l)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                    if (view2 instanceof TbImageView) {
                        if (this.b.o.a instanceof Boolean) {
                            if (((Boolean) this.b.o.a).booleanValue()) {
                                bu6.e(threadData, 1, this.b.mPageId, eu6.p0, this.b.t());
                            } else {
                                bu6.e(threadData, 3, this.b.mPageId, eu6.p0, this.b.t());
                            }
                        }
                        nv6.g(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        bu6.e(threadData, 15, this.b.mPageId, eu6.p0, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            bu6.c(threadData, this.b.b.getForum().getId());
                        }
                    } else {
                        bu6.e(threadData, 1, this.b.mPageId, eu6.p0, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            bu6.c(threadData, this.b.b.getForum().getId());
                        }
                    }
                } else {
                    bu6.e(threadData, 2, this.b.mPageId, eu6.p0, this.b.t());
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0921dd && threadData.isVideoThreadType()) {
                    this.b.Z(threadData);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f090519) {
                        nv6.a(eu6.p0, threadData.getRecomReason());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.o.a instanceof Boolean) {
                            if (((Boolean) this.b.o.a).booleanValue()) {
                                du6.k().h(eu6.p0, threadData, 1);
                            } else {
                                du6.k().h(eu6.p0, threadData, 3);
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090562) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0921df) {
                        du6.k().h(eu6.p0, threadData, 5);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().X() != null && threadData.getTopAgreePost().X().B() != null && threadData.getTopAgreePost().X().B().size() > 0) {
                            i = threadData.getTopAgreePost().N ? 9 : 8;
                        }
                        du6.k().h(eu6.p0, threadData, i);
                    } else {
                        du6.k().h(eu6.p0, threadData, 1);
                    }
                } else {
                    du6.k().h(eu6.p0, threadData, 2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(pn6 pn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(sr4 sr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, sr4Var, view2) == null) && sr4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092505) {
                    sr4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0924d7) {
                    sr4Var.objType = 4;
                } else {
                    sr4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pn6 a;

        public c(pn6 pn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pn6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof wu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((wu4) xnVar).t;
                threadData.objType = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((sr4) threadData, view2.getContext(), this.a.n, false, ex.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pn6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    @Override // com.baidu.tieba.lq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.j46
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tieba.gj6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity(), true);
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.f(4280);
            dxVar.x(this.mPageId);
            dxVar.w(new b(this));
            if (this.k) {
                bVar.l().d(0);
                bVar.l().h(0);
            }
            bVar.o(dxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.e);
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
    @Override // com.baidu.tieba.gj6, com.baidu.tieba.kn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wu4 wu4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wu4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, wu4Var, threadCardViewHolder);
            if (wu4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.m);
            threadCardViewHolder.a().q(i);
            fj6.i(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                wu4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.k(wu4Var.t.showFollowBtn(), null);
            threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, null);
            if (!wu4Var.t.isBjh() && !wu4Var.t.isWorksInfo() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.l)) {
                threadCardViewHolder.r();
            } else {
                threadCardViewHolder.f();
            }
            threadCardViewHolder.e(wu4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.o);
            wu4Var.t.updateShowStatus();
            if (eu6.p0 != null) {
                int i2 = 0;
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    i2 = frsViewData2.getTopThreadSize();
                }
                wu4Var.t.statFloor = (wu4Var.position + 1) - i2;
            }
            du6.k().c(eu6.p0, wu4Var.t);
            wu4Var.t.updateShowStatus();
            bu6.o(wu4Var.t, this.mPageId, eu6.p0, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                bu6.m(wu4Var.t, t());
                bu6.n(wu4Var.t, this.b.getForum().getId());
            }
            if (wu4Var != null) {
                wu4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void Z(ThreadData threadData) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (u()) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem param2 = param.param("obj_locate", i);
            if (threadData.getThreadAlaInfo() == null) {
                j = -1;
            } else {
                j = threadData.getThreadAlaInfo().live_id;
            }
            TiebaStatic.log(param2.param("obj_id", j).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tieba.eu6
    public cu6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return eu6.p0;
        }
        return (cu6) invokeV.objValue;
    }
}
