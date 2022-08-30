package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.vw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sz6 extends ou6<v06, ThreadCardViewHolder<v06>> implements xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public boolean f;
    public j06<v06> g;

    /* loaded from: classes5.dex */
    public class a extends j06<v06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz6 b;

        public a(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, v06 v06Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, v06Var) == null) {
                int i = 1;
                c06.b().d(true);
                vl5.c().h("page_recommend", "show_");
                if (v06Var == null || v06Var.getThreadData() == null || qi.isEmpty(v06Var.getThreadData().getTid())) {
                    return;
                }
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f09212d) {
                    TiebaStatic.log(v06Var.A());
                    vl5.c().i("page_recommend", "clk_", v06Var.A());
                    j17.c(v06Var.a, v06Var.r(), v06Var.n(), 1);
                } else if (id == R.id.obfuscated_res_0x7f092141) {
                    TiebaStatic.log(v06Var.A());
                    vl5.c().i("page_recommend", "clk_", v06Var.A());
                    j17.c(v06Var.a, v06Var.r(), v06Var.n(), 1);
                    i = 5;
                } else {
                    if (id == R.id.obfuscated_res_0x7f09212f) {
                        TiebaStatic.log(v06Var.T());
                        vl5.c().i("page_recommend", "clk_", v06Var.T());
                    } else {
                        if (id == R.id.obfuscated_res_0x7f09242b) {
                            TiebaStatic.log(v06Var.S());
                            vl5.c().i("page_recommend", "clk_", v06Var.S());
                            j17.c(v06Var.a, v06Var.r(), v06Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f092459) {
                            TiebaStatic.log(v06Var.S());
                            vl5.c().i("page_recommend", "clk_", v06Var.S());
                            j17.c(v06Var.a, v06Var.r(), v06Var.n(), 4);
                        } else if (id == R.id.obfuscated_res_0x7f090a75) {
                            TiebaStatic.log(v06Var.j());
                            vl5.c().i("page_recommend", "clk_", v06Var.j());
                        } else if (id == R.id.obfuscated_res_0x7f090cbf) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.obfuscated_res_0x7f090cba) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            j17.c(v06Var.a, v06Var.r(), v06Var.n(), 1);
                        } else if (id != R.id.obfuscated_res_0x7f090cbd && id != R.id.obfuscated_res_0x7f090cbe) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cbb) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(v06Var.P());
                                vl5.c().i("page_recommend", "clk_", v06Var.P());
                                j17.c(v06Var.a, v06Var.r(), v06Var.n(), 2);
                            }
                        } else {
                            StatisticItem statisticItem4 = new StatisticItem("c10760");
                            statisticItem4.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem4);
                        }
                        i = 2;
                    }
                    i = 0;
                }
                if (i != 0) {
                    j17.d(v06Var.a, this.b.b, v06Var.n(), i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements vw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vw.b
        public void a(ho4 ho4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ho4Var, view2) == null) || ho4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092459) {
                ho4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09242b) {
                ho4Var.objType = 4;
            } else {
                ho4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz6 a;

        public c(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof v06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                v06 v06Var = (v06) pnVar;
                v06Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), v06Var);
                }
                ThreadCardUtils.jumpToPB((ho4) v06Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = null;
        this.f = true;
        this.g = new a(this);
        this.c = tbPageContext;
        u();
    }

    @Override // com.baidu.tieba.xl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            v06.R = "c10705";
            v06.S = "c10730";
            v06.T = "c10731";
            v06.U = "c10704";
            v06.V = "c10755";
            v06.W = "c10710";
            v06.X = "c10736";
            v06.Y = "c10737";
            v06.Z = "c10711";
            v06.a0 = "c10758";
            v06.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: v */
    public ThreadCardViewHolder<v06> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity());
            vw vwVar = new vw(this.c.getPageActivity());
            vwVar.u(this.b);
            vwVar.d(1024);
            vwVar.t(new b(this));
            bVar.o(vwVar);
            bVar.n(new mx(this.c.getPageActivity()));
            bVar.h(new cx(this.c.getPageActivity()));
            gx gxVar = new gx(this.c.getPageActivity());
            gxVar.y(this.f);
            gxVar.x("index");
            gxVar.z(new StatisticItem("c13342"));
            bVar.h(gxVar);
            gy gyVar = new gy(this.c.getPageActivity());
            no4 no4Var = new no4();
            no4Var.b = 1;
            no4Var.h = 1;
            gyVar.w(no4Var);
            gyVar.y(1);
            gyVar.D(3);
            gyVar.z(2);
            gyVar.x(false);
            bVar.m(gyVar);
            ey i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<v06> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, v06 v06Var, ThreadCardViewHolder<v06> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, v06Var, threadCardViewHolder})) == null) {
            if (v06Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            v06Var.I(v06Var.position + 1);
            v06Var.a.statFloor = v06Var.n();
            c06.b().a(v06Var.O("c12190"));
            if (threadCardViewHolder.a() instanceof wl5) {
                threadCardViewHolder.a().b(this.e);
            }
            ux o = threadCardViewHolder.o(true);
            o.u(this.d);
            threadCardViewHolder.k(v06Var.showFollowBtn(), this.a);
            o.a(v06Var.getNegFeedBackData());
            threadCardViewHolder.e(v06Var);
            threadCardViewHolder.h(this.g);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            j17.i(v06Var.a, this.b, v06Var.n());
            j17.h(v06Var.a, v06Var.r(), v06Var.n());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
