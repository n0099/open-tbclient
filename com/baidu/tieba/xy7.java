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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xy7 extends jn<o46, ThreadCardViewHolder<o46>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public co c;
    public z36<o46> d;

    /* loaded from: classes6.dex */
    public class a extends z36<o46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy7 b;

        public a(xy7 xy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, o46 o46Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o46Var) == null) {
                s36.b().d(true);
                if (view2 != null && o46Var != null && o46Var.getThreadData() != null && !StringUtils.isNull(o46Var.getThreadData().getTid())) {
                    this.b.w(view2, o46Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy7 a;

        public b(xy7 xy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xy7Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof o46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o46 o46Var = (o46) wnVar;
                o46Var.f = 1;
                if (this.a.d != null) {
                    this.a.d.a(threadCardViewHolder.getView(), o46Var);
                }
                ThreadCardUtils.jumpToPB((rr4) o46Var, view2.getContext(), o46Var.C, false, dx.a((co) viewGroup, view2, i));
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void x(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, coVar) == null) {
            this.c = coVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: u */
    public ThreadCardViewHolder<o46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity());
            bVar.l().j(true);
            bVar.o(new lx(this.b.getPageActivity()));
            ThreadCardViewHolder<o46> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.c));
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o46 o46Var, ThreadCardViewHolder<o46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o46Var, threadCardViewHolder})) == null) {
            if (o46Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || o46Var.a == null) {
                return null;
            }
            o46Var.I(o46Var.position + 1);
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.p(false, Align.ALIGN_RIGHT_TOP, null);
            threadCardViewHolder.e(o46Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.d);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void w(View view2, o46 o46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, o46Var) == null) {
            int id = view2.getId();
            if (o46Var == null) {
                return;
            }
            if (id != R.id.obfuscated_res_0x7f090a8f && id != R.id.obfuscated_res_0x7f090a8e && id != R.id.obfuscated_res_0x7f090a90 && id != R.id.obfuscated_res_0x7f090a91) {
                e48.m(o46Var, 1, this.b);
            } else {
                e48.m(o46Var, 2, this.b);
            }
        }
    }
}
