package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.os;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uy9 extends ci<en6, AutoVideoCardViewHolder<en6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public vi c;
    public ku d;
    public mm6<en6> e;

    /* loaded from: classes8.dex */
    public class a extends mm6<en6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uy9 b;

        public a(uy9 uy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uy9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, en6 en6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, en6Var) == null) {
                em6.b().d(true);
                if (en6Var != null && en6Var.getThreadData() != null && !StringUtils.isNull(en6Var.getThreadData().getTid())) {
                    if (en6Var.getThreadData().middle_page_num <= 0) {
                        this.b.A(view2, en6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(en6Var.G(en6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;
        public final /* synthetic */ uy9 b;

        public b(uy9 uy9Var, ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uy9Var, kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uy9Var;
            this.a = kuVar;
        }

        @Override // com.baidu.tieba.os.a
        public void a(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, fw4Var) != null) || fw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (fw4Var instanceof en6) {
                fw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(fw4Var, this.b.mContext, 0, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(fw4Var, this.b.mContext, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uy9 a;

        public c(uy9 uy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uy9Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof en6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                en6 en6Var = (en6) piVar;
                en6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), en6Var);
                }
                ThreadCardUtils.jumpToPB((fw4) en6Var, view2.getContext(), en6Var.C, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uy9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public final void A(View view2, en6 en6Var) {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, en6Var) == null) && (kuVar = this.d) != null && kuVar.s() != null && this.d.s().getMainView() != null) {
            if (view2.getId() == this.d.s().getMainView().getId()) {
                b6a.o(en6Var, 4, this.b);
            } else if (view2.getId() == R.id.thread_card_root) {
                b6a.o(en6Var, 1, this.b);
            }
        }
    }

    public void D(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viVar) == null) {
            this.c = viVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: B */
    public AutoVideoCardViewHolder<en6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            bVar.l().k(true);
            us usVar = new us(this.b.getPageActivity());
            usVar.o(this.a);
            usVar.setFrom("pb");
            usVar.z(new b(this, usVar));
            this.d = usVar;
            bVar.n(usVar);
            ku kuVar = this.d;
            if (kuVar != null) {
                kuVar.setStageType("2002");
            }
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<en6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.e);
            k.t(0);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final gea z(en6 en6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, en6Var)) == null) {
            if (en6Var != null) {
                gea geaVar = new gea();
                geaVar.a = "6";
                geaVar.c = en6Var.g;
                if (en6Var.getThreadData() != null) {
                    geaVar.d = String.valueOf(en6Var.getThreadData().getFid());
                    if (en6Var.getThreadData().getThreadVideoInfo() != null) {
                        geaVar.m = en6Var.getThreadData().getThreadVideoInfo().video_md5;
                        geaVar.p = String.valueOf(en6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                geaVar.k = en6Var.e();
                geaVar.f = en6Var.k();
                geaVar.l = en6Var.c();
                geaVar.h = en6Var.u();
                geaVar.e = TbadkCoreApplication.getCurrentAccount();
                geaVar.q = String.valueOf(en6Var.h());
                return geaVar;
            }
            return null;
        }
        return (gea) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, en6 en6Var, AutoVideoCardViewHolder<en6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, en6Var, autoVideoCardViewHolder})) == null) {
            if (en6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            en6Var.B(en6Var.position + 1);
            autoVideoCardViewHolder.a().s(i);
            en6Var.f1089T = 0;
            autoVideoCardViewHolder.z(z(en6Var));
            autoVideoCardViewHolder.e(en6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.e);
            b6a.q(en6Var, this.b);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
