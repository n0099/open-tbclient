package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class se5 extends te5<bu4, ThreadCardViewHolder<bu4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i26<bu4> g;

    /* loaded from: classes5.dex */
    public class a extends i26<bu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se5 b;

        public a(se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bu4Var) == null) {
                this.b.u(view2, bu4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se5 a;

        public b(se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se5Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.N(view2, cdo);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se5(TbPageContext tbPageContext) {
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

    public final void N(View view2, Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, cdo) == null) && (cdo instanceof bu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((bu4) cdo).t;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((yq4) threadData, view2.getContext(), A(), false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new dz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: O */
    public ThreadCardViewHolder<bu4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.u(this.mPageId);
            jxVar.w(this.c);
            bVar.o(jxVar);
            bVar.n(new hx(this.c.getPageActivity()));
            bVar.h(new qx(this.c.getPageActivity()));
            uy uyVar = new uy(this.c.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = v();
            er4Var.h = w();
            uyVar.w(er4Var);
            uyVar.y(y());
            uyVar.D(z());
            uyVar.z(A());
            bVar.m(uyVar);
            bVar.l().h(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            bVar.l().b(R.drawable.addresslist_item_bg);
            bVar.l().g(ej.f(this.c.getPageActivity(), R.dimen.tbds17));
            sy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.r(A());
            ThreadCardViewHolder<bu4> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: P */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, ThreadCardViewHolder<bu4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, threadCardViewHolder})) == null) {
            if (bu4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            bu4Var.t.statFloor = getPositionByType(i) + 1;
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.e(bu4Var);
            threadCardViewHolder.a().p(this.g);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            L(threadCardViewHolder.getView(), bu4Var, i, i);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
