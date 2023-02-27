package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kz;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class uf7 extends qn<mg6, ThreadCardViewHolder<mg6>> implements dy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public jo d;
    public NEGFeedBackView.b e;
    public xf6<mg6> f;

    /* loaded from: classes6.dex */
    public class a extends xf6<mg6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uf7 b;

        public a(uf7 uf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xf6
        /* renamed from: d */
        public void a(View view2, mg6 mg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, mg6Var) == null) {
                qf6.b().d(true);
                if (view2 != null && mg6Var != null && mg6Var.getThreadData() != null && !StringUtils.isNull(mg6Var.getThreadData().getTid())) {
                    this.b.x(view2, mg6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uf7 a;

        public b(uf7 uf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uf7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof mg6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                mg6 mg6Var = (mg6) cdo;
                mg6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), mg6Var);
                }
                ThreadCardUtils.jumpToPB((zx4) mg6Var, view2.getContext(), 2, false, px.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new kz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
        u();
    }

    @Override // com.baidu.tieba.dy5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public void y(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void z(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, joVar) == null) {
            this.d = joVar;
        }
    }

    public final void A(mg6 mg6Var, mg6 mg6Var2) {
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, mg6Var, mg6Var2) == null) && (threadData = mg6Var2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(mg6Var2.a.getForumData().f())) {
            if (mg6Var != null && (threadData2 = mg6Var.a) != null && threadData2.getTid() != null && mg6Var.a.getForumData() != null && mg6Var.a.getForumData().f() != null && (!mg6Var.a.getTid().equals(mg6Var2.a.getTid()) || !mg6Var.a.getForumData().f().equals(mg6Var2.a.getForumData().f()))) {
                kh7.f(mg6Var2.a);
            }
            if (mg6Var == null) {
                kh7.f(mg6Var2.a);
            }
        }
    }

    public final void x(View view2, mg6 mg6Var) {
        int i;
        StatisticItem t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, mg6Var) == null) {
            int id = view2.getId();
            if (mg6Var == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread && id != R.id.forum_recommend_reason) {
                if (mg6Var.isVideoThreadType()) {
                    t = mg6Var.v();
                } else {
                    t = mg6Var.t();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(t));
                by5.c().i("page_recommend", "clk_", t);
                i = 1;
                kh7.b(mg6Var.a, mg6Var.n(), mg6Var.l());
            } else {
                TiebaStatic.log(mg6Var.h());
                by5.c().i("page_recommend", "clk_", mg6Var.h());
                i = 9;
            }
            if (i != 0) {
                kh7.d(mg6Var.a, this.a, mg6Var.l(), i);
                kh7.c(mg6Var.a, mg6Var.n(), mg6Var.l(), 3);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mg6.R = "c10705";
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
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            zy.b bVar = new zy.b(this.b.getPageActivity());
            bVar.o(new xx(this.b.getPageActivity()));
            zy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mg6 mg6Var, ThreadCardViewHolder<mg6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mg6Var, threadCardViewHolder})) == null) {
            if (mg6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && mg6Var.a != null) {
                if (i == 0) {
                    g09.a("main", true);
                }
                mg6Var.F(mg6Var.position + 1);
                mg6Var.a.statFloor = mg6Var.l();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.e);
                threadCardViewHolder.e(mg6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                qf6.b().a(mg6Var.u());
                by5.c().a(mg6Var.u());
                kh7.k(mg6Var.a, this.a, mg6Var.l());
                kh7.j(mg6Var.a, mg6Var.n(), mg6Var.l());
                A(threadCardViewHolder.a().h(), mg6Var);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
