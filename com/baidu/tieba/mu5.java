package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.ax;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes7.dex */
public class mu5 extends hu5<h45, AutoVideoCardViewHolder<h45>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wy g;
    public mp6<h45> h;

    /* loaded from: classes7.dex */
    public class a extends mp6<h45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mu5 b;

        public a(mu5 mu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mu5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, h45 h45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, h45Var) == null) {
                this.b.u(view2, h45Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ mu5 b;

        public b(mu5 mu5Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu5Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mu5Var;
            this.a = wyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, b15Var) != null) || b15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (b15Var instanceof h45) {
                b15Var.objType = 5;
                ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, this.b.C(), false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, this.b.C(), false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mu5 a;

        public c(mu5 mu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mu5Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof h45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                h45 h45Var = (h45) cnVar;
                h45Var.objType = 1;
                if (this.a.h != null) {
                    this.a.h.a(autoVideoCardViewHolder.getView(), h45Var);
                }
                ThreadCardUtils.jumpToPB((b15) h45Var, view2.getContext(), this.a.C(), false, ex.a((in) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu5(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_VIDEO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.h = new a(this);
    }

    public final pz9 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData != null) {
                pz9 pz9Var = new pz9();
                pz9Var.a = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                pz9Var.c = threadData.tid;
                pz9Var.f = threadData.mRecomSource;
                pz9Var.g = threadData.mRecomAbTag;
                pz9Var.h = threadData.mRecomWeight;
                pz9Var.i = "14";
                pz9Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    pz9Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    pz9Var.d = String.valueOf(threadData.getThreadData().getFid());
                    pz9Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        pz9Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        pz9Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                pz9Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() != null && threadData.getThreadData().getBaijiahaoData() != null) {
                    pz9Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                    pz9Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                    return pz9Var;
                }
                return pz9Var;
            }
            return null;
        }
        return (pz9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: R */
    public AutoVideoCardViewHolder<h45> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity(), false);
            gx gxVar = new gx(this.c.getPageActivity());
            gxVar.A(new b(this, gxVar));
            this.g = gxVar;
            gxVar.p(this.mPageId);
            this.g.setFrom(E());
            this.g.setStageType(F());
            bVar.n(this.g);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<h45> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.q(this.h);
            k.s(C());
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h45 h45Var, AutoVideoCardViewHolder<h45> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h45Var, autoVideoCardViewHolder})) == null) {
            if (h45Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            h45Var.t.statFloor = getPositionByType(i) + 1;
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.x(Q(h45Var.t));
            autoVideoCardViewHolder.e(h45Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.h);
            M(autoVideoCardViewHolder.getView(), h45Var.t, i, i);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
