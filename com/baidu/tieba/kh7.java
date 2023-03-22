package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kh7 extends tm<ag6, ThreadCardViewHolder<ag6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ki7 c;
    public String d;
    public mn e;
    public NEGFeedBackView.b f;
    public lf6<ag6> g;

    /* loaded from: classes5.dex */
    public class a extends lf6<ag6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 b;

        public a(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ag6Var) == null) {
                ef6.b().d(true);
                hx5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && ag6Var != null && ag6Var.getThreadData() != null && !StringUtils.isNull(ag6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !pg7.b(gg.g(ag6Var.getThreadData().getTid(), 0L))) {
                        pg7.a(gg.g(ag6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(gg.g(ag6Var.getThreadData().getTid(), 0L), ag6Var.w(), ag6Var.m(), ag6Var.k(), ag6Var.c(), gg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, ag6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, ag6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 a;

        public b(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof ag6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ag6 ag6Var = (ag6) gnVar;
                ag6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), ag6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) ag6Var, view2.getContext(), 2, false, sw.a((mn) viewGroup, view2, i));
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ag6 d;
        public final /* synthetic */ kh7 e;

        public c(kh7 kh7Var, ViewGroup viewGroup, View view2, int i, ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var, viewGroup, view2, Integer.valueOf(i), ag6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kh7Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = ag6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.l
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(sw.a((mn) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem o = this.d.o(ag6.e0);
                        o.param("obj_type", this.d.getThreadData().getSmartApp().id);
                        o.param("obj_name", this.d.getThreadData().getSmartApp().name);
                        TiebaStatic.log(o);
                    }
                }
                CardLinkageManager.INSTANCE.cancelHighLight(this.e.e, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.b = tbPageContext;
        y();
    }

    public void C(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void D(ki7 ki7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ki7Var) == null) {
            this.c = ki7Var;
        }
    }

    public void E(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mnVar) == null) {
            this.e = mnVar;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ag6 ag6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ag6Var, threadCardViewHolder})) == null) {
            if (ag6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ag6Var.a != null) {
                ag6Var.E(ag6Var.position + 1);
                ag6Var.a.statFloor = ag6Var.k();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                if (threadCardViewHolder.a().f() instanceof ey) {
                    ((ey) threadCardViewHolder.a().f()).F(new c(this, viewGroup, view2, i, ag6Var));
                }
                threadCardViewHolder.p(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.e(ag6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                ef6.b().a(ag6Var.u());
                hx5.c().a(ag6Var.u());
                pi7.p(ag6Var.a, this.a, ag6Var.k());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(View view2, ag6 ag6Var) {
        StatisticItem t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ag6Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(ag6Var.T());
                    hx5.c().i("page_recommend", "clk_", ag6Var.T());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(ag6Var.S());
                        hx5.c().i("page_recommend", "clk_", ag6Var.S());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(ag6Var.S());
                        hx5.c().i("page_recommend", "clk_", ag6Var.S());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(ag6Var.h());
                        hx5.c().i("page_recommend", "clk_", ag6Var.h());
                        i2 = 9;
                    } else {
                        if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || ag6Var == null || ag6Var.getThreadData() == null || ag6Var.getThreadData().getForumData() == null || StringUtils.isNull(ag6Var.getThreadData().getForumData().g())) {
                        i = i2;
                    }
                    if (i == 0) {
                        pi7.d(ag6Var.a, this.a, ag6Var.k(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (bg6.R(ag6Var.a)) {
                    t = ag6Var.v();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(t));
                } else {
                    t = ag6Var.t();
                    TiebaStatic.log(t);
                }
                hx5.c().i("page_recommend", "clk_", t);
                pi7.c(ag6Var.a, ag6Var.m(), ag6Var.k(), 1);
            }
            i2 = 1;
            if (id == R.id.thread_info_commont_container) {
            }
            i = i2;
            if (i == 0) {
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ag6.T = "c10730";
            ag6.U = "c10731";
            ag6.V = "c10704";
            ag6.W = "c10755";
            ag6.X = "c10710";
            ag6.Y = "c10736";
            ag6.Z = "c10737";
            ag6.a0 = "c10711";
            ag6.b0 = "c10758";
            ag6.c0 = "c10757";
            ag6.f0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity(), false);
            ey eyVar = new ey(this.b.getPageActivity());
            nw4 nw4Var = new nw4();
            nw4Var.b = 1;
            nw4Var.h = 1;
            eyVar.z(nw4Var);
            eyVar.B(1);
            eyVar.H("personalize_page");
            eyVar.G(3);
            eyVar.C(2);
            eyVar.f(32);
            eyVar.A(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
