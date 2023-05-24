package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.az;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iu7 extends en<lk6, ThreadCardViewHolder<lk6>> implements c16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public sv7 c;
    public String d;
    public boolean e;
    public xn f;
    public wj6<lk6> g;

    /* loaded from: classes6.dex */
    public class a extends wj6<lk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu7 b;

        public a(iu7 iu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wj6
        /* renamed from: d */
        public void a(View view2, lk6 lk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lk6Var) == null) {
                pj6.b().d(true);
                a16.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && lk6Var != null && lk6Var.getThreadData() != null && !StringUtils.isNull(lk6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !wt7.b(pg.g(lk6Var.getThreadData().getTid(), 0L))) {
                        wt7.a(pg.g(lk6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(pg.g(lk6Var.getThreadData().getTid(), 0L), lk6Var.w(), lk6Var.k(), lk6Var.i(), lk6Var.c(), pg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, lk6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, lk6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements bo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu7 a;

        public b(iu7 iu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu7Var;
        }

        @Override // com.baidu.tieba.bo
        public void b(View view2, rn rnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, rnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (rnVar instanceof lk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                lk6 lk6Var = (lk6) rnVar;
                lk6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), lk6Var);
                }
                ThreadCardUtils.jumpToPB((jy4) lk6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new az.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = true;
        this.g = new a(this);
        this.b = tbPageContext;
        x();
    }

    public void B(sv7 sv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv7Var) == null) {
            this.c = sv7Var;
        }
    }

    public void C(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xnVar) == null) {
            this.f = xnVar;
        }
    }

    @Override // com.baidu.tieba.c16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A(View view2, lk6 lk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, lk6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.god_reply_voice_btn) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem);
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        i = 5;
                        xv7.c(lk6Var.a, lk6Var.k(), lk6Var.i(), 1);
                    } else {
                        if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(lk6Var.L());
                                a16.c().i("page_recommend", "clk_", lk6Var.L());
                                xv7.c(lk6Var.a, lk6Var.k(), lk6Var.i(), 2);
                            }
                        } else {
                            StatisticItem statisticItem4 = new StatisticItem("c10760");
                            statisticItem4.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem4);
                        }
                        i = 0;
                    }
                    if (i != 0) {
                        xv7.d(lk6Var.a, this.a, lk6Var.i(), i);
                    }
                    xv7.e("c15196", lk6Var.getThreadData(), lk6Var.i());
                }
            } else {
                TiebaStatic.log(lk6Var.q());
                a16.c().i("page_recommend", "clk_", lk6Var.q());
                xv7.c(lk6Var.a, lk6Var.k(), lk6Var.i(), 1);
            }
            i = 1;
            if (i != 0) {
            }
            xv7.e("c15196", lk6Var.getThreadData(), lk6Var.i());
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            lk6.S = "c10705";
            lk6.T = "c10730";
            lk6.U = "c10731";
            lk6.V = "c10704";
            lk6.W = "c10755";
            lk6.X = "c10710";
            lk6.Y = "c10736";
            lk6.Z = "c10737";
            lk6.a0 = "c10711";
            lk6.b0 = "c10758";
            lk6.c0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: y */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            py.b bVar = new py.b(this.b.getPageActivity(), false);
            ox oxVar = new ox(this.b.getPageActivity());
            oxVar.D(this.e);
            oxVar.C("index");
            bVar.h(oxVar);
            py k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.f);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lk6 lk6Var, ThreadCardViewHolder<lk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lk6Var, threadCardViewHolder})) == null) {
            if (lk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && lk6Var.a != null) {
                lk6Var.B(lk6Var.position + 1);
                lk6Var.a.statFloor = lk6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(lk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                pj6.b().a(lk6Var.s());
                a16.c().a(lk6Var.s());
                xv7.p(lk6Var.a, this.a, lk6Var.i());
                if (!lk6Var.R) {
                    xv7.f("c15195", lk6Var.getThreadData());
                    lk6Var.R = true;
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
