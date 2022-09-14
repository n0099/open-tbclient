package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.gx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p17 extends qn<l26, AutoVideoCardViewHolder<l26>> implements go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public k27 c;
    public String d;
    public jo e;
    public az f;
    public v16<l26> g;

    /* loaded from: classes5.dex */
    public class a extends v16<l26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p17 b;

        public a(p17 p17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, l26 l26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, l26Var) == null) {
                o16.b().d(true);
                eo5.c().h("page_recommend", "show_");
                if (this.b.c == null || l26Var == null || l26Var.getThreadData() == null || StringUtils.isNull(l26Var.getThreadData().getTid())) {
                    return;
                }
                if (l26Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(l26Var.N(l26Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !o07.b(dh.g(l26Var.getThreadData().getTid(), 0L))) {
                    o07.a(dh.g(l26Var.getThreadData().getTid(), 0L));
                    this.b.c.e(dh.g(l26Var.getThreadData().getTid(), 0L), l26Var.D(), l26Var.r(), l26Var.n(), l26Var.c(), dh.e((String) view2.getTag(), 1), "homepage", l26Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, l26Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az a;
        public final /* synthetic */ p17 b;

        public b(p17 p17Var, az azVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p17Var, azVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p17Var;
            this.a = azVar;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(lq4 lq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lq4Var) == null) || lq4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(lq4Var instanceof l26)) {
                ThreadCardUtils.jumpToPB(lq4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            lq4Var.objType = 5;
            ThreadCardUtils.jumpToPB(lq4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p17 a;

        public c(p17 p17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p17Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof l26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                l26 l26Var = (l26) cdo;
                l26Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), l26Var);
                }
                ThreadCardUtils.jumpToPB((lq4) l26Var, view2.getContext(), 2, false, kx.a((jo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p17(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public AutoVideoCardViewHolder<l26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            t27 t27Var = new t27(this.b.getPageActivity());
            t27Var.v(new b(this, t27Var));
            this.f = t27Var;
            t27Var.x(this.a);
            this.f.u("index");
            this.f.y("2001");
            bVar.n(this.f);
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<l26> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.p(this.g);
            k.r(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l26 l26Var, AutoVideoCardViewHolder<l26> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l26Var, autoVideoCardViewHolder})) == null) {
            if (l26Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            l26Var.I(l26Var.position + 1);
            l26Var.a.statFloor = l26Var.n();
            autoVideoCardViewHolder.a().q(i);
            l26Var.T = 0;
            o16.b().a(l26Var.B());
            autoVideoCardViewHolder.u(x(l26Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(l26Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().p(this.g);
            p27.i(l26Var.a, this.a, l26Var.n());
            p27.h(l26Var.a, l26Var.r(), l26Var.n());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void C(k27 k27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k27Var) == null) {
            this.c = k27Var;
        }
    }

    public void D(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, joVar) == null) {
            this.e = joVar;
        }
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public void onPause() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (azVar = this.f) == null) {
            return;
        }
        azVar.s();
    }

    public void onResume() {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (azVar = this.f) == null) {
            return;
        }
        azVar.t();
    }

    public final ma8 x(l26 l26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, l26Var)) == null) {
            if (l26Var != null) {
                ma8 ma8Var = new ma8();
                ma8Var.a = "1";
                ma8Var.c = l26Var.g;
                if (l26Var.getThreadData() != null) {
                    ma8Var.d = String.valueOf(l26Var.getThreadData().getFid());
                    ma8Var.v = l26Var.getThreadData().getNid();
                    if (l26Var.getThreadData().getThreadVideoInfo() != null) {
                        ma8Var.m = l26Var.getThreadData().getThreadVideoInfo().video_md5;
                        ma8Var.p = String.valueOf(l26Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ma8Var.k = l26Var.h();
                ma8Var.f = l26Var.r();
                ma8Var.l = l26Var.c();
                ma8Var.h = l26Var.D();
                ma8Var.e = TbadkCoreApplication.getCurrentAccount();
                ma8Var.q = String.valueOf(l26Var.n());
                if (l26Var.getThreadData() == null || l26Var.getThreadData().getBaijiahaoData() == null) {
                    return ma8Var;
                }
                ma8Var.t = l26Var.getThreadData().getBaijiahaoData().oriUgcNid;
                ma8Var.u = l26Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return ma8Var;
            }
            return null;
        }
        return (ma8) invokeL.objValue;
    }

    public final void y(View view2, l26 l26Var) {
        az azVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, view2, l26Var) == null) || (azVar = this.f) == null || azVar.p() == null || this.f.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.f.p().getMainView().getId()) {
            CardLinkageManager.INSTANCE.cancelHighLight(this.e, l26Var);
            p27.d(l26Var.a, this.a, l26Var.n(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(l26Var.P()));
            p27.c(l26Var.a, l26Var.r(), l26Var.n(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09217e) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(l26Var.N(l26Var.a)));
            p27.c(l26Var.a, l26Var.r(), l26Var.n(), 1);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            l26.V = "c10708";
            l26.W = "c10735";
            l26.X = "c10709";
            l26.Y = "c10734";
            l26.Z = "c11929";
            l26.a0 = "c11928";
            l26.b0 = "c10756";
        }
    }
}
