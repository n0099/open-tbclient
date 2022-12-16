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
import com.baidu.tieba.ax;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y87 extends kn<x56, AutoVideoCardViewHolder<x56>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public Cdo c;
    public wy d;
    public a67 e;
    public h56<x56> f;

    /* loaded from: classes6.dex */
    public class a extends h56<x56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y87 b;

        public a(y87 y87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, x56 x56Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x56Var) == null) && view2 != null && x56Var != null && x56Var.getThreadData() != null) {
                this.b.y(view2, x56Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !d47.b(xg.g(x56Var.getThreadData().getTid(), 0L))) {
                    d47.a(xg.g(x56Var.getThreadData().getTid(), 0L));
                    this.b.e.e(xg.g(x56Var.getThreadData().getTid(), 0L), x56Var.z(), x56Var.o(), x56Var.m(), x56Var.c(), xg.e("3", 1), "video_tab", x56Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ y87 b;

        public b(y87 y87Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y87Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y87Var;
            this.a = wyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, vr4Var) != null) || vr4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (vr4Var instanceof x56) {
                vr4Var.objType = 5;
                g97.f((o56) vr4Var);
                g97.c(vr4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            g97.f((o56) vr4Var);
            g97.c(vr4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y87 a;

        public c(y87 y87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y87Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof x56) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x56 x56Var = (x56) xnVar;
                x56Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), x56Var);
                }
                g97.c(x56Var, view2.getContext(), 19, false, ex.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y87(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void y(View view2, x56 x56Var) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, x56Var) == null) && (wyVar = this.d) != null && wyVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                g97.h(x56Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                g97.f(x56Var);
            }
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(a67 a67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a67Var) == null) {
            this.e = a67Var;
        }
    }

    public void D(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cdo) == null) {
            this.c = cdo;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x56 x56Var, AutoVideoCardViewHolder<x56> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x56Var, autoVideoCardViewHolder})) == null) {
            if (x56Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            x56Var.I(x56Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.u(x(x56Var));
            g97.d(x56Var);
            autoVideoCardViewHolder.e(x56Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (wyVar = this.d) != null) {
            wyVar.v();
        }
    }

    public final yf8 x(x56 x56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, x56Var)) == null) {
            if (x56Var != null) {
                yf8 yf8Var = new yf8();
                yf8Var.a = "19";
                yf8Var.c = x56Var.g;
                if (x56Var.getThreadData() != null) {
                    yf8Var.d = String.valueOf(x56Var.getThreadData().getFid());
                    yf8Var.v = x56Var.getThreadData().getNid();
                    if (x56Var.getThreadData().getThreadVideoInfo() != null) {
                        yf8Var.m = x56Var.getThreadData().getThreadVideoInfo().video_md5;
                        yf8Var.p = String.valueOf(x56Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                yf8Var.k = x56Var.g();
                yf8Var.f = x56Var.o();
                yf8Var.l = x56Var.c();
                yf8Var.h = x56Var.z();
                yf8Var.e = TbadkCoreApplication.getCurrentAccount();
                yf8Var.q = String.valueOf(x56Var.m());
                if (x56Var.getThreadData() != null && x56Var.getThreadData().getBaijiahaoData() != null) {
                    yf8Var.t = x56Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    yf8Var.u = x56Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return yf8Var;
                }
                return yf8Var;
            }
            return null;
        }
        return (yf8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public AutoVideoCardViewHolder<x56> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.a.getPageActivity(), false);
            gx gxVar = new gx(this.a.getPageActivity());
            gxVar.y(new b(this, gxVar));
            this.d = gxVar;
            gxVar.A(this.b);
            this.d.x("video_tab");
            this.d.B("2001");
            bVar.n(this.d);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<x56> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
