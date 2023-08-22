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
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p48 extends om<zo6, ThreadCardViewHolder<zo6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public hn d;
    public x38 e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;
    public jo6<zo6> g;

    /* loaded from: classes7.dex */
    public class a extends jo6<zo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p48 b;

        public a(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, zo6 zo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zo6Var) == null) {
                co6.b().d(true);
                if (view2 != null && zo6Var != null && zo6Var.getThreadData() != null && !StringUtils.isNull(zo6Var.getThreadData().getTid())) {
                    this.b.z(view2, zo6Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p48 a;

        public b(p48 p48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p48Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof zo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zo6 zo6Var = (zo6) bnVar;
                zo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), zo6Var);
                }
                ThreadCardUtils.jumpToPB((w05) zo6Var, view2.getContext(), 2, false, dx.a((hn) viewGroup, view2, i));
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void B(x38 x38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x38Var) == null) {
            this.e = x38Var;
        }
    }

    public void C(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hnVar) == null) {
            this.d = hnVar;
        }
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
        }
    }

    public final void D(zo6 zo6Var, zo6 zo6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, zo6Var, zo6Var2) == null) && (threadData = zo6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(zo6Var2.a.getForumData().i())) {
            if (zo6Var != null && (threadData2 = zo6Var.a) != null && threadData2.getTid() != null && zo6Var.a.getForumData() != null && zo6Var.a.getForumData().i() != null && (!zo6Var.a.getTid().equals(zo6Var2.a.getTid()) || !zo6Var.a.getForumData().i().equals(zo6Var2.a.getForumData().i()))) {
                m68.h(zo6Var2.a);
            }
            if (zo6Var == null) {
                m68.h(zo6Var2.a);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            zo6.f1193T = "c10705";
            zo6.U = "c10730";
            zo6.V = "c10731";
            zo6.W = "c10704";
            zo6.X = "c10755";
            zo6.Y = "c10710";
            zo6.Z = "c10736";
            zo6.a0 = "c10737";
            zo6.b0 = "c10711";
            zo6.c0 = "c10758";
            zo6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity());
            bVar.o(new mx(this.b.getPageActivity()));
            ny k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zo6 zo6Var, ThreadCardViewHolder<zo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zo6Var, threadCardViewHolder})) == null) {
            if (zo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && zo6Var.a != null) {
                if (i == 0) {
                    e8a.a("main", true);
                }
                zo6Var.A(zo6Var.position + 1);
                zo6Var.a.statFloor = zo6Var.h();
                zo6Var.U(i);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.c);
                threadCardViewHolder.r(true, Align.ALIGN_RIGHT_TOP, this.f);
                zo6 h = threadCardViewHolder.b().h();
                boolean z = false;
                if (zo6Var.a.getForumData() != null && ((zo6Var.a.getForumData().j() && !zo6Var.a.getForumData().f()) || (zo6Var.a.getForumData().f() && zo6Var.a.getForumData().g()))) {
                    z = true;
                }
                threadCardViewHolder.l(z, true);
                threadCardViewHolder.f(zo6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                co6.b().a(zo6Var.r());
                q46.c().a(zo6Var.r());
                m68.p(zo6Var.a, this.a, zo6Var.h());
                m68.o(zo6Var.a, zo6Var.i(), zo6Var.h());
                D(h, zo6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, zo6 zo6Var) {
        int i;
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, zo6Var) == null) {
            int id = view2.getId();
            if (zo6Var == null) {
                return;
            }
            if (this.e != null && zo6Var.getThreadData() != null && zo6Var.getThreadData().isFromHomPage) {
                this.e.d(zo6Var.G(), zo6Var.getThreadData());
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (zo6Var.isVideoThreadType()) {
                    q = zo6Var.t();
                } else {
                    q = zo6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                q46.c().i("page_recommend", "clk_", q);
                i = 1;
                m68.b(zo6Var.a, zo6Var.i(), zo6Var.h());
            } else {
                TiebaStatic.log(zo6Var.f());
                q46.c().i("page_recommend", "clk_", zo6Var.f());
                i = 9;
            }
            if (i != 0) {
                m68.d(zo6Var.a, this.a, zo6Var.h(), i);
                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 3);
            }
        }
    }
}
