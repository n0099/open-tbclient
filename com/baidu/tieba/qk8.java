package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.os;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qk8 extends ci<an6, AutoVideoCardViewHolder<an6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public vi c;
    public ku d;
    public yh8 e;
    public im6<an6> f;

    /* loaded from: classes7.dex */
    public class a extends im6<an6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk8 b;

        public a(qk8 qk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qk8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im6
        /* renamed from: d */
        public void a(View view2, an6 an6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, an6Var) == null) && view2 != null && an6Var != null && an6Var.getThreadData() != null) {
                this.b.B(view2, an6Var);
                if (this.b.e != null && (view2.getTag() instanceof String) && !tf8.b(JavaTypesHelper.toLong(an6Var.getThreadData().getTid(), 0L))) {
                    tf8.a(JavaTypesHelper.toLong(an6Var.getThreadData().getTid(), 0L));
                    this.b.e.e(JavaTypesHelper.toLong(an6Var.getThreadData().getTid(), 0L), an6Var.u(), an6Var.k(), an6Var.h(), an6Var.c(), JavaTypesHelper.toInt("3", 1), "video_tab", an6Var.getThreadData().getBaijiahaoData());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;
        public final /* synthetic */ qk8 b;

        public b(qk8 qk8Var, ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk8Var, kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qk8Var;
            this.a = kuVar;
        }

        @Override // com.baidu.tieba.os.a
        public void a(cw4 cw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cw4Var) != null) || cw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (cw4Var instanceof an6) {
                cw4Var.objType = 5;
                yk8.f((qm6) cw4Var);
                yk8.c(cw4Var, this.b.mContext, 19, false, computeViewArea);
                return;
            }
            yk8.f((qm6) cw4Var);
            yk8.c(cw4Var, this.b.mContext, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk8 a;

        public c(qk8 qk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qk8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof an6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                an6 an6Var = (an6) piVar;
                an6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), an6Var);
                }
                yk8.c(an6Var, view2.getContext(), 19, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk8(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.a = tbPageContext;
    }

    public final void B(View view2, an6 an6Var) {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, an6Var) == null) && (kuVar = this.d) != null && kuVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                yk8.h(an6Var);
            } else if (view2.getId() == R.id.thread_card_root) {
                yk8.f(an6Var);
            }
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.b = bdUniqueId;
        }
    }

    public void F(yh8 yh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yh8Var) == null) {
            this.e = yh8Var;
        }
    }

    public void G(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viVar) == null) {
            this.c = viVar;
        }
    }

    public final cea A(an6 an6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, an6Var)) == null) {
            if (an6Var != null) {
                cea ceaVar = new cea();
                ceaVar.a = "19";
                ceaVar.c = an6Var.g;
                if (an6Var.getThreadData() != null) {
                    ceaVar.d = String.valueOf(an6Var.getThreadData().getFid());
                    ceaVar.v = an6Var.getThreadData().getNid();
                    if (an6Var.getThreadData().getThreadVideoInfo() != null) {
                        ceaVar.m = an6Var.getThreadData().getThreadVideoInfo().video_md5;
                        ceaVar.p = String.valueOf(an6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ceaVar.k = an6Var.e();
                ceaVar.f = an6Var.k();
                ceaVar.l = an6Var.c();
                ceaVar.h = an6Var.u();
                ceaVar.e = TbadkCoreApplication.getCurrentAccount();
                ceaVar.q = String.valueOf(an6Var.h());
                if (an6Var.getThreadData() != null && an6Var.getThreadData().getBaijiahaoData() != null) {
                    ceaVar.t = an6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    ceaVar.u = an6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return ceaVar;
                }
                return ceaVar;
            }
            return null;
        }
        return (cea) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: C */
    public AutoVideoCardViewHolder<an6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.a.getPageActivity(), false);
            us usVar = new us(this.a.getPageActivity());
            usVar.z(new b(this, usVar));
            this.d = usVar;
            usVar.o(this.b);
            this.d.setFrom("video_tab");
            this.d.setStageType("2001");
            bVar.n(this.d);
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<an6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.b);
            k.r(this.f);
            k.t(19);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, an6 an6Var, AutoVideoCardViewHolder<an6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, an6Var, autoVideoCardViewHolder})) == null) {
            if (an6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            an6Var.B(an6Var.position + 1);
            autoVideoCardViewHolder.a().s(i);
            autoVideoCardViewHolder.z(A(an6Var));
            yk8.d(an6Var);
            autoVideoCardViewHolder.e(an6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (kuVar = this.d) != null) {
            kuVar.x();
        }
    }
}
