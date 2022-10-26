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
import com.baidu.tieba.ez;
import com.baidu.tieba.kx;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.ty;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class nl6 extends kh6 implements n26, js6, ap5, o26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext l;
    public HashSet m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public hs6 r;
    public int s;
    public p26 t;
    public NEGFeedBackView.b u;
    public vg v;
    public vg w;

    @Override // com.baidu.tieba.n26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl6 b;

        public a(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, du4 du4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, du4Var) == null) && view2 != null && du4Var != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, du4Var, this.b.getType());
                }
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", du4Var.t.getFid()).param("tid", du4Var.t.getTid()));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0924a1 && view2.getId() != R.id.obfuscated_res_0x7f092473) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f092191) {
                        gs6.e(du4Var.t, 5, this.b.mPageId, this.b.r, this.b.t());
                        tt6.g(du4Var.t, this.b.b, 1);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091e97) {
                        gs6.e(du4Var.t, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090eba) {
                        gs6.e(du4Var.t, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090ed3) {
                        gs6.e(du4Var.t, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.t.a instanceof Boolean) {
                            if (((Boolean) this.b.t.a).booleanValue()) {
                                gs6.e(du4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                            } else {
                                gs6.e(du4Var.t, 3, this.b.mPageId, this.b.r, this.b.t());
                            }
                        }
                        tt6.g(du4Var.t, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        gs6.e(du4Var.t, 15, this.b.mPageId, this.b.r, this.b.t());
                        tt6.g(du4Var.t, this.b.b, 1);
                    } else {
                        gs6.e(du4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                        tt6.g(du4Var.t, this.b.b, 1);
                    }
                } else {
                    gs6.e(du4Var.t, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0924a1 && view2.getId() != R.id.obfuscated_res_0x7f092473) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f09050b) {
                        tt6.a(this.b.r, du4Var.getRecomReason());
                        return;
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.t.a instanceof Boolean) {
                            if (((Boolean) this.b.t.a).booleanValue()) {
                                is6.k().h(this.b.r, du4Var.t, 1);
                                return;
                            } else {
                                is6.k().h(this.b.r, du4Var.t, 3);
                                return;
                            }
                        }
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090554) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09217f) {
                        is6.k().h(this.b.r, du4Var.t, 5);
                        return;
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (du4Var.t.getTopAgreePost() != null && du4Var.t.getTopAgreePost().X() != null && du4Var.t.getTopAgreePost().X().B() != null && du4Var.t.getTopAgreePost().X().B().size() > 0) {
                            i = du4Var.t.getTopAgreePost().M ? 9 : 8;
                        }
                        is6.k().h(this.b.r, du4Var.t, i);
                        return;
                    } else {
                        is6.k().h(this.b.r, du4Var.t, 1);
                        return;
                    }
                }
                is6.k().h(this.b.r, du4Var.t, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(xs4 xs4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xs4Var, compoundButton, z) == null) {
            }
        }

        public b(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
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
        public void a(ArrayList arrayList, String str, xs4 xs4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, xs4Var) == null) && arrayList != null && xs4Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", xs4Var.c()).param("tid", xs4Var.f()).param("nid", xs4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", xs4Var.l).param("weight", xs4Var.k).param("ab_tag", xs4Var.p).param("extra", xs4Var.m).param("card_type", xs4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, xs4Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(xs4 xs4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xs4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", xs4Var.c()).param("tid", xs4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl6 a;

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

        public c(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl6Var;
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
                return new ConstrainImageLayout(this.a.l.getPageActivity());
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements wg {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl6 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl6Var;
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
                TbImageView tbImageView = new TbImageView(this.a.l.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements kx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
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

    /* loaded from: classes5.dex */
    public class f implements nn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;
        public final /* synthetic */ nl6 b;

        public f(nl6 nl6Var, ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var, eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nl6Var;
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

    /* loaded from: classes5.dex */
    public class g implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl6 a;

        public g(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl6Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof du4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                du4 du4Var = (du4) eoVar;
                ThreadData threadData = du4Var.t;
                threadData.objType = 1;
                if (this.a.t != null) {
                    this.a.t.a(threadCardViewHolder.getView(), du4Var);
                }
                ThreadCardUtils.jumpToPB((ar4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nl6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new hs6();
        this.t = new a(this);
        this.u = new b(this);
        this.v = new vg(new c(this), 6, 0);
        this.w = new vg(new d(this), 12, 0);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void Y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet();
            }
            is6.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.ap5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.o26
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tieba.n26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.s = i;
        }
    }

    @Override // com.baidu.tieba.kh6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.kh6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: Z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ty.b bVar = new ty.b(this.l.getPageActivity());
            kx kxVar = new kx(this.l.getPageActivity());
            kxVar.f(4280);
            kxVar.x(this.mPageId);
            kxVar.w(new e(this));
            bVar.o(kxVar);
            ey eyVar = new ey(this.l.getPageActivity());
            eyVar.x("frs");
            if (this.s == 502) {
                eyVar.z(false);
            } else {
                eyVar.z(true);
            }
            eyVar.w(this.v);
            eyVar.v(this.w);
            eyVar.y(this.q);
            bVar.n(eyVar);
            dz dzVar = new dz(this.l.getPageActivity());
            dzVar.B(this.l);
            dzVar.A(3);
            bVar.h(dzVar);
            bVar.h(new ry(this.l.getPageActivity()));
            vx vxVar = new vx(this.l.getPageActivity());
            bVar.h(vxVar);
            vxVar.B(this.q);
            vxVar.A("frs");
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                eyVar.A(new f(this, eyVar));
            }
            vy vyVar = new vy(this.l.getPageActivity());
            gr4 gr4Var = new gr4();
            int i = 10;
            if (100 == t().tabType) {
                if (!this.p) {
                    i = 25;
                }
                gr4Var.b = i;
                vyVar.B(19);
                vyVar.G(14);
            } else {
                if (!this.p) {
                    i = 2;
                }
                gr4Var.b = i;
                vyVar.B(2);
                vyVar.G(1);
            }
            gr4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !ej.isEmpty(this.b.getForum().getId())) {
                gr4Var.j = this.b.getForum().getId();
            }
            vyVar.z(gr4Var);
            vyVar.C(3);
            vyVar.f(16);
            bVar.m(vyVar);
            bVar.l().h(fj.f(this.mContext, R.dimen.tbds28));
            ty i2 = bVar.i();
            i2.r(3);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i2);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kh6, com.baidu.tieba.rn
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, du4 du4Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, du4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, du4Var, threadCardViewHolder);
            if (du4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().b(this.n);
                jh6.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    du4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (du4Var.t.getAuthor() != null && du4Var.t.getAuthor().getUserId() != null && du4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (du4Var.t.isSmartFrsThread() && du4Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.o(true).u(this.u);
                }
                threadCardViewHolder.r();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().f(32);
                }
                threadCardViewHolder.e(du4Var);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.t);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    du4Var.t.statFloor = (du4Var.position + 1) - i2;
                }
                is6.k().c(this.r, du4Var.t);
                Y(du4Var.t);
                du4Var.t.updateShowStatus();
                gs6.o(du4Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    gs6.m(du4Var.t, t());
                    gs6.n(du4Var.t, this.b.getForum().getId());
                }
                if (du4Var != null) {
                    du4Var.t.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.js6
    public hs6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (hs6) invokeV.objValue;
    }
}
