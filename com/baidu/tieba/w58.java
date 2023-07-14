package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w58 extends ln<mq6, ThreadCardViewHolder<mq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public eo d;

    /* loaded from: classes8.dex */
    public class a implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w58 a;

        public a(w58 w58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w58Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            mq6 mq6Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (ynVar instanceof mq6) {
                    mq6Var = (mq6) ynVar;
                } else {
                    mq6Var = null;
                }
                if (mq6Var != null) {
                    ((qp5) ServiceManager.getService(qp5.a.a())).b(this.a.b, mq6Var.d0());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            bVar.n(new vz(this.b, this.a));
            bVar.l().i(0);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d));
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new a(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mq6 mq6Var, ThreadCardViewHolder<mq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mq6Var, threadCardViewHolder})) == null) {
            if (threadCardViewHolder == null) {
                return null;
            }
            threadCardViewHolder.b().r(i);
            threadCardViewHolder.b().b(this.c);
            mq6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
            threadCardViewHolder.f(mq6Var);
            threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
