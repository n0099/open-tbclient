package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z48 extends tz7<fq6, ThreadCardViewHolder<fq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.b e;
    public eo f;
    public up6<fq6> g;

    /* loaded from: classes8.dex */
    public class a extends up6<fq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z48 b;

        public a(z48 z48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, fq6 fq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fq6Var) == null) {
                np6.b().d(true);
                r66.c().h("page_recommend", "show_");
                if (view2 != null && fq6Var != null && fq6Var.getThreadData() != null && !StringUtils.isNull(fq6Var.getThreadData().getTid())) {
                    this.b.A(view2, fq6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z48 a;

        public b(z48 z48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z48Var;
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
    public z48(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.c = tbPageContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(View view2, fq6 fq6Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, fq6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                TiebaStatic.log(fq6Var.p());
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                i = 2;
                if (i == 0) {
                    x68.d(fq6Var.a, this.b, fq6Var.h(), i);
                    return;
                }
                return;
            }
            i = 0;
            if (i == 0) {
            }
        }
    }

    public final void x(View view2, yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, ynVar) == null) && (ynVar instanceof fq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            fq6 fq6Var = (fq6) ynVar;
            fq6Var.f = 1;
            ThreadCardUtils.jumpToPB((t15) fq6Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new xz.a(1));
        }
    }

    public void B(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void C(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eoVar) == null) {
            this.f = eoVar;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public ThreadCardViewHolder<fq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity());
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.r(this.b);
            ayVar.C(this.c);
            bVar.o(ayVar);
            bVar.n(new yx(this.c.getPageActivity()));
            bVar.h(new iy(this.c.getPageActivity()));
            oz ozVar = new oz(this.c.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 1;
            z15Var.h = 1;
            ozVar.D(z15Var);
            ozVar.F(1);
            ozVar.L(3);
            ozVar.G(2);
            ozVar.E(false);
            bVar.m(ozVar);
            bVar.l().i(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            mz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<fq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new b(this));
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fq6Var, threadCardViewHolder})) == null) {
            if (fq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                fq6Var.B(fq6Var.position + 1);
                fq6Var.a.statFloor = fq6Var.h();
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.d);
                threadCardViewHolder.q(true).s(this.e);
                threadCardViewHolder.m(fq6Var.showFollowBtn(), this.a);
                threadCardViewHolder.f(fq6Var);
                threadCardViewHolder.b().q(this.g);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                np6.b().a(fq6Var.r());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
