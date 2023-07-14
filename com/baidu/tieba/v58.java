package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tieba.mz;
import com.baidu.tieba.xx;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v58 extends ln<lq6, AutoVideoCardViewHolder<lq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public s68 c;
    public String d;
    public eo e;
    public uz f;
    public up6<lq6> g;

    /* loaded from: classes8.dex */
    public class a extends up6<lq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v58 b;

        public a(v58 v58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq6Var) == null) {
                np6.b().d(true);
                r66.c().h("page_recommend", "show_");
                if (this.b.c != null && lq6Var != null && lq6Var.getThreadData() != null && !StringUtils.isNull(lq6Var.getThreadData().getTid())) {
                    if (lq6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lq6Var.J(lq6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !u48.b(wg.g(lq6Var.getThreadData().getTid(), 0L))) {
                        u48.a(wg.g(lq6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(wg.g(lq6Var.getThreadData().getTid(), 0L), lq6Var.v(), lq6Var.i(), lq6Var.h(), lq6Var.c(), wg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, lq6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, lq6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz a;
        public final /* synthetic */ v58 b;

        public b(v58 v58Var, uz uzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v58Var, uzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v58Var;
            this.a = uzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, t15Var) != null) || t15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (t15Var instanceof lq6) {
                t15Var.objType = 5;
                ThreadCardUtils.jumpToPB(t15Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(t15Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v58 a;

        public c(v58 v58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v58Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof lq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                lq6 lq6Var = (lq6) ynVar;
                lq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), lq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) lq6Var, view2.getContext(), 2, false, by.a((eo) viewGroup, view2, i));
                autoVideoCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s68Var) == null) {
            this.c = s68Var;
        }
    }

    public void F(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eoVar) == null) {
            this.e = eoVar;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, lq6 lq6Var) {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, lq6Var) == null) && (uzVar = this.f) != null && uzVar.x() != null && this.f.x().getMainView() != null) {
            if (view2.getId() == this.f.x().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, lq6Var);
                x68.d(lq6Var.a, this.a, lq6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lq6Var.L()));
                x68.c(lq6Var.a, lq6Var.i(), lq6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lq6Var.J(lq6Var.a)));
                x68.c(lq6Var.a, lq6Var.i(), lq6Var.h(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lq6.V = "c10708";
            lq6.W = "c10735";
            lq6.X = "c10709";
            lq6.Y = "c10734";
            lq6.Z = "c11929";
            lq6.a0 = "c11928";
            lq6.b0 = "c10756";
        }
    }

    public void onPause() {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (uzVar = this.f) != null) {
            uzVar.A();
        }
    }

    public void onResume() {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (uzVar = this.f) != null) {
            uzVar.B();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: C */
    public AutoVideoCardViewHolder<lq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            e78 e78Var = new e78(this.b.getPageActivity());
            e78Var.C(new b(this, e78Var));
            this.f = e78Var;
            e78Var.r(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, autoVideoCardViewHolder})) == null) {
            if (lq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lq6Var.B(lq6Var.position + 1);
            lq6Var.a.statFloor = lq6Var.h();
            autoVideoCardViewHolder.b().r(i);
            lq6Var.f1139T = 0;
            np6.b().a(lq6Var.r());
            autoVideoCardViewHolder.y(z(lq6Var));
            if (autoVideoCardViewHolder.b() != null) {
                autoVideoCardViewHolder.b().b(this.d);
            }
            autoVideoCardViewHolder.f(lq6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.g);
            x68.p(lq6Var.a, this.a, lq6Var.h());
            x68.o(lq6Var.a, lq6Var.i(), lq6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final av9 z(lq6 lq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, lq6Var)) == null) {
            if (lq6Var != null) {
                av9 av9Var = new av9();
                av9Var.a = "1";
                av9Var.c = lq6Var.g;
                if (lq6Var.getThreadData() != null) {
                    av9Var.d = String.valueOf(lq6Var.getThreadData().getFid());
                    av9Var.v = lq6Var.getThreadData().getNid();
                    if (lq6Var.getThreadData().getThreadVideoInfo() != null) {
                        av9Var.m = lq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        av9Var.p = String.valueOf(lq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                av9Var.k = lq6Var.e();
                av9Var.f = lq6Var.i();
                av9Var.l = lq6Var.c();
                av9Var.h = lq6Var.v();
                av9Var.e = TbadkCoreApplication.getCurrentAccount();
                av9Var.q = String.valueOf(lq6Var.h());
                if (lq6Var.getThreadData() != null && lq6Var.getThreadData().getBaijiahaoData() != null) {
                    av9Var.t = lq6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    av9Var.u = lq6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return av9Var;
                }
                return av9Var;
            }
            return null;
        }
        return (av9) invokeL.objValue;
    }
}
