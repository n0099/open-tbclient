package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o17 extends xv6<k26, ThreadCardViewHolder<k26>> implements go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public k27 d;
    public String e;
    public jo f;
    public NEGFeedBackView.b g;
    public v16<k26> h;

    /* loaded from: classes5.dex */
    public class a extends v16<k26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o17 b;

        public a(o17 o17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, k26 k26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, k26Var) == null) {
                o16.b().d(true);
                eo5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.d == null || k26Var == null || k26Var.getThreadData() == null || StringUtils.isNull(k26Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !o07.b(dh.g(k26Var.getThreadData().getTid(), 0L))) {
                    o07.a(dh.g(k26Var.getThreadData().getTid(), 0L));
                    this.b.d.e(dh.g(k26Var.getThreadData().getTid(), 0L), k26Var.D(), k26Var.r(), k26Var.n(), k26Var.c(), dh.e((String) view2.getTag(), 1), "homepage", k26Var.getThreadData().getBaijiahaoData());
                }
                this.b.A(view2, k26Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(o17 o17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(lq4 lq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, lq4Var, view2) == null) || lq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b4) {
                lq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092486) {
                lq4Var.objType = 4;
            } else {
                lq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o17 a;

        public c(o17 o17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o17Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof k26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                k26 k26Var = (k26) cdo;
                k26Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), k26Var);
                }
                if (q27.a(this.a.c, k26Var)) {
                    return;
                }
                ThreadCardUtils.jumpToPB((lq4) k26Var, view2.getContext(), 2, false, kx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o17(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.h = new a(this);
        this.c = tbPageContext;
        x();
    }

    public final void A(View view2, k26 k26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, k26Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f09217e || id == R.id.obfuscated_res_0x7f092192) {
                if (l26.R(k26Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(k26Var.C()));
                } else {
                    TiebaStatic.log(k26Var.A());
                }
                eo5.c().i("page_recommend", "clk_", k26Var.A());
                p27.c(k26Var.a, k26Var.r(), k26Var.n(), 1);
                i = 1;
            } else {
                if (id == R.id.obfuscated_res_0x7f092486) {
                    TiebaStatic.log(k26Var.S());
                    eo5.c().i("page_recommend", "clk_", k26Var.S());
                    p27.c(k26Var.a, k26Var.r(), k26Var.n(), 4);
                } else if (id == R.id.obfuscated_res_0x7f0924b4) {
                    TiebaStatic.log(k26Var.S());
                    eo5.c().i("page_recommend", "clk_", k26Var.S());
                    p27.c(k26Var.a, k26Var.r(), k26Var.n(), 4);
                } else if (id == R.id.obfuscated_res_0x7f090a8f) {
                    TiebaStatic.log(k26Var.j());
                    eo5.c().i("page_recommend", "clk_", k26Var.j());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090cd5) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        p27.c(k26Var.a, k26Var.r(), k26Var.n(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090cd8 && id != R.id.obfuscated_res_0x7f090cd9) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cd6) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(k26Var.P());
                            eo5.c().i("page_recommend", "clk_", k26Var.P());
                            p27.c(k26Var.a, k26Var.r(), k26Var.n(), 2);
                        } else {
                            i = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i = 5;
                }
                i = 2;
            }
            if (i != 0) {
                p27.d(k26Var.a, this.b, k26Var.n(), i);
            }
        }
    }

    public void B(k27 k27Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k27Var) == null) {
            this.d = k27Var;
        }
    }

    public void C(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, joVar) == null) {
            this.f = joVar;
        }
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k26.S = "c10730";
            k26.T = "c10731";
            k26.U = "c10704";
            k26.V = "c10755";
            k26.W = "c10710";
            k26.X = "c10736";
            k26.Y = "c10737";
            k26.Z = "c10711";
            k26.a0 = "c10758";
            k26.b0 = "c10757";
            k26.e0 = "c10734";
            k26.f0 = "c10708";
            k26.g0 = "c10735";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.u(this.b);
            jxVar.d(1024);
            jxVar.t(new b(this));
            jxVar.w(this.c);
            bVar.o(jxVar);
            sy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, k26 k26Var, ThreadCardViewHolder<k26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, k26Var, threadCardViewHolder})) == null) {
            if (k26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || k26Var.a == null) {
                return null;
            }
            k26Var.I(k26Var.position + 1);
            k26Var.a.statFloor = k26Var.n();
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.e);
            threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.g);
            threadCardViewHolder.l(k26Var.showFollowBtn(), this.a, true);
            threadCardViewHolder.e(k26Var);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            o16.b().a(k26Var.B());
            eo5.c().a(k26Var.B());
            p27.i(k26Var.a, this.b, k26Var.n());
            p27.h(k26Var.a, k26Var.r(), k26Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
