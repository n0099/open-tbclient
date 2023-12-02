package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class waa extends ci<xm6, ThreadCardViewHolder<xm6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public mm6<xm6> g;

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends mm6<xm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(waa waaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {waaVar};
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
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, xm6 xm6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xm6Var) == null) && view2 != null && xm6Var != null && xm6Var.getThreadData() != null) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                    if (id == R.id.forum_name_text) {
                        eaa.a(view2, xm6Var, 7);
                        return;
                    }
                    return;
                }
                eaa.a(view2, xm6Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ waa a;

        public b(waa waaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {waaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = waaVar;
        }

        @Override // com.baidu.tieba.rs.b
        public void a(fw4 fw4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, fw4Var, view2) == null) {
                this.a.F(view2, fw4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends mm6<fw4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ waa b;

        public c(waa waaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {waaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = waaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fw4Var) == null) {
                this.b.F(view2, fw4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ waa a;

        public d(waa waaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {waaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = waaVar;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.y(view2, piVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public waa(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xm6 xm6Var, ThreadCardViewHolder<xm6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xm6Var, threadCardViewHolder})) == null) {
            if (xm6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                xm6Var.B(xm6Var.position + 1);
                threadCardViewHolder.a().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.u();
                }
                threadCardViewHolder.e(xm6Var);
                threadCardViewHolder.a().r(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                eaa.b(xm6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f = z;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e = i;
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.c = str;
        }
    }

    public final void F(View view2, fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, view2, fw4Var) == null) && view2 != null && fw4Var != null && view2.getId() != -1) {
            int id = view2.getId();
            if (id != R.id.user_name && id != R.id.user_avatar) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    eaa.a(view2, fw4Var, 3);
                    return;
                }
                return;
            }
            eaa.a(view2, fw4Var, 1);
        }
    }

    public final void y(View view2, pi piVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, piVar) == null) && (piVar instanceof xm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            xm6 xm6Var = (xm6) piVar;
            xm6Var.f = 1;
            ThreadCardUtils.jumpToPB((fw4) xm6Var, view2.getContext(), 4, false);
            ((ThreadCardViewHolder) view2.getTag()).a().q(new nu.a(1));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            dn6.j0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public ThreadCardViewHolder<xm6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity());
            rs rsVar = new rs(this.b.getPageActivity());
            rsVar.o(this.a);
            rsVar.A(this.b);
            rsVar.c(32768);
            int i = this.d;
            if (i > 0) {
                rsVar.b(i);
            }
            rsVar.u(false);
            rsVar.B(false);
            rsVar.x(new b(this));
            bVar.o(rsVar);
            bVar.l().i(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds25));
            ps psVar = new ps(this.b.getPageActivity());
            psVar.n(new c(this));
            bVar.n(psVar);
            bVar.h(new zs(this.b.getPageActivity()));
            eu euVar = new eu(this.b.getPageActivity());
            euVar.b(32);
            euVar.D(false);
            lw4 lw4Var = new lw4();
            lw4Var.b = 3;
            lw4Var.h = 3;
            euVar.C(lw4Var);
            euVar.E(8);
            euVar.J(6);
            euVar.F(4);
            bVar.m(euVar);
            cu i2 = bVar.i();
            i2.t(4);
            ThreadCardViewHolder<xm6> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.a);
            threadCardViewHolder.t(this.e);
            setOnAdapterItemClickListener(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
