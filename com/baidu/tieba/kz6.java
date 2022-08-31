package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kz6 extends cn<t06, ThreadCardViewHolder<t06>> implements vl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public a17 c;
    public String d;
    public boolean e;
    public vn f;
    public h06<t06> g;

    /* loaded from: classes4.dex */
    public class a extends h06<t06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz6 b;

        public a(kz6 kz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, t06 t06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, t06Var) == null) {
                a06.b().d(true);
                tl5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.c == null || t06Var == null || t06Var.getThreadData() == null || StringUtils.isNull(t06Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !dz6.b(pg.g(t06Var.getThreadData().getTid(), 0L))) {
                    dz6.a(pg.g(t06Var.getThreadData().getTid(), 0L));
                    this.b.c.e(pg.g(t06Var.getThreadData().getTid(), 0L), t06Var.D(), t06Var.r(), t06Var.n(), t06Var.c(), pg.e((String) view2.getTag(), 1), "homepage", t06Var.getThreadData().getBaijiahaoData());
                }
                this.b.y(view2, t06Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz6 a;

        public b(kz6 kz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof t06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                t06 t06Var = (t06) pnVar;
                t06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), t06Var);
                }
                ThreadCardUtils.jumpToPB((go4) t06Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = true;
        this.g = new a(this);
        this.b = tbPageContext;
        v();
    }

    public void A(vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vnVar) == null) {
            this.f = vnVar;
        }
    }

    @Override // com.baidu.tieba.vl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            t06.R = "c10705";
            t06.S = "c10730";
            t06.T = "c10731";
            t06.U = "c10704";
            t06.V = "c10755";
            t06.W = "c10710";
            t06.X = "c10736";
            t06.Y = "c10737";
            t06.Z = "c10711";
            t06.a0 = "c10758";
            t06.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: w */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.b.getPageActivity(), false);
            rx rxVar = new rx(this.b.getPageActivity());
            rxVar.r("index");
            rxVar.s(this.e);
            bVar.n(rxVar);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, t06 t06Var, ThreadCardViewHolder<t06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t06Var, threadCardViewHolder})) == null) {
            if (t06Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || t06Var.a == null) {
                return null;
            }
            t06Var.I(t06Var.position + 1);
            t06Var.a.statFloor = t06Var.n();
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.a().b(this.d);
            threadCardViewHolder.e(t06Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.g);
            a06.b().a(t06Var.B());
            tl5.c().a(t06Var.B());
            rx rxVar = (rx) threadCardViewHolder.a().g();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rxVar.f.d.getLayoutParams();
            layoutParams.width = t06Var.j;
            layoutParams.height = t06Var.k;
            if (rxVar.f.d.getVisibility() != 8) {
                rxVar.f.d.setLayoutParams(layoutParams);
            }
            h17.i(t06Var.a, this.a, t06Var.n());
            h17.h(t06Var.a, t06Var.r(), t06Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, t06 t06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, t06Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f09212d || id == R.id.obfuscated_res_0x7f092141) {
                TiebaStatic.log(t06Var.A());
                tl5.c().i("page_recommend", "clk_", t06Var.A());
                h17.c(t06Var.a, t06Var.r(), t06Var.n(), 1);
                i = 1;
            } else {
                if (id == R.id.obfuscated_res_0x7f09242b) {
                    TiebaStatic.log(t06Var.S());
                    tl5.c().i("page_recommend", "clk_", t06Var.S());
                } else if (id == R.id.obfuscated_res_0x7f092459) {
                    TiebaStatic.log(t06Var.S());
                    tl5.c().i("page_recommend", "clk_", t06Var.S());
                } else if (id == R.id.obfuscated_res_0x7f090a75) {
                    TiebaStatic.log(t06Var.j());
                    tl5.c().i("page_recommend", "clk_", t06Var.j());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090cba) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                    } else if (id != R.id.obfuscated_res_0x7f090cbd && id != R.id.obfuscated_res_0x7f090cbe) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cbb) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(t06Var.P());
                            tl5.c().i("page_recommend", "clk_", t06Var.P());
                            h17.c(t06Var.a, t06Var.r(), t06Var.n(), 2);
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
                h17.d(t06Var.a, this.a, t06Var.n(), i);
            }
        }
    }

    public void z(a17 a17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a17Var) == null) {
            this.c = a17Var;
        }
    }
}
