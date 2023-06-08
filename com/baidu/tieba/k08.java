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
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.jz;
import com.baidu.tieba.ux;
import com.baidu.tieba.uz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k08 extends in<xo6, AutoVideoCardViewHolder<xo6>> implements f56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public g18 c;
    public String d;
    public bo e;
    public rz f;
    public go6<xo6> g;

    /* loaded from: classes6.dex */
    public class a extends go6<xo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 b;

        public a(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, xo6 xo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xo6Var) == null) {
                zn6.b().d(true);
                d56.c().h("page_recommend", "show_");
                if (this.b.c != null && xo6Var != null && xo6Var.getThreadData() != null && !StringUtils.isNull(xo6Var.getThreadData().getTid())) {
                    if (xo6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(xo6Var.J(xo6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !jz7.b(tg.g(xo6Var.getThreadData().getTid(), 0L))) {
                        jz7.a(tg.g(xo6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(tg.g(xo6Var.getThreadData().getTid(), 0L), xo6Var.w(), xo6Var.k(), xo6Var.i(), xo6Var.c(), tg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, xo6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, xo6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ k08 b;

        public b(k08 k08Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k08Var;
            this.a = rzVar;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(h15 h15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, h15Var) != null) || h15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (h15Var instanceof xo6) {
                h15Var.objType = 5;
                ThreadCardUtils.jumpToPB(h15Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(h15Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 a;

        public c(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k08Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof xo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                xo6 xo6Var = (xo6) vnVar;
                xo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), xo6Var);
                }
                ThreadCardUtils.jumpToPB((h15) xo6Var, view2.getContext(), 2, false, yx.a((bo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(g18 g18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, g18Var) == null) {
            this.c = g18Var;
        }
    }

    public void F(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, boVar) == null) {
            this.e = boVar;
        }
    }

    @Override // com.baidu.tieba.f56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, xo6 xo6Var) {
        rz rzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, xo6Var) == null) && (rzVar = this.f) != null && rzVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, xo6Var);
                l18.d(xo6Var.a, this.a, xo6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(xo6Var.L()));
                l18.c(xo6Var.a, xo6Var.k(), xo6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(xo6Var.J(xo6Var.a)));
                l18.c(xo6Var.a, xo6Var.k(), xo6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xo6.V = "c10708";
            xo6.W = "c10735";
            xo6.X = "c10709";
            xo6.Y = "c10734";
            xo6.Z = "c11929";
            xo6.a0 = "c11928";
            xo6.b0 = "c10756";
        }
    }

    public void onPause() {
        rz rzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (rzVar = this.f) != null) {
            rzVar.y();
        }
    }

    public void onResume() {
        rz rzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rzVar = this.f) != null) {
            rzVar.z();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: C */
    public AutoVideoCardViewHolder<xo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.b.getPageActivity(), false);
            r18 r18Var = new r18(this.b.getPageActivity());
            r18Var.A(new b(this, r18Var));
            this.f = r18Var;
            r18Var.C(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            jz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<xo6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xo6 xo6Var, AutoVideoCardViewHolder<xo6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xo6Var, autoVideoCardViewHolder})) == null) {
            if (xo6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            xo6Var.B(xo6Var.position + 1);
            xo6Var.a.statFloor = xo6Var.i();
            autoVideoCardViewHolder.a().r(i);
            xo6Var.f1190T = 0;
            zn6.b().a(xo6Var.s());
            autoVideoCardViewHolder.x(z(xo6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(xo6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            l18.p(xo6Var.a, this.a, xo6Var.i());
            l18.o(xo6Var.a, xo6Var.k(), xo6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final dj9 z(xo6 xo6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, xo6Var)) == null) {
            if (xo6Var != null) {
                dj9 dj9Var = new dj9();
                dj9Var.a = "1";
                dj9Var.c = xo6Var.g;
                if (xo6Var.getThreadData() != null) {
                    dj9Var.d = String.valueOf(xo6Var.getThreadData().getFid());
                    dj9Var.v = xo6Var.getThreadData().getNid();
                    if (xo6Var.getThreadData().getThreadVideoInfo() != null) {
                        dj9Var.m = xo6Var.getThreadData().getThreadVideoInfo().video_md5;
                        dj9Var.p = String.valueOf(xo6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                dj9Var.k = xo6Var.e();
                dj9Var.f = xo6Var.k();
                dj9Var.l = xo6Var.c();
                dj9Var.h = xo6Var.w();
                dj9Var.e = TbadkCoreApplication.getCurrentAccount();
                dj9Var.q = String.valueOf(xo6Var.i());
                if (xo6Var.getThreadData() != null && xo6Var.getThreadData().getBaijiahaoData() != null) {
                    dj9Var.t = xo6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    dj9Var.u = xo6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return dj9Var;
                }
                return dj9Var;
            }
            return null;
        }
        return (dj9) invokeL.objValue;
    }
}
