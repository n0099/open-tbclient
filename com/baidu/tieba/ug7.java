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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ug7 extends vb7<vf6, ThreadCardViewHolder<vf6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.b e;
    public mn f;
    public lf6<vf6> g;

    /* loaded from: classes6.dex */
    public class a extends lf6<vf6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug7 b;

        public a(ug7 ug7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ug7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, vf6 vf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vf6Var) == null) {
                ef6.b().d(true);
                hx5.c().h("page_recommend", "show_");
                if (view2 != null && vf6Var != null && vf6Var.getThreadData() != null && !StringUtils.isNull(vf6Var.getThreadData().getTid())) {
                    this.b.A(view2, vf6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug7 a;

        public b(ug7 ug7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ug7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, gnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ug7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
    public final void A(View view2, vf6 vf6Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, vf6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                TiebaStatic.log(vf6Var.t());
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                i = 2;
                if (i == 0) {
                    pi7.d(vf6Var.a, this.b, vf6Var.k(), i);
                    return;
                }
                return;
            }
            i = 0;
            if (i == 0) {
            }
        }
    }

    public final void x(View view2, gn gnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, gnVar) == null) && (gnVar instanceof vf6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            vf6 vf6Var = (vf6) gnVar;
            vf6Var.f = 1;
            ThreadCardUtils.jumpToPB((hw4) vf6Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new ny.a(1));
        }
    }

    public void B(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void C(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mnVar) == null) {
            this.f = mnVar;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public ThreadCardViewHolder<vf6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.c.getPageActivity());
            rw rwVar = new rw(this.c.getPageActivity());
            rwVar.x(this.b);
            rwVar.z(this.c);
            bVar.o(rwVar);
            bVar.n(new pw(this.c.getPageActivity()));
            bVar.h(new yw(this.c.getPageActivity()));
            ey eyVar = new ey(this.c.getPageActivity());
            nw4 nw4Var = new nw4();
            nw4Var.b = 1;
            nw4Var.h = 1;
            eyVar.z(nw4Var);
            eyVar.B(1);
            eyVar.G(3);
            eyVar.C(2);
            eyVar.A(false);
            bVar.m(eyVar);
            bVar.l().i(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<vf6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vf6 vf6Var, ThreadCardViewHolder<vf6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vf6Var, threadCardViewHolder})) == null) {
            if (vf6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                vf6Var.E(vf6Var.position + 1);
                vf6Var.a.statFloor = vf6Var.k();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.o(true).s(this.e);
                threadCardViewHolder.k(vf6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(vf6Var);
                threadCardViewHolder.a().q(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                ef6.b().a(vf6Var.u());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
