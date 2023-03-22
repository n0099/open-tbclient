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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.ow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rh7 extends tm<bg6, AutoVideoCardViewHolder<bg6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ki7 c;
    public String d;
    public mn e;
    public ky f;
    public lf6<bg6> g;

    /* loaded from: classes6.dex */
    public class a extends lf6<bg6> {
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
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, bg6 bg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bg6Var) == null) {
                ef6.b().d(true);
                hx5.c().h("page_recommend", "show_");
                if (this.b.c != null && bg6Var != null && bg6Var.getThreadData() != null && !StringUtils.isNull(bg6Var.getThreadData().getTid())) {
                    if (bg6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(bg6Var.L(bg6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !pg7.b(gg.g(bg6Var.getThreadData().getTid(), 0L))) {
                        pg7.a(gg.g(bg6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(gg.g(bg6Var.getThreadData().getTid(), 0L), bg6Var.w(), bg6Var.m(), bg6Var.k(), bg6Var.c(), gg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, bg6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, bg6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ rh7 b;

        public b(rh7 rh7Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh7Var, kyVar};
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
            this.a = kyVar;
        }

        @Override // com.baidu.tieba.ow.a
        public void a(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hw4Var) != null) || hw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (hw4Var instanceof bg6) {
                hw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(hw4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(hw4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements qn {
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

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof bg6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                bg6 bg6Var = (bg6) gnVar;
                bg6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), bg6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) bg6Var, view2.getContext(), 2, false, sw.a((mn) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ki7Var) == null) {
            this.c = ki7Var;
        }
    }

    public void F(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mnVar) == null) {
            this.e = mnVar;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, bg6 bg6Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, bg6Var) == null) && (kyVar = this.f) != null && kyVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, bg6Var);
                pi7.d(bg6Var.a, this.a, bg6Var.k(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(bg6Var.N()));
                pi7.c(bg6Var.a, bg6Var.m(), bg6Var.k(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(bg6Var.L(bg6Var.a)));
                pi7.c(bg6Var.a, bg6Var.m(), bg6Var.k(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            bg6.V = "c10708";
            bg6.W = "c10735";
            bg6.X = "c10709";
            bg6.Y = "c10734";
            bg6.Z = "c11929";
            bg6.a0 = "c11928";
            bg6.b0 = "c10756";
        }
    }

    public void onPause() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (kyVar = this.f) != null) {
            kyVar.w();
        }
    }

    public void onResume() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (kyVar = this.f) != null) {
            kyVar.x();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: C */
    public AutoVideoCardViewHolder<bg6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity(), false);
            ui7 ui7Var = new ui7(this.b.getPageActivity());
            ui7Var.z(new b(this, ui7Var));
            this.f = ui7Var;
            ui7Var.B(this.a);
            this.f.y("index");
            this.f.C("2001");
            bVar.n(this.f);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<bg6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bg6 bg6Var, AutoVideoCardViewHolder<bg6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bg6Var, autoVideoCardViewHolder})) == null) {
            if (bg6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            bg6Var.E(bg6Var.position + 1);
            bg6Var.a.statFloor = bg6Var.k();
            autoVideoCardViewHolder.a().r(i);
            bg6Var.T = 0;
            ef6.b().a(bg6Var.u());
            autoVideoCardViewHolder.u(z(bg6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(bg6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            pi7.p(bg6Var.a, this.a, bg6Var.k());
            pi7.o(bg6Var.a, bg6Var.m(), bg6Var.k());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final ey8 z(bg6 bg6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bg6Var)) == null) {
            if (bg6Var != null) {
                ey8 ey8Var = new ey8();
                ey8Var.a = "1";
                ey8Var.c = bg6Var.g;
                if (bg6Var.getThreadData() != null) {
                    ey8Var.d = String.valueOf(bg6Var.getThreadData().getFid());
                    ey8Var.v = bg6Var.getThreadData().getNid();
                    if (bg6Var.getThreadData().getThreadVideoInfo() != null) {
                        ey8Var.m = bg6Var.getThreadData().getThreadVideoInfo().video_md5;
                        ey8Var.p = String.valueOf(bg6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ey8Var.k = bg6Var.g();
                ey8Var.f = bg6Var.m();
                ey8Var.l = bg6Var.c();
                ey8Var.h = bg6Var.w();
                ey8Var.e = TbadkCoreApplication.getCurrentAccount();
                ey8Var.q = String.valueOf(bg6Var.k());
                if (bg6Var.getThreadData() != null && bg6Var.getThreadData().getBaijiahaoData() != null) {
                    ey8Var.t = bg6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    ey8Var.u = bg6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return ey8Var;
                }
                return ey8Var;
            }
            return null;
        }
        return (ey8) invokeL.objValue;
    }
}
