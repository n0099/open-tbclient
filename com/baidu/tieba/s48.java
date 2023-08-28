package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.NegFeedBackDecorItem;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.cx;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class s48 extends yy7<zo6, ThreadCardViewHolder<zo6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public boolean f;
    public jo6<zo6> g;

    /* loaded from: classes7.dex */
    public class a extends jo6<zo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s48 b;

        public a(s48 s48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, zo6 zo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zo6Var) == null) {
                int i = 1;
                co6.b().d(true);
                q46.c().h("page_recommend", "show_");
                if (zo6Var != null && zo6Var.getThreadData() != null && !di.isEmpty(zo6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(zo6Var.q());
                        q46.c().i("page_recommend", "clk_", zo6Var.q());
                        m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(zo6Var.q());
                        q46.c().i("page_recommend", "clk_", zo6Var.q());
                        m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                        i = 5;
                    } else {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(zo6Var.O());
                            q46.c().i("page_recommend", "clk_", zo6Var.O());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(zo6Var.N());
                                q46.c().i("page_recommend", "clk_", zo6Var.N());
                                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(zo6Var.N());
                                q46.c().i("page_recommend", "clk_", zo6Var.N());
                                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(zo6Var.f());
                                q46.c().i("page_recommend", "clk_", zo6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(zo6Var.K());
                                    q46.c().i("page_recommend", "clk_", zo6Var.K());
                                    m68.c(zo6Var.a, zo6Var.i(), zo6Var.h(), 2);
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
                        m68.d(zo6Var.a, this.b.b, zo6Var.h(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements cx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(s48 s48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.cx.b
        public void a(w05 w05Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, w05Var, view2) == null) && w05Var != null) {
                if (view2.getId() == R.id.user_name) {
                    w05Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    w05Var.objType = 4;
                } else {
                    w05Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s48 a;

        public c(s48 s48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s48Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof zo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                zo6 zo6Var = (zo6) bnVar;
                zo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), zo6Var);
                }
                ThreadCardUtils.jumpToPB((w05) zo6Var, view2.getContext(), 2, false);
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s48(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = true;
        this.g = new a(this);
        this.c = tbPageContext;
        u();
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
        }
    }

    public void z(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zo6.f1193T = "c10705";
            zo6.U = "c10730";
            zo6.V = "c10731";
            zo6.W = "c10704";
            zo6.X = "c10755";
            zo6.Y = "c10710";
            zo6.Z = "c10736";
            zo6.a0 = "c10737";
            zo6.b0 = "c10711";
            zo6.c0 = "c10758";
            zo6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: x */
    public ThreadCardViewHolder<zo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity());
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.q(this.b);
            cxVar.g(1024);
            cxVar.z(new b(this));
            bVar.o(cxVar);
            bVar.n(new xx(this.c.getPageActivity()));
            bVar.h(new kx(this.c.getPageActivity()));
            ox oxVar = new ox(this.c.getPageActivity());
            oxVar.E(this.f);
            oxVar.D("index");
            oxVar.F(new StatisticItem("c13342"));
            bVar.h(oxVar);
            py pyVar = new py(this.c.getPageActivity());
            c15 c15Var = new c15();
            c15Var.b = 1;
            c15Var.h = 1;
            pyVar.C(c15Var);
            pyVar.E(1);
            pyVar.J(3);
            pyVar.F(2);
            pyVar.D(false);
            bVar.m(pyVar);
            ny i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<zo6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.j(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zo6 zo6Var, ThreadCardViewHolder<zo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zo6Var, threadCardViewHolder})) == null) {
            if (zo6Var != null && threadCardViewHolder != null && threadCardViewHolder.b() != null) {
                zo6Var.A(zo6Var.position + 1);
                zo6Var.a.statFloor = zo6Var.h();
                co6.b().a(zo6Var.I("c12190"));
                if (threadCardViewHolder.b() instanceof r46) {
                    threadCardViewHolder.b().b(this.e);
                }
                NegFeedBackDecorItem q = threadCardViewHolder.q(true);
                q.setNegEventCallback(this.d);
                threadCardViewHolder.m(zo6Var.showFollowBtn(), this.a);
                q.onBindDataToView(zo6Var.getNegFeedBackData());
                threadCardViewHolder.f(zo6Var);
                threadCardViewHolder.i(this.g);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                m68.p(zo6Var.a, this.b, zo6Var.h());
                m68.o(zo6Var.a, zo6Var.i(), zo6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
