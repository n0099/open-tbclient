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
import com.baidu.tieba.ny;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wm9 extends om<ci9, ThreadCardViewHolder<ci9>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public hn d;
    public jo6<ci9> e;

    /* loaded from: classes8.dex */
    public class a extends jo6<ci9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm9 b;

        public a(wm9 wm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ci9 ci9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ci9Var) == null) && view2 != null && ci9Var != null && ci9Var.getThreadData() != null && !TextUtils.isEmpty(ci9Var.getThreadData().getTid())) {
                this.b.y(view2, ci9Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm9 a;

        public b(wm9 wm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wm9Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof ci9) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ci9 ci9Var = (ci9) bnVar;
                ci9Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), ci9Var);
                }
                UrlManager.getInstance().dealOneLink(ci9Var.W());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wm9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.om
    /* renamed from: u */
    public ThreadCardViewHolder<ci9> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            bVar.l().k(false);
            bVar.o(new mx(this.b.getPageActivity()));
            zx zxVar = new zx(this.b.getPageActivity());
            zxVar.setFrom("pb");
            zxVar.z(this.c);
            zxVar.B(false);
            bVar.n(zxVar);
            py pyVar = new py(this.b.getPageActivity());
            c15 c15Var = new c15();
            c15Var.b = 25;
            c15Var.h = 25;
            pyVar.C(c15Var);
            pyVar.E(25);
            pyVar.J(11);
            pyVar.F(0);
            pyVar.f(32);
            bVar.m(pyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(0);
            ThreadCardViewHolder<ci9> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ci9 ci9Var, ThreadCardViewHolder<ci9> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ci9Var, threadCardViewHolder})) == null) {
            if (ci9Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ci9Var.a != null) {
                ci9Var.A(ci9Var.position + 1);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(ci9Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.e);
                wp9.r(ci9Var, this.b, "2");
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, ci9 ci9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, ci9Var) == null) {
            if (view2.getId() != R.id.forum_head_image && view2.getId() != R.id.forum_head_barname && view2.getId() != R.id.forum_head_info_attention && view2.getId() != R.id.forum_head_info_thread) {
                if (view2.getId() == R.id.thread_card_root) {
                    wp9.p(ci9Var, 1, this.b, "2");
                    return;
                } else if (view2 instanceof TbImageView) {
                    wp9.p(ci9Var, 3, this.b, "2");
                    return;
                } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                    wp9.p(ci9Var, 1, this.b, "2");
                    return;
                } else {
                    return;
                }
            }
            wp9.p(ci9Var, 2, this.b, "2");
        }
    }
}
