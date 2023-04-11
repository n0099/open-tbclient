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
import com.baidu.tieba.dy;
import com.baidu.tieba.oy;
import com.baidu.tieba.pw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class or7 extends um<nh6, AutoVideoCardViewHolder<nh6>> implements py5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public hs7 c;
    public String d;
    public nn e;
    public ly f;
    public xg6<nh6> g;

    /* loaded from: classes5.dex */
    public class a extends xg6<nh6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or7 b;

        public a(or7 or7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = or7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg6
        /* renamed from: d */
        public void a(View view2, nh6 nh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nh6Var) == null) {
                qg6.b().d(true);
                ny5.c().h("page_recommend", "show_");
                if (this.b.c != null && nh6Var != null && nh6Var.getThreadData() != null && !StringUtils.isNull(nh6Var.getThreadData().getTid())) {
                    if (nh6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(nh6Var.L(nh6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !mq7.b(gg.g(nh6Var.getThreadData().getTid(), 0L))) {
                        mq7.a(gg.g(nh6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(gg.g(nh6Var.getThreadData().getTid(), 0L), nh6Var.w(), nh6Var.k(), nh6Var.i(), nh6Var.c(), gg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, nh6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, nh6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly a;
        public final /* synthetic */ or7 b;

        public b(or7 or7Var, ly lyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or7Var, lyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = or7Var;
            this.a = lyVar;
        }

        @Override // com.baidu.tieba.pw.a
        public void a(jw4 jw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jw4Var) != null) || jw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (jw4Var instanceof nh6) {
                jw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(jw4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(jw4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or7 a;

        public c(or7 or7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {or7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or7Var;
        }

        @Override // com.baidu.tieba.rn
        public void b(View view2, hn hnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, hnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (hnVar instanceof nh6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                nh6 nh6Var = (nh6) hnVar;
                nh6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), nh6Var);
                }
                ThreadCardUtils.jumpToPB((jw4) nh6Var, view2.getContext(), 2, false, tw.a((nn) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new oy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public or7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(hs7 hs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hs7Var) == null) {
            this.c = hs7Var;
        }
    }

    public void F(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nnVar) == null) {
            this.e = nnVar;
        }
    }

    @Override // com.baidu.tieba.py5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, nh6 nh6Var) {
        ly lyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, nh6Var) == null) && (lyVar = this.f) != null && lyVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, nh6Var);
                ms7.d(nh6Var.a, this.a, nh6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(nh6Var.N()));
                ms7.c(nh6Var.a, nh6Var.k(), nh6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(nh6Var.L(nh6Var.a)));
                ms7.c(nh6Var.a, nh6Var.k(), nh6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nh6.V = "c10708";
            nh6.W = "c10735";
            nh6.X = "c10709";
            nh6.Y = "c10734";
            nh6.Z = "c11929";
            nh6.a0 = "c11928";
            nh6.b0 = "c10756";
        }
    }

    public void onPause() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (lyVar = this.f) != null) {
            lyVar.w();
        }
    }

    public void onResume() {
        ly lyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (lyVar = this.f) != null) {
            lyVar.x();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: C */
    public AutoVideoCardViewHolder<nh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.b.getPageActivity(), false);
            rs7 rs7Var = new rs7(this.b.getPageActivity());
            rs7Var.z(new b(this, rs7Var));
            this.f = rs7Var;
            rs7Var.B(this.a);
            this.f.y("index");
            this.f.C("2001");
            bVar.n(this.f);
            dy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<nh6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nh6 nh6Var, AutoVideoCardViewHolder<nh6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nh6Var, autoVideoCardViewHolder})) == null) {
            if (nh6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            nh6Var.E(nh6Var.position + 1);
            nh6Var.a.statFloor = nh6Var.i();
            autoVideoCardViewHolder.a().r(i);
            nh6Var.T = 0;
            qg6.b().a(nh6Var.u());
            autoVideoCardViewHolder.u(z(nh6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(nh6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            ms7.p(nh6Var.a, this.a, nh6Var.i());
            ms7.o(nh6Var.a, nh6Var.k(), nh6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final u79 z(nh6 nh6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, nh6Var)) == null) {
            if (nh6Var != null) {
                u79 u79Var = new u79();
                u79Var.a = "1";
                u79Var.c = nh6Var.g;
                if (nh6Var.getThreadData() != null) {
                    u79Var.d = String.valueOf(nh6Var.getThreadData().getFid());
                    u79Var.v = nh6Var.getThreadData().getNid();
                    if (nh6Var.getThreadData().getThreadVideoInfo() != null) {
                        u79Var.m = nh6Var.getThreadData().getThreadVideoInfo().video_md5;
                        u79Var.p = String.valueOf(nh6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                u79Var.k = nh6Var.e();
                u79Var.f = nh6Var.k();
                u79Var.l = nh6Var.c();
                u79Var.h = nh6Var.w();
                u79Var.e = TbadkCoreApplication.getCurrentAccount();
                u79Var.q = String.valueOf(nh6Var.i());
                if (nh6Var.getThreadData() != null && nh6Var.getThreadData().getBaijiahaoData() != null) {
                    u79Var.t = nh6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    u79Var.u = nh6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return u79Var;
                }
                return u79Var;
            }
            return null;
        }
        return (u79) invokeL.objValue;
    }
}
