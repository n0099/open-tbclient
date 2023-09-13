package com.baidu.tieba;

import android.content.Context;
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
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j98 extends pm<h45, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public in c;
    public mp6<cq6> d;

    /* loaded from: classes6.dex */
    public class a extends mp6<cq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(j98 j98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, cq6 cq6Var) {
            ThreadCardViewHolder threadCardViewHolder;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) == null) {
                super.a(view2, cq6Var);
                if (cq6Var != null && cq6Var.getThreadData() != null && (threadCardViewHolder = (ThreadCardViewHolder) view2.getTag()) != null) {
                    ThreadCardUtils.jumpToPB((b15) cq6Var.getThreadData(), view2.getContext(), 0, false);
                    threadCardViewHolder.a().p(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j98 a;

        public b(j98 j98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j98Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof cq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) cnVar;
                if (this.a.d != null) {
                    this.a.d.a(threadCardViewHolder.getView(), cq6Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j98(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
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
        this.a = bdUniqueId2;
    }

    public void x(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inVar) == null) {
            this.c = inVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            bVar.h(new ky(this.b.getPageActivity()));
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.s(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h45 h45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h45Var, threadCardViewHolder})) == null) {
            if (h45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && (threadData = h45Var.t) != null) {
                threadData.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.e(h45Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
