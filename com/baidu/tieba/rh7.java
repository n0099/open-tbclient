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
import com.baidu.tieba.kt;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vt;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rh7 extends yc7<py4, AutoVideoCardViewHolder<ThreadData>> implements zj6, io7, yz5, ak6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public String n;
    public int o;
    public go7 p;
    public bk6<ThreadData> q;

    @Override // com.baidu.tieba.zj6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ak6
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends bk6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh7 b;

        public a(rh7 rh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
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
                    ho7.k().h(this.b.p, threadData, 1);
                    this.b.f0(threadData);
                } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.header_divider) {
                        fr7.a(this.b.p, threadData.getRecomReason());
                    } else if (view2.getId() == R.id.operable_video_container) {
                        threadData.cancelHighLight();
                        ho7.k().h(this.b.p, threadData, 4);
                        this.b.f0(threadData);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        this.b.f0(threadData);
                    }
                } else {
                    ho7.k().h(this.b.p, threadData, 2);
                }
                if (view2.getId() == R.id.operable_video_container) {
                    fo7.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                    fr7.h(threadData, this.b.b, 2);
                } else if (view2.getId() == R.id.video_play) {
                    fo7.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                    fr7.h(threadData, this.b.b, 1);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        fo7.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                        fr7.h(threadData, this.b.b, 1);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        fo7.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                        fr7.h(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        fo7.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                    } else {
                        fr7.h(threadData, this.b.b, 1);
                        fo7.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                    }
                } else {
                    fo7.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st a;
        public final /* synthetic */ rh7 b;

        public b(rh7 rh7Var, st stVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh7Var, stVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh7Var;
            this.a = stVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jv4Var) != null) || jv4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (jv4Var instanceof ThreadData) {
                jv4Var.objType = 5;
                ThreadCardUtils.jumpToPB(jv4Var, this.b.mContext, this.b.o, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(jv4Var, this.b.mContext, this.b.o, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh7 a;

        public c(rh7 rh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof py4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((py4) yhVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((jv4) threadData, view2.getContext(), this.a.o, false, as.a((ei) viewGroup, view2, i));
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new go7();
        this.q = new a(this);
        this.l = tbPageContext;
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.zj6
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.yc7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }

    public final aw9 c0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            aw9 aw9Var = new aw9();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                aw9Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                aw9Var.a = str;
            }
            if (this.p.e == 501) {
                aw9Var.a = "frs_tab";
            }
            aw9Var.d = this.p.c;
            aw9Var.c = threadData.getTid();
            aw9Var.f = threadData.mRecomSource;
            aw9Var.g = threadData.mRecomReason;
            aw9Var.h = threadData.mRecomWeight;
            aw9Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                aw9Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return aw9Var;
        }
        return (aw9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: d0 */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.l.getPageActivity(), false);
            cs csVar = new cs(this.l.getPageActivity(), true);
            csVar.setFrom("frs");
            csVar.setStageType("2003");
            csVar.B(new b(this, csVar));
            csVar.C(true);
            bVar.n(csVar);
            kt k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.r(this.q);
            k.t(this.o);
            setOnAdapterItemClickListener(new c(this));
            autoVideoCardViewHolder.p(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yc7, com.baidu.tieba.lh
    /* renamed from: e0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, py4 py4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (py4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.a() instanceof xz5) {
                autoVideoCardViewHolder.a().b(this.m);
            }
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) py4Var, (py4) autoVideoCardViewHolder);
            xc7.i(autoVideoCardViewHolder.a().f(), this.b);
            autoVideoCardViewHolder.y(c0(py4Var.t));
            autoVideoCardViewHolder.a().s(i);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                py4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.e(py4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.q);
            if (this.p != null) {
                int i2 = 0;
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null) {
                    i2 = frsViewData2.getTopThreadSize();
                }
                py4Var.t.statFloor = (py4Var.position + 1) - i2;
            }
            ho7.k().c(this.p, py4Var.t);
            ho7.k().b(py4Var.t);
            ho7.k().e(py4Var.t, u());
            fo7.p(py4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                fo7.n(py4Var.t, t());
                fo7.o(py4Var.t, this.b.getForum().getId());
            }
            if (100 == t().tabType) {
                ho7.k().f(py4Var.t);
            }
            py4Var.t.updateShowStatus();
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

    @Override // com.baidu.tieba.io7
    public go7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (go7) invokeV.objValue;
    }
}
