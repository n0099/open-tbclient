package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.CardLinkageManager;
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
public class l38 extends lm<tn6, AutoVideoCardViewHolder<tn6>> implements b46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public m48 c;
    public String d;
    public en e;
    public sy f;
    public cn6<tn6> g;

    /* loaded from: classes6.dex */
    public class a extends cn6<tn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l38 b;

        public a(l38 l38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, tn6 tn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tn6Var) == null) {
                vm6.b().d(true);
                z36.c().h("page_recommend", "show_");
                if (this.b.c != null && tn6Var != null && tn6Var.getThreadData() != null && !StringUtils.isNull(tn6Var.getThreadData().getTid())) {
                    if (tn6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(tn6Var.G(tn6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !i28.b(JavaTypesHelper.toLong(tn6Var.getThreadData().getTid(), 0L))) {
                        i28.a(JavaTypesHelper.toLong(tn6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(tn6Var.getThreadData().getTid(), 0L), tn6Var.u(), tn6Var.i(), tn6Var.h(), tn6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, tn6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, tn6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ww.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;
        public final /* synthetic */ l38 b;

        public b(l38 l38Var, sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var, syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l38Var;
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
                ThreadCardUtils.jumpToPB(q05Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(q05Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l38 a;

        public c(l38 l38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l38Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ymVar instanceof tn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                tn6 tn6Var = (tn6) ymVar;
                tn6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), tn6Var);
                }
                ThreadCardUtils.jumpToPB((q05) tn6Var, view2.getContext(), 2, false, ax.a((en) viewGroup, view2, i));
                autoVideoCardViewHolder.b().p(new vy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l38(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = tbPageContext;
        B();
    }

    public void E(m48 m48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, m48Var) == null) {
            this.c = m48Var;
        }
    }

    public void F(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, enVar) == null) {
            this.e = enVar;
        }
    }

    @Override // com.baidu.tieba.b46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, tn6 tn6Var) {
        sy syVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, tn6Var) == null) && (syVar = this.f) != null && syVar.u() != null && this.f.u().getMainView() != null) {
            if (view2.getId() == this.f.u().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, tn6Var);
                r48.d(tn6Var.a, this.a, tn6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(tn6Var.I()));
                r48.c(tn6Var.a, tn6Var.i(), tn6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(tn6Var.G(tn6Var.a)));
                r48.c(tn6Var.a, tn6Var.i(), tn6Var.h(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            tn6.V = "c10708";
            tn6.W = "c10735";
            tn6.X = "c10709";
            tn6.Y = "c10734";
            tn6.Z = "c11929";
            tn6.a0 = "c11928";
            tn6.b0 = "c10756";
        }
    }

    public void onPause() {
        sy syVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (syVar = this.f) != null) {
            syVar.z();
        }
    }

    public void onResume() {
        sy syVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (syVar = this.f) != null) {
            syVar.A();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: C */
    public AutoVideoCardViewHolder<tn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.b.getPageActivity(), false);
            y48 y48Var = new y48(this.b.getPageActivity());
            y48Var.B(new b(this, y48Var));
            this.f = y48Var;
            y48Var.q(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            ky k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<tn6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tn6 tn6Var, AutoVideoCardViewHolder<tn6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tn6Var, autoVideoCardViewHolder})) == null) {
            if (tn6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            tn6Var.A(tn6Var.position + 1);
            tn6Var.a.statFloor = tn6Var.h();
            autoVideoCardViewHolder.b().r(i);
            tn6Var.f1169T = 0;
            vm6.b().a(tn6Var.r());
            autoVideoCardViewHolder.y(z(tn6Var));
            if (autoVideoCardViewHolder.b() != null) {
                autoVideoCardViewHolder.b().b(this.d);
            }
            autoVideoCardViewHolder.f(tn6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.g);
            r48.p(tn6Var.a, this.a, tn6Var.h());
            r48.o(tn6Var.a, tn6Var.i(), tn6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final tt9 z(tn6 tn6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, tn6Var)) == null) {
            if (tn6Var != null) {
                tt9 tt9Var = new tt9();
                tt9Var.a = "1";
                tt9Var.c = tn6Var.g;
                if (tn6Var.getThreadData() != null) {
                    tt9Var.d = String.valueOf(tn6Var.getThreadData().getFid());
                    tt9Var.v = tn6Var.getThreadData().getNid();
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
                if (tn6Var.getThreadData() != null && tn6Var.getThreadData().getBaijiahaoData() != null) {
                    tt9Var.t = tn6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    tt9Var.u = tn6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return tt9Var;
                }
                return tt9Var;
            }
            return null;
        }
        return (tt9) invokeL.objValue;
    }
}
