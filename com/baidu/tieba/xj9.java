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
import com.baidu.tieba.mz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xj9 extends ln<df9, ThreadCardViewHolder<df9>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public eo d;
    public up6<df9> e;

    /* loaded from: classes8.dex */
    public class a extends up6<df9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj9 b;

        public a(xj9 xj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xj9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, df9 df9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, df9Var) == null) && view2 != null && df9Var != null && df9Var.getThreadData() != null && !TextUtils.isEmpty(df9Var.getThreadData().getTid())) {
                this.b.y(view2, df9Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj9 a;

        public b(xj9 xj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj9Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof df9) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                df9 df9Var = (df9) ynVar;
                df9Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), df9Var);
                }
                UrlManager.getInstance().dealOneLink(df9Var.c0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public ThreadCardViewHolder<df9> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            bVar.l().k(false);
            bVar.o(new ky(this.b.getPageActivity()));
            xy xyVar = new xy(this.b.getPageActivity());
            xyVar.setFrom("pb");
            xyVar.A(this.c);
            xyVar.C(false);
            bVar.n(xyVar);
            oz ozVar = new oz(this.b.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 25;
            z15Var.h = 25;
            ozVar.D(z15Var);
            ozVar.F(25);
            ozVar.L(11);
            ozVar.G(0);
            ozVar.g(32);
            bVar.m(ozVar);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(0);
            ThreadCardViewHolder<df9> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, df9 df9Var, ThreadCardViewHolder<df9> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, df9Var, threadCardViewHolder})) == null) {
            if (df9Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && df9Var.a != null) {
                df9Var.B(df9Var.position + 1);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(df9Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.e);
                xm9.p(df9Var, this.b, "2");
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, df9 df9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, df9Var) == null) {
            if (view2.getId() != R.id.forum_head_image && view2.getId() != R.id.forum_head_barname && view2.getId() != R.id.forum_head_info_attention && view2.getId() != R.id.forum_head_info_thread) {
                if (view2.getId() == R.id.thread_card_root) {
                    xm9.n(df9Var, 1, this.b, "2");
                    return;
                } else if (view2 instanceof TbImageView) {
                    xm9.n(df9Var, 3, this.b, "2");
                    return;
                } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                    xm9.n(df9Var, 1, this.b, "2");
                    return;
                } else {
                    return;
                }
            }
            xm9.n(df9Var, 2, this.b, "2");
        }
    }
}
