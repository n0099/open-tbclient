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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.xx;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes7.dex */
public class mv5 extends hv5<z45, AutoVideoCardViewHolder<z45>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz g;
    public up6<z45> h;

    /* loaded from: classes7.dex */
    public class a extends up6<z45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv5 b;

        public a(mv5 mv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mv5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z45Var) == null) {
                this.b.u(view2, z45Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz a;
        public final /* synthetic */ mv5 b;

        public b(mv5 mv5Var, uz uzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv5Var, uzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mv5Var;
            this.a = uzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, t15Var) != null) || t15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (t15Var instanceof z45) {
                t15Var.objType = 5;
                ThreadCardUtils.jumpToPB(t15Var, this.b.mContext, this.b.C(), false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(t15Var, this.b.mContext, this.b.C(), false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv5 a;

        public c(mv5 mv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mv5Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof z45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                z45 z45Var = (z45) ynVar;
                z45Var.objType = 1;
                if (this.a.h != null) {
                    this.a.h.a(autoVideoCardViewHolder.getView(), z45Var);
                }
                ThreadCardUtils.jumpToPB((t15) z45Var, view2.getContext(), this.a.C(), false, by.a((eo) viewGroup, view2, i));
                autoVideoCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mv5(TbPageContext<?> tbPageContext) {
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

    public final av9 R(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData != null) {
                av9 av9Var = new av9();
                av9Var.a = PayUVEventType.PAY_WALLET_BANNER_SHOW;
                av9Var.c = threadData.tid;
                av9Var.f = threadData.mRecomSource;
                av9Var.g = threadData.mRecomAbTag;
                av9Var.h = threadData.mRecomWeight;
                av9Var.i = "14";
                av9Var.q = String.valueOf(threadData.statFloor);
                if (threadData.getThreadVideoChannelInfo() != null) {
                    av9Var.k = String.valueOf(threadData.getThreadVideoChannelInfo().a);
                }
                if (threadData.getThreadData() != null) {
                    av9Var.d = String.valueOf(threadData.getThreadData().getFid());
                    av9Var.v = threadData.getThreadData().getNid();
                    if (threadData.getThreadData().getThreadVideoInfo() != null) {
                        av9Var.m = threadData.getThreadData().getThreadVideoInfo().video_md5;
                        av9Var.p = String.valueOf(threadData.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                av9Var.e = TbadkCoreApplication.getCurrentAccount();
                if (threadData.getThreadData() != null && threadData.getThreadData().getBaijiahaoData() != null) {
                    av9Var.t = threadData.getThreadData().getBaijiahaoData().oriUgcNid;
                    av9Var.u = threadData.getThreadData().getBaijiahaoData().oriUgcVid;
                    return av9Var;
                }
                return av9Var;
            }
            return null;
        }
        return (av9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: S */
    public AutoVideoCardViewHolder<z45> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity(), false);
            dy dyVar = new dy(this.c.getPageActivity());
            dyVar.C(new b(this, dyVar));
            this.g = dyVar;
            dyVar.r(this.mPageId);
            this.g.setFrom(E());
            this.g.setStageType(F());
            bVar.n(this.g);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<z45> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.mPageId);
            k.q(this.h);
            k.s(C());
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: T */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, z45 z45Var, AutoVideoCardViewHolder<z45> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z45Var, autoVideoCardViewHolder})) == null) {
            if (z45Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            z45Var.t.statFloor = getPositionByType(i) + 1;
            autoVideoCardViewHolder.b().r(i);
            autoVideoCardViewHolder.y(R(z45Var.t));
            autoVideoCardViewHolder.f(z45Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.h);
            N(autoVideoCardViewHolder.getView(), z45Var.t, i, i);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
