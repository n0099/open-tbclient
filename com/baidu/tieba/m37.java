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
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m37 extends kn<a56, ThreadCardViewHolder<a56>> implements lq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public b57 c;
    public String d;
    public boolean e;
    public Cdo f;
    public l46<a56> g;

    /* loaded from: classes5.dex */
    public class a extends l46<a56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m37 b;

        public a(m37 m37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, a56 a56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, a56Var) == null) {
                e46.b().d(true);
                jq5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && a56Var != null && a56Var.getThreadData() != null && !StringUtils.isNull(a56Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !e37.b(xg.g(a56Var.getThreadData().getTid(), 0L))) {
                        e37.a(xg.g(a56Var.getThreadData().getTid(), 0L));
                        this.b.c.e(xg.g(a56Var.getThreadData().getTid(), 0L), a56Var.D(), a56Var.r(), a56Var.n(), a56Var.c(), xg.e((String) view2.getTag(), 1), "homepage", a56Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.y(view2, a56Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m37 a;

        public b(m37 m37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m37Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof a56) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                a56 a56Var = (a56) xnVar;
                a56Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), a56Var);
                }
                ThreadCardUtils.jumpToPB((sr4) a56Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m37(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cdo) == null) {
            this.f = cdo;
        }
    }

    @Override // com.baidu.tieba.lq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public void z(b57 b57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b57Var) == null) {
            this.c = b57Var;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a56.R = "c10705";
            a56.S = "c10730";
            a56.T = "c10731";
            a56.U = "c10704";
            a56.V = "c10755";
            a56.W = "c10710";
            a56.X = "c10736";
            a56.Y = "c10737";
            a56.Z = "c10711";
            a56.a0 = "c10758";
            a56.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: w */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            by byVar = new by(this.b.getPageActivity());
            byVar.u("index");
            byVar.v(this.e);
            bVar.n(byVar);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.f);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, a56 a56Var, ThreadCardViewHolder<a56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, a56Var, threadCardViewHolder})) == null) {
            if (a56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && a56Var.a != null) {
                a56Var.I(a56Var.position + 1);
                a56Var.a.statFloor = a56Var.n();
                threadCardViewHolder.a().q(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(a56Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.g);
                e46.b().a(a56Var.B());
                jq5.c().a(a56Var.B());
                by byVar = (by) threadCardViewHolder.a().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) byVar.f.d.getLayoutParams();
                layoutParams.width = a56Var.j;
                layoutParams.height = a56Var.k;
                if (byVar.f.d.getVisibility() != 8) {
                    byVar.f.d.setLayoutParams(layoutParams);
                }
                g57.i(a56Var.a, this.a, a56Var.n());
                g57.h(a56Var.a, a56Var.r(), a56Var.n());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, a56 a56Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, a56Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.obfuscated_res_0x7f0921dd && id != R.id.obfuscated_res_0x7f0921f1) {
                if (id == R.id.obfuscated_res_0x7f0924d7) {
                    TiebaStatic.log(a56Var.S());
                    jq5.c().i("page_recommend", "clk_", a56Var.S());
                } else if (id == R.id.obfuscated_res_0x7f092505) {
                    TiebaStatic.log(a56Var.S());
                    jq5.c().i("page_recommend", "clk_", a56Var.S());
                } else if (id == R.id.obfuscated_res_0x7f090aad) {
                    TiebaStatic.log(a56Var.j());
                    jq5.c().i("page_recommend", "clk_", a56Var.j());
                    i = 9;
                } else {
                    if (id == R.id.obfuscated_res_0x7f090cfe) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                    } else if (id != R.id.obfuscated_res_0x7f090d01 && id != R.id.obfuscated_res_0x7f090d02) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cff) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(a56Var.P());
                            jq5.c().i("page_recommend", "clk_", a56Var.P());
                            g57.c(a56Var.a, a56Var.r(), a56Var.n(), 2);
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
            } else {
                TiebaStatic.log(a56Var.A());
                jq5.c().i("page_recommend", "clk_", a56Var.A());
                g57.c(a56Var.a, a56Var.r(), a56Var.n(), 1);
                i = 1;
            }
            if (i != 0) {
                g57.d(a56Var.a, this.a, a56Var.n(), i);
            }
        }
    }
}
