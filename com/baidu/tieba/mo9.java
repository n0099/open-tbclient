package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mo9 extends pm<ej9, ThreadCardViewHolder<ej9>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public in d;
    public mp6<ej9> e;

    /* loaded from: classes7.dex */
    public class a extends mp6<ej9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo9 b;

        public a(mo9 mo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mo9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, ej9 ej9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ej9Var) == null) && view2 != null && ej9Var != null && ej9Var.getThreadData() != null && !TextUtils.isEmpty(ej9Var.getThreadData().getTid())) {
                this.b.y(view2, ej9Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo9 a;

        public b(mo9 mo9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mo9Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof ej9) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ej9 ej9Var = (ej9) cnVar;
                ej9Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), ej9Var);
                }
                UrlManager.getInstance().dealOneLink(ej9Var.W());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mo9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = true;
        this.e = new a(this);
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public ThreadCardViewHolder<ej9> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            bVar.l().k(false);
            bVar.o(new nx(this.b.getPageActivity()));
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.setFrom("pb");
            ayVar.y(this.c);
            ayVar.B(false);
            bVar.n(ayVar);
            qy qyVar = new qy(this.b.getPageActivity());
            h15 h15Var = new h15();
            h15Var.b = 25;
            h15Var.h = 25;
            qyVar.D(h15Var);
            qyVar.F(25);
            qyVar.K(11);
            qyVar.G(0);
            qyVar.e(32);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(0);
            ThreadCardViewHolder<ej9> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ej9 ej9Var, ThreadCardViewHolder<ej9> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ej9Var, threadCardViewHolder})) == null) {
            if (ej9Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ej9Var.a != null) {
                ej9Var.B(ej9Var.position + 1);
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.e(ej9Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.e);
                nr9.r(ej9Var, this.b, "2");
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, ej9 ej9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, ej9Var) == null) {
            if (view2.getId() != R.id.forum_head_image && view2.getId() != R.id.forum_head_barname && view2.getId() != R.id.forum_head_info_attention && view2.getId() != R.id.forum_head_info_thread) {
                if (view2.getId() == R.id.thread_card_root) {
                    nr9.p(ej9Var, 1, this.b, "2");
                    return;
                } else if (view2 instanceof TbImageView) {
                    nr9.p(ej9Var, 3, this.b, "2");
                    return;
                } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                    nr9.p(ej9Var, 1, this.b, "2");
                    return;
                } else {
                    return;
                }
            }
            nr9.p(ej9Var, 2, this.b, "2");
        }
    }
}
