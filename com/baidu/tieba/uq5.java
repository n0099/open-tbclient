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
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uq5 extends vq5<mz4, ThreadCardViewHolder<mz4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mm6<mz4> g;

    /* loaded from: classes8.dex */
    public class a extends mm6<mz4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq5 b;

        public a(uq5 uq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uq5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, mz4 mz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mz4Var) == null) {
                this.b.x(view2, mz4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uq5 a;

        public b(uq5 uq5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uq5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uq5Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.P(view2, piVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq5(TbPageContext tbPageContext) {
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

    public final void P(View view2, pi piVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, piVar) == null) && (piVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((mz4) piVar).t;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), D(), false);
            ((ThreadCardViewHolder) view2.getTag()).a().q(new nu.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: Q */
    public ThreadCardViewHolder<mz4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.c.getPageActivity());
            rs rsVar = new rs(this.c.getPageActivity());
            rsVar.o(this.mPageId);
            rsVar.A(this.c);
            bVar.o(rsVar);
            bVar.n(new ps(this.c.getPageActivity()));
            bVar.h(new zs(this.c.getPageActivity()));
            eu euVar = new eu(this.c.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = y();
            lw4Var.h = z();
            euVar.C(lw4Var);
            euVar.E(B());
            euVar.J(C());
            euVar.F(D());
            bVar.m(euVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            bVar.l().b(R.drawable.addresslist_item_bg);
            bVar.l().h(BdUtilHelper.getDimens(this.c.getPageActivity(), R.dimen.tbds17));
            cu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.t(D());
            ThreadCardViewHolder<mz4> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: R */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, ThreadCardViewHolder<mz4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, threadCardViewHolder})) == null) {
            if (mz4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                mz4Var.t.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.e(mz4Var);
                threadCardViewHolder.a().r(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                N(threadCardViewHolder.getView(), mz4Var, i, i);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
