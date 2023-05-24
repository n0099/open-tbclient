package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
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
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yu7 extends en<mk6, AutoVideoCardViewHolder<mk6>> implements c16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public sv7 c;
    public String d;
    public xn e;
    public xy f;
    public wj6<mk6> g;

    /* loaded from: classes8.dex */
    public class a extends wj6<mk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 b;

        public a(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wj6
        /* renamed from: d */
        public void a(View view2, mk6 mk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mk6Var) == null) {
                pj6.b().d(true);
                a16.c().h("page_recommend", "show_");
                if (this.b.c != null && mk6Var != null && mk6Var.getThreadData() != null && !StringUtils.isNull(mk6Var.getThreadData().getTid())) {
                    if (mk6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(mk6Var.J(mk6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !wt7.b(pg.g(mk6Var.getThreadData().getTid(), 0L))) {
                        wt7.a(pg.g(mk6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(pg.g(mk6Var.getThreadData().getTid(), 0L), mk6Var.w(), mk6Var.k(), mk6Var.i(), mk6Var.c(), pg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, mk6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, mk6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy a;
        public final /* synthetic */ yu7 b;

        public b(yu7 yu7Var, xy xyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var, xyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yu7Var;
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
                ThreadCardUtils.jumpToPB(jy4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(jy4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements bo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 a;

        public c(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu7Var;
        }

        @Override // com.baidu.tieba.bo
        public void b(View view2, rn rnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, rnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (rnVar instanceof mk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                mk6 mk6Var = (mk6) rnVar;
                mk6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), mk6Var);
                }
                ThreadCardUtils.jumpToPB((jy4) mk6Var, view2.getContext(), 2, false, ex.a((xn) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new az.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.b = tbPageContext;
        B();
    }

    public void E(sv7 sv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sv7Var) == null) {
            this.c = sv7Var;
        }
    }

    public void F(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xnVar) == null) {
            this.e = xnVar;
        }
    }

    @Override // com.baidu.tieba.c16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, mk6 mk6Var) {
        xy xyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, mk6Var) == null) && (xyVar = this.f) != null && xyVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, mk6Var);
                xv7.d(mk6Var.a, this.a, mk6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(mk6Var.L()));
                xv7.c(mk6Var.a, mk6Var.k(), mk6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(mk6Var.J(mk6Var.a)));
                xv7.c(mk6Var.a, mk6Var.k(), mk6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mk6.V = "c10708";
            mk6.W = "c10735";
            mk6.X = "c10709";
            mk6.Y = "c10734";
            mk6.Z = "c11929";
            mk6.a0 = "c11928";
            mk6.b0 = "c10756";
        }
    }

    public void onPause() {
        xy xyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (xyVar = this.f) != null) {
            xyVar.y();
        }
    }

    public void onResume() {
        xy xyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (xyVar = this.f) != null) {
            xyVar.z();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: C */
    public AutoVideoCardViewHolder<mk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            py.b bVar = new py.b(this.b.getPageActivity(), false);
            cw7 cw7Var = new cw7(this.b.getPageActivity());
            cw7Var.A(new b(this, cw7Var));
            this.f = cw7Var;
            cw7Var.C(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            py k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<mk6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mk6 mk6Var, AutoVideoCardViewHolder<mk6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mk6Var, autoVideoCardViewHolder})) == null) {
            if (mk6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            mk6Var.B(mk6Var.position + 1);
            mk6Var.a.statFloor = mk6Var.i();
            autoVideoCardViewHolder.a().r(i);
            mk6Var.T = 0;
            pj6.b().a(mk6Var.s());
            autoVideoCardViewHolder.u(z(mk6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(mk6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            xv7.p(mk6Var.a, this.a, mk6Var.i());
            xv7.o(mk6Var.a, mk6Var.k(), mk6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final sc9 z(mk6 mk6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mk6Var)) == null) {
            if (mk6Var != null) {
                sc9 sc9Var = new sc9();
                sc9Var.a = "1";
                sc9Var.c = mk6Var.g;
                if (mk6Var.getThreadData() != null) {
                    sc9Var.d = String.valueOf(mk6Var.getThreadData().getFid());
                    sc9Var.v = mk6Var.getThreadData().getNid();
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
                if (mk6Var.getThreadData() != null && mk6Var.getThreadData().getBaijiahaoData() != null) {
                    sc9Var.t = mk6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    sc9Var.u = mk6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return sc9Var;
                }
                return sc9Var;
            }
            return null;
        }
        return (sc9) invokeL.objValue;
    }
}
