package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ky;
import com.baidu.tieba.vy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t28 extends lm<rn6, ThreadCardViewHolder<rn6>> implements a46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public en d;
    public b28 e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;
    public bn6<rn6> g;

    /* loaded from: classes8.dex */
    public class a extends bn6<rn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 b;

        public a(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bn6
        /* renamed from: d */
        public void a(View view2, rn6 rn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rn6Var) == null) {
                um6.b().d(true);
                if (view2 != null && rn6Var != null && rn6Var.getThreadData() != null && !StringUtils.isNull(rn6Var.getThreadData().getTid())) {
                    this.b.z(view2, rn6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t28 a;

        public b(t28 t28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t28Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ymVar instanceof rn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rn6 rn6Var = (rn6) ymVar;
                rn6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), rn6Var);
                }
                ThreadCardUtils.jumpToPB((q05) rn6Var, view2.getContext(), 2, false, ax.a((en) viewGroup, view2, i));
                threadCardViewHolder.b().p(new vy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t28(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        u();
    }

    public void A(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nEGFeedbackEventCallback) == null) {
            this.f = nEGFeedbackEventCallback;
        }
    }

    public void B(b28 b28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b28Var) == null) {
            this.e = b28Var;
        }
    }

    public void C(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, enVar) == null) {
            this.d = enVar;
        }
    }

    @Override // com.baidu.tieba.a46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
        }
    }

    public final void D(rn6 rn6Var, rn6 rn6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, rn6Var, rn6Var2) == null) && (threadData = rn6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(rn6Var2.a.getForumData().i())) {
            if (rn6Var != null && (threadData2 = rn6Var.a) != null && threadData2.getTid() != null && rn6Var.a.getForumData() != null && rn6Var.a.getForumData().i() != null && (!rn6Var.a.getTid().equals(rn6Var2.a.getTid()) || !rn6Var.a.getForumData().i().equals(rn6Var2.a.getForumData().i()))) {
                q48.h(rn6Var2.a);
            }
            if (rn6Var == null) {
                q48.h(rn6Var2.a);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            rn6.f1161T = "c10705";
            rn6.U = "c10730";
            rn6.V = "c10731";
            rn6.W = "c10704";
            rn6.X = "c10755";
            rn6.Y = "c10710";
            rn6.Z = "c10736";
            rn6.a0 = "c10737";
            rn6.b0 = "c10711";
            rn6.c0 = "c10758";
            rn6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.b.getPageActivity());
            bVar.o(new jx(this.b.getPageActivity()));
            ky k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rn6 rn6Var, ThreadCardViewHolder<rn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rn6Var, threadCardViewHolder})) == null) {
            if (rn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && rn6Var.a != null) {
                if (i == 0) {
                    y3a.a("main", true);
                }
                rn6Var.A(rn6Var.position + 1);
                rn6Var.a.statFloor = rn6Var.h();
                rn6Var.U(i);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.c);
                threadCardViewHolder.r(true, Align.ALIGN_RIGHT_TOP, this.f);
                rn6 h = threadCardViewHolder.b().h();
                boolean z = false;
                if (rn6Var.a.getForumData() != null && ((rn6Var.a.getForumData().j() && !rn6Var.a.getForumData().f()) || (rn6Var.a.getForumData().f() && rn6Var.a.getForumData().g()))) {
                    z = true;
                }
                threadCardViewHolder.l(z, true);
                threadCardViewHolder.f(rn6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                um6.b().a(rn6Var.r());
                y36.c().a(rn6Var.r());
                q48.p(rn6Var.a, this.a, rn6Var.h());
                q48.o(rn6Var.a, rn6Var.i(), rn6Var.h());
                D(h, rn6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, rn6 rn6Var) {
        int i;
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, rn6Var) == null) {
            int id = view2.getId();
            if (rn6Var == null) {
                return;
            }
            if (this.e != null && rn6Var.getThreadData() != null && rn6Var.getThreadData().isFromHomPage) {
                this.e.d(rn6Var.G(), rn6Var.getThreadData());
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (rn6Var.isVideoThreadType()) {
                    q = rn6Var.t();
                } else {
                    q = rn6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                y36.c().i("page_recommend", "clk_", q);
                i = 1;
                q48.b(rn6Var.a, rn6Var.i(), rn6Var.h());
            } else {
                TiebaStatic.log(rn6Var.f());
                y36.c().i("page_recommend", "clk_", rn6Var.f());
                i = 9;
            }
            if (i != 0) {
                q48.d(rn6Var.a, this.a, rn6Var.h(), i);
                q48.c(rn6Var.a, rn6Var.i(), rn6Var.h(), 3);
            }
        }
    }
}
