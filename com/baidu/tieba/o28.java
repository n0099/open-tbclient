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
import com.baidu.tieba.ky;
import com.baidu.tieba.vy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o28 extends dx7<nn6, ThreadCardViewHolder<nn6>> implements b46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;
    public en f;
    public cn6<nn6> g;

    /* loaded from: classes7.dex */
    public class a extends cn6<nn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o28 b;

        public a(o28 o28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, nn6 nn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nn6Var) == null) {
                vm6.b().d(true);
                z36.c().h("page_recommend", "show_");
                if (view2 != null && nn6Var != null && nn6Var.getThreadData() != null && !StringUtils.isNull(nn6Var.getThreadData().getTid())) {
                    this.b.A(view2, nn6Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o28 a;

        public b(o28 o28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o28Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, ymVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o28(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
    public final void A(View view2, nn6 nn6Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, nn6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                TiebaStatic.log(nn6Var.q());
            } else if (id == R.id.user_avatar || id == R.id.user_name) {
                i = 2;
                if (i == 0) {
                    r48.d(nn6Var.a, this.b, nn6Var.h(), i);
                    return;
                }
                return;
            }
            i = 0;
            if (i == 0) {
            }
        }
    }

    public final void x(View view2, ym ymVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, ymVar) == null) && (ymVar instanceof nn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            nn6 nn6Var = (nn6) ymVar;
            nn6Var.f = 1;
            ThreadCardUtils.jumpToPB((q05) nn6Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new vy.a(1));
        }
    }

    public void B(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nEGFeedbackEventCallback) == null) {
            this.e = nEGFeedbackEventCallback;
        }
    }

    public void C(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, enVar) == null) {
            this.f = enVar;
        }
    }

    @Override // com.baidu.tieba.b46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: y */
    public ThreadCardViewHolder<nn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.c.getPageActivity());
            zw zwVar = new zw(this.c.getPageActivity());
            zwVar.q(this.b);
            zwVar.B(this.c);
            bVar.o(zwVar);
            bVar.n(new xw(this.c.getPageActivity()));
            bVar.h(new hx(this.c.getPageActivity()));
            my myVar = new my(this.c.getPageActivity());
            w05 w05Var = new w05();
            w05Var.b = 1;
            w05Var.h = 1;
            myVar.C(w05Var);
            myVar.E(1);
            myVar.J(3);
            myVar.F(2);
            myVar.D(false);
            bVar.m(myVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            ky k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<nn6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nn6 nn6Var, ThreadCardViewHolder<nn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nn6Var, threadCardViewHolder})) == null) {
            if (nn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                nn6Var.A(nn6Var.position + 1);
                nn6Var.a.statFloor = nn6Var.h();
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.d);
                threadCardViewHolder.q(true).setNegEventCallback(this.e);
                threadCardViewHolder.m(nn6Var.showFollowBtn(), this.a);
                threadCardViewHolder.f(nn6Var);
                threadCardViewHolder.b().q(this.g);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                vm6.b().a(nn6Var.r());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
