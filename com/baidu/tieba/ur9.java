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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ay;
import com.baidu.tieba.mz;
import com.baidu.tieba.xx;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ur9 extends ln<kq6, ThreadCardViewHolder<kq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public up6<kq6> g;

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends up6<kq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ur9 ur9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var};
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
        public void a(View view2, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kq6Var) == null) && view2 != null && kq6Var != null && kq6Var.getThreadData() != null && view2.getId() == R.id.forum_name_text) {
                xq9.a(view2, kq6Var, 7);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ur9 ur9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && view2 != null && t15Var != null) {
                int id = view2.getId();
                if (id == R.id.user_name || id == R.id.user_avatar) {
                    xq9.a(view2, t15Var, 1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz a;
        public final /* synthetic */ ur9 b;

        public c(ur9 ur9Var, hz hzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var, hzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ur9Var;
            this.a = hzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) && t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(t15Var.getThreadData().originalThreadData, this.b.mContext, 4);
                xq9.a(this.a.l(), t15Var, 6);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ ur9 b;

        public d(ur9 ur9Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ur9Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) && t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(t15Var.getThreadData().originalThreadData, this.b.mContext, 4);
                xq9.a(this.a.l(), t15Var, 6);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur9 a;

        public e(ur9 ur9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur9Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof kq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                kq6 kq6Var = (kq6) ynVar;
                kq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), kq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) kq6Var, view2.getContext(), 4, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            this.e = i;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public ThreadCardViewHolder<kq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity());
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.r(this.a);
            ayVar.h(1024);
            ayVar.h(32768);
            int i = this.d;
            if (i > 0) {
                ayVar.g(i);
            }
            ayVar.z(false);
            ayVar.D(false);
            ayVar.A(new b(this));
            bVar.o(ayVar);
            hz hzVar = new hz(this.b);
            hzVar.t(Boolean.FALSE);
            hzVar.z(yi.g(this.mContext, R.dimen.tbds9));
            bVar.n(hzVar);
            bVar.l().i(yi.g(this.mContext, R.dimen.tbds25));
            hz hzVar2 = new hz(this.b);
            hzVar2.t(Boolean.TRUE);
            hzVar2.F(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            hzVar2.D(new c(this, hzVar2));
            bVar.h(hzVar2);
            tz tzVar = new tz(this.b.getPageActivity());
            tzVar.t(Boolean.TRUE);
            tzVar.E(new d(this, tzVar));
            bVar.h(tzVar);
            bVar.h(new qz(this.b.getPageActivity()));
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
            ThreadCardViewHolder<kq6> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.j(this.a);
            threadCardViewHolder.s(this.e);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kq6 kq6Var, ThreadCardViewHolder<kq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kq6Var, threadCardViewHolder})) == null) {
            if (kq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && kq6Var.a != null) {
                kq6Var.B(kq6Var.position + 1);
                threadCardViewHolder.b().b(this.c);
                if (!this.f) {
                    threadCardViewHolder.t();
                }
                threadCardViewHolder.f(kq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                xq9.b(kq6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
