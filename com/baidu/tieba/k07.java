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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.rw;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class k07 extends ew6<mz4, ThreadCardViewHolder<mz4>> implements jf6, e77, jx5, kf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public boolean q;
    public c77 r;
    public lf6<mz4> s;
    public NEGFeedBackView.b t;
    public xf<ConstrainImageLayout> u;
    public xf<TbImageView> v;

    @Override // com.baidu.tieba.jf6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.jf6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends lf6<mz4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 b;

        public a(k07 k07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, mz4 mz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mz4Var) == null) && view2 != null && mz4Var != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, mz4Var, this.b.getType());
                }
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", mz4Var.t.getFid()).param("tid", mz4Var.t.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        b77.e(mz4Var.t, 5, this.b.mPageId, this.b.r, this.b.t());
                        s87.g(mz4Var.t, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        b77.e(mz4Var.t, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        b77.e(mz4Var.t, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        b77.e(mz4Var.t, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.s.a instanceof Boolean) {
                            if (((Boolean) this.b.s.a).booleanValue()) {
                                b77.e(mz4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                            } else {
                                b77.e(mz4Var.t, 3, this.b.mPageId, this.b.r, this.b.t());
                            }
                        }
                        s87.g(mz4Var.t, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        b77.e(mz4Var.t, 15, this.b.mPageId, this.b.r, this.b.t());
                        s87.g(mz4Var.t, this.b.b, 1);
                    } else {
                        b77.e(mz4Var.t, 1, this.b.mPageId, this.b.r, this.b.t());
                        s87.g(mz4Var.t, this.b.b, 1);
                    }
                } else {
                    b77.e(mz4Var.t, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_divider_tv) {
                        s87.a(this.b.r, mz4Var.getRecomReason());
                        return;
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.s.a instanceof Boolean) {
                            if (((Boolean) this.b.s.a).booleanValue()) {
                                d77.k().h(this.b.r, mz4Var.t, 1);
                                return;
                            } else {
                                d77.k().h(this.b.r, mz4Var.t, 3);
                                return;
                            }
                        }
                        return;
                    } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else if (view2.getId() == R.id.thread_card_voice) {
                        d77.k().h(this.b.r, mz4Var.t, 5);
                        return;
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (mz4Var.t.getTopAgreePost() != null && mz4Var.t.getTopAgreePost().Z() != null && mz4Var.t.getTopAgreePost().Z().T() != null && mz4Var.t.getTopAgreePost().Z().T().size() > 0) {
                            i = mz4Var.t.getTopAgreePost().N ? 9 : 8;
                        }
                        d77.k().h(this.b.r, mz4Var.t, i);
                        return;
                    } else {
                        d77.k().h(this.b.r, mz4Var.t, 1);
                        return;
                    }
                }
                d77.k().h(this.b.r, mz4Var.t, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(fy4 fy4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy4Var, compoundButton, z) == null) {
            }
        }

        public b(k07 k07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var};
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
        public void a(ArrayList<Integer> arrayList, String str, fy4 fy4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, fy4Var) == null) && arrayList != null && fy4Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", fy4Var.c()).param("tid", fy4Var.f()).param("nid", fy4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", fy4Var.l).param("weight", fy4Var.k).param("ab_tag", fy4Var.p).param("extra", fy4Var.m).param("card_type", fy4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, fy4Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(fy4 fy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fy4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", fy4Var.c()).param("tid", fy4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 a;

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

        public c(k07 k07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k07Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
    public class d implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(k07 k07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k07Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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
    public class e implements rw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(k07 k07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw.b
        public void a(hw4 hw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, hw4Var, view2) == null) && hw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    hw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    hw4Var.objType = 4;
                } else {
                    hw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements pm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx a;
        public final /* synthetic */ k07 b;

        public f(k07 k07Var, nx nxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var, nxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k07Var;
            this.a = nxVar;
        }

        @Override // com.baidu.tieba.pm
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
    public class g implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k07 a;

        public g(k07 k07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k07Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                mz4 mz4Var = (mz4) gnVar;
                ThreadData threadData = mz4Var.t;
                threadData.objType = 1;
                if (this.a.s != null) {
                    this.a.s.a(threadCardViewHolder.getView(), mz4Var);
                }
                ThreadCardUtils.jumpToPB((hw4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new c77();
        this.s = new a(this);
        this.t = new b(this);
        this.u = new xf<>(new c(this), 6, 0);
        this.v = new xf<>(new d(this), 12, 0);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void a0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            d77.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.kf6
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tieba.ew6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.ew6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.q = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: b0 */
    public ThreadCardViewHolder<mz4> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.l.getPageActivity());
            rw rwVar = new rw(this.l.getPageActivity());
            rwVar.f(4280);
            rwVar.x(this.mPageId);
            rwVar.w(new e(this));
            bVar.o(rwVar);
            nx nxVar = new nx(this.l.getPageActivity());
            nxVar.x("frs");
            nxVar.z(true);
            nxVar.w(this.u);
            nxVar.v(this.v);
            nxVar.y(this.q);
            bVar.n(nxVar);
            my myVar = new my(this.l.getPageActivity());
            myVar.B(this.l);
            myVar.A(3);
            bVar.h(myVar);
            bVar.h(new ay(this.l.getPageActivity()));
            cx cxVar = new cx(this.l.getPageActivity());
            bVar.h(cxVar);
            cxVar.B(this.q);
            cxVar.A("frs");
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                nxVar.A(new f(this, nxVar));
            }
            ey eyVar = new ey(this.l.getPageActivity());
            nw4 nw4Var = new nw4();
            int i = 10;
            if (100 == t().tabType) {
                if (!this.p) {
                    i = 25;
                }
                nw4Var.b = i;
                eyVar.B(19);
                eyVar.G(14);
            } else {
                if (!this.p) {
                    i = 2;
                }
                nw4Var.b = i;
                eyVar.B(2);
                eyVar.G(1);
            }
            nw4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !gi.isEmpty(this.b.getForum().getId())) {
                nw4Var.j = this.b.getForum().getId();
            }
            eyVar.z(nw4Var);
            eyVar.C(3);
            eyVar.f(16);
            bVar.m(eyVar);
            bVar.l().i(hi.g(this.mContext, R.dimen.tbds28));
            cy i2 = bVar.i();
            i2.s(3);
            ThreadCardViewHolder<mz4> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ew6, com.baidu.tieba.tm
    /* renamed from: c0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, ThreadCardViewHolder<mz4> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mz4Var, (mz4) threadCardViewHolder);
            if (mz4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                threadCardViewHolder.a().b(this.n);
                dw6.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    mz4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (mz4Var.t.getAuthor() != null && mz4Var.t.getAuthor().getUserId() != null && mz4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (mz4Var.t.isSmartFrsThread() && mz4Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.o(true).s(this.t);
                }
                threadCardViewHolder.r();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().f(32);
                }
                threadCardViewHolder.e(mz4Var);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    mz4Var.t.statFloor = (mz4Var.position + 1) - i2;
                }
                d77.k().c(this.r, mz4Var.t);
                a0(mz4Var.t);
                mz4Var.t.updateShowStatus();
                b77.o(mz4Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    b77.m(mz4Var.t, t());
                    b77.n(mz4Var.t, this.b.getForum().getId());
                }
                if (mz4Var != null) {
                    mz4Var.t.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.e77
    public c77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (c77) invokeV.objValue;
    }
}
