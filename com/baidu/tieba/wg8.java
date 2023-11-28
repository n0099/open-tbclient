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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wg8 extends la8<zm6, ThreadCardViewHolder<zm6>> implements a26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public yh8 d;
    public String e;
    public vi f;
    public NEGFeedBackView.NEGFeedbackEventCallback g;
    public im6<zm6> h;

    /* loaded from: classes8.dex */
    public class a extends im6<zm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg8 b;

        public a(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im6
        /* renamed from: d */
        public void a(View view2, zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zm6Var) == null) {
                am6.b().d(true);
                y16.c().h("page_recommend", "show_");
                if (view2 != null && this.b.d != null && zm6Var != null && zm6Var.getThreadData() != null && !StringUtils.isNull(zm6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !tf8.b(JavaTypesHelper.toLong(zm6Var.getThreadData().getTid(), 0L))) {
                        tf8.a(JavaTypesHelper.toLong(zm6Var.getThreadData().getTid(), 0L));
                        this.b.d.e(JavaTypesHelper.toLong(zm6Var.getThreadData().getTid(), 0L), zm6Var.u(), zm6Var.k(), zm6Var.h(), zm6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, zm6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.D(view2, zm6Var);
                    nua.t(CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK, zm6Var.getThreadData(), 4);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rs.b
        public void a(cw4 cw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, cw4Var, view2) == null) && cw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    cw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    cw4Var.objType = 4;
                } else {
                    cw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg8 a;

        public c(wg8 wg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof zm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zm6 zm6Var = (zm6) piVar;
                zm6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), zm6Var);
                }
                if (!o36.a(view2.getContext(), zm6Var.getThreadData()) && !fi8.b(this.a.c, zm6Var)) {
                    ThreadCardUtils.jumpToPB((cw4) zm6Var, view2.getContext(), 2, false, ss.a((vi) viewGroup, view2, i));
                    threadCardViewHolder.a().q(new nu.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        A();
    }

    public void E(yh8 yh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yh8Var) == null) {
            this.d = yh8Var;
        }
    }

    public void F(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viVar) == null) {
            this.f = viVar;
        }
    }

    @Override // com.baidu.tieba.a26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zm6.U = "c10730";
            zm6.V = "c10731";
            zm6.W = "c10704";
            zm6.X = "c10755";
            zm6.Y = "c10710";
            zm6.Z = "c10736";
            zm6.a0 = "c10737";
            zm6.b0 = "c10711";
            zm6.c0 = "c10758";
            zm6.d0 = "c10757";
            zm6.g0 = "c10734";
            zm6.h0 = "c10708";
            zm6.i0 = "c10735";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: B */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.c.getPageActivity());
            rs rsVar = new rs(this.c.getPageActivity());
            rsVar.o(this.b);
            rsVar.c(1024);
            rsVar.x(new b(this));
            rsVar.A(this.c);
            rsVar.y(1);
            bVar.o(rsVar);
            cu k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.t(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zm6 zm6Var, ThreadCardViewHolder<zm6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zm6Var, threadCardViewHolder})) == null) {
            if (zm6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && zm6Var.a != null) {
                if (i == 0) {
                    soa.a("main", true);
                }
                bp5.a.h(this.b);
                zm6Var.B(zm6Var.position + 1);
                zm6Var.a.statFloor = zm6Var.h();
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP, this.g);
                threadCardViewHolder.o(zm6Var.showFollowBtn(), this.a, true);
                threadCardViewHolder.e(zm6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.h);
                am6.b().a(zm6Var.s());
                y16.c().a(zm6Var.s());
                di8.p(zm6Var.a, this.b, zm6Var.h());
                di8.o(zm6Var.a, zm6Var.k(), zm6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void D(View view2, zm6 zm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, zm6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(zm6Var.N());
                    y16.c().i("page_recommend", "clk_", zm6Var.N());
                    di8.c(zm6Var.a, zm6Var.k(), zm6Var.h(), 4);
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(zm6Var.N());
                    y16.c().i("page_recommend", "clk_", zm6Var.N());
                    di8.c(zm6Var.a, zm6Var.k(), zm6Var.h(), 4);
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(zm6Var.f());
                    y16.c().i("page_recommend", "clk_", zm6Var.f());
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        di8.c(zm6Var.a, zm6Var.k(), zm6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(zm6Var.J());
                            y16.c().i("page_recommend", "clk_", zm6Var.J());
                            di8.c(zm6Var.a, zm6Var.k(), zm6Var.h(), 2);
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
                if (an6.L(zm6Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(zm6Var.t()));
                } else {
                    TiebaStatic.log(zm6Var.q());
                }
                y16.c().i("page_recommend", "clk_", zm6Var.q());
                di8.c(zm6Var.a, zm6Var.k(), zm6Var.h(), 1);
                i = 1;
            }
            if (i != 0) {
                di8.d(zm6Var.a, this.b, zm6Var.h(), i);
            }
        }
    }
}
