package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.ez;
import com.baidu.tieba.kx;
import com.baidu.tieba.ty;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class z17 extends sw6 implements ap5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext c;
    public NEGFeedBackView.b d;
    public g37 e;
    public String f;
    public boolean g;
    public vg h;
    public vg i;
    public p26 j;

    /* loaded from: classes6.dex */
    public class a implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z17 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public a(z17 z17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z17Var;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) obj;
            e(constrainImageLayout);
            return constrainImageLayout;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            ConstrainImageLayout constrainImageLayout = (ConstrainImageLayout) obj;
            h(constrainImageLayout);
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.c.getPageActivity());
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z17 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(z17 z17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z17Var;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            TbImageView tbImageView = (TbImageView) obj;
            e(tbImageView);
            return tbImageView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            TbImageView tbImageView = (TbImageView) obj;
            h(tbImageView);
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.c.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z17 b;

        public c(z17 z17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z17Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, e36 e36Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, e36Var) == null) {
                i26.b().d(true);
                yo5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.e != null && e36Var != null && e36Var.getThreadData() != null && !StringUtils.isNull(e36Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !k17.b(eh.g(e36Var.getThreadData().getTid(), 0L))) {
                        k17.a(eh.g(e36Var.getThreadData().getTid(), 0L));
                        this.b.e.e(eh.g(e36Var.getThreadData().getTid(), 0L), e36Var.D(), e36Var.r(), e36Var.n(), e36Var.c(), eh.e((String) view2.getTag(), 1), "homepage", e36Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, e36Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements kx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(z17 z17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kx.b
        public void a(ar4 ar4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, ar4Var, view2) == null) && ar4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0924a1) {
                    ar4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092473) {
                    ar4Var.objType = 4;
                } else {
                    ar4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements nn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;
        public final /* synthetic */ z17 b;

        public e(z17 z17Var, ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z17Var, eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z17Var;
            this.a = eyVar;
        }

        @Override // com.baidu.tieba.nn
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.A(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z17 a;

        public f(z17 z17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z17Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof e36) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                e36 e36Var = (e36) eoVar;
                e36Var.f = 1;
                if (this.a.j != null) {
                    this.a.j.a(threadCardViewHolder.getView(), e36Var);
                }
                ThreadCardUtils.jumpToPB((ar4) e36Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z17(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = true;
        this.h = new vg(new a(this), 6, 0);
        this.i = new vg(new b(this), 12, 0);
        this.j = new c(this);
        this.c = tbPageContext;
        x();
    }

    public void B(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void C(g37 g37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g37Var) == null) {
            this.e = g37Var;
        }
    }

    @Override // com.baidu.tieba.ap5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.g = z;
        }
    }

    public final void A(View view2, e36 e36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, e36Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.obfuscated_res_0x7f09217d) {
                TiebaStatic.log(e36Var.A());
                yo5.c().i("page_recommend", "clk_", e36Var.A());
                l37.c(e36Var.a, e36Var.r(), e36Var.n(), 1);
                i = 1;
            } else if (id == R.id.obfuscated_res_0x7f092191) {
                TiebaStatic.log(e36Var.A());
                yo5.c().i("page_recommend", "clk_", e36Var.A());
                i = 5;
                l37.c(e36Var.a, e36Var.r(), e36Var.n(), 1);
            } else {
                if (id == R.id.obfuscated_res_0x7f09217f) {
                    TiebaStatic.log(e36Var.T());
                    yo5.c().i("page_recommend", "clk_", e36Var.T());
                } else {
                    if (id == R.id.obfuscated_res_0x7f092473) {
                        TiebaStatic.log(e36Var.S());
                        yo5.c().i("page_recommend", "clk_", e36Var.S());
                        l37.c(e36Var.a, e36Var.r(), e36Var.n(), 4);
                    } else if (id == R.id.obfuscated_res_0x7f0924a1) {
                        TiebaStatic.log(e36Var.S());
                        yo5.c().i("page_recommend", "clk_", e36Var.S());
                        l37.c(e36Var.a, e36Var.r(), e36Var.n(), 4);
                    } else if (id == R.id.obfuscated_res_0x7f090a99) {
                        TiebaStatic.log(e36Var.j());
                        yo5.c().i("page_recommend", "clk_", e36Var.j());
                    } else if (id == R.id.obfuscated_res_0x7f090ce3) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.obfuscated_res_0x7f090cde) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        l37.c(e36Var.a, e36Var.r(), e36Var.n(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090ce1 && id != R.id.obfuscated_res_0x7f090ce2) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f090cdf) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(e36Var.P());
                            yo5.c().i("page_recommend", "clk_", e36Var.P());
                            l37.c(e36Var.a, e36Var.r(), e36Var.n(), 2);
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
                l37.d(e36Var.a, this.b, e36Var.n(), i);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e36.R = "c10705";
            e36.S = "c10730";
            e36.T = "c10731";
            e36.U = "c10704";
            e36.V = "c10755";
            e36.W = "c10710";
            e36.X = "c10736";
            e36.Y = "c10737";
            e36.Z = "c10711";
            e36.a0 = "c10758";
            e36.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: y */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            ty.b bVar = new ty.b(this.c.getPageActivity());
            kx kxVar = new kx(this.c.getPageActivity());
            kxVar.x(this.b);
            kxVar.g(1024);
            kxVar.w(new d(this));
            bVar.o(kxVar);
            ey eyVar = new ey(this.c.getPageActivity());
            eyVar.x("index");
            eyVar.w(this.h);
            eyVar.v(this.i);
            eyVar.y(this.g);
            bVar.n(eyVar);
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.A(true);
            bVar.h(ayVar);
            bVar.h(new py(this.c.getPageActivity()));
            bVar.h(new iy(this.c.getPageActivity()));
            bVar.h(new rx(this.c.getPageActivity()));
            vx vxVar = new vx(this.c.getPageActivity());
            vxVar.B(this.g);
            vxVar.A("index");
            bVar.h(vxVar);
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                eyVar.A(new e(this, eyVar));
            }
            vy vyVar = new vy(this.c.getPageActivity());
            gr4 gr4Var = new gr4();
            gr4Var.b = 1;
            gr4Var.h = 1;
            vyVar.z(gr4Var);
            vyVar.B(1);
            vyVar.G(3);
            vyVar.C(2);
            vyVar.A(false);
            bVar.m(vyVar);
            ty i = bVar.i();
            i.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, e36 e36Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, e36Var, threadCardViewHolder})) == null) {
            if (e36Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && e36Var.a != null) {
                e36Var.I(e36Var.position + 1);
                e36Var.a.statFloor = e36Var.n();
                threadCardViewHolder.a().b(this.f);
                threadCardViewHolder.o(true).u(this.d);
                threadCardViewHolder.k(e36Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(e36Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.j);
                i26.b().a(e36Var.B());
                yo5.c().i("page_recommend", "show_", e36Var.B());
                l37.i(e36Var.a, this.b, e36Var.n());
                l37.h(e36Var.a, e36Var.r(), e36Var.n());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
