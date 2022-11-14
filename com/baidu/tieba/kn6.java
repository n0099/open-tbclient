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
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class kn6 extends gj6<wu4, ThreadCardViewHolder<wu4>> implements j46, eu6, lq5, k46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public cu6 r;
    public int s;
    public l46<wu4> t;
    public NEGFeedBackView.b u;
    public og<ConstrainImageLayout> v;
    public og<TbImageView> w;

    @Override // com.baidu.tieba.j46
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends l46<wu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn6 b;

        public a(kn6 kn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, wu4 wu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wu4Var) == null) && view2 != null && wu4Var != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, wu4Var, this.b.getType());
                }
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", wu4Var.t.getFid()).param("tid", wu4Var.t.getTid()));
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921f1) {
                        bu6.e(wu4Var.t, 5, this.b.mPageId, this.b.r, this.b.t());
                        nv6.g(wu4Var.t, this.b.b, 1);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091eee) {
                        bu6.e(wu4Var.t, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090ef6) {
                        bu6.e(wu4Var.t, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090f0f) {
                        bu6.e(wu4Var.t, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.t.a instanceof Boolean) {
                            if (((Boolean) this.b.t.a).booleanValue()) {
                                bu6.e(wu4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                            } else {
                                bu6.e(wu4Var.t, 3, this.b.mPageId, this.b.r, this.b.t());
                            }
                        }
                        nv6.g(wu4Var.t, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        bu6.e(wu4Var.t, 15, this.b.mPageId, this.b.r, this.b.t());
                        nv6.g(wu4Var.t, this.b.b, 1);
                    } else {
                        bu6.e(wu4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                        nv6.g(wu4Var.t, this.b.b, 1);
                    }
                } else {
                    bu6.e(wu4Var.t, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f090519) {
                        nv6.a(this.b.r, wu4Var.getRecomReason());
                        return;
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.t.a instanceof Boolean) {
                            if (((Boolean) this.b.t.a).booleanValue()) {
                                du6.k().h(this.b.r, wu4Var.t, 1);
                                return;
                            } else {
                                du6.k().h(this.b.r, wu4Var.t, 3);
                                return;
                            }
                        }
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090562) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0921df) {
                        du6.k().h(this.b.r, wu4Var.t, 5);
                        return;
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (wu4Var.t.getTopAgreePost() != null && wu4Var.t.getTopAgreePost().X() != null && wu4Var.t.getTopAgreePost().X().B() != null && wu4Var.t.getTopAgreePost().X().B().size() > 0) {
                            i = wu4Var.t.getTopAgreePost().N ? 9 : 8;
                        }
                        du6.k().h(this.b.r, wu4Var.t, i);
                        return;
                    } else {
                        du6.k().h(this.b.r, wu4Var.t, 1);
                        return;
                    }
                }
                du6.k().h(this.b.r, wu4Var.t, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(pt4 pt4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pt4Var, compoundButton, z) == null) {
            }
        }

        public b(kn6 kn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, pt4 pt4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, pt4Var) == null) && arrayList != null && pt4Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", pt4Var.c()).param("tid", pt4Var.f()).param("nid", pt4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", pt4Var.l).param("weight", pt4Var.k).param("ab_tag", pt4Var.p).param("extra", pt4Var.m).param("card_type", pt4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, pt4Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(pt4 pt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pt4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", pt4Var.c()).param("tid", pt4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements pg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn6 a;

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

        public c(kn6 kn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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

    /* loaded from: classes4.dex */
    public class d implements pg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn6 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(kn6 kn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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

    /* loaded from: classes4.dex */
    public class e implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(kn6 kn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var};
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

    /* loaded from: classes4.dex */
    public class f implements gn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx a;
        public final /* synthetic */ kn6 b;

        public f(kn6 kn6Var, zx zxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var, zxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kn6Var;
            this.a = zxVar;
        }

        @Override // com.baidu.tieba.gn
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

    /* loaded from: classes4.dex */
    public class g implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kn6 a;

        public g(kn6 kn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kn6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof wu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wu4 wu4Var = (wu4) xnVar;
                ThreadData threadData = wu4Var.t;
                threadData.objType = 1;
                if (this.a.t != null) {
                    this.a.t.a(threadCardViewHolder.getView(), wu4Var);
                }
                ThreadCardUtils.jumpToPB((sr4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kn6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new cu6();
        this.t = new a(this);
        this.u = new b(this);
        this.v = new og<>(new c(this), 6, 0);
        this.w = new og<>(new d(this), 12, 0);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void Y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            du6.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.lq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.k46
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tieba.j46
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.s = i;
        }
    }

    @Override // com.baidu.tieba.gj6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.gj6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: Z */
    public ThreadCardViewHolder<wu4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.l.getPageActivity());
            dx dxVar = new dx(this.l.getPageActivity());
            dxVar.f(4280);
            dxVar.x(this.mPageId);
            dxVar.w(new e(this));
            bVar.o(dxVar);
            zx zxVar = new zx(this.l.getPageActivity());
            zxVar.x("frs");
            if (this.s == 502) {
                zxVar.z(false);
            } else {
                zxVar.z(true);
            }
            zxVar.w(this.v);
            zxVar.v(this.w);
            zxVar.y(this.q);
            bVar.n(zxVar);
            yy yyVar = new yy(this.l.getPageActivity());
            yyVar.B(this.l);
            yyVar.A(3);
            bVar.h(yyVar);
            bVar.h(new my(this.l.getPageActivity()));
            ox oxVar = new ox(this.l.getPageActivity());
            bVar.h(oxVar);
            oxVar.B(this.q);
            oxVar.A("frs");
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                zxVar.A(new f(this, zxVar));
            }
            qy qyVar = new qy(this.l.getPageActivity());
            yr4 yr4Var = new yr4();
            int i = 10;
            if (100 == t().tabType) {
                if (!this.p) {
                    i = 25;
                }
                yr4Var.b = i;
                qyVar.B(19);
                qyVar.G(14);
            } else {
                if (!this.p) {
                    i = 2;
                }
                yr4Var.b = i;
                qyVar.B(2);
                qyVar.G(1);
            }
            yr4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !xi.isEmpty(this.b.getForum().getId())) {
                yr4Var.j = this.b.getForum().getId();
            }
            qyVar.z(yr4Var);
            qyVar.C(3);
            qyVar.f(16);
            bVar.m(qyVar);
            bVar.l().h(yi.g(this.mContext, R.dimen.tbds28));
            oy i2 = bVar.i();
            i2.r(3);
            ThreadCardViewHolder<wu4> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gj6, com.baidu.tieba.kn
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wu4 wu4Var, ThreadCardViewHolder<wu4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wu4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, wu4Var, threadCardViewHolder);
            if (wu4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().b(this.n);
                fj6.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    wu4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (wu4Var.t.getAuthor() != null && wu4Var.t.getAuthor().getUserId() != null && wu4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (wu4Var.t.isSmartFrsThread() && wu4Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.o(true).s(this.u);
                }
                threadCardViewHolder.r();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().f(32);
                }
                threadCardViewHolder.e(wu4Var);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.t);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    wu4Var.t.statFloor = (wu4Var.position + 1) - i2;
                }
                du6.k().c(this.r, wu4Var.t);
                Y(wu4Var.t);
                wu4Var.t.updateShowStatus();
                bu6.o(wu4Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    bu6.m(wu4Var.t, t());
                    bu6.n(wu4Var.t, this.b.getForum().getId());
                }
                if (wu4Var != null) {
                    wu4Var.t.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.eu6
    public cu6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (cu6) invokeV.objValue;
    }
}
