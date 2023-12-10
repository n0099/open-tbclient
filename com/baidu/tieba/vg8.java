package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vg8 extends ci<dn6, ThreadCardViewHolder<dn6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public di8 c;
    public String d;
    public vi e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;
    public mm6<dn6> g;

    /* loaded from: classes8.dex */
    public class a extends mm6<dn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg8 b;

        public a(vg8 vg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, dn6 dn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dn6Var) == null) {
                em6.b().d(true);
                c26.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && dn6Var != null && dn6Var.getThreadData() != null && !StringUtils.isNull(dn6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !yf8.b(JavaTypesHelper.toLong(dn6Var.getThreadData().getTid(), 0L))) {
                        yf8.a(JavaTypesHelper.toLong(dn6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(dn6Var.getThreadData().getTid(), 0L), dn6Var.u(), dn6Var.k(), dn6Var.h(), dn6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, dn6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, dn6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg8 a;

        public b(vg8 vg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vg8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof dn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dn6 dn6Var = (dn6) piVar;
                dn6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), dn6Var);
                }
                ThreadCardUtils.jumpToPB((fw4) dn6Var, view2.getContext(), 2, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ dn6 d;
        public final /* synthetic */ vg8 e;

        public c(vg8 vg8Var, ViewGroup viewGroup, View view2, int i, dn6 dn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg8Var, viewGroup, view2, Integer.valueOf(i), dn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = vg8Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = dn6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.n
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(ss.a((vi) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem l = this.d.l(dn6.f0);
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
    public vg8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    public void D(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nEGFeedbackEventCallback) == null) {
            this.f = nEGFeedbackEventCallback;
        }
    }

    public void E(di8 di8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, di8Var) == null) {
            this.c = di8Var;
        }
    }

    public void F(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viVar) == null) {
            this.e = viVar;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            eu euVar = new eu(this.b.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 1;
            lw4Var.h = 1;
            euVar.C(lw4Var);
            euVar.E(1);
            euVar.K("personalize_page");
            euVar.J(3);
            euVar.F(2);
            euVar.b(32);
            euVar.D(false);
            bVar.m(euVar);
            cu k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dn6 dn6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dn6Var, threadCardViewHolder})) == null) {
            if (dn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && dn6Var.a != null) {
                dn6Var.B(dn6Var.position + 1);
                dn6Var.a.statFloor = dn6Var.h();
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.d);
                if (threadCardViewHolder.a().f() instanceof eu) {
                    ((eu) threadCardViewHolder.a().f()).I(new c(this, viewGroup, view2, i, dn6Var));
                }
                threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.e(dn6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                em6.b().a(dn6Var.s());
                c26.c().a(dn6Var.s());
                ii8.p(dn6Var.a, this.a, dn6Var.h());
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
    public final void C(View view2, dn6 dn6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, dn6Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(dn6Var.O());
                    c26.c().i("page_recommend", "clk_", dn6Var.O());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(dn6Var.N());
                        c26.c().i("page_recommend", "clk_", dn6Var.N());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(dn6Var.N());
                        c26.c().i("page_recommend", "clk_", dn6Var.N());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(dn6Var.f());
                        c26.c().i("page_recommend", "clk_", dn6Var.f());
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
                            ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || dn6Var == null || dn6Var.getThreadData() == null || dn6Var.getThreadData().getForumData() == null || StringUtils.isNull(dn6Var.getThreadData().getForumData().i())) {
                        i = i2;
                    }
                    if (i == 0) {
                        ii8.d(dn6Var.a, this.a, dn6Var.h(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (en6.L(dn6Var.a)) {
                    q = dn6Var.t();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                } else {
                    q = dn6Var.q();
                    TiebaStatic.log(q);
                }
                c26.c().i("page_recommend", "clk_", q);
                ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 1);
            }
            i2 = 1;
            if (id == R.id.thread_info_commont_container) {
            }
            i = i2;
            if (i == 0) {
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            dn6.U = "c10730";
            dn6.V = "c10731";
            dn6.W = "c10704";
            dn6.X = "c10755";
            dn6.Y = "c10710";
            dn6.Z = "c10736";
            dn6.a0 = "c10737";
            dn6.b0 = "c10711";
            dn6.c0 = "c10758";
            dn6.d0 = "c10757";
            dn6.g0 = "c10734";
        }
    }
}
