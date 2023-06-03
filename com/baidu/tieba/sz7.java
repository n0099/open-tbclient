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
import com.baidu.tieba.jz;
import com.baidu.tieba.uz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sz7 extends in<uo6, ThreadCardViewHolder<uo6>> implements d56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public bo d;
    public bz7 e;
    public NEGFeedBackView.b f;
    public eo6<uo6> g;

    /* loaded from: classes7.dex */
    public class a extends eo6<uo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz7 b;

        public a(sz7 sz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eo6
        /* renamed from: d */
        public void a(View view2, uo6 uo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uo6Var) == null) {
                xn6.b().d(true);
                if (view2 != null && uo6Var != null && uo6Var.getThreadData() != null && !StringUtils.isNull(uo6Var.getThreadData().getTid())) {
                    this.b.z(view2, uo6Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz7 a;

        public b(sz7 sz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz7Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof uo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                uo6 uo6Var = (uo6) vnVar;
                uo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), uo6Var);
                }
                ThreadCardUtils.jumpToPB((f15) uo6Var, view2.getContext(), 2, false, yx.a((bo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void B(bz7 bz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bz7Var) == null) {
            this.e = bz7Var;
        }
    }

    public void C(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, boVar) == null) {
            this.d = boVar;
        }
    }

    @Override // com.baidu.tieba.d56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
        }
    }

    public final void D(uo6 uo6Var, uo6 uo6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, uo6Var, uo6Var2) == null) && (threadData = uo6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(uo6Var2.a.getForumData().i())) {
            if (uo6Var != null && (threadData2 = uo6Var.a) != null && threadData2.getTid() != null && uo6Var.a.getForumData() != null && uo6Var.a.getForumData().i() != null && (!uo6Var.a.getTid().equals(uo6Var2.a.getTid()) || !uo6Var.a.getForumData().i().equals(uo6Var2.a.getForumData().i()))) {
                j18.h(uo6Var2.a);
            }
            if (uo6Var == null) {
                j18.h(uo6Var2.a);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            uo6.f1170T = "c10705";
            uo6.U = "c10730";
            uo6.V = "c10731";
            uo6.W = "c10704";
            uo6.X = "c10755";
            uo6.Y = "c10710";
            uo6.Z = "c10736";
            uo6.a0 = "c10737";
            uo6.b0 = "c10711";
            uo6.c0 = "c10758";
            uo6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.b.getPageActivity());
            bVar.o(new hy(this.b.getPageActivity()));
            jz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uo6 uo6Var, ThreadCardViewHolder<uo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uo6Var, threadCardViewHolder})) == null) {
            if (uo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && uo6Var.a != null) {
                if (i == 0) {
                    uq9.a("main", true);
                }
                uo6Var.B(uo6Var.position + 1);
                uo6Var.a.statFloor = uo6Var.i();
                uo6Var.a0(i);
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.f);
                uo6 h = threadCardViewHolder.a().h();
                boolean z = false;
                if (uo6Var.a.getForumData() != null && ((uo6Var.a.getForumData().j() && !uo6Var.a.getForumData().f()) || (uo6Var.a.getForumData().f() && uo6Var.a.getForumData().g()))) {
                    z = true;
                }
                threadCardViewHolder.k(z, true);
                threadCardViewHolder.e(uo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                xn6.b().a(uo6Var.s());
                b56.c().a(uo6Var.s());
                j18.p(uo6Var.a, this.a, uo6Var.i());
                j18.o(uo6Var.a, uo6Var.k(), uo6Var.i());
                D(h, uo6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, uo6 uo6Var) {
        int i;
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, view2, uo6Var) == null) {
            int id = view2.getId();
            if (uo6Var == null) {
                return;
            }
            if (this.e != null && uo6Var.getThreadData() != null && uo6Var.getThreadData().isFromHomPage) {
                this.e.d(uo6Var.J(), uo6Var.getThreadData());
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (uo6Var.isVideoThreadType()) {
                    q = uo6Var.u();
                } else {
                    q = uo6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                b56.c().i("page_recommend", "clk_", q);
                i = 1;
                j18.b(uo6Var.a, uo6Var.k(), uo6Var.i());
            } else {
                TiebaStatic.log(uo6Var.f());
                b56.c().i("page_recommend", "clk_", uo6Var.f());
                i = 9;
            }
            if (i != 0) {
                j18.d(uo6Var.a, this.a, uo6Var.i(), i);
                j18.c(uo6Var.a, uo6Var.k(), uo6Var.i(), 3);
            }
        }
    }
}
