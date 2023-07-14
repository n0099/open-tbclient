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
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o58 extends ln<kq6, ThreadCardViewHolder<kq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public s68 c;
    public String d;
    public eo e;
    public NEGFeedBackView.b f;
    public up6<kq6> g;

    /* loaded from: classes7.dex */
    public class a extends up6<kq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 b;

        public a(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kq6Var) == null) {
                np6.b().d(true);
                r66.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && kq6Var != null && kq6Var.getThreadData() != null && !StringUtils.isNull(kq6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !u48.b(wg.g(kq6Var.getThreadData().getTid(), 0L))) {
                        u48.a(wg.g(kq6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(wg.g(kq6Var.getThreadData().getTid(), 0L), kq6Var.v(), kq6Var.i(), kq6Var.h(), kq6Var.c(), wg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, kq6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, kq6Var);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public b(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof kq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                kq6 kq6Var = (kq6) ynVar;
                kq6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), kq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) kq6Var, view2.getContext(), 2, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ kq6 d;
        public final /* synthetic */ o58 e;

        public c(o58 o58Var, ViewGroup viewGroup, View view2, int i, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var, viewGroup, view2, Integer.valueOf(i), kq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o58Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = kq6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(by.a((eo) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem k = this.d.k(kq6.f0);
                        k.param("obj_type", this.d.getThreadData().getSmartApp().id);
                        k.param("obj_name", this.d.getThreadData().getSmartApp().name);
                        TiebaStatic.log(k);
                    }
                }
                CardLinkageManager.INSTANCE.cancelHighLight(this.e.e, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void D(s68 s68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s68Var) == null) {
            this.c = s68Var;
        }
    }

    public void E(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eoVar) == null) {
            this.e = eoVar;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kq6 kq6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kq6Var, threadCardViewHolder})) == null) {
            if (kq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && kq6Var.a != null) {
                kq6Var.B(kq6Var.position + 1);
                kq6Var.a.statFloor = kq6Var.h();
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.d);
                if (threadCardViewHolder.b().f() instanceof oz) {
                    ((oz) threadCardViewHolder.b().f()).J(new c(this, viewGroup, view2, i, kq6Var));
                }
                threadCardViewHolder.r(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.f(kq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.g);
                np6.b().a(kq6Var.r());
                r66.c().a(kq6Var.r());
                x68.p(kq6Var.a, this.a, kq6Var.h());
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
    public final void B(View view2, kq6 kq6Var) {
        StatisticItem p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kq6Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kq6Var.S());
                    r66.c().i("page_recommend", "clk_", kq6Var.S());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kq6Var.R());
                        r66.c().i("page_recommend", "clk_", kq6Var.R());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kq6Var.R());
                        r66.c().i("page_recommend", "clk_", kq6Var.R());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kq6Var.f());
                        r66.c().i("page_recommend", "clk_", kq6Var.f());
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
                            x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || kq6Var == null || kq6Var.getThreadData() == null || kq6Var.getThreadData().getForumData() == null || StringUtils.isNull(kq6Var.getThreadData().getForumData().i())) {
                        i = i2;
                    }
                    if (i == 0) {
                        x68.d(kq6Var.a, this.a, kq6Var.h(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (lq6.N(kq6Var.a)) {
                    p = kq6Var.t();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p));
                } else {
                    p = kq6Var.p();
                    TiebaStatic.log(p);
                }
                r66.c().i("page_recommend", "clk_", p);
                x68.c(kq6Var.a, kq6Var.i(), kq6Var.h(), 1);
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
            kq6.g0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            oz ozVar = new oz(this.b.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 1;
            z15Var.h = 1;
            ozVar.D(z15Var);
            ozVar.F(1);
            ozVar.M("personalize_page");
            ozVar.L(3);
            ozVar.G(2);
            ozVar.g(32);
            ozVar.E(false);
            bVar.m(ozVar);
            mz k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
