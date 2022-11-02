package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o77 extends jn<p46, AutoVideoCardViewHolder<p46>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public co c;
    public vy d;
    public q47 e;
    public z36<p46> f;

    /* loaded from: classes5.dex */
    public class a extends z36<p46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o77 b;

        public a(o77 o77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o77Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, p46 p46Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p46Var) == null) && view2 != null && p46Var != null && p46Var.getThreadData() != null) {
                this.b.y(view2, p46Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !t27.b(wg.g(p46Var.getThreadData().getTid(), 0L))) {
                    t27.a(wg.g(p46Var.getThreadData().getTid(), 0L));
                    this.b.e.e(wg.g(p46Var.getThreadData().getTid(), 0L), p46Var.D(), p46Var.r(), p46Var.n(), p46Var.c(), wg.e("3", 1), "video_tab", p46Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ o77 b;

        public b(o77 o77Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o77Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o77Var;
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
                w77.f((g46) rr4Var);
                w77.c(rr4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            w77.f((g46) rr4Var);
            w77.c(rr4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o77 a;

        public c(o77 o77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o77Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof p46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                p46 p46Var = (p46) wnVar;
                p46Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), p46Var);
                }
                w77.c(p46Var, view2.getContext(), 19, false, dx.a((co) viewGroup, view2, i));
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o77(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void y(View view2, p46 p46Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, p46Var) == null) && (vyVar = this.d) != null && vyVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                w77.h(p46Var);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0921d0) {
                w77.f(p46Var);
            }
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(q47 q47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q47Var) == null) {
            this.e = q47Var;
        }
    }

    public void D(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, coVar) == null) {
            this.c = coVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p46 p46Var, AutoVideoCardViewHolder<p46> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p46Var, autoVideoCardViewHolder})) == null) {
            if (p46Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            p46Var.I(p46Var.position + 1);
            autoVideoCardViewHolder.a().q(i);
            autoVideoCardViewHolder.u(x(p46Var));
            w77.d(p46Var);
            autoVideoCardViewHolder.e(p46Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (vyVar = this.d) != null) {
            vyVar.v();
        }
    }

    public final uc8 x(p46 p46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, p46Var)) == null) {
            if (p46Var != null) {
                uc8 uc8Var = new uc8();
                uc8Var.a = "19";
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: z */
    public AutoVideoCardViewHolder<p46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.a.getPageActivity(), false);
            fx fxVar = new fx(this.a.getPageActivity());
            fxVar.y(new b(this, fxVar));
            this.d = fxVar;
            fxVar.A(this.b);
            this.d.x("video_tab");
            this.d.B("2001");
            bVar.n(this.d);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<p46> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.p(this.f);
            k.r(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
