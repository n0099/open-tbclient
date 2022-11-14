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
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class s37 extends my6<a56, ThreadCardViewHolder<a56>> implements lq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public boolean f;
    public l46<a56> g;

    /* loaded from: classes5.dex */
    public class a extends l46<a56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s37 b;

        public a(s37 s37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, a56 a56Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, a56Var) == null) {
                int i = 1;
                e46.b().d(true);
                jq5.c().h("page_recommend", "show_");
                if (a56Var != null && a56Var.getThreadData() != null && !xi.isEmpty(a56Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id == R.id.obfuscated_res_0x7f0921dd) {
                        TiebaStatic.log(a56Var.A());
                        jq5.c().i("page_recommend", "clk_", a56Var.A());
                        g57.c(a56Var.a, a56Var.r(), a56Var.n(), 1);
                    } else if (id == R.id.obfuscated_res_0x7f0921f1) {
                        TiebaStatic.log(a56Var.A());
                        jq5.c().i("page_recommend", "clk_", a56Var.A());
                        g57.c(a56Var.a, a56Var.r(), a56Var.n(), 1);
                        i = 5;
                    } else {
                        if (id == R.id.obfuscated_res_0x7f0921df) {
                            TiebaStatic.log(a56Var.T());
                            jq5.c().i("page_recommend", "clk_", a56Var.T());
                        } else {
                            if (id == R.id.obfuscated_res_0x7f0924d7) {
                                TiebaStatic.log(a56Var.S());
                                jq5.c().i("page_recommend", "clk_", a56Var.S());
                                g57.c(a56Var.a, a56Var.r(), a56Var.n(), 4);
                            } else if (id == R.id.obfuscated_res_0x7f092505) {
                                TiebaStatic.log(a56Var.S());
                                jq5.c().i("page_recommend", "clk_", a56Var.S());
                                g57.c(a56Var.a, a56Var.r(), a56Var.n(), 4);
                            } else if (id == R.id.obfuscated_res_0x7f090aad) {
                                TiebaStatic.log(a56Var.j());
                                jq5.c().i("page_recommend", "clk_", a56Var.j());
                            } else if (id == R.id.obfuscated_res_0x7f090d03) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.obfuscated_res_0x7f090cfe) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                g57.c(a56Var.a, a56Var.r(), a56Var.n(), 1);
                            } else if (id != R.id.obfuscated_res_0x7f090d01 && id != R.id.obfuscated_res_0x7f090d02) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.obfuscated_res_0x7f090cff) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(a56Var.P());
                                    jq5.c().i("page_recommend", "clk_", a56Var.P());
                                    g57.c(a56Var.a, a56Var.r(), a56Var.n(), 2);
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
                        g57.d(a56Var.a, this.b.b, a56Var.n(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(s37 s37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(sr4 sr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, sr4Var, view2) == null) && sr4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092505) {
                    sr4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0924d7) {
                    sr4Var.objType = 4;
                } else {
                    sr4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s37 a;

        public c(s37 s37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s37Var;
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
    public s37(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.lq5
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

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u() {
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
    /* renamed from: v */
    public ThreadCardViewHolder<a56> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.x(this.b);
            dxVar.g(1024);
            dxVar.w(new b(this));
            bVar.o(dxVar);
            bVar.n(new wx(this.c.getPageActivity()));
            bVar.h(new kx(this.c.getPageActivity()));
            ox oxVar = new ox(this.c.getPageActivity());
            oxVar.B(this.f);
            oxVar.A("index");
            oxVar.C(new StatisticItem("c13342"));
            bVar.h(oxVar);
            qy qyVar = new qy(this.c.getPageActivity());
            yr4 yr4Var = new yr4();
            yr4Var.b = 1;
            yr4Var.h = 1;
            qyVar.z(yr4Var);
            qyVar.B(1);
            qyVar.G(3);
            qyVar.C(2);
            qyVar.A(false);
            bVar.m(qyVar);
            oy i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<a56> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, a56 a56Var, ThreadCardViewHolder<a56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, a56Var, threadCardViewHolder})) == null) {
            if (a56Var != null && threadCardViewHolder != null && threadCardViewHolder.a() != null) {
                a56Var.I(a56Var.position + 1);
                a56Var.a.statFloor = a56Var.n();
                e46.b().a(a56Var.O("c12190"));
                if (threadCardViewHolder.a() instanceof kq5) {
                    threadCardViewHolder.a().b(this.e);
                }
                ey o = threadCardViewHolder.o(true);
                o.s(this.d);
                threadCardViewHolder.k(a56Var.showFollowBtn(), this.a);
                o.a(a56Var.getNegFeedBackData());
                threadCardViewHolder.e(a56Var);
                threadCardViewHolder.h(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                g57.i(a56Var.a, this.b, a56Var.n());
                g57.h(a56Var.a, a56Var.r(), a56Var.n());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
