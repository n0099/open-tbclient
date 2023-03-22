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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.ow;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q07 extends ew6<mz4, AutoVideoCardViewHolder<ThreadData>> implements jf6, e77, jx5, kf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public String n;
    public int o;
    public c77 p;
    public lf6<ThreadData> q;

    @Override // com.baidu.tieba.jf6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.kf6
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends lf6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q07 b;

        public a(q07 q07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
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
                if (view2.getId() == R.id.thread_card_root && threadData.isVideoThreadType()) {
                    d77.k().h(this.b.p, threadData, 1);
                    this.b.f0(threadData);
                } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.header_divider) {
                        s87.a(this.b.p, threadData.getRecomReason());
                    } else if (view2.getId() == R.id.operable_video_container) {
                        threadData.cancelHighLight();
                        d77.k().h(this.b.p, threadData, 4);
                        this.b.f0(threadData);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        this.b.f0(threadData);
                    }
                } else {
                    d77.k().h(this.b.p, threadData, 2);
                }
                if (view2.getId() == R.id.operable_video_container) {
                    b77.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                    s87.g(threadData, this.b.b, 2);
                } else if (view2.getId() == R.id.video_play) {
                    b77.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                    s87.g(threadData, this.b.b, 1);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        b77.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                        s87.g(threadData, this.b.b, 1);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        b77.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                        s87.g(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        b77.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                    } else {
                        s87.g(threadData, this.b.b, 1);
                        b77.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                    }
                } else {
                    b77.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ q07 b;

        public b(q07 q07Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q07Var;
            this.a = kyVar;
        }

        @Override // com.baidu.tieba.ow.a
        public void a(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hw4Var) != null) || hw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (hw4Var instanceof ThreadData) {
                hw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(hw4Var, this.b.mContext, this.b.o, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(hw4Var, this.b.mContext, this.b.o, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q07 a;

        public c(q07 q07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q07Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) gnVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((hw4) threadData, view2.getContext(), this.a.o, false, sw.a((mn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new c77();
        this.q = new a(this);
        this.l = tbPageContext;
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.jf6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.ew6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }

    public final ey8 c0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            ey8 ey8Var = new ey8();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                ey8Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                ey8Var.a = str;
            }
            if (this.p.e == 501) {
                ey8Var.a = "frs_tab";
            }
            ey8Var.d = this.p.c;
            ey8Var.c = threadData.getTid();
            ey8Var.f = threadData.mRecomSource;
            ey8Var.g = threadData.mRecomReason;
            ey8Var.h = threadData.mRecomWeight;
            ey8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                ey8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return ey8Var;
        }
        return (ey8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: d0 */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.l.getPageActivity(), false);
            uw uwVar = new uw(this.l.getPageActivity(), true);
            uwVar.y("frs");
            uwVar.C("2003");
            uwVar.z(new b(this, uwVar));
            uwVar.A(true);
            bVar.n(uwVar);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.q(this.q);
            k.s(this.o);
            setOnAdapterItemClickListener(new c(this));
            autoVideoCardViewHolder.n(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ew6, com.baidu.tieba.tm
    /* renamed from: e0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (mz4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.a() instanceof ix5) {
                autoVideoCardViewHolder.a().b(this.m);
            }
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mz4Var, (mz4) autoVideoCardViewHolder);
            dw6.i(autoVideoCardViewHolder.a().f(), this.b);
            autoVideoCardViewHolder.u(c0(mz4Var.t));
            autoVideoCardViewHolder.a().r(i);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                mz4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.e(mz4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.q);
            if (this.p != null) {
                int i2 = 0;
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    i2 = frsViewData2.getTopThreadSize();
                }
                mz4Var.t.statFloor = (mz4Var.position + 1) - i2;
            }
            d77.k().c(this.p, mz4Var.t);
            d77.k().b(mz4Var.t);
            d77.k().e(mz4Var.t, u());
            b77.o(mz4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                b77.m(mz4Var.t, t());
                b77.n(mz4Var.t, this.b.getForum().getId());
            }
            if (100 == t().tabType) {
                d77.k().f(mz4Var.t);
            }
            mz4Var.t.updateShowStatus();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(ThreadData threadData) {
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

    @Override // com.baidu.tieba.e77
    public c77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (c77) invokeV.objValue;
    }
}
