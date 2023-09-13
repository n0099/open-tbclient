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
import com.baidu.tieba.ax;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r68 extends pm<dq6, AutoVideoCardViewHolder<dq6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public s78 c;
    public String d;
    public in e;
    public wy f;
    public mp6<dq6> g;

    /* loaded from: classes7.dex */
    public class a extends mp6<dq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r68 b;

        public a(r68 r68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, dq6 dq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dq6Var) == null) {
                ep6.b().d(true);
                m56.c().h("page_recommend", "show_");
                if (this.b.c != null && dq6Var != null && dq6Var.getThreadData() != null && !StringUtils.isNull(dq6Var.getThreadData().getTid())) {
                    if (dq6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(dq6Var.G(dq6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !o58.b(JavaTypesHelper.toLong(dq6Var.getThreadData().getTid(), 0L))) {
                        o58.a(JavaTypesHelper.toLong(dq6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(dq6Var.getThreadData().getTid(), 0L), dq6Var.u(), dq6Var.i(), dq6Var.h(), dq6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, dq6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, dq6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ax.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy a;
        public final /* synthetic */ r68 b;

        public b(r68 r68Var, wy wyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r68Var, wyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r68Var;
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
                ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(b15Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r68 a;

        public c(r68 r68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r68Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof dq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                dq6 dq6Var = (dq6) cnVar;
                dq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), dq6Var);
                }
                ThreadCardUtils.jumpToPB((b15) dq6Var, view2.getContext(), 2, false, ex.a((in) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r68(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s78Var) == null) {
            this.c = s78Var;
        }
    }

    public void F(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, inVar) == null) {
            this.e = inVar;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, dq6 dq6Var) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, dq6Var) == null) && (wyVar = this.f) != null && wyVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, dq6Var);
                x78.d(dq6Var.a, this.a, dq6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(dq6Var.J()));
                x78.c(dq6Var.a, dq6Var.i(), dq6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(dq6Var.G(dq6Var.a)));
                x78.c(dq6Var.a, dq6Var.i(), dq6Var.h(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dq6.V = "c10708";
            dq6.W = "c10735";
            dq6.X = "c10709";
            dq6.Y = "c10734";
            dq6.Z = "c11929";
            dq6.a0 = "c11928";
            dq6.b0 = "c10756";
        }
    }

    public void onPause() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (wyVar = this.f) != null) {
            wyVar.y();
        }
    }

    public void onResume() {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (wyVar = this.f) != null) {
            wyVar.z();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: C */
    public AutoVideoCardViewHolder<dq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            f88 f88Var = new f88(this.b.getPageActivity());
            f88Var.A(new b(this, f88Var));
            this.f = f88Var;
            f88Var.p(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<dq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dq6 dq6Var, AutoVideoCardViewHolder<dq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dq6Var, autoVideoCardViewHolder})) == null) {
            if (dq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            dq6Var.B(dq6Var.position + 1);
            dq6Var.a.statFloor = dq6Var.h();
            autoVideoCardViewHolder.a().r(i);
            dq6Var.f1091T = 0;
            ep6.b().a(dq6Var.s());
            autoVideoCardViewHolder.x(z(dq6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(dq6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            x78.p(dq6Var.a, this.a, dq6Var.h());
            x78.o(dq6Var.a, dq6Var.i(), dq6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final pz9 z(dq6 dq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, dq6Var)) == null) {
            if (dq6Var != null) {
                pz9 pz9Var = new pz9();
                pz9Var.a = "1";
                pz9Var.c = dq6Var.g;
                if (dq6Var.getThreadData() != null) {
                    pz9Var.d = String.valueOf(dq6Var.getThreadData().getFid());
                    pz9Var.v = dq6Var.getThreadData().getNid();
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
                if (dq6Var.getThreadData() != null && dq6Var.getThreadData().getBaijiahaoData() != null) {
                    pz9Var.t = dq6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    pz9Var.u = dq6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return pz9Var;
                }
                return pz9Var;
            }
            return null;
        }
        return (pz9) invokeL.objValue;
    }
}
