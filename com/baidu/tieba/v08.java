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
import com.baidu.tieba.lz;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v08 extends kn<gp6, ThreadCardViewHolder<gp6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public y18 c;
    public String d;
    public Cdo e;
    public NEGFeedBackView.b f;
    public qo6<gp6> g;

    /* loaded from: classes8.dex */
    public class a extends qo6<gp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v08 b;

        public a(v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, gp6 gp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gp6Var) == null) {
                jo6.b().d(true);
                n56.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && gp6Var != null && gp6Var.getThreadData() != null && !StringUtils.isNull(gp6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !b08.b(vg.g(gp6Var.getThreadData().getTid(), 0L))) {
                        b08.a(vg.g(gp6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(vg.g(gp6Var.getThreadData().getTid(), 0L), gp6Var.w(), gp6Var.k(), gp6Var.i(), gp6Var.c(), vg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, gp6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, gp6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v08 a;

        public b(v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v08Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof gp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gp6 gp6Var = (gp6) xnVar;
                gp6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), gp6Var);
                }
                ThreadCardUtils.jumpToPB((l15) gp6Var, view2.getContext(), 2, false, ay.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ gp6 d;
        public final /* synthetic */ v08 e;

        public c(v08 v08Var, ViewGroup viewGroup, View view2, int i, gp6 gp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var, viewGroup, view2, Integer.valueOf(i), gp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = v08Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = gp6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(ay.a((Cdo) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem l = this.d.l(gp6.f0);
                        l.param("obj_type", this.d.getThreadData().getSmartApp().id);
                        l.param("obj_name", this.d.getThreadData().getSmartApp().name);
                        TiebaStatic.log(l);
                    }
                }
                CardLinkageManager.INSTANCE.cancelHighLight(this.e.e, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void D(y18 y18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y18Var) == null) {
            this.c = y18Var;
        }
    }

    public void E(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cdo) == null) {
            this.e = cdo;
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, gp6 gp6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gp6Var, threadCardViewHolder})) == null) {
            if (gp6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && gp6Var.a != null) {
                gp6Var.B(gp6Var.position + 1);
                gp6Var.a.statFloor = gp6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                if (threadCardViewHolder.a().f() instanceof nz) {
                    ((nz) threadCardViewHolder.a().f()).H(new c(this, viewGroup, view2, i, gp6Var));
                }
                threadCardViewHolder.q(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.e(gp6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                jo6.b().a(gp6Var.s());
                n56.c().a(gp6Var.s());
                d28.p(gp6Var.a, this.a, gp6Var.i());
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
    public final void B(View view2, gp6 gp6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gp6Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(gp6Var.U());
                    n56.c().i("page_recommend", "clk_", gp6Var.U());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(gp6Var.R());
                        n56.c().i("page_recommend", "clk_", gp6Var.R());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(gp6Var.R());
                        n56.c().i("page_recommend", "clk_", gp6Var.R());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(gp6Var.f());
                        n56.c().i("page_recommend", "clk_", gp6Var.f());
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
                            d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || gp6Var == null || gp6Var.getThreadData() == null || gp6Var.getThreadData().getForumData() == null || StringUtils.isNull(gp6Var.getThreadData().getForumData().i())) {
                        i = i2;
                    }
                    if (i == 0) {
                        d28.d(gp6Var.a, this.a, gp6Var.i(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (hp6.P(gp6Var.a)) {
                    q = gp6Var.u();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                } else {
                    q = gp6Var.q();
                    TiebaStatic.log(q);
                }
                n56.c().i("page_recommend", "clk_", q);
                d28.c(gp6Var.a, gp6Var.k(), gp6Var.i(), 1);
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
            gp6.U = "c10730";
            gp6.V = "c10731";
            gp6.W = "c10704";
            gp6.X = "c10755";
            gp6.Y = "c10710";
            gp6.Z = "c10736";
            gp6.a0 = "c10737";
            gp6.b0 = "c10711";
            gp6.c0 = "c10758";
            gp6.d0 = "c10757";
            gp6.g0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.b.getPageActivity(), false);
            nz nzVar = new nz(this.b.getPageActivity());
            r15 r15Var = new r15();
            r15Var.b = 1;
            r15Var.h = 1;
            nzVar.B(r15Var);
            nzVar.D(1);
            nzVar.J("personalize_page");
            nzVar.I(3);
            nzVar.E(2);
            nzVar.f(32);
            nzVar.C(false);
            bVar.m(nzVar);
            lz k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
