package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u58 extends i08<xp6, ThreadCardViewHolder<xp6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;
    public in f;
    public mp6<xp6> g;

    /* loaded from: classes8.dex */
    public class a extends mp6<xp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u58 b;

        public a(u58 u58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, xp6 xp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xp6Var) == null) {
                ep6.b().d(true);
                m56.c().h("page_recommend", "show_");
                if (view2 != null && xp6Var != null && xp6Var.getThreadData() != null && !StringUtils.isNull(xp6Var.getThreadData().getTid())) {
                    this.b.A(view2, xp6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u58 a;

        public b(u58 u58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u58Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, cnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u58(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
    public final void A(View view2, xp6 xp6Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, xp6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                TiebaStatic.log(xp6Var.q());
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                i = 2;
                if (i == 0) {
                    x78.d(xp6Var.a, this.b, xp6Var.h(), i);
                    return;
                }
                return;
            }
            i = 0;
            if (i == 0) {
            }
        }
    }

    public final void x(View view2, cn cnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, cnVar) == null) && (cnVar instanceof xp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            xp6 xp6Var = (xp6) cnVar;
            xp6Var.f = 1;
            ThreadCardUtils.jumpToPB((b15) xp6Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new zy.a(1));
        }
    }

    public void B(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nEGFeedbackEventCallback) == null) {
            this.e = nEGFeedbackEventCallback;
        }
    }

    public void C(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inVar) == null) {
            this.f = inVar;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public ThreadCardViewHolder<xp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.p(this.b);
            dxVar.B(this.c);
            bVar.o(dxVar);
            bVar.n(new bx(this.c.getPageActivity()));
            bVar.h(new lx(this.c.getPageActivity()));
            qy qyVar = new qy(this.c.getPageActivity());
            h15 h15Var = new h15();
            h15Var.b = 1;
            h15Var.h = 1;
            qyVar.D(h15Var);
            qyVar.F(1);
            qyVar.K(3);
            qyVar.G(2);
            qyVar.E(false);
            bVar.m(qyVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            oy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<xp6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xp6 xp6Var, ThreadCardViewHolder<xp6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xp6Var, threadCardViewHolder})) == null) {
            if (xp6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                xp6Var.B(xp6Var.position + 1);
                xp6Var.a.statFloor = xp6Var.h();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.p(true).setNegEventCallback(this.e);
                threadCardViewHolder.l(xp6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(xp6Var);
                threadCardViewHolder.a().q(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                ep6.b().a(xp6Var.s());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
