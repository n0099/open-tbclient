package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.kz;
import com.baidu.tieba.lx;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lg7 extends qn<ng6, AutoVideoCardViewHolder<ng6>> implements dy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public fh7 c;
    public String d;
    public jo e;
    public hz f;
    public xf6<ng6> g;

    /* loaded from: classes5.dex */
    public class a extends xf6<ng6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lg7 b;

        public a(lg7 lg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xf6
        /* renamed from: d */
        public void a(View view2, ng6 ng6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ng6Var) == null) {
                qf6.b().d(true);
                by5.c().h("page_recommend", "show_");
                if (this.b.c != null && ng6Var != null && ng6Var.getThreadData() != null && !StringUtils.isNull(ng6Var.getThreadData().getTid())) {
                    if (ng6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ng6Var.N(ng6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !jf7.b(dh.g(ng6Var.getThreadData().getTid(), 0L))) {
                        jf7.a(dh.g(ng6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(dh.g(ng6Var.getThreadData().getTid(), 0L), ng6Var.x(), ng6Var.n(), ng6Var.l(), ng6Var.c(), dh.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, ng6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.y(view2, ng6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz a;
        public final /* synthetic */ lg7 b;

        public b(lg7 lg7Var, hz hzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lg7Var, hzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lg7Var;
            this.a = hzVar;
        }

        @Override // com.baidu.tieba.lx.a
        public void a(zx4 zx4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, zx4Var) != null) || zx4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (zx4Var instanceof ng6) {
                zx4Var.objType = 5;
                ThreadCardUtils.jumpToPB(zx4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(zx4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lg7 a;

        public c(lg7 lg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lg7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ng6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ng6 ng6Var = (ng6) cdo;
                ng6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), ng6Var);
                }
                ThreadCardUtils.jumpToPB((zx4) ng6Var, view2.getContext(), 2, false, px.a((jo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new kz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lg7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void C(fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fh7Var) == null) {
            this.c = fh7Var;
        }
    }

    public void D(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, joVar) == null) {
            this.e = joVar;
        }
    }

    @Override // com.baidu.tieba.dy5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public AutoVideoCardViewHolder<ng6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            zy.b bVar = new zy.b(this.b.getPageActivity(), false);
            ph7 ph7Var = new ph7(this.b.getPageActivity());
            ph7Var.y(new b(this, ph7Var));
            this.f = ph7Var;
            ph7Var.A(this.a);
            this.f.x("index");
            this.f.B("2001");
            bVar.n(this.f);
            zy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<ng6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ng6 ng6Var, AutoVideoCardViewHolder<ng6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ng6Var, autoVideoCardViewHolder})) == null) {
            if (ng6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ng6Var.F(ng6Var.position + 1);
            ng6Var.a.statFloor = ng6Var.l();
            autoVideoCardViewHolder.a().r(i);
            ng6Var.T = 0;
            qf6.b().a(ng6Var.u());
            autoVideoCardViewHolder.u(x(ng6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(ng6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            kh7.k(ng6Var.a, this.a, ng6Var.l());
            kh7.j(ng6Var.a, ng6Var.n(), ng6Var.l());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        hz hzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (hzVar = this.f) != null) {
            hzVar.v();
        }
    }

    public void onResume() {
        hz hzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (hzVar = this.f) != null) {
            hzVar.w();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ng6.V = "c10708";
            ng6.W = "c10735";
            ng6.X = "c10709";
            ng6.Y = "c10734";
            ng6.Z = "c11929";
            ng6.a0 = "c11928";
            ng6.b0 = "c10756";
        }
    }

    public final bt8 x(ng6 ng6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ng6Var)) == null) {
            if (ng6Var != null) {
                bt8 bt8Var = new bt8();
                bt8Var.a = "1";
                bt8Var.c = ng6Var.g;
                if (ng6Var.getThreadData() != null) {
                    bt8Var.d = String.valueOf(ng6Var.getThreadData().getFid());
                    bt8Var.v = ng6Var.getThreadData().getNid();
                    if (ng6Var.getThreadData().getThreadVideoInfo() != null) {
                        bt8Var.m = ng6Var.getThreadData().getThreadVideoInfo().video_md5;
                        bt8Var.p = String.valueOf(ng6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                bt8Var.k = ng6Var.g();
                bt8Var.f = ng6Var.n();
                bt8Var.l = ng6Var.c();
                bt8Var.h = ng6Var.x();
                bt8Var.e = TbadkCoreApplication.getCurrentAccount();
                bt8Var.q = String.valueOf(ng6Var.l());
                if (ng6Var.getThreadData() != null && ng6Var.getThreadData().getBaijiahaoData() != null) {
                    bt8Var.t = ng6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    bt8Var.u = ng6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return bt8Var;
                }
                return bt8Var;
            }
            return null;
        }
        return (bt8) invokeL.objValue;
    }

    public final void y(View view2, ng6 ng6Var) {
        hz hzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, ng6Var) == null) && (hzVar = this.f) != null && hzVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, ng6Var);
                kh7.d(ng6Var.a, this.a, ng6Var.l(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ng6Var.P()));
                kh7.c(ng6Var.a, ng6Var.n(), ng6Var.l(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ng6Var.N(ng6Var.a)));
                kh7.c(ng6Var.a, ng6Var.n(), ng6Var.l(), 1);
            }
        }
    }
}
