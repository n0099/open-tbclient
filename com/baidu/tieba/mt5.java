package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mt5 extends nt5<c45, ThreadCardViewHolder<c45>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jo6<c45> g;

    /* loaded from: classes7.dex */
    public class a extends jo6<c45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt5 b;

        public a(mt5 mt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mt5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, c45 c45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, c45Var) == null) {
                this.b.u(view2, c45Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt5 a;

        public b(mt5 mt5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt5Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.O(view2, bnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mt5(TbPageContext tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_ARTICLE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
    }

    public final void O(View view2, bn bnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, bnVar) == null) && (bnVar instanceof c45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((c45) bnVar).t;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((w05) threadData, view2.getContext(), C(), false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new yy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: P */
    public ThreadCardViewHolder<c45> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity());
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.q(this.mPageId);
            cxVar.B(this.c);
            bVar.o(cxVar);
            bVar.n(new ax(this.c.getPageActivity()));
            bVar.h(new kx(this.c.getPageActivity()));
            py pyVar = new py(this.c.getPageActivity());
            c15 c15Var = new c15();
            c15Var.b = x();
            c15Var.h = y();
            pyVar.C(c15Var);
            pyVar.E(A());
            pyVar.J(B());
            pyVar.F(C());
            bVar.m(pyVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            bVar.l().b(R.drawable.addresslist_item_bg);
            bVar.l().h(BdUtilHelper.getDimens(this.c.getPageActivity(), R.dimen.tbds17));
            ny k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.s(C());
            ThreadCardViewHolder<c45> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: Q */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, c45 c45Var, ThreadCardViewHolder<c45> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, c45Var, threadCardViewHolder})) == null) {
            if (c45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                c45Var.t.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(c45Var);
                threadCardViewHolder.b().q(this.g);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                M(threadCardViewHolder.getView(), c45Var, i, i);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
