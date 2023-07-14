package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l08 extends ln<lq6, ThreadCardViewHolder<lq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public eo e;
    public fy f;
    public up6<lq6> g;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public AutoVideoCardViewHolder<lq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, ThreadCardViewHolder<lq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends up6<lq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l08 b;

        public a(l08 l08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq6Var) == null) {
                BdToast b = BdToast.b(this.b.c.getContext(), this.b.c.getString(R.string.video_is_checking));
                b.g(BdToast.ToastIcon.FAILURE);
                b.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l08 a;

        public b(l08 l08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l08Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                BdToast b = BdToast.b(this.a.c.getContext(), this.a.c.getString(R.string.video_is_checking));
                b.g(BdToast.ToastIcon.FAILURE);
                b.q();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.g = new a(this);
        this.c = tbPageContext;
        this.b = bdUniqueId2;
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    public void z(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eoVar) == null) {
            this.e = eoVar;
        }
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return cq6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return cq6.K;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return cq6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ln
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            return cq6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public ThreadCardViewHolder<lq6> onCreateContentViewHolder(ViewGroup viewGroup, lq6 lq6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, lq6Var)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity(), false);
            fy fyVar = new fy(this.c.getPageActivity());
            this.f = fyVar;
            fyVar.r(this.a);
            bVar.n(this.f);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            ThreadCardViewHolder<lq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            k.q(this.g);
            k.s(1);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, ThreadCardViewHolder<lq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, threadCardViewHolder})) == null) {
            if (lq6Var == null) {
                return threadCardViewHolder.getView();
            }
            if (threadCardViewHolder == null) {
                return null;
            }
            lq6Var.B(lq6Var.position + 1);
            np6.b().a(lq6Var.d("c12351"));
            threadCardViewHolder.b().r(i);
            lq6Var.f1139T = 0;
            if (threadCardViewHolder.b() instanceof s66) {
                threadCardViewHolder.b().b(this.d);
            }
            threadCardViewHolder.f(lq6Var);
            threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().q(this.g);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
