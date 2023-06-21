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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kz;
import com.baidu.tieba.vx;
import com.baidu.tieba.vz;
import com.baidu.tieba.yx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v08 extends yu7<bp6, ThreadCardViewHolder<bp6>> implements k56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.b d;
    public String e;
    public co f;
    public lo6<bp6> g;

    /* loaded from: classes8.dex */
    public class a extends lo6<bp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v08 b;

        public a(v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v08Var;
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
                if (view2 != null && bp6Var != null && bp6Var.getThreadData() != null && !StringUtils.isNull(bp6Var.getThreadData().getTid())) {
                    int id = view2.getId();
                    if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
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
                    } else {
                        TiebaStatic.log(bp6Var.P("c12642"));
                        i56.c().i("page_recommend", "clk_", bp6Var.q());
                        y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 1);
                    }
                    if (i != 0) {
                        y18.d(bp6Var.a, this.b.b, bp6Var.i(), i);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements yx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var};
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

    /* loaded from: classes8.dex */
    public class c implements vx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ v08 b;

        public c(v08 v08Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v08Var;
            this.a = rzVar;
        }

        @Override // com.baidu.tieba.vx.a
        public void a(i15 i15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, i15Var) == null) && i15Var != null && i15Var.getThreadData() != null && i15Var.getThreadData().originalThreadData != null) {
                xw5.b(1, this.b.mContext, i15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements vx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ v08 b;

        public d(v08 v08Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v08Var;
            this.a = rzVar;
        }

        @Override // com.baidu.tieba.vx.a
        public void a(i15 i15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, i15Var) == null) && i15Var != null && i15Var.getThreadData() != null && i15Var.getThreadData().originalThreadData != null) {
                xw5.b(1, this.b.mContext, i15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "personalize_page", null, "index", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a00 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ v08 b;

        public e(v08 v08Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v08Var;
            this.a = rzVar;
        }

        @Override // com.baidu.tieba.a00
        public void a(i15 i15Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, i15Var) == null) && i15Var != null && i15Var.getThreadData() != null && i15Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (i15Var.getThreadData().originalThreadData.r != null) {
                    if (i15Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                xw5.a(1, z, this.b.mContext, i15Var.getThreadData(), 0, this.a.A(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v08 a;

        public f(v08 v08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v08Var;
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
    public v08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    public void C(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.d = bVar;
        }
    }

    @Override // com.baidu.tieba.k56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: A */
    public ThreadCardViewHolder<bp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.c.getPageActivity());
            rz rzVar = new rz(this.c.getPageActivity());
            yx yxVar = new yx(this.c.getPageActivity());
            yxVar.z(this.b);
            yxVar.g(1024);
            yxVar.y(new b(this));
            bVar.o(yxVar);
            fz fzVar = new fz(this.c);
            fzVar.r(Boolean.FALSE);
            fzVar.setFrom("index");
            bVar.n(fzVar);
            fz fzVar2 = new fz(this.c);
            fzVar2.r(Boolean.TRUE);
            fzVar2.setFrom("index");
            fzVar2.D(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            fzVar2.B(new c(this, rzVar));
            bVar.h(fzVar2);
            rzVar.r(Boolean.TRUE);
            rzVar.setFrom("index");
            rzVar.C(new d(this, rzVar));
            rzVar.D(new e(this, rzVar));
            bVar.h(rzVar);
            bVar.h(new oz(this.c.getPageActivity()));
            bVar.h(new gy(this.c.getPageActivity()));
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
            kz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder<bp6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bp6 bp6Var, ThreadCardViewHolder<bp6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bp6Var, threadCardViewHolder})) == null) {
            if (bp6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && bp6Var.a != null) {
                bp6Var.B(bp6Var.position + 1);
                bp6Var.a.statFloor = bp6Var.i();
                threadCardViewHolder.a().r(i);
                eo6.b().a(bp6Var.Q("c12641"));
                i56.c().i("page_recommend", "show_", bp6Var.s());
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.p(true).s(this.d);
                threadCardViewHolder.l(bp6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(bp6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                y18.p(bp6Var.a, this.b, bp6Var.i());
                y18.o(bp6Var.a, bp6Var.k(), bp6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
}
