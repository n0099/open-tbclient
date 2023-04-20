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
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.qw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jv7 extends vm<oh6, AutoVideoCardViewHolder<oh6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public on c;
    public my d;
    public is7 e;
    public yg6<oh6> f;

    /* loaded from: classes5.dex */
    public class a extends yg6<oh6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv7 b;

        public a(jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg6
        /* renamed from: d */
        public void a(View view2, oh6 oh6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, oh6Var) == null) && view2 != null && oh6Var != null && oh6Var.getThreadData() != null) {
                this.b.A(view2, oh6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !nq7.b(gg.g(oh6Var.getThreadData().getTid(), 0L))) {
                    nq7.a(gg.g(oh6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(gg.g(oh6Var.getThreadData().getTid(), 0L), oh6Var.w(), oh6Var.k(), oh6Var.i(), oh6Var.c(), gg.e("3", 1), "video_tab", oh6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ jv7 b;

        public b(jv7 jv7Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv7Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jv7Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.qw.a
        public void a(kw4 kw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, kw4Var) != null) || kw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (kw4Var instanceof oh6) {
                kw4Var.objType = 5;
                rv7.f((fh6) kw4Var);
                rv7.c(kw4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            rv7.f((fh6) kw4Var);
            rv7.c(kw4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements sn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv7 a;

        public c(jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv7Var;
        }

        @Override // com.baidu.tieba.sn
        public void b(View view2, in inVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, inVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (inVar instanceof oh6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                oh6 oh6Var = (oh6) inVar;
                oh6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), oh6Var);
                }
                rv7.c(oh6Var, view2.getContext(), 19, false, uw.a((on) viewGroup, view2, i));
                threadCardViewHolder.a().p(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jv7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, oh6 oh6Var) {
        my myVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, oh6Var) == null) && (myVar = this.d) != null && myVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                rv7.h(oh6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                rv7.f(oh6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(is7 is7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, is7Var) == null) {
            this.e = is7Var;
        }
    }

    public void F(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onVar) == null) {
            this.c = onVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: B */
    public AutoVideoCardViewHolder<oh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.a.getPageActivity(), false);
            ww wwVar = new ww(this.a.getPageActivity());
            wwVar.z(new b(this, wwVar));
            this.d = wwVar;
            wwVar.B(this.b);
            this.d.y("video_tab");
            this.d.C("2001");
            bVar.n(this.d);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<oh6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, oh6 oh6Var, AutoVideoCardViewHolder<oh6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oh6Var, autoVideoCardViewHolder})) == null) {
            if (oh6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            oh6Var.E(oh6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.u(z(oh6Var));
            rv7.d(oh6Var);
            autoVideoCardViewHolder.e(oh6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        my myVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (myVar = this.d) != null) {
            myVar.w();
        }
    }

    public final c89 z(oh6 oh6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, oh6Var)) == null) {
            if (oh6Var != null) {
                c89 c89Var = new c89();
                c89Var.a = "19";
                c89Var.c = oh6Var.g;
                if (oh6Var.getThreadData() != null) {
                    c89Var.d = String.valueOf(oh6Var.getThreadData().getFid());
                    c89Var.v = oh6Var.getThreadData().getNid();
                    if (oh6Var.getThreadData().getThreadVideoInfo() != null) {
                        c89Var.m = oh6Var.getThreadData().getThreadVideoInfo().video_md5;
                        c89Var.p = String.valueOf(oh6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                c89Var.k = oh6Var.e();
                c89Var.f = oh6Var.k();
                c89Var.l = oh6Var.c();
                c89Var.h = oh6Var.w();
                c89Var.e = TbadkCoreApplication.getCurrentAccount();
                c89Var.q = String.valueOf(oh6Var.i());
                if (oh6Var.getThreadData() != null && oh6Var.getThreadData().getBaijiahaoData() != null) {
                    c89Var.t = oh6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    c89Var.u = oh6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return c89Var;
                }
                return c89Var;
            }
            return null;
        }
        return (c89) invokeL.objValue;
    }
}
