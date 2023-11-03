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
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.tieba.ns;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lu7 extends pp7<hz4, AutoVideoCardViewHolder<ThreadData>> implements vl6, c18, s16, wl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public String n;
    public int o;
    public a18 p;
    public xl6<ThreadData> q;

    @Override // com.baidu.tieba.vl6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.wl6
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends xl6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lu7 b;

        public a(lu7 lu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xl6
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
                    b18.k().h(this.b.p, threadData, 1);
                    this.b.f0(threadData);
                } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.header_divider) {
                        a48.a(this.b.p, threadData.getRecomReason());
                    } else if (view2.getId() == R.id.operable_video_container) {
                        threadData.cancelHighLight();
                        b18.k().h(this.b.p, threadData, 4);
                        this.b.f0(threadData);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        this.b.f0(threadData);
                    }
                } else {
                    b18.k().h(this.b.p, threadData, 2);
                }
                if (view2.getId() == R.id.operable_video_container) {
                    z08.e(threadData, 4, this.b.mPageId, this.b.p, this.b.u());
                    a48.h(threadData, this.b.b, 2);
                } else if (view2.getId() == R.id.video_play) {
                    z08.e(threadData, 4, this.b.mPageId, this.b.p, this.b.u());
                    a48.h(threadData, this.b.b, 1);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        z08.e(threadData, 5, this.b.mPageId, this.b.p, this.b.u());
                        a48.h(threadData, this.b.b, 1);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        z08.e(threadData, 15, this.b.mPageId, this.b.p, this.b.u());
                        a48.h(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        z08.e(threadData, 14, this.b.mPageId, this.b.p, this.b.u());
                    } else {
                        a48.h(threadData, this.b.b, 1);
                        z08.e(threadData, 1, this.b.mPageId, this.b.p, this.b.u());
                    }
                } else {
                    z08.e(threadData, 2, this.b.mPageId, this.b.p, this.b.u());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ lu7 b;

        public b(lu7 lu7Var, ju juVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu7Var, juVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lu7Var;
            this.a = juVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bw4Var) != null) || bw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (bw4Var instanceof ThreadData) {
                bw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(bw4Var, this.b.mContext, this.b.o, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(bw4Var, this.b.mContext, this.b.o, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lu7 a;

        public c(lu7 lu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lu7Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof hz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((hz4) oiVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((bw4) threadData, view2.getContext(), this.a.o, false, rs.a((ui) viewGroup, view2, i));
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new a18();
        this.q = new a(this);
        this.l = tbPageContext;
    }

    @Override // com.baidu.tieba.s16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.vl6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.pp7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }

    public final f9a c0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            f9a f9aVar = new f9a();
            String str = "3";
            if (100 == u().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                f9aVar.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                f9aVar.a = str;
            }
            if (this.p.e == 501) {
                f9aVar.a = "frs_tab";
            }
            f9aVar.d = this.p.c;
            f9aVar.c = threadData.getTid();
            f9aVar.f = threadData.mRecomSource;
            f9aVar.g = threadData.mRecomReason;
            f9aVar.h = threadData.mRecomWeight;
            f9aVar.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                f9aVar.m = threadData.getThreadVideoInfo().video_md5;
            }
            return f9aVar;
        }
        return (f9a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: d0 */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.l.getPageActivity(), false);
            ts tsVar = new ts(this.l.getPageActivity(), true);
            tsVar.setFrom("frs");
            tsVar.setStageType("2003");
            tsVar.z(new b(this, tsVar));
            tsVar.A(true);
            bVar.n(tsVar);
            bu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.r(this.q);
            k.t(this.o);
            setOnAdapterItemClickListener(new c(this));
            autoVideoCardViewHolder.q(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pp7, com.baidu.tieba.bi
    /* renamed from: e0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hz4 hz4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hz4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (hz4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.a() instanceof r16) {
                autoVideoCardViewHolder.a().b(this.m);
            }
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) hz4Var, (hz4) autoVideoCardViewHolder);
            op7.i(autoVideoCardViewHolder.a().f(), this.b);
            autoVideoCardViewHolder.z(c0(hz4Var.t));
            autoVideoCardViewHolder.a().s(i);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                hz4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.e(hz4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.q);
            if (this.p != null) {
                int i2 = 0;
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    i2 = frsViewData2.getTopThreadSize();
                }
                hz4Var.t.statFloor = (hz4Var.position + 1) - i2;
            }
            b18.k().c(this.p, hz4Var.t);
            b18.k().b(hz4Var.t);
            b18.k().e(hz4Var.t, x());
            z08.p(hz4Var.t, this.mPageId, this.p, u());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                z08.n(hz4Var.t, u());
                z08.o(hz4Var.t, this.b.getForum().getId());
            }
            if (100 == u().tabType) {
                b18.k().f(hz4Var.t);
            }
            hz4Var.t.updateShowStatus();
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
            if (x()) {
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

    @Override // com.baidu.tieba.c18
    public a18 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (a18) invokeV.objValue;
    }
}
