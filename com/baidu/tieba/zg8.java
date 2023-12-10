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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zg8 extends qa8<dn6, ThreadCardViewHolder<dn6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public boolean f;
    public mm6<dn6> g;

    /* loaded from: classes9.dex */
    public class a extends mm6<dn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zg8 b;

        public a(zg8 zg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, dn6 dn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dn6Var) == null) {
                int i = 1;
                em6.b().d(true);
                c26.c().h("page_recommend", "show_");
                if (view2 != null && dn6Var != null && dn6Var.getThreadData() != null && !StringUtils.isNull(dn6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(dn6Var.O());
                            c26.c().i("page_recommend", "clk_", dn6Var.O());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(dn6Var.N());
                                c26.c().i("page_recommend", "clk_", dn6Var.N());
                                ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(dn6Var.N());
                                c26.c().i("page_recommend", "clk_", dn6Var.N());
                                ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(dn6Var.f());
                                c26.c().i("page_recommend", "clk_", dn6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(dn6Var.J());
                                    c26.c().i("page_recommend", "clk_", dn6Var.J());
                                    ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 2);
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
                        TiebaStatic.log(dn6Var.L("c12642"));
                        c26.c().i("page_recommend", "clk_", dn6Var.q());
                        ii8.c(dn6Var.a, dn6Var.k(), dn6Var.h(), 1);
                    }
                    if (i != 0) {
                        ii8.d(dn6Var.a, this.b.b, dn6Var.h(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(zg8 zg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg8Var};
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
        public void a(fw4 fw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, fw4Var, view2) == null) && fw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    fw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    fw4Var.objType = 4;
                } else {
                    fw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zg8 a;

        public c(zg8 zg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zg8Var;
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
                ThreadCardUtils.jumpToPB((fw4) dn6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zg8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        x();
    }

    public void A(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f = z;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            dn6.f1090T = "c10705";
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
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public ThreadCardViewHolder<dn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.c.getPageActivity());
            rs rsVar = new rs(this.c.getPageActivity());
            rsVar.o(this.b);
            rsVar.c(1024);
            rsVar.x(new b(this));
            bVar.o(rsVar);
            hu huVar = new hu(this.c.getPageActivity());
            bVar.n(huVar);
            huVar.z(2);
            bVar.h(new gu(this.c.getPageActivity()));
            bVar.h(new zs(this.c.getPageActivity()));
            dt dtVar = new dt(this.c.getPageActivity());
            dtVar.C(this.f);
            dtVar.B("index");
            bVar.h(dtVar);
            eu euVar = new eu(this.c.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 1;
            lw4Var.h = 1;
            euVar.C(lw4Var);
            euVar.E(1);
            euVar.J(3);
            euVar.F(2);
            euVar.D(false);
            bVar.m(euVar);
            cu i = bVar.i();
            i.t(2);
            ThreadCardViewHolder<dn6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dn6 dn6Var, ThreadCardViewHolder<dn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dn6Var, threadCardViewHolder})) == null) {
            if (dn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && dn6Var.a != null) {
                dn6Var.B(dn6Var.position + 1);
                dn6Var.a.statFloor = dn6Var.h();
                em6.b().a(dn6Var.M("c12641"));
                c26.c().i("page_recommend", "show_", dn6Var.s());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.r(true).setNegEventCallback(this.d);
                threadCardViewHolder.n(dn6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(dn6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.g);
                ii8.p(dn6Var.a, this.b, dn6Var.h());
                ii8.o(dn6Var.a, dn6Var.k(), dn6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
