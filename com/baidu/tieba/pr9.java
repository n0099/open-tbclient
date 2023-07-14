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
import com.baidu.tieba.ay;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pr9 extends ln<fq6, ThreadCardViewHolder<fq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public up6<fq6> g;

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends up6<fq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pr9 pr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr9Var};
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
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, fq6 fq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fq6Var) == null) && view2 != null && fq6Var != null && fq6Var.getThreadData() != null) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                    if (id == R.id.forum_name_text) {
                        xq9.a(view2, fq6Var, 7);
                        return;
                    }
                    return;
                }
                xq9.a(view2, fq6Var, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr9 a;

        public b(pr9 pr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr9Var;
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) {
                this.a.E(view2, t15Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends up6<t15> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr9 b;

        public c(pr9 pr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, t15 t15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, t15Var) == null) {
                this.b.E(view2, t15Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr9 a;

        public d(pr9 pr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr9Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, ynVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pr9(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f = z;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public final void E(View view2, t15 t15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, t15Var) == null) && view2 != null && t15Var != null && view2.getId() != -1) {
            int id = view2.getId();
            if (id != R.id.user_name && id != R.id.user_avatar) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    xq9.a(view2, t15Var, 3);
                    return;
                }
                return;
            }
            xq9.a(view2, t15Var, 1);
        }
    }

    public final void x(View view2, yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, view2, ynVar) == null) && (ynVar instanceof fq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            fq6 fq6Var = (fq6) ynVar;
            fq6Var.f = 1;
            ThreadCardUtils.jumpToPB((t15) fq6Var, view2.getContext(), 4, false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new xz.a(1));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            kq6.j0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public ThreadCardViewHolder<fq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity());
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.r(this.a);
            ayVar.C(this.b);
            ayVar.h(32768);
            int i = this.d;
            if (i > 0) {
                ayVar.g(i);
            }
            ayVar.z(false);
            ayVar.D(false);
            ayVar.A(new b(this));
            bVar.o(ayVar);
            bVar.l().i(yi.g(this.mContext, R.dimen.tbds25));
            yx yxVar = new yx(this.b.getPageActivity());
            yxVar.q(new c(this));
            bVar.n(yxVar);
            bVar.h(new iy(this.b.getPageActivity()));
            oz ozVar = new oz(this.b.getPageActivity());
            ozVar.g(32);
            ozVar.E(false);
            z15 z15Var = new z15();
            z15Var.b = 3;
            z15Var.h = 3;
            ozVar.D(z15Var);
            ozVar.F(8);
            ozVar.L(6);
            ozVar.G(4);
            bVar.m(ozVar);
            mz i2 = bVar.i();
            i2.s(4);
            ThreadCardViewHolder<fq6> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.j(this.a);
            threadCardViewHolder.s(this.e);
            setOnAdapterItemClickListener(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, fq6 fq6Var, ThreadCardViewHolder<fq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fq6Var, threadCardViewHolder})) == null) {
            if (fq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                fq6Var.B(fq6Var.position + 1);
                threadCardViewHolder.b().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.t();
                }
                threadCardViewHolder.f(fq6Var);
                threadCardViewHolder.b().q(this.g);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                xq9.b(fq6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
