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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ky;
import com.baidu.tieba.vy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k38 extends dx7<sn6, ThreadCardViewHolder<sn6>> implements b46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public m48 d;
    public String e;
    public en f;
    public NEGFeedBackView.NEGFeedbackEventCallback g;
    public cn6<sn6> h;

    /* loaded from: classes6.dex */
    public class a extends cn6<sn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k38 b;

        public a(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cn6
        /* renamed from: d */
        public void a(View view2, sn6 sn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sn6Var) == null) {
                vm6.b().d(true);
                z36.c().h("page_recommend", "show_");
                if (view2 != null && this.b.d != null && sn6Var != null && sn6Var.getThreadData() != null && !StringUtils.isNull(sn6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !i28.b(JavaTypesHelper.toLong(sn6Var.getThreadData().getTid(), 0L))) {
                        i28.a(JavaTypesHelper.toLong(sn6Var.getThreadData().getTid(), 0L));
                        this.b.d.e(JavaTypesHelper.toLong(sn6Var.getThreadData().getTid(), 0L), sn6Var.u(), sn6Var.i(), sn6Var.h(), sn6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, sn6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, sn6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zw.b
        public void a(q05 q05Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, q05Var, view2) == null) && q05Var != null) {
                if (view2.getId() == R.id.user_name) {
                    q05Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    q05Var.objType = 4;
                } else {
                    q05Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k38 a;

        public c(k38 k38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k38Var;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ymVar instanceof sn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sn6 sn6Var = (sn6) ymVar;
                sn6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), sn6Var);
                }
                if (!s48.a(this.a.c, sn6Var)) {
                    ThreadCardUtils.jumpToPB((q05) sn6Var, view2.getContext(), 2, false, ax.a((en) viewGroup, view2, i));
                    threadCardViewHolder.b().p(new vy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k38(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.h = new a(this);
        this.c = tbPageContext;
        z();
    }

    public void D(m48 m48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, m48Var) == null) {
            this.d = m48Var;
        }
    }

    public void E(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, enVar) == null) {
            this.f = enVar;
        }
    }

    @Override // com.baidu.tieba.b46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ky.b bVar = new ky.b(this.c.getPageActivity());
            zw zwVar = new zw(this.c.getPageActivity());
            zwVar.q(this.b);
            zwVar.g(1024);
            zwVar.z(new b(this));
            zwVar.B(this.c);
            bVar.o(zwVar);
            ky k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sn6 sn6Var, ThreadCardViewHolder<sn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sn6Var, threadCardViewHolder})) == null) {
            if (sn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && sn6Var.a != null) {
                if (i == 0) {
                    z3a.a("main", true);
                }
                sn6Var.A(sn6Var.position + 1);
                sn6Var.a.statFloor = sn6Var.h();
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.e);
                threadCardViewHolder.r(true, Align.ALIGN_RIGHT_TOP, this.g);
                threadCardViewHolder.n(sn6Var.showFollowBtn(), this.a, true);
                threadCardViewHolder.f(sn6Var);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                vm6.b().a(sn6Var.r());
                z36.c().a(sn6Var.r());
                r48.p(sn6Var.a, this.b, sn6Var.h());
                r48.o(sn6Var.a, sn6Var.i(), sn6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, sn6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(sn6Var.N());
                    z36.c().i("page_recommend", "clk_", sn6Var.N());
                    r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 4);
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(sn6Var.N());
                    z36.c().i("page_recommend", "clk_", sn6Var.N());
                    r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 4);
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(sn6Var.f());
                    z36.c().i("page_recommend", "clk_", sn6Var.f());
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(sn6Var.K());
                            z36.c().i("page_recommend", "clk_", sn6Var.K());
                            r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 2);
                        } else {
                            i = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i = 5;
                }
                i = 2;
            } else {
                if (tn6.L(sn6Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(sn6Var.t()));
                } else {
                    TiebaStatic.log(sn6Var.q());
                }
                z36.c().i("page_recommend", "clk_", sn6Var.q());
                r48.c(sn6Var.a, sn6Var.i(), sn6Var.h(), 1);
                i = 1;
            }
            if (i != 0) {
                r48.d(sn6Var.a, this.b, sn6Var.h(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sn6.U = "c10730";
            sn6.V = "c10731";
            sn6.W = "c10704";
            sn6.X = "c10755";
            sn6.Y = "c10710";
            sn6.Z = "c10736";
            sn6.a0 = "c10737";
            sn6.b0 = "c10711";
            sn6.c0 = "c10758";
            sn6.d0 = "c10757";
            sn6.g0 = "c10734";
            sn6.h0 = "c10708";
            sn6.i0 = "c10735";
        }
    }
}
