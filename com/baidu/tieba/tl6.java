package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ez;
import com.baidu.tieba.hx;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.ty;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tl6 extends kh6 implements n26, js6, ap5, o26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext l;
    public String m;
    public String n;
    public int o;
    public hs6 p;
    public p26 q;

    @Override // com.baidu.tieba.n26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.o26
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 b;

        public a(tl6 tl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, threadData, ThreadData.TYPE_VIDEO);
                }
                if ("c13010".equals(this.b.n)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09217d && threadData.isVideoThreadType()) {
                    is6.k().h(this.b.p, threadData, 1);
                    this.b.d0(threadData);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090554) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() != R.id.obfuscated_res_0x7f0924a1 && view2.getId() != R.id.obfuscated_res_0x7f092473) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f090d56) {
                        tt6.a(this.b.p, threadData.getRecomReason());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091738) {
                        threadData.cancelHighLight();
                        is6.k().h(this.b.p, threadData, 4);
                        this.b.d0(threadData);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        this.b.d0(threadData);
                    }
                } else {
                    is6.k().h(this.b.p, threadData, 2);
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f091738) {
                    gs6.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                    tt6.g(threadData, this.b.b, 2);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092541) {
                    gs6.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                    tt6.g(threadData, this.b.b, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f0924a1 && view2.getId() != R.id.obfuscated_res_0x7f092473) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f092191) {
                        gs6.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                        tt6.g(threadData, this.b.b, 1);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        gs6.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                        tt6.g(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091e97) {
                        gs6.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                    } else {
                        tt6.g(threadData, this.b.b, 1);
                        gs6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                    }
                } else {
                    gs6.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz a;
        public final /* synthetic */ tl6 b;

        public b(tl6 tl6Var, bz bzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var, bzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl6Var;
            this.a = bzVar;
        }

        @Override // com.baidu.tieba.hx.a
        public void a(ar4 ar4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ar4Var) != null) || ar4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (ar4Var instanceof ThreadData) {
                ar4Var.objType = 5;
                ThreadCardUtils.jumpToPB(ar4Var, this.b.mContext, this.b.o, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(ar4Var, this.b.mContext, this.b.o, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 a;

        public c(tl6 tl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl6Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof du4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((du4) eoVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((ar4) threadData, view2.getContext(), this.a.o, false, lx.a((ko) viewGroup, view2, i));
                threadCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tl6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 3;
        this.p = new hs6();
        this.q = new a(this);
        this.l = tbPageContext;
    }

    @Override // com.baidu.tieba.ap5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.n26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.kh6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }

    public final kb8 a0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            kb8 kb8Var = new kb8();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                kb8Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                kb8Var.a = str;
            }
            if (this.p.e == 501) {
                kb8Var.a = "frs_tab";
            }
            kb8Var.d = this.p.c;
            kb8Var.c = threadData.getTid();
            kb8Var.f = threadData.mRecomSource;
            kb8Var.g = threadData.mRecomReason;
            kb8Var.h = threadData.mRecomWeight;
            kb8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                kb8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return kb8Var;
        }
        return (kb8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: b0 */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ty.b bVar = new ty.b(this.l.getPageActivity(), false);
            nx nxVar = new nx(this.l.getPageActivity(), true);
            nxVar.x("frs");
            nxVar.B("2003");
            nxVar.y(new b(this, nxVar));
            if (this.o == 502) {
                nxVar.z(false);
            } else {
                nxVar.z(true);
            }
            bVar.n(nxVar);
            ty k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.p(this.q);
            k.r(this.o);
            setOnAdapterItemClickListener(new c(this));
            autoVideoCardViewHolder.n(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6, com.baidu.tieba.rn
    /* renamed from: c0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, du4 du4Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, du4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (du4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.a() instanceof zo5) {
                autoVideoCardViewHolder.a().b(this.m);
            }
            super.onFillViewHolder(i, view2, viewGroup, du4Var, autoVideoCardViewHolder);
            jh6.i(autoVideoCardViewHolder.a().f(), this.b);
            autoVideoCardViewHolder.u(a0(du4Var.t));
            autoVideoCardViewHolder.a().q(i);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                du4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.e(du4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.q);
            if (this.p != null) {
                int i2 = 0;
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    i2 = frsViewData2.getTopThreadSize();
                }
                du4Var.t.statFloor = (du4Var.position + 1) - i2;
            }
            is6.k().c(this.p, du4Var.t);
            is6.k().b(du4Var.t);
            is6.k().e(du4Var.t, u());
            gs6.o(du4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                gs6.m(du4Var.t, t());
                gs6.n(du4Var.t, this.b.getForum().getId());
            }
            if (100 == t().tabType) {
                is6.k().f(du4Var.t);
            }
            du4Var.t.updateShowStatus();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(ThreadData threadData) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
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

    @Override // com.baidu.tieba.js6
    public hs6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (hs6) invokeV.objValue;
    }
}
