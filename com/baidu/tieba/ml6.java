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
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ml6 extends dh6<bu4, AutoVideoCardViewHolder<ThreadData>> implements g26, ds6, to5, h26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public String n;
    public int o;
    public bs6 p;
    public i26<ThreadData> q;

    /* loaded from: classes5.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml6 b;

        public a(ml6 ml6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ml6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, threadData, ThreadData.TYPE_VIDEO);
            }
            if ("c13010".equals(this.b.n)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092181 && threadData.isVideoThreadType()) {
                cs6.k().h(this.b.p, threadData, 1);
                this.b.d0(threadData);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09054b) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0924b7 || view2.getId() == R.id.obfuscated_res_0x7f092489) {
                cs6.k().h(this.b.p, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090d49) {
                mt6.a(this.b.p, threadData.getRecomReason());
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091746) {
                threadData.cancelHighLight();
                cs6.k().h(this.b.p, threadData, 4);
                this.b.d0(threadData);
            } else if (view2 instanceof ThreadGodReplyLayout) {
                this.b.d0(threadData);
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091746) {
                as6.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                mt6.g(threadData, this.b.b, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092557) {
                as6.e(threadData, 4, this.b.mPageId, this.b.p, this.b.t());
                mt6.g(threadData, this.b.b, 1);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0924b7 && view2.getId() != R.id.obfuscated_res_0x7f092489) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092195) {
                    as6.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                    mt6.g(threadData, this.b.b, 1);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    as6.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                    mt6.g(threadData, this.b.b, 1);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091e98) {
                    mt6.g(threadData, this.b.b, 1);
                    as6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                } else {
                    as6.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                }
            } else {
                as6.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ ml6 b;

        public b(ml6 ml6Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml6Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ml6Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(yq4 yq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yq4Var) == null) || yq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(yq4Var instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, this.b.o, false, computeViewArea);
                return;
            }
            yq4Var.objType = 5;
            ThreadCardUtils.jumpToPB(yq4Var, this.b.mContext, this.b.o, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml6 a;

        public c(ml6 ml6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof bu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((bu4) cdo).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((yq4) threadData, view2.getContext(), this.a.o, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ml6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new bs6();
        this.q = new a(this);
        this.l = tbPageContext;
    }

    @Override // com.baidu.tieba.g26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final ab8 a0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            ab8 ab8Var = new ab8();
            if (100 == t().tabType) {
                ab8Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                ab8Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.p.e == 501) {
                ab8Var.a = "frs_tab";
            }
            ab8Var.d = this.p.c;
            ab8Var.c = threadData.getTid();
            ab8Var.f = threadData.mRecomSource;
            ab8Var.g = threadData.mRecomReason;
            ab8Var.h = threadData.mRecomWeight;
            ab8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                ab8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return ab8Var;
        }
        return (ab8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: b0 */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.l.getPageActivity(), false);
            mx mxVar = new mx(this.l.getPageActivity(), true);
            mxVar.u("frs");
            mxVar.y("2003");
            mxVar.v(new b(this, mxVar));
            if (this.o == 502) {
                mxVar.w(false);
            } else {
                mxVar.w(true);
            }
            bVar.n(mxVar);
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
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
    @Override // com.baidu.tieba.dh6, com.baidu.tieba.qn
    /* renamed from: c0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (bu4Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder.a() instanceof so5) {
                autoVideoCardViewHolder.a().b(this.m);
            }
            super.onFillViewHolder(i, view2, viewGroup, bu4Var, autoVideoCardViewHolder);
            ch6.i(autoVideoCardViewHolder.a().f(), this.b);
            autoVideoCardViewHolder.u(a0(bu4Var.t));
            autoVideoCardViewHolder.a().q(i);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                bu4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.e(bu4Var.t);
            autoVideoCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.q);
            if (this.p != null) {
                FrsViewData frsViewData2 = this.b;
                bu4Var.t.statFloor = (bu4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            cs6.k().c(this.p, bu4Var.t);
            cs6.k().b(bu4Var.t);
            cs6.k().e(bu4Var.t, u());
            as6.o(bu4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                as6.m(bu4Var.t, t());
                as6.n(bu4Var.t, this.b.getForum().getId());
            }
            if (100 == t().tabType) {
                cs6.k().f(bu4Var.t);
            }
            bu4Var.t.updateShowStatus();
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void d0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", u() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.ds6
    public bs6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (bs6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h26
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.g26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.dh6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n = str;
        }
    }
}
