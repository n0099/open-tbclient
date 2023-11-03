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
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.tieba.ns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y88 extends bi<om6, AutoVideoCardViewHolder<om6>> implements s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public ui d;
    public ju e;
    public xl6<om6> f;

    /* loaded from: classes9.dex */
    public class a extends xl6<om6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y88 b;

        public a(y88 y88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y88Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xl6
        /* renamed from: d */
        public void a(View view2, om6 om6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, om6Var) == null) {
                pl6.b().d(true);
                q16.c().h("page_recommend", "show_");
                if (om6Var != null && om6Var.getThreadData() != null && !StringUtils.isNull(om6Var.getThreadData().getTid())) {
                    if (om6Var.getThreadData().middle_page_num <= 0) {
                        this.b.A(view2, om6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(om6Var.G(om6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ y88 b;

        public b(y88 y88Var, ju juVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y88Var, juVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y88Var;
            this.a = juVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bw4Var) != null) || bw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (bw4Var instanceof om6) {
                bw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(bw4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(bw4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y88 a;

        public c(y88 y88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y88Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof om6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                om6 om6Var = (om6) oiVar;
                om6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), om6Var);
                }
                ThreadCardUtils.jumpToPB((bw4) om6Var, view2.getContext(), 1, false, rs.a((ui) viewGroup, view2, i));
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y88(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, om6 om6Var) {
        ju juVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, om6Var) == null) && (juVar = this.e) != null && juVar.s() != null && this.e.s().getMainView() != null) {
            if (view2.getId() == this.e.s().getMainView().getId()) {
                y78.b(view2, om6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                y78.b(view2, om6Var, 2);
            }
        }
    }

    public void D(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uiVar) == null) {
            this.d = uiVar;
        }
    }

    @Override // com.baidu.tieba.s16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: B */
    public AutoVideoCardViewHolder<om6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.b.getPageActivity(), false);
            nf8 nf8Var = new nf8(this.b.getPageActivity());
            nf8Var.o(this.a);
            nf8Var.setFrom("concern_tab");
            nf8Var.z(new b(this, nf8Var));
            this.e = nf8Var;
            bVar.n(nf8Var);
            ju juVar = this.e;
            if (juVar != null) {
                juVar.setStageType("2001");
            }
            bu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<om6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.f);
            k.t(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final f9a z(om6 om6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, om6Var)) == null) {
            if (om6Var != null) {
                f9a f9aVar = new f9a();
                f9aVar.a = "7";
                f9aVar.c = om6Var.g;
                if (om6Var.getThreadData() != null) {
                    f9aVar.d = String.valueOf(om6Var.getThreadData().getFid());
                    if (om6Var.getThreadData().getThreadVideoInfo() != null) {
                        f9aVar.m = om6Var.getThreadData().getThreadVideoInfo().video_md5;
                        f9aVar.p = String.valueOf(om6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                f9aVar.k = om6Var.e();
                f9aVar.f = om6Var.i();
                f9aVar.l = om6Var.c();
                f9aVar.h = om6Var.u();
                f9aVar.e = TbadkCoreApplication.getCurrentAccount();
                f9aVar.q = String.valueOf(om6Var.h());
                return f9aVar;
            }
            return null;
        }
        return (f9a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, om6 om6Var, AutoVideoCardViewHolder<om6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, om6Var, autoVideoCardViewHolder})) == null) {
            if (om6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            om6Var.A(om6Var.position + 1);
            pl6.b().a(om6Var.d("c12351"));
            autoVideoCardViewHolder.a().s(i);
            om6Var.f1142T = 0;
            autoVideoCardViewHolder.z(z(om6Var));
            if (autoVideoCardViewHolder.a() instanceof r16) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(om6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
