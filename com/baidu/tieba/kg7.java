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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kz;
import com.baidu.tieba.ox;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kg7 extends pa7<mg6, ThreadCardViewHolder<mg6>> implements dy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public fh7 d;
    public String e;
    public jo f;
    public NEGFeedBackView.b g;
    public xf6<mg6> h;

    /* loaded from: classes5.dex */
    public class a extends xf6<mg6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 b;

        public a(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xf6
        /* renamed from: d */
        public void a(View view2, mg6 mg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mg6Var) == null) {
                qf6.b().d(true);
                by5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.d != null && mg6Var != null && mg6Var.getThreadData() != null && !StringUtils.isNull(mg6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !jf7.b(dh.g(mg6Var.getThreadData().getTid(), 0L))) {
                        jf7.a(dh.g(mg6Var.getThreadData().getTid(), 0L));
                        this.b.d.e(dh.g(mg6Var.getThreadData().getTid(), 0L), mg6Var.x(), mg6Var.n(), mg6Var.l(), mg6Var.c(), dh.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, mg6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, mg6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ox.b
        public void a(zx4 zx4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, zx4Var, view2) == null) && zx4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    zx4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    zx4Var.objType = 4;
                } else {
                    zx4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        public c(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof mg6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                mg6 mg6Var = (mg6) cdo;
                mg6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), mg6Var);
                }
                if (!lh7.a(this.a.c, mg6Var)) {
                    ThreadCardUtils.jumpToPB((zx4) mg6Var, view2.getContext(), 2, false, px.a((jo) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new kz.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kg7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        x();
    }

    public void B(fh7 fh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh7Var) == null) {
            this.d = fh7Var;
        }
    }

    public void C(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, joVar) == null) {
            this.f = joVar;
        }
    }

    @Override // com.baidu.tieba.dy5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.e = str;
        }
    }

    public final void A(View view2, mg6 mg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, mg6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(mg6Var.S());
                    by5.c().i("page_recommend", "clk_", mg6Var.S());
                    kh7.c(mg6Var.a, mg6Var.n(), mg6Var.l(), 4);
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(mg6Var.S());
                    by5.c().i("page_recommend", "clk_", mg6Var.S());
                    kh7.c(mg6Var.a, mg6Var.n(), mg6Var.l(), 4);
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(mg6Var.h());
                    by5.c().i("page_recommend", "clk_", mg6Var.h());
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        kh7.c(mg6Var.a, mg6Var.n(), mg6Var.l(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(mg6Var.P());
                            by5.c().i("page_recommend", "clk_", mg6Var.P());
                            kh7.c(mg6Var.a, mg6Var.n(), mg6Var.l(), 2);
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
                if (ng6.R(mg6Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(mg6Var.v()));
                } else {
                    TiebaStatic.log(mg6Var.t());
                }
                by5.c().i("page_recommend", "clk_", mg6Var.t());
                kh7.c(mg6Var.a, mg6Var.n(), mg6Var.l(), 1);
                i = 1;
            }
            if (i != 0) {
                kh7.d(mg6Var.a, this.b, mg6Var.l(), i);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            mg6.S = "c10730";
            mg6.T = "c10731";
            mg6.U = "c10704";
            mg6.V = "c10755";
            mg6.W = "c10710";
            mg6.X = "c10736";
            mg6.Y = "c10737";
            mg6.Z = "c10711";
            mg6.a0 = "c10758";
            mg6.b0 = "c10757";
            mg6.e0 = "c10734";
            mg6.f0 = "c10708";
            mg6.g0 = "c10735";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            zy.b bVar = new zy.b(this.c.getPageActivity());
            ox oxVar = new ox(this.c.getPageActivity());
            oxVar.x(this.b);
            oxVar.g(1024);
            oxVar.w(new b(this));
            oxVar.z(this.c);
            bVar.o(oxVar);
            zy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mg6 mg6Var, ThreadCardViewHolder<mg6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mg6Var, threadCardViewHolder})) == null) {
            if (mg6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && mg6Var.a != null) {
                mg6Var.F(mg6Var.position + 1);
                mg6Var.a.statFloor = mg6Var.l();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.g);
                threadCardViewHolder.l(mg6Var.showFollowBtn(), this.a, true);
                threadCardViewHolder.e(mg6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                qf6.b().a(mg6Var.u());
                by5.c().a(mg6Var.u());
                kh7.k(mg6Var.a, this.b, mg6Var.l());
                kh7.j(mg6Var.a, mg6Var.n(), mg6Var.l());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
