package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.tieba.ns;
import com.baidu.tieba.qs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xd8 extends q78<nm6, ThreadCardViewHolder<nm6>> implements s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public ui f;
    public xl6<nm6> g;

    /* loaded from: classes9.dex */
    public class a extends xl6<nm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd8 b;

        public a(xd8 xd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xl6
        /* renamed from: d */
        public void a(View view2, nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nm6Var) == null) {
                int i = 1;
                pl6.b().d(true);
                q16.c().h("page_recommend", "show_");
                if (view2 != null && nm6Var != null && nm6Var.getThreadData() != null && !StringUtils.isNull(nm6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(nm6Var.O());
                            q16.c().i("page_recommend", "clk_", nm6Var.O());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(nm6Var.N());
                                q16.c().i("page_recommend", "clk_", nm6Var.N());
                                ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(nm6Var.N());
                                q16.c().i("page_recommend", "clk_", nm6Var.N());
                                ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(nm6Var.f());
                                q16.c().i("page_recommend", "clk_", nm6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(nm6Var.J());
                                    q16.c().i("page_recommend", "clk_", nm6Var.J());
                                    ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 2);
                                }
                            } else {
                                StatisticItem statisticItem4 = new StatisticItem("c10760");
                                statisticItem4.param("obj_locate", 1);
                                TiebaStatic.log(statisticItem4);
                            }
                            i = 2;
                        }
                        i = 0;
                    } else {
                        TiebaStatic.log(nm6Var.L("c12642"));
                        q16.c().i("page_recommend", "clk_", nm6Var.q());
                        ff8.c(nm6Var.a, nm6Var.i(), nm6Var.h(), 1);
                    }
                    if (i != 0) {
                        ff8.d(nm6Var.a, this.b.b, nm6Var.h(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements qs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xd8 xd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.qs.b
        public void a(bw4 bw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, bw4Var, view2) == null) && bw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    bw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    bw4Var.objType = 4;
                } else {
                    bw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu a;
        public final /* synthetic */ xd8 b;

        public c(xd8 xd8Var, iu iuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd8Var, iuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xd8Var;
            this.a = iuVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().originalThreadData != null) {
                lt5.b(1, this.b.mContext, bw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu a;
        public final /* synthetic */ xd8 b;

        public d(xd8 xd8Var, iu iuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd8Var, iuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xd8Var;
            this.a = iuVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().originalThreadData != null) {
                lt5.b(1, this.b.mContext, bw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements ru {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu a;
        public final /* synthetic */ xd8 b;

        public e(xd8 xd8Var, iu iuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd8Var, iuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xd8Var;
            this.a = iuVar;
        }

        @Override // com.baidu.tieba.ru
        public void a(bw4 bw4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null && bw4Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (bw4Var.getThreadData().originalThreadData.r != null) {
                    if (bw4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                lt5.a(1, z, this.b.mContext, bw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd8 a;

        public f(xd8 xd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd8Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof nm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                nm6 nm6Var = (nm6) oiVar;
                nm6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), nm6Var);
                }
                ThreadCardUtils.jumpToPB((bw4) nm6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.c = tbPageContext;
        A();
    }

    public void D(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    @Override // com.baidu.tieba.s16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.e = str;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nm6.f1138T = "c10705";
            nm6.U = "c10730";
            nm6.V = "c10731";
            nm6.W = "c10704";
            nm6.X = "c10755";
            nm6.Y = "c10710";
            nm6.Z = "c10736";
            nm6.a0 = "c10737";
            nm6.b0 = "c10711";
            nm6.c0 = "c10758";
            nm6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: B */
    public ThreadCardViewHolder<nm6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.c.getPageActivity());
            iu iuVar = new iu(this.c.getPageActivity());
            qs qsVar = new qs(this.c.getPageActivity());
            qsVar.o(this.b);
            qsVar.c(1024);
            qsVar.x(new b(this));
            bVar.o(qsVar);
            wt wtVar = new wt(this.c);
            wtVar.q(Boolean.FALSE);
            wtVar.setFrom("index");
            bVar.n(wtVar);
            wt wtVar2 = new wt(this.c);
            wtVar2.q(Boolean.TRUE);
            wtVar2.setFrom("index");
            wtVar2.C(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            wtVar2.A(new c(this, iuVar));
            bVar.h(wtVar2);
            iuVar.q(Boolean.TRUE);
            iuVar.setFrom("index");
            iuVar.B(new d(this, iuVar));
            iuVar.C(new e(this, iuVar));
            bVar.h(iuVar);
            bVar.h(new fu(this.c.getPageActivity()));
            bVar.h(new ys(this.c.getPageActivity()));
            du duVar = new du(this.c.getPageActivity());
            hw4 hw4Var = new hw4();
            hw4Var.b = 1;
            hw4Var.h = 1;
            duVar.C(hw4Var);
            duVar.E(1);
            duVar.J(3);
            duVar.F(2);
            duVar.D(false);
            bVar.m(duVar);
            bu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.t(2);
            ThreadCardViewHolder<nm6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nm6 nm6Var, ThreadCardViewHolder<nm6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nm6Var, threadCardViewHolder})) == null) {
            if (nm6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && nm6Var.a != null) {
                nm6Var.A(nm6Var.position + 1);
                nm6Var.a.statFloor = nm6Var.h();
                threadCardViewHolder.a().s(i);
                pl6.b().a(nm6Var.M("c12641"));
                q16.c().i("page_recommend", "show_", nm6Var.s());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.r(true).setNegEventCallback(this.d);
                threadCardViewHolder.n(nm6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(nm6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                ff8.p(nm6Var.a, this.b, nm6Var.h());
                ff8.o(nm6Var.a, nm6Var.i(), nm6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
