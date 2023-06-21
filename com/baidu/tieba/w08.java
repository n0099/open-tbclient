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
import com.baidu.tieba.vz;
import com.baidu.tieba.yx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w08 extends yu7<bp6, ThreadCardViewHolder<bp6>> implements k56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public t18 d;
    public String e;
    public co f;
    public NEGFeedBackView.b g;
    public lo6<bp6> h;

    /* loaded from: classes8.dex */
    public class a extends lo6<bp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w08 b;

        public a(w08 w08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lo6
        /* renamed from: d */
        public void a(View view2, bp6 bp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bp6Var) == null) {
                eo6.b().d(true);
                i56.c().h("page_recommend", "show_");
                if (view2 != null && this.b.d != null && bp6Var != null && bp6Var.getThreadData() != null && !StringUtils.isNull(bp6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !wz7.b(ug.g(bp6Var.getThreadData().getTid(), 0L))) {
                        wz7.a(ug.g(bp6Var.getThreadData().getTid(), 0L));
                        this.b.d.e(ug.g(bp6Var.getThreadData().getTid(), 0L), bp6Var.w(), bp6Var.k(), bp6Var.i(), bp6Var.c(), ug.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, bp6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, bp6Var);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements yx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(w08 w08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w08Var};
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
    public class c implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w08 a;

        public c(w08 w08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w08Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof bp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                bp6 bp6Var = (bp6) wnVar;
                bp6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), bp6Var);
                }
                if (!z18.a(this.a.c, bp6Var)) {
                    ThreadCardUtils.jumpToPB((i15) bp6Var, view2.getContext(), 2, false, zx.a((co) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new vz.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void D(t18 t18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t18Var) == null) {
            this.d = t18Var;
        }
    }

    public void E(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, coVar) == null) {
            this.f = coVar;
        }
    }

    @Override // com.baidu.tieba.k56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.c.getPageActivity());
            yx yxVar = new yx(this.c.getPageActivity());
            yxVar.z(this.b);
            yxVar.g(1024);
            yxVar.y(new b(this));
            yxVar.B(this.c);
            bVar.o(yxVar);
            kz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new c(this));
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
                if (i == 0) {
                    rs9.a("main", true);
                }
                bp6Var.B(bp6Var.position + 1);
                bp6Var.a.statFloor = bp6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.e);
                threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.g);
                threadCardViewHolder.m(bp6Var.showFollowBtn(), this.a, true);
                threadCardViewHolder.e(bp6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                eo6.b().a(bp6Var.s());
                i56.c().a(bp6Var.s());
                y18.p(bp6Var.a, this.b, bp6Var.i());
                y18.o(bp6Var.a, bp6Var.k(), bp6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, bp6 bp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bp6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
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
                    i = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                        y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(bp6Var.M());
                            i56.c().i("page_recommend", "clk_", bp6Var.M());
                            y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 2);
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
                if (cp6.P(bp6Var.a)) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(bp6Var.u()));
                } else {
                    TiebaStatic.log(bp6Var.q());
                }
                i56.c().i("page_recommend", "clk_", bp6Var.q());
                y18.c(bp6Var.a, bp6Var.k(), bp6Var.i(), 1);
                i = 1;
            }
            if (i != 0) {
                y18.d(bp6Var.a, this.b, bp6Var.i(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
            bp6.g0 = "c10734";
            bp6.h0 = "c10708";
            bp6.i0 = "c10735";
        }
    }
}
