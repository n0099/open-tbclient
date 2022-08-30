package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class qj6 extends cf6<kr4, ThreadCardViewHolder<kr4>> implements h06, hq6, xl5, i06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public fq6 r;
    public int s;
    public j06<kr4> t;
    public NEGFeedBackView.b u;
    public gg<ConstrainImageLayout> v;
    public gg<TbImageView> w;

    /* loaded from: classes5.dex */
    public class a extends j06<kr4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 b;

        public a(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, kr4 kr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kr4Var) == null) || view2 == null || kr4Var == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, kr4Var, this.b.getType());
            }
            if ("c13010".equals(this.b.o)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", kr4Var.t.getFid()).param("tid", kr4Var.t.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092459 && view2.getId() != R.id.obfuscated_res_0x7f09242b) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092141) {
                    eq6.e(kr4Var.t, 5, this.b.mPageId, this.b.r, this.b.t());
                    pr6.g(kr4Var.t, this.b.b, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e45) {
                    eq6.e(kr4Var.t, 14, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eab) {
                    eq6.e(kr4Var.t, 12, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec3) {
                    eq6.e(kr4Var.t, 13, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.t.a instanceof Boolean) {
                        if (((Boolean) this.b.t.a).booleanValue()) {
                            eq6.e(kr4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                        } else {
                            eq6.e(kr4Var.t, 3, this.b.mPageId, this.b.r, this.b.t());
                        }
                    }
                    pr6.g(kr4Var.t, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    eq6.e(kr4Var.t, 15, this.b.mPageId, this.b.r, this.b.t());
                    pr6.g(kr4Var.t, this.b.b, 1);
                } else {
                    eq6.e(kr4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                    pr6.g(kr4Var.t, this.b.b, 1);
                }
            } else {
                eq6.e(kr4Var.t, 2, this.b.mPageId, this.b.r, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092459 || view2.getId() == R.id.obfuscated_res_0x7f09242b) {
                gq6.k().h(this.b.r, kr4Var.t, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904f3) {
                pr6.a(this.b.r, kr4Var.getRecomReason());
            } else if (view2 instanceof TbImageView) {
                if (this.b.t.a instanceof Boolean) {
                    if (((Boolean) this.b.t.a).booleanValue()) {
                        gq6.k().h(this.b.r, kr4Var.t, 1);
                    } else {
                        gq6.k().h(this.b.r, kr4Var.t, 3);
                    }
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09053c) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09212f) {
                gq6.k().h(this.b.r, kr4Var.t, 5);
            } else if (!(view2 instanceof ThreadGodReplyLayout)) {
                gq6.k().h(this.b.r, kr4Var.t, 1);
            } else {
                int i = 6;
                if (kr4Var.t.getTopAgreePost() != null && kr4Var.t.getTopAgreePost().V() != null && kr4Var.t.getTopAgreePost().V().B() != null && kr4Var.t.getTopAgreePost().V().B().size() > 0) {
                    i = kr4Var.t.getTopAgreePost().L ? 9 : 8;
                }
                gq6.k().h(this.b.r, kr4Var.t, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, eq4 eq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, eq4Var) == null) || arrayList == null || eq4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", eq4Var.c()).param("tid", eq4Var.f()).param("nid", eq4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", eq4Var.l).param("weight", eq4Var.k).param("ab_tag", eq4Var.p).param("extra", eq4Var.m).param("card_type", eq4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, eq4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(eq4 eq4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eq4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(eq4 eq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", eq4Var.c()).param("tid", eq4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements hg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public c(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.l.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements hg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public d(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.hg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.l.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
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
    }

    /* loaded from: classes5.dex */
    public class e implements vw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
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
    public class f implements ym {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px a;
        public final /* synthetic */ qj6 b;

        public f(qj6 qj6Var, px pxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var, pxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj6Var;
            this.a = pxVar;
        }

        @Override // com.baidu.tieba.ym
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.x(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public g(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof kr4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                kr4 kr4Var = (kr4) pnVar;
                ThreadData threadData = kr4Var.t;
                threadData.objType = 1;
                if (this.a.t != null) {
                    this.a.t.a(threadCardViewHolder.getView(), kr4Var);
                }
                ThreadCardUtils.jumpToPB((ho4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = true;
        this.r = new fq6();
        this.t = new a(this);
        this.u = new b(this);
        this.v = new gg<>(new c(this), 6, 0);
        this.w = new gg<>(new d(this), 12, 0);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void Y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            gq6.k().d(threadData, this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: Z */
    public ThreadCardViewHolder<kr4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.l.getPageActivity());
            vw vwVar = new vw(this.l.getPageActivity());
            vwVar.c(4280);
            vwVar.u(this.mPageId);
            vwVar.t(new e(this));
            bVar.o(vwVar);
            px pxVar = new px(this.l.getPageActivity());
            pxVar.u("frs");
            if (this.s == 502) {
                pxVar.w(false);
            } else {
                pxVar.w(true);
            }
            pxVar.t(this.v);
            pxVar.s(this.w);
            pxVar.v(this.q);
            bVar.n(pxVar);
            oy oyVar = new oy(this.l.getPageActivity());
            oyVar.y(this.l);
            oyVar.x(3);
            bVar.h(oyVar);
            bVar.h(new cy(this.l.getPageActivity()));
            gx gxVar = new gx(this.l.getPageActivity());
            bVar.h(gxVar);
            gxVar.y(this.q);
            gxVar.x("frs");
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                pxVar.x(new f(this, pxVar));
            }
            gy gyVar = new gy(this.l.getPageActivity());
            no4 no4Var = new no4();
            if (100 == t().tabType) {
                no4Var.b = this.p ? 10 : 25;
                gyVar.y(19);
                gyVar.D(14);
            } else {
                no4Var.b = this.p ? 10 : 2;
                gyVar.y(2);
                gyVar.D(1);
            }
            no4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !qi.isEmpty(this.b.getForum().getId())) {
                no4Var.j = this.b.getForum().getId();
            }
            gyVar.w(no4Var);
            gyVar.z(3);
            gyVar.c(16);
            bVar.m(gyVar);
            bVar.l().h(ri.f(this.mContext, R.dimen.tbds28));
            ey i = bVar.i();
            i.r(3);
            ThreadCardViewHolder<kr4> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.h06
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cf6, com.baidu.tieba.cn
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kr4 kr4Var, ThreadCardViewHolder<kr4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kr4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, kr4Var, threadCardViewHolder);
            if (kr4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.n);
            bf6.i(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                kr4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            boolean z = (kr4Var.t.getAuthor() == null || kr4Var.t.getAuthor().getUserId() == null || !kr4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (kr4Var.t.isSmartFrsThread() && kr4Var.t.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.o(true).u(this.u);
            }
            threadCardViewHolder.r();
            if (threadCardViewHolder.a().f() != null) {
                threadCardViewHolder.a().f().c(32);
            }
            threadCardViewHolder.e(kr4Var);
            threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.t);
            if (this.r != null) {
                FrsViewData frsViewData2 = this.b;
                kr4Var.t.statFloor = (kr4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            gq6.k().c(this.r, kr4Var.t);
            Y(kr4Var.t);
            kr4Var.t.updateShowStatus();
            eq6.o(kr4Var.t, this.mPageId, this.r, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                eq6.m(kr4Var.t, t());
                eq6.n(kr4Var.t, this.b.getForum().getId());
            }
            if (kr4Var != null) {
                kr4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.xl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.hq6
    public fq6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : (fq6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i06
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tieba.h06
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.s = i;
        }
    }

    @Override // com.baidu.tieba.cf6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.cf6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }
}
