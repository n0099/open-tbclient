package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ky;
import com.baidu.tieba.vy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x78 extends lm<sn6, ThreadCardViewHolder<sn6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public en c;
    public cn6<sn6> d;

    /* loaded from: classes8.dex */
    public class a extends cn6<sn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x78 b;

        public a(x78 x78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, sn6 sn6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sn6Var) == null) && view2 != null && sn6Var != null && sn6Var.getThreadData() != null) {
                this.b.u(view2, sn6Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x78 a;

        public b(x78 x78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x78Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ymVar instanceof sn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sn6 sn6Var = (sn6) ymVar;
                sn6Var.f = 1;
                if (this.a.d != null) {
                    this.a.d.a(threadCardViewHolder.getView(), sn6Var);
                }
                d88.c(sn6Var, view2.getContext(), 19, false, ax.a((en) viewGroup, view2, i));
                threadCardViewHolder.b().p(new vy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x78(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = new a(this);
        this.b = tbPageContext;
    }

    public void A(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, enVar) == null) {
            this.c = enVar;
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public final void u(View view2, sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, view2, sn6Var) != null) || sn6Var == null) {
            return;
        }
        int id = view2.getId();
        if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                d88.g(sn6Var);
                return;
            }
            return;
        }
        d88.f(sn6Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.b.getPageActivity());
            bVar.l().j(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds30));
            bVar.o(new jx(this.b.getPageActivity()));
            ky k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.c);
            k.s(19);
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
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sn6 sn6Var, ThreadCardViewHolder<sn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sn6Var, threadCardViewHolder})) == null) {
            if (sn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sn6Var.a != null) {
                sn6Var.A(sn6Var.position + 1);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(sn6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.d);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
