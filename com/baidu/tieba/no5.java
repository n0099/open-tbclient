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
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class no5 extends oo5<py4, ThreadCardViewHolder<py4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bk6<py4> g;

    /* loaded from: classes7.dex */
    public class a extends bk6<py4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no5 b;

        public a(no5 no5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = no5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, py4 py4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, py4Var) == null) {
                this.b.u(view2, py4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no5 a;

        public b(no5 no5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no5Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.O(view2, yhVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no5(TbPageContext tbPageContext) {
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

    public final void O(View view2, yh yhVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, yhVar) == null) && (yhVar instanceof py4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((py4) yhVar).t;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((jv4) threadData, view2.getContext(), C(), false);
            ((ThreadCardViewHolder) view2.getTag()).a().q(new vt.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: P */
    public ThreadCardViewHolder<py4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.c.getPageActivity());
            zr zrVar = new zr(this.c.getPageActivity());
            zrVar.q(this.mPageId);
            zrVar.C(this.c);
            bVar.o(zrVar);
            bVar.n(new xr(this.c.getPageActivity()));
            bVar.h(new hs(this.c.getPageActivity()));
            mt mtVar = new mt(this.c.getPageActivity());
            pv4 pv4Var = new pv4();
            pv4Var.b = x();
            pv4Var.h = y();
            mtVar.E(pv4Var);
            mtVar.G(A());
            mtVar.L(B());
            mtVar.H(C());
            bVar.m(mtVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            bVar.l().b(R.drawable.addresslist_item_bg);
            bVar.l().h(BdUtilHelper.getDimens(this.c.getPageActivity(), R.dimen.tbds17));
            kt k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.t(C());
            ThreadCardViewHolder<py4> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: Q */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, py4 py4Var, ThreadCardViewHolder<py4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py4Var, threadCardViewHolder})) == null) {
            if (py4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                py4Var.t.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.e(py4Var);
                threadCardViewHolder.a().r(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                M(threadCardViewHolder.getView(), py4Var, i, i);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
