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
import com.baidu.tieba.dy;
import com.baidu.tieba.oy;
import com.baidu.tieba.pw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class iv7 extends um<nh6, AutoVideoCardViewHolder<nh6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public nn c;
    public ly d;
    public hs7 e;
    public xg6<nh6> f;

    /* loaded from: classes5.dex */
    public class a extends xg6<nh6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv7 b;

        public a(iv7 iv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg6
        /* renamed from: d */
        public void a(View view2, nh6 nh6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nh6Var) == null) && view2 != null && nh6Var != null && nh6Var.getThreadData() != null) {
                this.b.A(view2, nh6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !mq7.b(gg.g(nh6Var.getThreadData().getTid(), 0L))) {
                    mq7.a(gg.g(nh6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(gg.g(nh6Var.getThreadData().getTid(), 0L), nh6Var.w(), nh6Var.k(), nh6Var.i(), nh6Var.c(), gg.e("3", 1), "video_tab", nh6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ iv7 b;

        public b(iv7 iv7Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv7Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iv7Var;
            this.a = lyVar;
        }

        @Override // com.baidu.tieba.pw.a
        public void a(jw4 jw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jw4Var) != null) || jw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (jw4Var instanceof nh6) {
                jw4Var.objType = 5;
                qv7.f((eh6) jw4Var);
                qv7.c(jw4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            qv7.f((eh6) jw4Var);
            qv7.c(jw4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv7 a;

        public c(iv7 iv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv7Var;
        }

        @Override // com.baidu.tieba.rn
        public void b(View view2, hn hnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, hnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (hnVar instanceof nh6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                nh6 nh6Var = (nh6) hnVar;
                nh6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), nh6Var);
                }
                qv7.c(nh6Var, view2.getContext(), 19, false, tw.a((nn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, nh6 nh6Var) {
        ly lyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, nh6Var) == null) && (lyVar = this.d) != null && lyVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                qv7.h(nh6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                qv7.f(nh6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(hs7 hs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hs7Var) == null) {
            this.e = hs7Var;
        }
    }

    public void F(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nnVar) == null) {
            this.c = nnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: B */
    public AutoVideoCardViewHolder<nh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.a.getPageActivity(), false);
            vw vwVar = new vw(this.a.getPageActivity());
            vwVar.z(new b(this, vwVar));
            this.d = vwVar;
            vwVar.B(this.b);
            this.d.y("video_tab");
            this.d.C("2001");
            bVar.n(this.d);
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<nh6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nh6 nh6Var, AutoVideoCardViewHolder<nh6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nh6Var, autoVideoCardViewHolder})) == null) {
            if (nh6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            nh6Var.E(nh6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.u(z(nh6Var));
            qv7.d(nh6Var);
            autoVideoCardViewHolder.e(nh6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (lyVar = this.d) != null) {
            lyVar.w();
        }
    }

    public final u79 z(nh6 nh6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, nh6Var)) == null) {
            if (nh6Var != null) {
                u79 u79Var = new u79();
                u79Var.a = "19";
                u79Var.c = nh6Var.g;
                if (nh6Var.getThreadData() != null) {
                    u79Var.d = String.valueOf(nh6Var.getThreadData().getFid());
                    u79Var.v = nh6Var.getThreadData().getNid();
                    if (nh6Var.getThreadData().getThreadVideoInfo() != null) {
                        u79Var.m = nh6Var.getThreadData().getThreadVideoInfo().video_md5;
                        u79Var.p = String.valueOf(nh6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                u79Var.k = nh6Var.e();
                u79Var.f = nh6Var.k();
                u79Var.l = nh6Var.c();
                u79Var.h = nh6Var.w();
                u79Var.e = TbadkCoreApplication.getCurrentAccount();
                u79Var.q = String.valueOf(nh6Var.i());
                if (nh6Var.getThreadData() != null && nh6Var.getThreadData().getBaijiahaoData() != null) {
                    u79Var.t = nh6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    u79Var.u = nh6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return u79Var;
                }
                return u79Var;
            }
            return null;
        }
        return (u79) invokeL.objValue;
    }
}
