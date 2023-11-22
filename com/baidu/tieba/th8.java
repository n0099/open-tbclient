package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.tieba.ns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class th8 extends bi<pm6, AutoVideoCardViewHolder<pm6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public ui c;
    public ju d;
    public bf8 e;
    public yl6<pm6> f;

    /* loaded from: classes8.dex */
    public class a extends yl6<pm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th8 b;

        public a(th8 th8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = th8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yl6
        /* renamed from: d */
        public void a(View view2, pm6 pm6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, pm6Var) == null) && view2 != null && pm6Var != null && pm6Var.getThreadData() != null) {
                this.b.B(view2, pm6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !xc8.b(JavaTypesHelper.toLong(pm6Var.getThreadData().getTid(), 0L))) {
                    xc8.a(JavaTypesHelper.toLong(pm6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(JavaTypesHelper.toLong(pm6Var.getThreadData().getTid(), 0L), pm6Var.u(), pm6Var.i(), pm6Var.h(), pm6Var.c(), JavaTypesHelper.toInt("3", 1), "video_tab", pm6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ th8 b;

        public b(th8 th8Var, ju juVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th8Var, juVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = th8Var;
            this.a = juVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bw4Var) != null) || bw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (bw4Var instanceof pm6) {
                bw4Var.objType = 5;
                bi8.f((gm6) bw4Var);
                bi8.c(bw4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            bi8.f((gm6) bw4Var);
            bi8.c(bw4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ th8 a;

        public c(th8 th8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = th8Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof pm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                pm6 pm6Var = (pm6) oiVar;
                pm6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), pm6Var);
                }
                bi8.c(pm6Var, view2.getContext(), 19, false, rs.a((ui) viewGroup, view2, i));
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public th8(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.a = tbPageContext;
    }

    public final void B(View view2, pm6 pm6Var) {
        ju juVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, pm6Var) == null) && (juVar = this.d) != null && juVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                bi8.h(pm6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                bi8.f(pm6Var);
            }
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void F(bf8 bf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bf8Var) == null) {
            this.e = bf8Var;
        }
    }

    public void G(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uiVar) == null) {
            this.c = uiVar;
        }
    }

    public final g9a A(pm6 pm6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pm6Var)) == null) {
            if (pm6Var != null) {
                g9a g9aVar = new g9a();
                g9aVar.a = "19";
                g9aVar.c = pm6Var.g;
                if (pm6Var.getThreadData() != null) {
                    g9aVar.d = String.valueOf(pm6Var.getThreadData().getFid());
                    g9aVar.v = pm6Var.getThreadData().getNid();
                    if (pm6Var.getThreadData().getThreadVideoInfo() != null) {
                        g9aVar.m = pm6Var.getThreadData().getThreadVideoInfo().video_md5;
                        g9aVar.p = String.valueOf(pm6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                g9aVar.k = pm6Var.e();
                g9aVar.f = pm6Var.i();
                g9aVar.l = pm6Var.c();
                g9aVar.h = pm6Var.u();
                g9aVar.e = TbadkCoreApplication.getCurrentAccount();
                g9aVar.q = String.valueOf(pm6Var.h());
                if (pm6Var.getThreadData() != null && pm6Var.getThreadData().getBaijiahaoData() != null) {
                    g9aVar.t = pm6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    g9aVar.u = pm6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return g9aVar;
                }
                return g9aVar;
            }
            return null;
        }
        return (g9a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: C */
    public AutoVideoCardViewHolder<pm6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.a.getPageActivity(), false);
            ts tsVar = new ts(this.a.getPageActivity());
            tsVar.z(new b(this, tsVar));
            this.d = tsVar;
            tsVar.o(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            bu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<pm6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.r(this.f);
            k.t(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, pm6 pm6Var, AutoVideoCardViewHolder<pm6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pm6Var, autoVideoCardViewHolder})) == null) {
            if (pm6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            pm6Var.A(pm6Var.position + 1);
            autoVideoCardViewHolder.a().s(i);
            autoVideoCardViewHolder.z(A(pm6Var));
            bi8.d(pm6Var);
            autoVideoCardViewHolder.e(pm6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        ju juVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (juVar = this.d) != null) {
            juVar.x();
        }
    }
}
