package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.cx;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m98 extends jn<j46, ThreadCardViewHolder<j46>> implements zp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public z36<j46> g;

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends z36<j46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
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
        public void a(View view2, j46 j46Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, j46Var) == null) && view2 != null && j46Var != null && j46Var.getThreadData() != null) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f0921d0 && id != R.id.obfuscated_res_0x7f090406) {
                    if (id == R.id.obfuscated_res_0x7f090aac) {
                        u88.a(view2, j46Var, 7);
                        return;
                    }
                    return;
                }
                u88.a(view2, j46Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m98 a;

        public b(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m98Var;
        }

        @Override // com.baidu.tieba.cx.b
        public void a(rr4 rr4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, rr4Var, view2) == null) {
                this.a.C(view2, rr4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends z36<rr4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m98 b;

        public c(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, rr4 rr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rr4Var) == null) {
                this.b.C(view2, rr4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m98 a;

        public d(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m98Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.v(view2, wnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m98(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        u();
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.zp5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e = i;
        }
    }

    public final void C(View view2, rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, rr4Var) == null) && view2 != null && rr4Var != null && view2.getId() != -1) {
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f0924f6 && id != R.id.obfuscated_res_0x7f0924c8) {
                if (id == R.id.obfuscated_res_0x7f09072f || id == R.id.obfuscated_res_0x7f090406) {
                    u88.a(view2, rr4Var, 3);
                    return;
                }
                return;
            }
            u88.a(view2, rr4Var, 1);
        }
    }

    public final void v(View view2, wn wnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, wnVar) == null) && (wnVar instanceof j46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            j46 j46Var = (j46) wnVar;
            j46Var.f = 1;
            ThreadCardUtils.jumpToPB((rr4) j46Var, view2.getContext(), 4, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new yy.a(1));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o46.h0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: w */
    public ThreadCardViewHolder<j46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity());
            cx cxVar = new cx(this.b.getPageActivity());
            cxVar.x(this.a);
            cxVar.z(this.b);
            cxVar.g(32768);
            int i = this.d;
            if (i > 0) {
                cxVar.f(i);
            }
            cxVar.v(false);
            cxVar.A(false);
            cxVar.w(new b(this));
            bVar.o(cxVar);
            bVar.l().h(xi.g(this.mContext, R.dimen.tbds25));
            ax axVar = new ax(this.b.getPageActivity());
            axVar.p(new c(this));
            bVar.n(axVar);
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
            ThreadCardViewHolder<j46> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.a);
            threadCardViewHolder.q(this.e);
            setOnAdapterItemClickListener(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, j46 j46Var, ThreadCardViewHolder<j46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, j46Var, threadCardViewHolder})) == null) {
            if (j46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                j46Var.I(j46Var.position + 1);
                threadCardViewHolder.a().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.r();
                }
                threadCardViewHolder.e(j46Var);
                threadCardViewHolder.a().p(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                u88.b(j46Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
