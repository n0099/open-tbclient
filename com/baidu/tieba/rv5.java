package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rv5 extends hv5<z45, ThreadCardViewHolder<z45>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public up6<z45> g;

    /* loaded from: classes7.dex */
    public class a extends up6<z45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv5 b;

        public a(rv5 rv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rv5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z45Var) == null) {
                super.a(view2, z45Var);
                if (z45Var != null && z45Var.getThreadData() != null && !ListUtils.isEmpty(z45Var.getThreadData().getLinkDataList()) && z45Var.getThreadData().getLinkDataList().get(0) != null) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (!TextUtils.isEmpty(z45Var.getThreadData().getLinkDataList().get(0).linkUrl) && (currentActivity instanceof TbPageContextSupport)) {
                        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{z45Var.getThreadData().getLinkDataList().get(0).linkUrl});
                    }
                    this.b.u(view2, z45Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv5 a;

        public b(rv5 rv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv5Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof z45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                z45 z45Var = (z45) ynVar;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), z45Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rv5(TbPageContext<?> tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_SINGLE_LINK);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: P */
    public ThreadCardViewHolder<z45> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity(), false);
            bVar.h(new iz(this.c.getPageActivity()));
            mz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.s(C());
            ThreadCardViewHolder<z45> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: Q */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, z45 z45Var, ThreadCardViewHolder<z45> threadCardViewHolder) {
        InterceptResult invokeCommon;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z45Var, threadCardViewHolder})) == null) {
            if (z45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && (threadData = z45Var.t) != null) {
                threadData.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(z45Var);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
