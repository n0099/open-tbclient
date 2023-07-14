package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tieba.ay;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k58 extends tz7<kq6, ThreadCardViewHolder<kq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public s68 e;
    public String f;
    public boolean g;
    public ng<ConstrainImageLayout> h;
    public ng<TbImageView> i;
    public up6<kq6> j;

    /* loaded from: classes6.dex */
    public class a implements og<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

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

        public a(k58 k58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k58Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
    public class b implements og<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(k58 k58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k58Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
    public class c extends up6<kq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 b;

        public c(k58 k58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kq6Var) == null) {
                np6.b().d(true);
                r66.c().h("page_recommend", "show_");
                if (view2 != null && this.b.e != null && kq6Var != null && kq6Var.getThreadData() != null && !StringUtils.isNull(kq6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !u48.b(wg.g(kq6Var.getThreadData().getTid(), 0L))) {
                        u48.a(wg.g(kq6Var.getThreadData().getTid(), 0L));
                        this.b.e.e(wg.g(kq6Var.getThreadData().getTid(), 0L), kq6Var.v(), kq6Var.i(), kq6Var.h(), kq6Var.c(), wg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, kq6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, kq6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(k58 k58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && t15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    t15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    t15Var.objType = 4;
                } else {
                    t15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements hn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy a;
        public final /* synthetic */ k58 b;

        public e(k58 k58Var, yy yyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var, yyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k58Var;
            this.a = yyVar;
        }

        @Override // com.baidu.tieba.hn
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.D(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k58 a;

        public f(k58 k58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k58Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof kq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                kq6 kq6Var = (kq6) ynVar;
                kq6Var.f = 1;
                if (this.a.j != null) {
                    this.a.j.a(threadCardViewHolder.getView(), kq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) kq6Var, view2.getContext(), 2, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.h = new ng<>(new a(this), 6, 0);
        this.i = new ng<>(new b(this), 12, 0);
        this.j = new c(this);
        this.c = tbPageContext;
        z();
    }

    public void D(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void E(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s68Var) == null) {
            this.e = s68Var;
        }
    }

    @Override // com.baidu.tieba.t66
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
    @Override // com.baidu.tieba.ln
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity());
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.r(this.b);
            ayVar.h(1024);
            ayVar.A(new d(this));
            bVar.o(ayVar);
            yy yyVar = new yy(this.c.getPageActivity());
            yyVar.setFrom("index");
            yyVar.A(this.h);
            yyVar.z(this.i);
            yyVar.B(this.g);
            bVar.n(yyVar);
            uy uyVar = new uy(this.c.getPageActivity());
            uyVar.E(true);
            bVar.h(uyVar);
            bVar.h(new iz(this.c.getPageActivity()));
            bVar.h(new bz(this.c.getPageActivity()));
            bVar.h(new iy(this.c.getPageActivity()));
            my myVar = new my(this.c.getPageActivity());
            myVar.F(this.g);
            myVar.E("index");
            bVar.h(myVar);
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                yyVar.D(new e(this, yyVar));
            }
            oz ozVar = new oz(this.c.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 1;
            z15Var.h = 1;
            ozVar.D(z15Var);
            ozVar.F(1);
            ozVar.L(3);
            ozVar.G(2);
            ozVar.E(false);
            bVar.m(ozVar);
            mz i = bVar.i();
            i.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kq6 kq6Var, ThreadCardViewHolder<kq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kq6Var, threadCardViewHolder})) == null) {
            if (kq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && kq6Var.a != null) {
                kq6Var.B(kq6Var.position + 1);
                kq6Var.a.statFloor = kq6Var.h();
                threadCardViewHolder.b().b(this.f);
                threadCardViewHolder.q(true).s(this.d);
                threadCardViewHolder.m(kq6Var.showFollowBtn(), this.a);
                threadCardViewHolder.f(kq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.j);
                np6.b().a(kq6Var.r());
                r66.c().i("page_recommend", "show_", kq6Var.r());
                x68.p(kq6Var.a, this.b, kq6Var.h());
                x68.o(kq6Var.a, kq6Var.i(), kq6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, kq6 kq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, kq6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.thread_card_root) {
                TiebaStatic.log(kq6Var.p());
                r66.c().i("page_recommend", "clk_", kq6Var.p());
                x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 1);
                i = 1;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(kq6Var.p());
                r66.c().i("page_recommend", "clk_", kq6Var.p());
                i = 5;
                x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 1);
            } else {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kq6Var.S());
                    r66.c().i("page_recommend", "clk_", kq6Var.S());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kq6Var.R());
                        r66.c().i("page_recommend", "clk_", kq6Var.R());
                        x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 4);
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kq6Var.R());
                        r66.c().i("page_recommend", "clk_", kq6Var.R());
                        x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 4);
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kq6Var.f());
                        r66.c().i("page_recommend", "clk_", kq6Var.f());
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(kq6Var.M());
                            r66.c().i("page_recommend", "clk_", kq6Var.M());
                            x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 2);
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
                x68.d(kq6Var.a, this.b, kq6Var.h(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            kq6.f1135T = "c10705";
            kq6.U = "c10730";
            kq6.V = "c10731";
            kq6.W = "c10704";
            kq6.X = "c10755";
            kq6.Y = "c10710";
            kq6.Z = "c10736";
            kq6.a0 = "c10737";
            kq6.b0 = "c10711";
            kq6.c0 = "c10758";
            kq6.d0 = "c10757";
        }
    }
}
