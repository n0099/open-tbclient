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
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v37 extends jn<p46, AutoVideoCardViewHolder<p46>> implements zp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public q47 c;
    public String d;
    public co e;
    public vy f;
    public z36<p46> g;

    /* loaded from: classes6.dex */
    public class a extends z36<p46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v37 b;

        public a(v37 v37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, p46 p46Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p46Var) == null) {
                s36.b().d(true);
                xp5.c().h("page_recommend", "show_");
                if (this.b.c != null && p46Var != null && p46Var.getThreadData() != null && !StringUtils.isNull(p46Var.getThreadData().getTid())) {
                    if (p46Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p46Var.N(p46Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !t27.b(wg.g(p46Var.getThreadData().getTid(), 0L))) {
                        t27.a(wg.g(p46Var.getThreadData().getTid(), 0L));
                        this.b.c.e(wg.g(p46Var.getThreadData().getTid(), 0L), p46Var.D(), p46Var.r(), p46Var.n(), p46Var.c(), wg.e((String) view2.getTag(), 1), "homepage", p46Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.y(view2, p46Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ v37 b;

        public b(v37 v37Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v37Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, rr4Var) != null) || rr4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (rr4Var instanceof p46) {
                rr4Var.objType = 5;
                ThreadCardUtils.jumpToPB(rr4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(rr4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v37 a;

        public c(v37 v37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v37Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof p46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                p46 p46Var = (p46) wnVar;
                p46Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), p46Var);
                }
                ThreadCardUtils.jumpToPB((rr4) p46Var, view2.getContext(), 2, false, dx.a((co) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v37(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void C(q47 q47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q47Var) == null) {
            this.c = q47Var;
        }
    }

    public void D(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, coVar) == null) {
            this.e = coVar;
        }
    }

    @Override // com.baidu.tieba.zp5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: A */
    public AutoVideoCardViewHolder<p46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            z47 z47Var = new z47(this.b.getPageActivity());
            z47Var.y(new b(this, z47Var));
            this.f = z47Var;
            z47Var.A(this.a);
            this.f.x("index");
            this.f.B("2001");
            bVar.n(this.f);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<p46> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p46 p46Var, AutoVideoCardViewHolder<p46> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p46Var, autoVideoCardViewHolder})) == null) {
            if (p46Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            p46Var.I(p46Var.position + 1);
            p46Var.a.statFloor = p46Var.n();
            autoVideoCardViewHolder.a().q(i);
            p46Var.T = 0;
            s36.b().a(p46Var.B());
            autoVideoCardViewHolder.u(x(p46Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(p46Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            v47.i(p46Var.a, this.a, p46Var.n());
            v47.h(p46Var.a, p46Var.r(), p46Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (vyVar = this.f) != null) {
            vyVar.v();
        }
    }

    public void onResume() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (vyVar = this.f) != null) {
            vyVar.w();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p46.V = "c10708";
            p46.W = "c10735";
            p46.X = "c10709";
            p46.Y = "c10734";
            p46.Z = "c11929";
            p46.a0 = "c11928";
            p46.b0 = "c10756";
        }
    }

    public final uc8 x(p46 p46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, p46Var)) == null) {
            if (p46Var != null) {
                uc8 uc8Var = new uc8();
                uc8Var.a = "1";
                uc8Var.c = p46Var.g;
                if (p46Var.getThreadData() != null) {
                    uc8Var.d = String.valueOf(p46Var.getThreadData().getFid());
                    uc8Var.v = p46Var.getThreadData().getNid();
                    if (p46Var.getThreadData().getThreadVideoInfo() != null) {
                        uc8Var.m = p46Var.getThreadData().getThreadVideoInfo().video_md5;
                        uc8Var.p = String.valueOf(p46Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                uc8Var.k = p46Var.h();
                uc8Var.f = p46Var.r();
                uc8Var.l = p46Var.c();
                uc8Var.h = p46Var.D();
                uc8Var.e = TbadkCoreApplication.getCurrentAccount();
                uc8Var.q = String.valueOf(p46Var.n());
                if (p46Var.getThreadData() != null && p46Var.getThreadData().getBaijiahaoData() != null) {
                    uc8Var.t = p46Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    uc8Var.u = p46Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return uc8Var;
                }
                return uc8Var;
            }
            return null;
        }
        return (uc8) invokeL.objValue;
    }

    public final void y(View view2, p46 p46Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, p46Var) == null) && (vyVar = this.f) != null && vyVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, p46Var);
                v47.d(p46Var.a, this.a, p46Var.n(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p46Var.P()));
                v47.c(p46Var.a, p46Var.r(), p46Var.n(), 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0921d0) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p46Var.N(p46Var.a)));
                v47.c(p46Var.a, p46Var.r(), p46Var.n(), 1);
            }
        }
    }
}
