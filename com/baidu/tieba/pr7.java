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
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.qw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pr7 extends vm<oh6, AutoVideoCardViewHolder<oh6>> implements qy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public is7 c;
    public String d;
    public on e;
    public my f;
    public yg6<oh6> g;

    /* loaded from: classes5.dex */
    public class a extends yg6<oh6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr7 b;

        public a(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg6
        /* renamed from: d */
        public void a(View view2, oh6 oh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, oh6Var) == null) {
                rg6.b().d(true);
                oy5.c().h("page_recommend", "show_");
                if (this.b.c != null && oh6Var != null && oh6Var.getThreadData() != null && !StringUtils.isNull(oh6Var.getThreadData().getTid())) {
                    if (oh6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(oh6Var.L(oh6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !nq7.b(gg.g(oh6Var.getThreadData().getTid(), 0L))) {
                        nq7.a(gg.g(oh6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(gg.g(oh6Var.getThreadData().getTid(), 0L), oh6Var.w(), oh6Var.k(), oh6Var.i(), oh6Var.c(), gg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, oh6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, oh6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;
        public final /* synthetic */ pr7 b;

        public b(pr7 pr7Var, my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var, myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pr7Var;
            this.a = myVar;
        }

        @Override // com.baidu.tieba.qw.a
        public void a(kw4 kw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, kw4Var) != null) || kw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (kw4Var instanceof oh6) {
                kw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(kw4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(kw4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements sn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr7 a;

        public c(pr7 pr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pr7Var;
        }

        @Override // com.baidu.tieba.sn
        public void b(View view2, in inVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, inVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (inVar instanceof oh6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                oh6 oh6Var = (oh6) inVar;
                oh6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), oh6Var);
                }
                ThreadCardUtils.jumpToPB((kw4) oh6Var, view2.getContext(), 2, false, uw.a((on) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pr7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(is7 is7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, is7Var) == null) {
            this.c = is7Var;
        }
    }

    public void F(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onVar) == null) {
            this.e = onVar;
        }
    }

    @Override // com.baidu.tieba.qy5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, oh6 oh6Var) {
        my myVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, oh6Var) == null) && (myVar = this.f) != null && myVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, oh6Var);
                ns7.d(oh6Var.a, this.a, oh6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(oh6Var.N()));
                ns7.c(oh6Var.a, oh6Var.k(), oh6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(oh6Var.L(oh6Var.a)));
                ns7.c(oh6Var.a, oh6Var.k(), oh6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            oh6.V = "c10708";
            oh6.W = "c10735";
            oh6.X = "c10709";
            oh6.Y = "c10734";
            oh6.Z = "c11929";
            oh6.a0 = "c11928";
            oh6.b0 = "c10756";
        }
    }

    public void onPause() {
        my myVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (myVar = this.f) != null) {
            myVar.w();
        }
    }

    public void onResume() {
        my myVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (myVar = this.f) != null) {
            myVar.x();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: C */
    public AutoVideoCardViewHolder<oh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.b.getPageActivity(), false);
            ss7 ss7Var = new ss7(this.b.getPageActivity());
            ss7Var.z(new b(this, ss7Var));
            this.f = ss7Var;
            ss7Var.B(this.a);
            this.f.y("index");
            this.f.C("2001");
            bVar.n(this.f);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<oh6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, oh6 oh6Var, AutoVideoCardViewHolder<oh6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oh6Var, autoVideoCardViewHolder})) == null) {
            if (oh6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            oh6Var.E(oh6Var.position + 1);
            oh6Var.a.statFloor = oh6Var.i();
            autoVideoCardViewHolder.a().r(i);
            oh6Var.T = 0;
            rg6.b().a(oh6Var.u());
            autoVideoCardViewHolder.u(z(oh6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(oh6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            ns7.p(oh6Var.a, this.a, oh6Var.i());
            ns7.o(oh6Var.a, oh6Var.k(), oh6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final c89 z(oh6 oh6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, oh6Var)) == null) {
            if (oh6Var != null) {
                c89 c89Var = new c89();
                c89Var.a = "1";
                c89Var.c = oh6Var.g;
                if (oh6Var.getThreadData() != null) {
                    c89Var.d = String.valueOf(oh6Var.getThreadData().getFid());
                    c89Var.v = oh6Var.getThreadData().getNid();
                    if (oh6Var.getThreadData().getThreadVideoInfo() != null) {
                        c89Var.m = oh6Var.getThreadData().getThreadVideoInfo().video_md5;
                        c89Var.p = String.valueOf(oh6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                c89Var.k = oh6Var.e();
                c89Var.f = oh6Var.k();
                c89Var.l = oh6Var.c();
                c89Var.h = oh6Var.w();
                c89Var.e = TbadkCoreApplication.getCurrentAccount();
                c89Var.q = String.valueOf(oh6Var.i());
                if (oh6Var.getThreadData() != null && oh6Var.getThreadData().getBaijiahaoData() != null) {
                    c89Var.t = oh6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    c89Var.u = oh6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return c89Var;
                }
                return c89Var;
            }
            return null;
        }
        return (c89) invokeL.objValue;
    }
}
