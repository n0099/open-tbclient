package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbLabelWidget;
import com.baidu.tieba.az;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nu7 extends en<lk6, ThreadCardViewHolder<lk6>> implements c16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public sv7 c;
    public String d;
    public xn e;
    public wj6<lk6> f;

    /* loaded from: classes6.dex */
    public class a extends wj6<lk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu7 b;

        public a(nu7 nu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nu7Var;
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
                    this.b.z(view2, lk6Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TbLabelWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy a;

        public b(nu7 nu7Var, jy jyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu7Var, jyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jyVar;
        }

        @Override // com.baidu.tbadk.widget.TbLabelWidget.b
        public void a(View view2, int i, TbLabelWidget.c cVar) {
            ThreadRecommendInfoData threadRecommendInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, cVar) == null) {
                StatisticItem statisticItem = new StatisticItem("c14686");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                if (this.a.z() != null) {
                    ThreadData z = this.a.z();
                    statisticItem.param("tid", z.getTid());
                    if (!ListUtils.isEmpty(z.getThreadRecommendInfoDataList()) && (threadRecommendInfoData = z.getThreadRecommendInfoDataList().get(0)) != null) {
                        statisticItem.param("obj_param1", threadRecommendInfoData.businessId);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu7 a;

        public c(nu7 nu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nu7Var;
        }

        @Override // com.baidu.tieba.bo
        public void b(View view2, rn rnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, rnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (rnVar instanceof lk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                lk6 lk6Var = (lk6) rnVar;
                lk6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), lk6Var);
                }
                ThreadCardUtils.jumpToPB((jy4) lk6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new az.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
            this.e = xnVar;
        }
    }

    @Override // com.baidu.tieba.c16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(lk6 lk6Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, lk6Var) == null) && lk6Var != null && (threadData = lk6Var.a) != null && threadData.getThreadRecommendInfoDataList() != null) {
            StatisticItem statisticItem = new StatisticItem("c14686");
            ThreadRecommendInfoData threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(lk6Var.a.getThreadRecommendInfoDataList(), 0);
            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("tid", lk6Var.a.getTid());
                statisticItem.param("obj_param1", threadRecommendInfoData.businessId);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            py.b bVar = new py.b(this.b.getPageActivity(), false);
            jy jyVar = new jy(this.b.getPageActivity());
            jyVar.B(new b(this, jyVar));
            jyVar.y();
            jyVar.C(this.b);
            bVar.h(jyVar);
            py k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lk6 lk6Var, ThreadCardViewHolder<lk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lk6Var, threadCardViewHolder})) == null) {
            if (lk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && lk6Var.a != null) {
                A(lk6Var);
                lk6Var.B(lk6Var.position + 1);
                lk6Var.a.statFloor = lk6Var.i();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(lk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                pj6.b().a(lk6Var.s());
                a16.c().a(lk6Var.s());
                xv7.p(lk6Var.a, this.a, lk6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, lk6 lk6Var) {
        StatisticItem q;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, lk6Var) == null) {
            int id = view2.getId();
            if (lk6Var == null) {
                return;
            }
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id != R.id.forum_name_text && id != R.id.forum_enter_button) {
                    i = 0;
                } else {
                    TiebaStatic.log(lk6Var.f());
                    a16.c().i("page_recommend", "clk_", lk6Var.f());
                    i = 9;
                }
            } else {
                if (lk6Var.isVideoThreadType()) {
                    q = lk6Var.u();
                } else {
                    q = lk6Var.q();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                a16.c().i("page_recommend", "clk_", q);
                i = 1;
                xv7.b(lk6Var.a, lk6Var.k(), lk6Var.i());
            }
            if (i != 0) {
                xv7.d(lk6Var.a, this.a, lk6Var.i(), i);
            }
        }
    }
}
