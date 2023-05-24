package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ax;
import com.baidu.tieba.az;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kz8 extends en<mk6, AutoVideoCardViewHolder<mk6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public xn c;
    public xy d;
    public wj6<mk6> e;

    /* loaded from: classes6.dex */
    public class a extends wj6<mk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz8 b;

        public a(kz8 kz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wj6
        /* renamed from: d */
        public void a(View view2, mk6 mk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mk6Var) == null) {
                pj6.b().d(true);
                if (mk6Var != null && mk6Var.getThreadData() != null && !StringUtils.isNull(mk6Var.getThreadData().getTid())) {
                    if (mk6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, mk6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(mk6Var.J(mk6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy a;
        public final /* synthetic */ kz8 b;

        public b(kz8 kz8Var, xy xyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz8Var, xyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz8Var;
            this.a = xyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(jy4 jy4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jy4Var) != null) || jy4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (jy4Var instanceof mk6) {
                jy4Var.objType = 5;
                ThreadCardUtils.jumpToPB(jy4Var, this.b.mContext, 0, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(jy4Var, this.b.mContext, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz8 a;

        public c(kz8 kz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz8Var;
        }

        @Override // com.baidu.tieba.bo
        public void b(View view2, rn rnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, rnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (rnVar instanceof mk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                mk6 mk6Var = (mk6) rnVar;
                mk6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), mk6Var);
                }
                ThreadCardUtils.jumpToPB((jy4) mk6Var, view2.getContext(), mk6Var.C, false, ex.a((xn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new az.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public final void z(View view2, mk6 mk6Var) {
        xy xyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, mk6Var) == null) && (xyVar = this.d) != null && xyVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                s49.m(mk6Var, 4, this.b);
            } else if (view2.getId() == R.id.thread_card_root) {
                s49.m(mk6Var, 1, this.b);
            }
        }
    }

    public void C(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xnVar) == null) {
            this.c = xnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: A */
    public AutoVideoCardViewHolder<mk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            py.b bVar = new py.b(this.b.getPageActivity(), false);
            bVar.l().k(true);
            gx gxVar = new gx(this.b.getPageActivity());
            gxVar.C(this.a);
            gxVar.setFrom("pb");
            gxVar.A(new b(this, gxVar));
            this.d = gxVar;
            bVar.n(gxVar);
            xy xyVar = this.d;
            if (xyVar != null) {
                xyVar.setStageType("2002");
            }
            py k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<mk6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.e);
            k.s(0);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final sc9 y(mk6 mk6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mk6Var)) == null) {
            if (mk6Var != null) {
                sc9 sc9Var = new sc9();
                sc9Var.a = "6";
                sc9Var.c = mk6Var.g;
                if (mk6Var.getThreadData() != null) {
                    sc9Var.d = String.valueOf(mk6Var.getThreadData().getFid());
                    if (mk6Var.getThreadData().getThreadVideoInfo() != null) {
                        sc9Var.m = mk6Var.getThreadData().getThreadVideoInfo().video_md5;
                        sc9Var.p = String.valueOf(mk6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                sc9Var.k = mk6Var.e();
                sc9Var.f = mk6Var.k();
                sc9Var.l = mk6Var.c();
                sc9Var.h = mk6Var.w();
                sc9Var.e = TbadkCoreApplication.getCurrentAccount();
                sc9Var.q = String.valueOf(mk6Var.i());
                return sc9Var;
            }
            return null;
        }
        return (sc9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mk6 mk6Var, AutoVideoCardViewHolder<mk6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mk6Var, autoVideoCardViewHolder})) == null) {
            if (mk6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            mk6Var.B(mk6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            mk6Var.T = 0;
            autoVideoCardViewHolder.u(y(mk6Var));
            autoVideoCardViewHolder.e(mk6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.e);
            s49.n(mk6Var, this.b);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
