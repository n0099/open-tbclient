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
import com.baidu.tieba.bz;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.qy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x87 extends ln<o96, ThreadCardViewHolder<o96>> implements bs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public y97 c;
    public String d;
    public eo e;
    public NEGFeedBackView.b f;
    public z86<o96> g;

    /* loaded from: classes6.dex */
    public class a extends z86<o96> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x87 b;

        public a(x87 x87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z86
        /* renamed from: d */
        public void a(View view2, o96 o96Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o96Var) == null) {
                s86.b().d(true);
                zr5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && o96Var != null && o96Var.getThreadData() != null && !StringUtils.isNull(o96Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !c87.b(yg.g(o96Var.getThreadData().getTid(), 0L))) {
                        c87.a(yg.g(o96Var.getThreadData().getTid(), 0L));
                        this.b.c.e(yg.g(o96Var.getThreadData().getTid(), 0L), o96Var.z(), o96Var.o(), o96Var.m(), o96Var.c(), yg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, o96Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.z(view2, o96Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x87 a;

        public b(x87 x87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x87Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof o96) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o96 o96Var = (o96) ynVar;
                o96Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), o96Var);
                }
                ThreadCardUtils.jumpToPB((fs4) o96Var, view2.getContext(), 2, false, gx.a((eo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new bz.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ o96 d;
        public final /* synthetic */ x87 e;

        public c(x87 x87Var, ViewGroup viewGroup, View view2, int i, o96 o96Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x87Var, viewGroup, view2, Integer.valueOf(i), o96Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x87Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = o96Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(gx.a((eo) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem p = this.d.p(o96.d0);
                        p.param("obj_type", this.d.getThreadData().getSmartApp().id);
                        p.param("obj_name", this.d.getThreadData().getSmartApp().name);
                        TiebaStatic.log(p);
                    }
                }
                CardLinkageManager.INSTANCE.cancelHighLight(this.e.e, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x87(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        w();
    }

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void B(y97 y97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y97Var) == null) {
            this.c = y97Var;
        }
    }

    public void C(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eoVar) == null) {
            this.e = eoVar;
        }
    }

    @Override // com.baidu.tieba.bs5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o96.S = "c10730";
            o96.T = "c10731";
            o96.U = "c10704";
            o96.V = "c10755";
            o96.W = "c10710";
            o96.X = "c10736";
            o96.Y = "c10737";
            o96.Z = "c10711";
            o96.a0 = "c10758";
            o96.b0 = "c10757";
            o96.e0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            qy.b bVar = new qy.b(this.b.getPageActivity(), false);
            sy syVar = new sy(this.b.getPageActivity());
            ls4 ls4Var = new ls4();
            ls4Var.b = 1;
            ls4Var.h = 1;
            syVar.z(ls4Var);
            syVar.B(1);
            syVar.H("personalize_page");
            syVar.G(3);
            syVar.C(2);
            syVar.f(32);
            syVar.A(false);
            bVar.m(syVar);
            qy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o96 o96Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o96Var, threadCardViewHolder})) == null) {
            if (o96Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o96Var.a != null) {
                o96Var.I(o96Var.position + 1);
                o96Var.a.statFloor = o96Var.m();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                if (threadCardViewHolder.a().f() instanceof sy) {
                    ((sy) threadCardViewHolder.a().f()).F(new c(this, viewGroup, view2, i, o96Var));
                }
                threadCardViewHolder.p(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.e(o96Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                s86.b().a(o96Var.x());
                zr5.c().a(o96Var.x());
                da7.k(o96Var.a, this.a, o96Var.m());
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
    public final void z(View view2, o96 o96Var) {
        StatisticItem v;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, o96Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(o96Var.T());
                    zr5.c().i("page_recommend", "clk_", o96Var.T());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(o96Var.S());
                        zr5.c().i("page_recommend", "clk_", o96Var.S());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(o96Var.S());
                        zr5.c().i("page_recommend", "clk_", o96Var.S());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(o96Var.i());
                        zr5.c().i("page_recommend", "clk_", o96Var.i());
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
                            da7.c(o96Var.a, o96Var.o(), o96Var.m(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || o96Var == null || o96Var.getThreadData() == null || o96Var.getThreadData().getForumData() == null || StringUtils.isNull(o96Var.getThreadData().getForumData().f())) {
                        i = i2;
                    }
                    if (i == 0) {
                        da7.d(o96Var.a, this.a, o96Var.m(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (p96.R(o96Var.a)) {
                    v = o96Var.y();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(v));
                } else {
                    v = o96Var.v();
                    TiebaStatic.log(v);
                }
                zr5.c().i("page_recommend", "clk_", v);
                da7.c(o96Var.a, o96Var.o(), o96Var.m(), 1);
            }
            i2 = 1;
            if (id == R.id.thread_info_commont_container) {
            }
            i = i2;
            if (i == 0) {
            }
        }
    }
}
