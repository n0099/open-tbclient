package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.kz;
import com.baidu.tieba.vz;
import com.baidu.tieba.yx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k08 extends yu7<bp6, ThreadCardViewHolder<bp6>> implements k56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public boolean f;
    public lo6<bp6> g;

    /* loaded from: classes6.dex */
    public class a extends lo6<bp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 b;

        public a(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lo6
        /* renamed from: d */
        public void a(View view2, bp6 bp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bp6Var) == null) {
                int i = 1;
                eo6.b().d(true);
                i56.c().h("page_recommend", "show_");
                if (bp6Var != null && bp6Var.getThreadData() != null && !vi.isEmpty(bp6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id == R.id.thread_card_root) {
                        TiebaStatic.log(bp6Var.q());
                        i56.c().i("page_recommend", "clk_", bp6Var.q());
                        y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 1);
                    } else if (id == R.id.thread_info_commont_container) {
                        TiebaStatic.log(bp6Var.q());
                        i56.c().i("page_recommend", "clk_", bp6Var.q());
                        y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 1);
                        i = 5;
                    } else {
                        if (id == R.id.thread_card_voice) {
                            TiebaStatic.log(bp6Var.U());
                            i56.c().i("page_recommend", "clk_", bp6Var.U());
                        } else {
                            if (id == R.id.user_avatar) {
                                TiebaStatic.log(bp6Var.R());
                                i56.c().i("page_recommend", "clk_", bp6Var.R());
                                y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 4);
                            } else if (id == R.id.user_name) {
                                TiebaStatic.log(bp6Var.R());
                                i56.c().i("page_recommend", "clk_", bp6Var.R());
                                y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 4);
                            } else if (id == R.id.forum_name_text) {
                                TiebaStatic.log(bp6Var.f());
                                i56.c().i("page_recommend", "clk_", bp6Var.f());
                            } else if (id == R.id.god_reply_voice_btn) {
                                StatisticItem statisticItem = new StatisticItem("c10760");
                                statisticItem.param("obj_locate", 4);
                                TiebaStatic.log(statisticItem);
                            } else if (id == R.id.god_reply_content) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 2);
                                TiebaStatic.log(statisticItem2);
                                y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 1);
                            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                                        statisticItem3.param("obj_locate", 3);
                                        TiebaStatic.log(statisticItem3);
                                    }
                                    TiebaStatic.log(bp6Var.M());
                                    i56.c().i("page_recommend", "clk_", bp6Var.M());
                                    y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 2);
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
                        y18.d(bp6Var.a, this.b.b, bp6Var.i(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yx.b
        public void a(i15 i15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, i15Var, view2) == null) && i15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    i15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    i15Var.objType = 4;
                } else {
                    i15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k08 a;

        public c(k08 k08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k08Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof bp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                bp6 bp6Var = (bp6) wnVar;
                bp6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), bp6Var);
                }
                ThreadCardUtils.jumpToPB((i15) bp6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.k56
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

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bp6.f1092T = "c10705";
            bp6.U = "c10730";
            bp6.V = "c10731";
            bp6.W = "c10704";
            bp6.X = "c10755";
            bp6.Y = "c10710";
            bp6.Z = "c10736";
            bp6.a0 = "c10737";
            bp6.b0 = "c10711";
            bp6.c0 = "c10758";
            bp6.d0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: x */
    public ThreadCardViewHolder<bp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.c.getPageActivity());
            yx yxVar = new yx(this.c.getPageActivity());
            yxVar.z(this.b);
            yxVar.g(1024);
            yxVar.y(new b(this));
            bVar.o(yxVar);
            bVar.n(new ty(this.c.getPageActivity()));
            bVar.h(new gy(this.c.getPageActivity()));
            ky kyVar = new ky(this.c.getPageActivity());
            kyVar.D(this.f);
            kyVar.C("index");
            kyVar.E(new StatisticItem("c13342"));
            bVar.h(kyVar);
            mz mzVar = new mz(this.c.getPageActivity());
            o15 o15Var = new o15();
            o15Var.b = 1;
            o15Var.h = 1;
            mzVar.B(o15Var);
            mzVar.D(1);
            mzVar.I(3);
            mzVar.E(2);
            mzVar.C(false);
            bVar.m(mzVar);
            kz i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<bp6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bp6 bp6Var, ThreadCardViewHolder<bp6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bp6Var, threadCardViewHolder})) == null) {
            if (bp6Var != null && threadCardViewHolder != null && threadCardViewHolder.a() != null) {
                bp6Var.B(bp6Var.position + 1);
                bp6Var.a.statFloor = bp6Var.i();
                eo6.b().a(bp6Var.L("c12190"));
                if (threadCardViewHolder.a() instanceof j56) {
                    threadCardViewHolder.a().b(this.e);
                }
                az p = threadCardViewHolder.p(true);
                p.s(this.d);
                threadCardViewHolder.l(bp6Var.showFollowBtn(), this.a);
                p.a(bp6Var.getNegFeedBackData());
                threadCardViewHolder.e(bp6Var);
                threadCardViewHolder.h(this.g);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                y18.p(bp6Var.a, this.b, bp6Var.i());
                y18.o(bp6Var.a, bp6Var.k(), bp6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
