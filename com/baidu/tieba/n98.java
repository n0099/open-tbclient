package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n98 extends jn<o46, ThreadCardViewHolder<o46>> implements zp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public z36<o46> g;

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends z36<o46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n98 n98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var};
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
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, o46 o46Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o46Var) == null) && view2 != null && o46Var != null && o46Var.getThreadData() != null && view2.getId() == R.id.obfuscated_res_0x7f090aac) {
                u88.a(view2, o46Var, 7);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy a;
        public final /* synthetic */ n98 b;

        public b(n98 n98Var, iy iyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var, iyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n98Var;
            this.a = iyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rr4Var) == null) && rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(rr4Var.getThreadData().originalThreadData, this.b.mContext, 4);
                u88.a(this.a.k(), rr4Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qy a;
        public final /* synthetic */ n98 b;

        public c(n98 n98Var, qy qyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var, qyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n98Var;
            this.a = qyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, rr4Var) == null) && rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(rr4Var.getThreadData().originalThreadData, this.b.mContext, 4);
                u88.a(this.a.k(), rr4Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n98 a;

        public d(n98 n98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n98Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof o46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o46 o46Var = (o46) wnVar;
                o46Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), o46Var);
                }
                ThreadCardUtils.jumpToPB((rr4) o46Var, view2.getContext(), 4, false);
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n98(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = 0;
        this.e = 0;
        this.g = new a(this);
        this.b = tbPageContext;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.zp5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f = z;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.e = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public ThreadCardViewHolder<o46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity());
            cx cxVar = new cx(this.b.getPageActivity());
            cxVar.x(this.a);
            cxVar.g(1024);
            cxVar.g(32768);
            int i = this.d;
            if (i > 0) {
                cxVar.f(i);
            }
            cxVar.v(false);
            cxVar.A(false);
            bVar.o(cxVar);
            iy iyVar = new iy(this.b);
            iyVar.r(Boolean.FALSE);
            iyVar.z(ImageViewerConfig.FROM_CONCERN);
            iyVar.v(xi.g(this.mContext, R.dimen.tbds9));
            bVar.n(iyVar);
            bVar.l().h(xi.g(this.mContext, R.dimen.tbds25));
            iy iyVar2 = new iy(this.b);
            iyVar2.r(Boolean.TRUE);
            iyVar2.z(ImageViewerConfig.FROM_CONCERN);
            iyVar2.C(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            iyVar2.A(new b(this, iyVar2));
            bVar.h(iyVar2);
            qy qyVar = new qy(this.b.getPageActivity());
            qyVar.r(Boolean.TRUE);
            qyVar.y(new c(this, qyVar));
            bVar.h(qyVar);
            bVar.h(new jx(this.b.getPageActivity()));
            py pyVar = new py(this.b.getPageActivity());
            pyVar.f(32);
            pyVar.A(false);
            xr4 xr4Var = new xr4();
            xr4Var.b = 3;
            xr4Var.h = 3;
            pyVar.z(xr4Var);
            pyVar.B(8);
            pyVar.G(6);
            pyVar.C(4);
            bVar.m(pyVar);
            ny i2 = bVar.i();
            i2.r(4);
            ThreadCardViewHolder<o46> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.a);
            threadCardViewHolder.q(this.e);
            setOnAdapterItemClickListener(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o46 o46Var, ThreadCardViewHolder<o46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o46Var, threadCardViewHolder})) == null) {
            if (o46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o46Var.a != null) {
                o46Var.I(o46Var.position + 1);
                threadCardViewHolder.a().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.r();
                }
                threadCardViewHolder.e(o46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.g);
                u88.b(o46Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
