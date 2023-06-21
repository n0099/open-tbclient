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
import com.baidu.tieba.kz;
import com.baidu.tieba.vx;
import com.baidu.tieba.vz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x08 extends jn<cp6, AutoVideoCardViewHolder<cp6>> implements k56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public t18 c;
    public String d;
    public co e;
    public sz f;
    public lo6<cp6> g;

    /* loaded from: classes8.dex */
    public class a extends lo6<cp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x08 b;

        public a(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lo6
        /* renamed from: d */
        public void a(View view2, cp6 cp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cp6Var) == null) {
                eo6.b().d(true);
                i56.c().h("page_recommend", "show_");
                if (this.b.c != null && cp6Var != null && cp6Var.getThreadData() != null && !StringUtils.isNull(cp6Var.getThreadData().getTid())) {
                    if (cp6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(cp6Var.J(cp6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !wz7.b(ug.g(cp6Var.getThreadData().getTid(), 0L))) {
                        wz7.a(ug.g(cp6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(ug.g(cp6Var.getThreadData().getTid(), 0L), cp6Var.w(), cp6Var.k(), cp6Var.i(), cp6Var.c(), ug.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, cp6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, cp6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements vx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;
        public final /* synthetic */ x08 b;

        public b(x08 x08Var, sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var, szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x08Var;
            this.a = szVar;
        }

        @Override // com.baidu.tieba.vx.a
        public void a(i15 i15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, i15Var) != null) || i15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (i15Var instanceof cp6) {
                i15Var.objType = 5;
                ThreadCardUtils.jumpToPB(i15Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(i15Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x08 a;

        public c(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x08Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof cp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                cp6 cp6Var = (cp6) wnVar;
                cp6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), cp6Var);
                }
                ThreadCardUtils.jumpToPB((i15) cp6Var, view2.getContext(), 2, false, zx.a((co) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(t18 t18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t18Var) == null) {
            this.c = t18Var;
        }
    }

    public void F(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, coVar) == null) {
            this.e = coVar;
        }
    }

    @Override // com.baidu.tieba.k56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, cp6 cp6Var) {
        sz szVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, cp6Var) == null) && (szVar = this.f) != null && szVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, cp6Var);
                y18.d(cp6Var.a, this.a, cp6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(cp6Var.L()));
                y18.c(cp6Var.a, cp6Var.k(), cp6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(cp6Var.J(cp6Var.a)));
                y18.c(cp6Var.a, cp6Var.k(), cp6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cp6.V = "c10708";
            cp6.W = "c10735";
            cp6.X = "c10709";
            cp6.Y = "c10734";
            cp6.Z = "c11929";
            cp6.a0 = "c11928";
            cp6.b0 = "c10756";
        }
    }

    public void onPause() {
        sz szVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (szVar = this.f) != null) {
            szVar.y();
        }
    }

    public void onResume() {
        sz szVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (szVar = this.f) != null) {
            szVar.z();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: C */
    public AutoVideoCardViewHolder<cp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.b.getPageActivity(), false);
            e28 e28Var = new e28(this.b.getPageActivity());
            e28Var.A(new b(this, e28Var));
            this.f = e28Var;
            e28Var.C(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            kz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<cp6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cp6 cp6Var, AutoVideoCardViewHolder<cp6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cp6Var, autoVideoCardViewHolder})) == null) {
            if (cp6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            cp6Var.B(cp6Var.position + 1);
            cp6Var.a.statFloor = cp6Var.i();
            autoVideoCardViewHolder.a().r(i);
            cp6Var.f1095T = 0;
            eo6.b().a(cp6Var.s());
            autoVideoCardViewHolder.x(z(cp6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(cp6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            y18.p(cp6Var.a, this.a, cp6Var.i());
            y18.o(cp6Var.a, cp6Var.k(), cp6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final hk9 z(cp6 cp6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cp6Var)) == null) {
            if (cp6Var != null) {
                hk9 hk9Var = new hk9();
                hk9Var.a = "1";
                hk9Var.c = cp6Var.g;
                if (cp6Var.getThreadData() != null) {
                    hk9Var.d = String.valueOf(cp6Var.getThreadData().getFid());
                    hk9Var.v = cp6Var.getThreadData().getNid();
                    if (cp6Var.getThreadData().getThreadVideoInfo() != null) {
                        hk9Var.m = cp6Var.getThreadData().getThreadVideoInfo().video_md5;
                        hk9Var.p = String.valueOf(cp6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                hk9Var.k = cp6Var.e();
                hk9Var.f = cp6Var.k();
                hk9Var.l = cp6Var.c();
                hk9Var.h = cp6Var.w();
                hk9Var.e = TbadkCoreApplication.getCurrentAccount();
                hk9Var.q = String.valueOf(cp6Var.i());
                if (cp6Var.getThreadData() != null && cp6Var.getThreadData().getBaijiahaoData() != null) {
                    hk9Var.t = cp6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    hk9Var.u = cp6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return hk9Var;
                }
                return hk9Var;
            }
            return null;
        }
        return (hk9) invokeL.objValue;
    }
}
