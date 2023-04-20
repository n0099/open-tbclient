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
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yq7 extends vm<nh6, ThreadCardViewHolder<nh6>> implements qy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public on d;
    public NEGFeedBackView.b e;
    public yg6<nh6> f;

    /* loaded from: classes7.dex */
    public class a extends yg6<nh6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq7 b;

        public a(yq7 yq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg6
        /* renamed from: d */
        public void a(View view2, nh6 nh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nh6Var) == null) {
                rg6.b().d(true);
                if (view2 != null && nh6Var != null && nh6Var.getThreadData() != null && !StringUtils.isNull(nh6Var.getThreadData().getTid())) {
                    this.b.z(view2, nh6Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements sn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yq7 a;

        public b(yq7 yq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yq7Var;
        }

        @Override // com.baidu.tieba.sn
        public void b(View view2, in inVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, inVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (inVar instanceof nh6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                nh6 nh6Var = (nh6) inVar;
                nh6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), nh6Var);
                }
                ThreadCardUtils.jumpToPB((kw4) nh6Var, view2.getContext(), 2, false, uw.a((on) viewGroup, view2, i));
                threadCardViewHolder.a().p(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = tbPageContext;
        u();
    }

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void B(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onVar) == null) {
            this.d = onVar;
        }
    }

    @Override // com.baidu.tieba.qy5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public final void C(nh6 nh6Var, nh6 nh6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nh6Var, nh6Var2) == null) && (threadData = nh6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(nh6Var2.a.getForumData().g())) {
            if (nh6Var != null && (threadData2 = nh6Var.a) != null && threadData2.getTid() != null && nh6Var.a.getForumData() != null && nh6Var.a.getForumData().g() != null && (!nh6Var.a.getTid().equals(nh6Var2.a.getTid()) || !nh6Var.a.getForumData().g().equals(nh6Var2.a.getForumData().g()))) {
                ns7.h(nh6Var2.a);
            }
            if (nh6Var == null) {
                ns7.h(nh6Var2.a);
            }
        }
    }

    public final void z(View view2, nh6 nh6Var) {
        int i;
        StatisticItem s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, nh6Var) == null) {
            int id = view2.getId();
            if (nh6Var == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (nh6Var.isVideoThreadType()) {
                    s = nh6Var.v();
                } else {
                    s = nh6Var.s();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(s));
                oy5.c().i("page_recommend", "clk_", s);
                i = 1;
                ns7.b(nh6Var.a, nh6Var.k(), nh6Var.i());
            } else {
                TiebaStatic.log(nh6Var.f());
                oy5.c().i("page_recommend", "clk_", nh6Var.f());
                i = 9;
            }
            if (i != 0) {
                ns7.d(nh6Var.a, this.a, nh6Var.i(), i);
                ns7.c(nh6Var.a, nh6Var.k(), nh6Var.i(), 3);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            nh6.S = "c10705";
            nh6.T = "c10730";
            nh6.U = "c10731";
            nh6.V = "c10704";
            nh6.W = "c10755";
            nh6.X = "c10710";
            nh6.Y = "c10736";
            nh6.Z = "c10737";
            nh6.a0 = "c10711";
            nh6.b0 = "c10758";
            nh6.c0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.b.getPageActivity());
            bVar.o(new cx(this.b.getPageActivity()));
            ey k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nh6 nh6Var, ThreadCardViewHolder<nh6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nh6Var, threadCardViewHolder})) == null) {
            if (nh6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && nh6Var.a != null) {
                if (i == 0) {
                    lf9.a("main", true);
                }
                nh6Var.E(nh6Var.position + 1);
                nh6Var.a.statFloor = nh6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.e);
                threadCardViewHolder.e(nh6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                rg6.b().a(nh6Var.u());
                oy5.c().a(nh6Var.u());
                ns7.p(nh6Var.a, this.a, nh6Var.i());
                ns7.o(nh6Var.a, nh6Var.k(), nh6Var.i());
                C(threadCardViewHolder.a().h(), nh6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
