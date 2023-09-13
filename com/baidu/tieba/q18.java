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
import com.baidu.tieba.ax;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q18 extends pm<dq6, AutoVideoCardViewHolder<dq6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public in d;
    public wy e;
    public mp6<dq6> f;

    /* loaded from: classes7.dex */
    public class a extends mp6<dq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q18 b;

        public a(q18 q18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dq6Var) == null) {
                ep6.b().d(true);
                m56.c().h("page_recommend", "show_");
                if (dq6Var != null && dq6Var.getThreadData() != null && !StringUtils.isNull(dq6Var.getThreadData().getTid())) {
                    if (dq6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, dq6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(dq6Var.G(dq6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ q18 b;

        public b(q18 q18Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q18Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q18Var;
            this.a = wyVar;
        }

        @Override // com.baidu.tieba.ax.a
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, b15Var) != null) || b15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (b15Var instanceof dq6) {
                b15Var.objType = 5;
                ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q18 a;

        public c(q18 q18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q18Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof dq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dq6 dq6Var = (dq6) cnVar;
                dq6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), dq6Var);
                }
                ThreadCardUtils.jumpToPB((b15) dq6Var, view2.getContext(), 1, false, ex.a((in) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void z(View view2, dq6 dq6Var) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, dq6Var) == null) && (wyVar = this.e) != null && wyVar.t() != null && this.e.t().getMainView() != null) {
            if (view2.getId() == this.e.t().getMainView().getId()) {
                q08.b(view2, dq6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                q08.b(view2, dq6Var, 2);
            }
        }
    }

    public void C(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inVar) == null) {
            this.d = inVar;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: A */
    public AutoVideoCardViewHolder<dq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            f88 f88Var = new f88(this.b.getPageActivity());
            f88Var.p(this.a);
            f88Var.setFrom("concern_tab");
            f88Var.A(new b(this, f88Var));
            this.e = f88Var;
            bVar.n(f88Var);
            wy wyVar = this.e;
            if (wyVar != null) {
                wyVar.setStageType("2001");
            }
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<dq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.f);
            k.s(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final pz9 y(dq6 dq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dq6Var)) == null) {
            if (dq6Var != null) {
                pz9 pz9Var = new pz9();
                pz9Var.a = "7";
                pz9Var.c = dq6Var.g;
                if (dq6Var.getThreadData() != null) {
                    pz9Var.d = String.valueOf(dq6Var.getThreadData().getFid());
                    if (dq6Var.getThreadData().getThreadVideoInfo() != null) {
                        pz9Var.m = dq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        pz9Var.p = String.valueOf(dq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                pz9Var.k = dq6Var.e();
                pz9Var.f = dq6Var.i();
                pz9Var.l = dq6Var.c();
                pz9Var.h = dq6Var.u();
                pz9Var.e = TbadkCoreApplication.getCurrentAccount();
                pz9Var.q = String.valueOf(dq6Var.h());
                return pz9Var;
            }
            return null;
        }
        return (pz9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dq6 dq6Var, AutoVideoCardViewHolder<dq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dq6Var, autoVideoCardViewHolder})) == null) {
            if (dq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            dq6Var.B(dq6Var.position + 1);
            ep6.b().a(dq6Var.d("c12351"));
            autoVideoCardViewHolder.a().r(i);
            dq6Var.f1091T = 0;
            autoVideoCardViewHolder.x(y(dq6Var));
            if (autoVideoCardViewHolder.a() instanceof n56) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(dq6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
