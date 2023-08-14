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
import com.baidu.tieba.ky;
import com.baidu.tieba.vy;
import com.baidu.tieba.ww;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ly7 extends lm<tn6, AutoVideoCardViewHolder<tn6>> implements b46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public en d;
    public sy e;
    public cn6<tn6> f;

    /* loaded from: classes6.dex */
    public class a extends cn6<tn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly7 b;

        public a(ly7 ly7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ly7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, tn6 tn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tn6Var) == null) {
                vm6.b().d(true);
                z36.c().h("page_recommend", "show_");
                if (tn6Var != null && tn6Var.getThreadData() != null && !StringUtils.isNull(tn6Var.getThreadData().getTid())) {
                    if (tn6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, tn6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(tn6Var.G(tn6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ww.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;
        public final /* synthetic */ ly7 b;

        public b(ly7 ly7Var, sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly7Var, syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ly7Var;
            this.a = syVar;
        }

        @Override // com.baidu.tieba.ww.a
        public void a(q05 q05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, q05Var) != null) || q05Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (q05Var instanceof tn6) {
                q05Var.objType = 5;
                ThreadCardUtils.jumpToPB(q05Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(q05Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly7 a;

        public c(ly7 ly7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ly7Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ymVar instanceof tn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                tn6 tn6Var = (tn6) ymVar;
                tn6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), tn6Var);
                }
                ThreadCardUtils.jumpToPB((q05) tn6Var, view2.getContext(), 1, false, ax.a((en) viewGroup, view2, i));
                threadCardViewHolder.b().p(new vy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void z(View view2, tn6 tn6Var) {
        sy syVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, tn6Var) == null) && (syVar = this.e) != null && syVar.u() != null && this.e.u().getMainView() != null) {
            if (view2.getId() == this.e.u().getMainView().getId()) {
                lx7.b(view2, tn6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                lx7.b(view2, tn6Var, 2);
            }
        }
    }

    public void C(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, enVar) == null) {
            this.d = enVar;
        }
    }

    @Override // com.baidu.tieba.b46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: A */
    public AutoVideoCardViewHolder<tn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.b.getPageActivity(), false);
            y48 y48Var = new y48(this.b.getPageActivity());
            y48Var.q(this.a);
            y48Var.setFrom("concern_tab");
            y48Var.B(new b(this, y48Var));
            this.e = y48Var;
            bVar.n(y48Var);
            sy syVar = this.e;
            if (syVar != null) {
                syVar.setStageType("2001");
            }
            ky k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<tn6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.a);
            k.q(this.f);
            k.s(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final tt9 y(tn6 tn6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tn6Var)) == null) {
            if (tn6Var != null) {
                tt9 tt9Var = new tt9();
                tt9Var.a = "7";
                tt9Var.c = tn6Var.g;
                if (tn6Var.getThreadData() != null) {
                    tt9Var.d = String.valueOf(tn6Var.getThreadData().getFid());
                    if (tn6Var.getThreadData().getThreadVideoInfo() != null) {
                        tt9Var.m = tn6Var.getThreadData().getThreadVideoInfo().video_md5;
                        tt9Var.p = String.valueOf(tn6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                tt9Var.k = tn6Var.e();
                tt9Var.f = tn6Var.i();
                tt9Var.l = tn6Var.c();
                tt9Var.h = tn6Var.u();
                tt9Var.e = TbadkCoreApplication.getCurrentAccount();
                tt9Var.q = String.valueOf(tn6Var.h());
                return tt9Var;
            }
            return null;
        }
        return (tt9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tn6 tn6Var, AutoVideoCardViewHolder<tn6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tn6Var, autoVideoCardViewHolder})) == null) {
            if (tn6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            tn6Var.A(tn6Var.position + 1);
            vm6.b().a(tn6Var.d("c12351"));
            autoVideoCardViewHolder.b().r(i);
            tn6Var.f1169T = 0;
            autoVideoCardViewHolder.y(y(tn6Var));
            if (autoVideoCardViewHolder.b() instanceof a46) {
                autoVideoCardViewHolder.b().b(this.c);
            }
            autoVideoCardViewHolder.f(tn6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
