package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
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
import com.baidu.tieba.cx;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u48 extends yy7<zo6, ThreadCardViewHolder<zo6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public h68 e;
    public String f;
    public boolean g;
    public ag<ConstrainImageLayout> h;
    public ag<TbImageView> i;
    public jo6<zo6> j;

    /* loaded from: classes8.dex */
    public class a implements bg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

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

        public a(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u48Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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

    /* loaded from: classes8.dex */
    public class b implements bg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u48Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
        @Override // com.baidu.tieba.bg
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

    /* loaded from: classes8.dex */
    public class c extends jo6<zo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 b;

        public c(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, zo6 zo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zo6Var) == null) {
                co6.b().d(true);
                q46.c().h("page_recommend", "show_");
                if (view2 != null && this.b.e != null && zo6Var != null && zo6Var.getThreadData() != null && !StringUtils.isNull(zo6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !d48.b(JavaTypesHelper.toLong(zo6Var.getThreadData().getTid(), 0L))) {
                        d48.a(JavaTypesHelper.toLong(zo6Var.getThreadData().getTid(), 0L));
                        this.b.e.e(JavaTypesHelper.toLong(zo6Var.getThreadData().getTid(), 0L), zo6Var.u(), zo6Var.i(), zo6Var.h(), zo6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, zo6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, zo6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements cx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.cx.b
        public void a(w05 w05Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, w05Var, view2) == null) && w05Var != null) {
                if (view2.getId() == R.id.user_name) {
                    w05Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    w05Var.objType = 4;
                } else {
                    w05Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements lm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay a;
        public final /* synthetic */ u48 b;

        public e(u48 u48Var, ay ayVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var, ayVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u48Var;
            this.a = ayVar;
        }

        @Override // com.baidu.tieba.lm
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.C(null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u48 a;

        public f(u48 u48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u48Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof zo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zo6 zo6Var = (zo6) bnVar;
                zo6Var.f = 1;
                if (this.a.j != null) {
                    this.a.j.a(threadCardViewHolder.getView(), zo6Var);
                }
                ThreadCardUtils.jumpToPB((w05) zo6Var, view2.getContext(), 2, false);
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.h = new ag<>(new a(this), 6, 0);
        this.i = new ag<>(new b(this), 12, 0);
        this.j = new c(this);
        this.c = tbPageContext;
        z();
    }

    public void D(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    public void E(h68 h68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h68Var) == null) {
            this.e = h68Var;
        }
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.g = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity());
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.q(this.b);
            cxVar.g(1024);
            cxVar.z(new d(this));
            bVar.o(cxVar);
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.setFrom("index");
            ayVar.z(this.h);
            ayVar.y(this.i);
            ayVar.A(this.g);
            bVar.n(ayVar);
            wx wxVar = new wx(this.c.getPageActivity());
            wxVar.D(true);
            bVar.h(wxVar);
            bVar.h(new jy(this.c.getPageActivity()));
            bVar.h(new dy(this.c.getPageActivity()));
            bVar.h(new kx(this.c.getPageActivity()));
            ox oxVar = new ox(this.c.getPageActivity());
            oxVar.E(this.g);
            oxVar.D("index");
            bVar.h(oxVar);
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                ayVar.C(new e(this, ayVar));
            }
            py pyVar = new py(this.c.getPageActivity());
            c15 c15Var = new c15();
            c15Var.b = 1;
            c15Var.h = 1;
            pyVar.C(c15Var);
            pyVar.E(1);
            pyVar.J(3);
            pyVar.F(2);
            pyVar.D(false);
            bVar.m(pyVar);
            ny i = bVar.i();
            i.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zo6 zo6Var, ThreadCardViewHolder<zo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zo6Var, threadCardViewHolder})) == null) {
            if (zo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && zo6Var.a != null) {
                zo6Var.A(zo6Var.position + 1);
                zo6Var.a.statFloor = zo6Var.h();
                threadCardViewHolder.b().b(this.f);
                threadCardViewHolder.q(true).setNegEventCallback(this.d);
                threadCardViewHolder.m(zo6Var.showFollowBtn(), this.a);
                threadCardViewHolder.f(zo6Var);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.j);
                co6.b().a(zo6Var.r());
                q46.c().i("page_recommend", "show_", zo6Var.r());
                m68.p(zo6Var.a, this.b, zo6Var.h());
                m68.o(zo6Var.a, zo6Var.i(), zo6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, zo6 zo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, zo6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.thread_card_root) {
                TiebaStatic.log(zo6Var.q());
                q46.c().i("page_recommend", "clk_", zo6Var.q());
                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                i = 1;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(zo6Var.q());
                q46.c().i("page_recommend", "clk_", zo6Var.q());
                i = 5;
                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
            } else {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(zo6Var.O());
                    q46.c().i("page_recommend", "clk_", zo6Var.O());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(zo6Var.N());
                        q46.c().i("page_recommend", "clk_", zo6Var.N());
                        m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 4);
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(zo6Var.N());
                        q46.c().i("page_recommend", "clk_", zo6Var.N());
                        m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 4);
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(zo6Var.f());
                        q46.c().i("page_recommend", "clk_", zo6Var.f());
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(zo6Var.K());
                            q46.c().i("page_recommend", "clk_", zo6Var.K());
                            m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 2);
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
                m68.d(zo6Var.a, this.b, zo6Var.h(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            zo6.f1193T = "c10705";
            zo6.U = "c10730";
            zo6.V = "c10731";
            zo6.W = "c10704";
            zo6.X = "c10755";
            zo6.Y = "c10710";
            zo6.Z = "c10736";
            zo6.a0 = "c10737";
            zo6.b0 = "c10711";
            zo6.c0 = "c10758";
            zo6.d0 = "c10757";
        }
    }
}
