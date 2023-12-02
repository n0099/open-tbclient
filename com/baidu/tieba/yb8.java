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
/* loaded from: classes9.dex */
public class yb8 extends ci<en6, AutoVideoCardViewHolder<en6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public vi d;
    public ku e;
    public mm6<en6> f;

    /* loaded from: classes9.dex */
    public class a extends mm6<en6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb8 b;

        public a(yb8 yb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, en6 en6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, en6Var) == null) {
                em6.b().d(true);
                c26.c().h("page_recommend", "show_");
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

    /* loaded from: classes9.dex */
    public class b implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;
        public final /* synthetic */ yb8 b;

        public b(yb8 yb8Var, ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb8Var, kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yb8Var;
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
                ThreadCardUtils.jumpToPB(fw4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(fw4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb8 a;

        public c(yb8 yb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yb8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof en6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                en6 en6Var = (en6) piVar;
                en6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), en6Var);
                }
                ThreadCardUtils.jumpToPB((fw4) en6Var, view2.getContext(), 1, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = tbPageContext;
    }

    public final void A(View view2, en6 en6Var) {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, en6Var) == null) && (kuVar = this.e) != null && kuVar.s() != null && this.e.s().getMainView() != null) {
            if (view2.getId() == this.e.s().getMainView().getId()) {
                ya8.b(view2, en6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                ya8.b(view2, en6Var, 2);
            }
        }
    }

    public void D(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viVar) == null) {
            this.d = viVar;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
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
            qi8 qi8Var = new qi8(this.b.getPageActivity());
            qi8Var.o(this.a);
            qi8Var.setFrom("concern_tab");
            qi8Var.z(new b(this, qi8Var));
            this.e = qi8Var;
            bVar.n(qi8Var);
            ku kuVar = this.e;
            if (kuVar != null) {
                kuVar.setStageType("2001");
            }
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<en6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.f);
            k.t(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final gea z(en6 en6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, en6Var)) == null) {
            if (en6Var != null) {
                gea geaVar = new gea();
                geaVar.a = "7";
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
            em6.b().a(en6Var.d("c12351"));
            autoVideoCardViewHolder.a().s(i);
            en6Var.f1089T = 0;
            autoVideoCardViewHolder.z(z(en6Var));
            if (autoVideoCardViewHolder.a() instanceof d26) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(en6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
