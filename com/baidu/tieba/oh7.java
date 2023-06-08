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
import com.baidu.tieba.jz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.uz;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class oh7 extends id7<n45, ThreadCardViewHolder<n45>> implements eo6, oo7, f56, fo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public mo7 r;
    public go6<n45> s;
    public NEGFeedBackView.b t;
    public kg<ConstrainImageLayout> u;
    public kg<TbImageView> v;

    @Override // com.baidu.tieba.eo6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.eo6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends go6<n45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh7 b;

        public a(oh7 oh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, n45 n45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, n45Var) == null) && view2 != null && n45Var != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, n45Var, this.b.getType());
                }
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", n45Var.t.getFid()).param("tid", n45Var.t.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        lo7.e(n45Var.t, 5, this.b.mPageId, this.b.r, this.b.t());
                        er7.g(n45Var.t, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        lo7.e(n45Var.t, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        lo7.e(n45Var.t, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        lo7.e(n45Var.t, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.s.a instanceof Boolean) {
                            if (((Boolean) this.b.s.a).booleanValue()) {
                                lo7.e(n45Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                            } else {
                                lo7.e(n45Var.t, 3, this.b.mPageId, this.b.r, this.b.t());
                            }
                        }
                        er7.g(n45Var.t, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        lo7.e(n45Var.t, 15, this.b.mPageId, this.b.r, this.b.t());
                        er7.g(n45Var.t, this.b.b, 1);
                    } else {
                        lo7.e(n45Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                        er7.g(n45Var.t, this.b.b, 1);
                    }
                } else {
                    lo7.e(n45Var.t, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_divider_tv) {
                        er7.a(this.b.r, n45Var.getRecomReason());
                        return;
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.s.a instanceof Boolean) {
                            if (((Boolean) this.b.s.a).booleanValue()) {
                                no7.k().h(this.b.r, n45Var.t, 1);
                                return;
                            } else {
                                no7.k().h(this.b.r, n45Var.t, 3);
                                return;
                            }
                        }
                        return;
                    } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else if (view2.getId() == R.id.thread_card_voice) {
                        no7.k().h(this.b.r, n45Var.t, 5);
                        return;
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (n45Var.t.getTopAgreePost() != null && n45Var.t.getTopAgreePost().a0() != null && n45Var.t.getTopAgreePost().a0().W() != null && n45Var.t.getTopAgreePost().a0().W().size() > 0) {
                            i = n45Var.t.getTopAgreePost().N ? 9 : 8;
                        }
                        no7.k().h(this.b.r, n45Var.t, i);
                        return;
                    } else {
                        no7.k().h(this.b.r, n45Var.t, 1);
                        return;
                    }
                }
                no7.k().h(this.b.r, n45Var.t, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(g35 g35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g35Var, compoundButton, z) == null) {
            }
        }

        public b(oh7 oh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var};
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
        public void a(ArrayList<Integer> arrayList, String str, g35 g35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, g35Var) == null) && arrayList != null && g35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", g35Var.c()).param("tid", g35Var.f()).param("nid", g35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", g35Var.l).param("weight", g35Var.k).param("ab_tag", g35Var.p).param("extra", g35Var.m).param("card_type", g35Var.o).param(TiebaStatic.Params.OBJ_FLOOR, g35Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(g35 g35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g35Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", g35Var.c()).param("tid", g35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements lg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh7 a;

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

        public c(oh7 oh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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

    /* loaded from: classes7.dex */
    public class d implements lg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh7 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(oh7 oh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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

    /* loaded from: classes7.dex */
    public class e implements xx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(oh7 oh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.xx.b
        public void a(h15 h15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, h15Var, view2) == null) && h15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    h15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    h15Var.objType = 4;
                } else {
                    h15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements en {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ oh7 b;

        public f(oh7 oh7Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oh7Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.en
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.B(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oh7 a;

        public g(oh7 oh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oh7Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof n45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                n45 n45Var = (n45) vnVar;
                ThreadData threadData = n45Var.t;
                threadData.objType = 1;
                if (this.a.s != null) {
                    this.a.s.a(threadCardViewHolder.getView(), n45Var);
                }
                ThreadCardUtils.jumpToPB((h15) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new mo7();
        this.s = new a(this);
        this.t = new b(this);
        this.u = new kg<>(new c(this), 6, 0);
        this.v = new kg<>(new d(this), 12, 0);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void a0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            no7.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.f56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.fo6
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tieba.id7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.id7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: b0 */
    public ThreadCardViewHolder<n45> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.l.getPageActivity());
            xx xxVar = new xx(this.l.getPageActivity());
            xxVar.f(4280);
            xxVar.z(this.mPageId);
            xxVar.y(new e(this));
            bVar.o(xxVar);
            vy vyVar = new vy(this.l.getPageActivity());
            vyVar.setFrom("frs");
            vyVar.A(true);
            vyVar.y(this.u);
            vyVar.x(this.v);
            vyVar.z(this.q);
            bVar.n(vyVar);
            tz tzVar = new tz(this.l.getPageActivity());
            tzVar.D(this.l);
            tzVar.C(3);
            bVar.h(tzVar);
            bVar.h(new hz(this.l.getPageActivity()));
            jy jyVar = new jy(this.l.getPageActivity());
            bVar.h(jyVar);
            jyVar.D(this.q);
            jyVar.C("frs");
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                vyVar.B(new f(this, vyVar));
            }
            lz lzVar = new lz(this.l.getPageActivity());
            n15 n15Var = new n15();
            int i = 10;
            if (100 == t().tabType) {
                if (!this.p) {
                    i = 25;
                }
                n15Var.b = i;
                lzVar.D(19);
                lzVar.I(14);
            } else {
                if (!this.p) {
                    i = 2;
                }
                n15Var.b = i;
                lzVar.D(2);
                lzVar.I(1);
            }
            n15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !ui.isEmpty(this.b.getForum().getId())) {
                n15Var.j = this.b.getForum().getId();
            }
            lzVar.B(n15Var);
            lzVar.E(3);
            lzVar.f(16);
            bVar.m(lzVar);
            bVar.l().i(vi.g(this.mContext, R.dimen.tbds28));
            jz i2 = bVar.i();
            i2.s(3);
            ThreadCardViewHolder<n45> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.n();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.id7, com.baidu.tieba.in
    /* renamed from: c0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n45 n45Var, ThreadCardViewHolder<n45> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n45Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) n45Var, (n45) threadCardViewHolder);
            if (n45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().b(this.n);
                hd7.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    n45Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (n45Var.t.getAuthor() != null && n45Var.t.getAuthor().getUserId() != null && n45Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (n45Var.t.isSmartFrsThread() && n45Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.p(true).s(this.t);
                }
                threadCardViewHolder.s();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().f(32);
                }
                threadCardViewHolder.e(n45Var);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    n45Var.t.statFloor = (n45Var.position + 1) - i2;
                }
                no7.k().c(this.r, n45Var.t);
                a0(n45Var.t);
                n45Var.t.updateShowStatus();
                lo7.p(n45Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    lo7.n(n45Var.t, t());
                    lo7.o(n45Var.t, this.b.getForum().getId());
                }
                if (n45Var != null) {
                    n45Var.t.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.oo7
    public mo7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (mo7) invokeV.objValue;
    }
}
