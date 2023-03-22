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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.ow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ll7 extends tm<bg6, AutoVideoCardViewHolder<bg6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public mn c;
    public ky d;
    public ki7 e;
    public lf6<bg6> f;

    /* loaded from: classes5.dex */
    public class a extends lf6<bg6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 b;

        public a(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ll7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, bg6 bg6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bg6Var) == null) && view2 != null && bg6Var != null && bg6Var.getThreadData() != null) {
                this.b.A(view2, bg6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !pg7.b(gg.g(bg6Var.getThreadData().getTid(), 0L))) {
                    pg7.a(gg.g(bg6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(gg.g(bg6Var.getThreadData().getTid(), 0L), bg6Var.w(), bg6Var.m(), bg6Var.k(), bg6Var.c(), gg.e("3", 1), "video_tab", bg6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ ll7 b;

        public b(ll7 ll7Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ll7Var;
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
                tl7.f((sf6) hw4Var);
                tl7.c(hw4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            tl7.f((sf6) hw4Var);
            tl7.c(hw4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll7 a;

        public c(ll7 ll7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof bg6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                bg6 bg6Var = (bg6) gnVar;
                bg6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), bg6Var);
                }
                tl7.c(bg6Var, view2.getContext(), 19, false, sw.a((mn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ll7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, bg6 bg6Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, bg6Var) == null) && (kyVar = this.d) != null && kyVar.t() != null && this.d.t().getMainView() != null) {
            if (view2.getId() == this.d.t().getMainView().getId()) {
                tl7.h(bg6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                tl7.f(bg6Var);
            }
        }
    }

    public void D(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void E(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ki7Var) == null) {
            this.e = ki7Var;
        }
    }

    public void F(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mnVar) == null) {
            this.c = mnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: B */
    public AutoVideoCardViewHolder<bg6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.a.getPageActivity(), false);
            uw uwVar = new uw(this.a.getPageActivity());
            uwVar.z(new b(this, uwVar));
            this.d = uwVar;
            uwVar.B(this.b);
            this.d.y("video_tab");
            this.d.C("2001");
            bVar.n(this.d);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<bg6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.q(this.f);
            k.s(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bg6 bg6Var, AutoVideoCardViewHolder<bg6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bg6Var, autoVideoCardViewHolder})) == null) {
            if (bg6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            bg6Var.E(bg6Var.position + 1);
            autoVideoCardViewHolder.a().r(i);
            autoVideoCardViewHolder.u(z(bg6Var));
            tl7.d(bg6Var);
            autoVideoCardViewHolder.e(bg6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (kyVar = this.d) != null) {
            kyVar.w();
        }
    }

    public final ey8 z(bg6 bg6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bg6Var)) == null) {
            if (bg6Var != null) {
                ey8 ey8Var = new ey8();
                ey8Var.a = "19";
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
