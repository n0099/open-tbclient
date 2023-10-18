package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qv7 extends lh<rk6, ThreadCardViewHolder<rk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public ei d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;
    public bk6<rk6> f;

    /* loaded from: classes7.dex */
    public class a extends bk6<rk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv7 b;

        public a(qv7 qv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, rk6 rk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rk6Var) == null) {
                tj6.b().d(true);
                if (view2 != null && rk6Var != null && rk6Var.getThreadData() != null && !StringUtils.isNull(rk6Var.getThreadData().getTid())) {
                    this.b.z(view2, rk6Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv7 a;

        public b(qv7 qv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qv7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof rk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rk6 rk6Var = (rk6) yhVar;
                rk6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), rk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) rk6Var, view2.getContext(), 2, false, as.a((ei) viewGroup, view2, i));
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eiVar) == null) {
            this.d = eiVar;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rk6.f1159T = "c10705";
            rk6.U = "c10730";
            rk6.V = "c10731";
            rk6.W = "c10704";
            rk6.X = "c10755";
            rk6.Y = "c10710";
            rk6.Z = "c10736";
            rk6.a0 = "c10737";
            rk6.b0 = "c10711";
            rk6.c0 = "c10758";
            rk6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity());
            bVar.o(new js(this.b.getPageActivity()));
            kt k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rk6 rk6Var, ThreadCardViewHolder<rk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rk6Var, threadCardViewHolder})) == null) {
            if (rk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && rk6Var.a != null) {
                rk6Var.A(rk6Var.position + 1);
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.r(false, Align.ALIGN_RIGHT_TOP, this.e);
                threadCardViewHolder.e(rk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.f);
                tj6.b().a(rk6Var.r());
                wz5.c().a(rk6Var.r());
                k28.p(rk6Var.a, this.a, rk6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, rk6 rk6Var) {
        int i;
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, rk6Var) == null) {
            int id = view2.getId();
            if (rk6Var == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                if (rk6Var.isVideoThreadType()) {
                    q = rk6Var.t();
                } else {
                    q = rk6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                wz5.c().i("page_concern", "clk_", q);
                i = 1;
            } else {
                TiebaStatic.log(rk6Var.f());
                wz5.c().i("page_concern", "clk_", rk6Var.f());
                i = 9;
            }
            if (i != 0) {
                k28.d(rk6Var.a, this.a, rk6Var.h(), i);
            }
        }
    }
}
