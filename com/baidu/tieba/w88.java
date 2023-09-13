package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w88 extends pm<w35, ThreadCardViewHolder<w35>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public in c;
    public String d;
    public String e;
    public wz4 f;

    /* loaded from: classes8.dex */
    public class a implements wz4<MetaData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        public a(w88 w88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wz4
        /* renamed from: a */
        public void b(View view2, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, metaData, Integer.valueOf(i), Long.valueOf(j)}) != null) || metaData == null) {
                return;
            }
            r88.b("c13758", metaData, i + 1, this.a.e);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wz4
        /* renamed from: c */
        public void d(View view2, MetaData metaData, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, metaData, Integer.valueOf(i), Long.valueOf(j)}) != null) || metaData == null) {
                return;
            }
            r88.a("c13758", metaData, i + 1, this.a.e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w88(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    public void x(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, inVar) == null) {
            this.c = inVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            i28 i28Var = new i28(this.b, this.a);
            i28Var.u(this.f);
            bVar.n(i28Var);
            bVar.l().c(0);
            bVar.l().g(0);
            bVar.l().f(0);
            bVar.l().i(0);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c));
            threadCardViewHolder.i(this.a);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w35 w35Var, ThreadCardViewHolder<w35> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w35Var, threadCardViewHolder})) == null) {
            if (w35Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().r(i);
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.d);
                }
                threadCardViewHolder.e(w35Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
