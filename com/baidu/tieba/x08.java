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
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x08 extends lh<rk6, ThreadCardViewHolder<rk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public f28 c;
    public String d;
    public ei e;
    public NEGFeedBackView.NEGFeedbackEventCallback f;
    public bk6<rk6> g;

    /* loaded from: classes8.dex */
    public class a extends bk6<rk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x08 b;

        public a(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, rk6 rk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rk6Var) == null) {
                tj6.b().d(true);
                wz5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && rk6Var != null && rk6Var.getThreadData() != null && !StringUtils.isNull(rk6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !b08.b(JavaTypesHelper.toLong(rk6Var.getThreadData().getTid(), 0L))) {
                        b08.a(JavaTypesHelper.toLong(rk6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(rk6Var.getThreadData().getTid(), 0L), rk6Var.u(), rk6Var.i(), rk6Var.h(), rk6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, rk6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, rk6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x08 a;

        public b(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x08Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof rk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                rk6 rk6Var = (rk6) yhVar;
                rk6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), rk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) rk6Var, view2.getContext(), 2, false, as.a((ei) viewGroup, view2, i));
                threadCardViewHolder.a().q(new vt.a(1));
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
        public final /* synthetic */ rk6 d;
        public final /* synthetic */ x08 e;

        public c(x08 x08Var, ViewGroup viewGroup, View view2, int i, rk6 rk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var, viewGroup, view2, Integer.valueOf(i), rk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x08Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = rk6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(as.a((ei) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem l = this.d.l(rk6.f0);
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
    public x08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void C(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nEGFeedbackEventCallback) == null) {
            this.f = nEGFeedbackEventCallback;
        }
    }

    public void D(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f28Var) == null) {
            this.c = f28Var;
        }
    }

    public void E(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eiVar) == null) {
            this.e = eiVar;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rk6 rk6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rk6Var, threadCardViewHolder})) == null) {
            if (rk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && rk6Var.a != null) {
                rk6Var.A(rk6Var.position + 1);
                rk6Var.a.statFloor = rk6Var.h();
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.d);
                if (threadCardViewHolder.a().f() instanceof mt) {
                    ((mt) threadCardViewHolder.a().f()).K(new c(this, viewGroup, view2, i, rk6Var));
                }
                threadCardViewHolder.r(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.e(rk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                tj6.b().a(rk6Var.r());
                wz5.c().a(rk6Var.r());
                k28.p(rk6Var.a, this.a, rk6Var.h());
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
    public final void B(View view2, rk6 rk6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, rk6Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(rk6Var.O());
                    wz5.c().i("page_recommend", "clk_", rk6Var.O());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(rk6Var.N());
                        wz5.c().i("page_recommend", "clk_", rk6Var.N());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(rk6Var.N());
                        wz5.c().i("page_recommend", "clk_", rk6Var.N());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(rk6Var.f());
                        wz5.c().i("page_recommend", "clk_", rk6Var.f());
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
                            k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || rk6Var == null || rk6Var.getThreadData() == null || rk6Var.getThreadData().getForumData() == null || StringUtils.isNull(rk6Var.getThreadData().getForumData().i())) {
                        i = i2;
                    }
                    if (i == 0) {
                        k28.d(rk6Var.a, this.a, rk6Var.h(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (sk6.L(rk6Var.a)) {
                    q = rk6Var.t();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                } else {
                    q = rk6Var.q();
                    TiebaStatic.log(q);
                }
                wz5.c().i("page_recommend", "clk_", q);
                k28.c(rk6Var.a, rk6Var.i(), rk6Var.h(), 1);
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
            rk6.U = "c10730";
            rk6.V = "c10731";
            rk6.W = "c10704";
            rk6.X = "c10755";
            rk6.Y = "c10710";
            rk6.Z = "c10736";
            rk6.a0 = "c10737";
            rk6.b0 = "c10711";
            rk6.c0 = "c10758";
            rk6.d0 = "c10757";
            rk6.g0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            mt mtVar = new mt(this.b.getPageActivity());
            pv4 pv4Var = new pv4();
            pv4Var.b = 1;
            pv4Var.h = 1;
            mtVar.E(pv4Var);
            mtVar.G(1);
            mtVar.M("personalize_page");
            mtVar.L(3);
            mtVar.H(2);
            mtVar.e(32);
            mtVar.F(false);
            bVar.m(mtVar);
            kt k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
