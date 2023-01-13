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
import com.baidu.tieba.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cx;
import com.baidu.tieba.qy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xc7 extends ln<p96, AutoVideoCardViewHolder<p96>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public eo c;
    public yy d;
    public y97 e;
    public z86<p96> f;

    /* loaded from: classes6.dex */
    public class a extends z86<p96> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc7 b;

        public a(xc7 xc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xc7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z86
        /* renamed from: d */
        public void a(View view2, p96 p96Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p96Var) == null) && view2 != null && p96Var != null && p96Var.getThreadData() != null) {
                this.b.y(view2, p96Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !c87.b(yg.g(p96Var.getThreadData().getTid(), 0L))) {
                    c87.a(yg.g(p96Var.getThreadData().getTid(), 0L));
                    this.b.e.e(yg.g(p96Var.getThreadData().getTid(), 0L), p96Var.z(), p96Var.o(), p96Var.m(), p96Var.c(), yg.e("3", 1), "video_tab", p96Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy a;
        public final /* synthetic */ xc7 b;

        public b(xc7 xc7Var, yy yyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc7Var, yyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xc7Var;
            this.a = yyVar;
        }

        @Override // com.baidu.tieba.cx.a
        public void a(fs4 fs4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, fs4Var) != null) || fs4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (fs4Var instanceof p96) {
                fs4Var.objType = 5;
                fd7.f((g96) fs4Var);
                fd7.c(fs4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            fd7.f((g96) fs4Var);
            fd7.c(fs4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc7 a;

        public c(xc7 xc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc7Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof p96) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                p96 p96Var = (p96) ynVar;
                p96Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), p96Var);
                }
                fd7.c(p96Var, view2.getContext(), 19, false, gx.a((eo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new bz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xc7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void y(View view2, p96 p96Var) {
        yy yyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, p96Var) == null) && (yyVar = this.d) != null && yyVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                fd7.h(p96Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                fd7.f(p96Var);
            }
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void C(y97 y97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y97Var) == null) {
            this.e = y97Var;
        }
    }

    public void D(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eoVar) == null) {
            this.c = eoVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p96 p96Var, AutoVideoCardViewHolder<p96> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p96Var, autoVideoCardViewHolder})) == null) {
            if (p96Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            p96Var.I(p96Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.u(x(p96Var));
            fd7.d(p96Var);
            autoVideoCardViewHolder.e(p96Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        yy yyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (yyVar = this.d) != null) {
            yyVar.v();
        }
    }

    public final qk8 x(p96 p96Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, p96Var)) == null) {
            if (p96Var != null) {
                qk8 qk8Var = new qk8();
                qk8Var.a = "19";
                qk8Var.c = p96Var.g;
                if (p96Var.getThreadData() != null) {
                    qk8Var.d = String.valueOf(p96Var.getThreadData().getFid());
                    qk8Var.v = p96Var.getThreadData().getNid();
                    if (p96Var.getThreadData().getThreadVideoInfo() != null) {
                        qk8Var.m = p96Var.getThreadData().getThreadVideoInfo().video_md5;
                        qk8Var.p = String.valueOf(p96Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                qk8Var.k = p96Var.g();
                qk8Var.f = p96Var.o();
                qk8Var.l = p96Var.c();
                qk8Var.h = p96Var.z();
                qk8Var.e = TbadkCoreApplication.getCurrentAccount();
                qk8Var.q = String.valueOf(p96Var.m());
                if (p96Var.getThreadData() != null && p96Var.getThreadData().getBaijiahaoData() != null) {
                    qk8Var.t = p96Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    qk8Var.u = p96Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return qk8Var;
                }
                return qk8Var;
            }
            return null;
        }
        return (qk8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: z */
    public AutoVideoCardViewHolder<p96> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            qy.b bVar = new qy.b(this.a.getPageActivity(), false);
            ix ixVar = new ix(this.a.getPageActivity());
            ixVar.y(new b(this, ixVar));
            this.d = ixVar;
            ixVar.A(this.b);
            this.d.x("video_tab");
            this.d.B("2001");
            bVar.n(this.d);
            qy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<p96> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }
}
