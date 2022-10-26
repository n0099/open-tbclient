package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ez;
import com.baidu.tieba.hx;
import com.baidu.tieba.ty;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l27 extends rn implements ap5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext b;
    public g37 c;
    public String d;
    public ko e;
    public bz f;
    public p26 g;

    /* loaded from: classes4.dex */
    public class a extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 b;

        public a(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, f36 f36Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, f36Var) == null) {
                i26.b().d(true);
                yo5.c().h("page_recommend", "show_");
                if (this.b.c != null && f36Var != null && f36Var.getThreadData() != null && !StringUtils.isNull(f36Var.getThreadData().getTid())) {
                    if (f36Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(f36Var.N(f36Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !k17.b(eh.g(f36Var.getThreadData().getTid(), 0L))) {
                        k17.a(eh.g(f36Var.getThreadData().getTid(), 0L));
                        this.b.c.e(eh.g(f36Var.getThreadData().getTid(), 0L), f36Var.D(), f36Var.r(), f36Var.n(), f36Var.c(), eh.e((String) view2.getTag(), 1), "homepage", f36Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.y(view2, f36Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements hx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bz a;
        public final /* synthetic */ l27 b;

        public b(l27 l27Var, bz bzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var, bzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l27Var;
            this.a = bzVar;
        }

        @Override // com.baidu.tieba.hx.a
        public void a(ar4 ar4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, ar4Var) != null) || ar4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (ar4Var instanceof f36) {
                ar4Var.objType = 5;
                ThreadCardUtils.jumpToPB(ar4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(ar4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l27 a;

        public c(l27 l27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l27Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof f36) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                f36 f36Var = (f36) eoVar;
                f36Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), f36Var);
                }
                ThreadCardUtils.jumpToPB((ar4) f36Var, view2.getContext(), 2, false, lx.a((ko) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l27(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    public void C(g37 g37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g37Var) == null) {
            this.c = g37Var;
        }
    }

    public void D(ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, koVar) == null) {
            this.e = koVar;
        }
    }

    @Override // com.baidu.tieba.ap5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: A */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ty.b bVar = new ty.b(this.b.getPageActivity(), false);
            p37 p37Var = new p37(this.b.getPageActivity());
            p37Var.y(new b(this, p37Var));
            this.f = p37Var;
            p37Var.A(this.a);
            this.f.x("index");
            this.f.B("2001");
            bVar.n(this.f);
            ty k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, f36 f36Var, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, f36Var, autoVideoCardViewHolder})) == null) {
            if (f36Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            f36Var.I(f36Var.position + 1);
            f36Var.a.statFloor = f36Var.n();
            autoVideoCardViewHolder.a().q(i);
            f36Var.T = 0;
            i26.b().a(f36Var.B());
            autoVideoCardViewHolder.u(x(f36Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(f36Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            l37.i(f36Var.a, this.a, f36Var.n());
            l37.h(f36Var.a, f36Var.r(), f36Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        bz bzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bzVar = this.f) != null) {
            bzVar.v();
        }
    }

    public void onResume() {
        bz bzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (bzVar = this.f) != null) {
            bzVar.w();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f36.V = "c10708";
            f36.W = "c10735";
            f36.X = "c10709";
            f36.Y = "c10734";
            f36.Z = "c11929";
            f36.a0 = "c11928";
            f36.b0 = "c10756";
        }
    }

    public final kb8 x(f36 f36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, f36Var)) == null) {
            if (f36Var != null) {
                kb8 kb8Var = new kb8();
                kb8Var.a = "1";
                kb8Var.c = f36Var.g;
                if (f36Var.getThreadData() != null) {
                    kb8Var.d = String.valueOf(f36Var.getThreadData().getFid());
                    kb8Var.v = f36Var.getThreadData().getNid();
                    if (f36Var.getThreadData().getThreadVideoInfo() != null) {
                        kb8Var.m = f36Var.getThreadData().getThreadVideoInfo().video_md5;
                        kb8Var.p = String.valueOf(f36Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                kb8Var.k = f36Var.h();
                kb8Var.f = f36Var.r();
                kb8Var.l = f36Var.c();
                kb8Var.h = f36Var.D();
                kb8Var.e = TbadkCoreApplication.getCurrentAccount();
                kb8Var.q = String.valueOf(f36Var.n());
                if (f36Var.getThreadData() != null && f36Var.getThreadData().getBaijiahaoData() != null) {
                    kb8Var.t = f36Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    kb8Var.u = f36Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return kb8Var;
                }
                return kb8Var;
            }
            return null;
        }
        return (kb8) invokeL.objValue;
    }

    public final void y(View view2, f36 f36Var) {
        bz bzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, f36Var) == null) && (bzVar = this.f) != null && bzVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, f36Var);
                l37.d(f36Var.a, this.a, f36Var.n(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(f36Var.P()));
                l37.c(f36Var.a, f36Var.r(), f36Var.n(), 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09217d) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(f36Var.N(f36Var.a)));
                l37.c(f36Var.a, f36Var.r(), f36Var.n(), 1);
            }
        }
    }
}
