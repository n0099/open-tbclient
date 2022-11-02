package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k37 extends jn<o46, ThreadCardViewHolder<o46>> implements zp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public q47 c;
    public String d;
    public co e;
    public z36<o46> f;

    /* loaded from: classes4.dex */
    public class a extends z36<o46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k37 b;

        public a(k37 k37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k37Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, o46 o46Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o46Var) == null) {
                s36.b().d(true);
                xp5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && o46Var != null && o46Var.getThreadData() != null && !StringUtils.isNull(o46Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !t27.b(wg.g(o46Var.getThreadData().getTid(), 0L))) {
                        t27.a(wg.g(o46Var.getThreadData().getTid(), 0L));
                        this.b.c.e(wg.g(o46Var.getThreadData().getTid(), 0L), o46Var.D(), o46Var.r(), o46Var.n(), o46Var.c(), wg.e((String) view2.getTag(), 1), "homepage", o46Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.x(view2, o46Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k37 a;

        public b(k37 k37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k37Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof o46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o46 o46Var = (o46) wnVar;
                o46Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), o46Var);
                }
                ThreadCardUtils.jumpToPB((rr4) o46Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k37(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, coVar) == null) {
            this.e = coVar;
        }
    }

    @Override // com.baidu.tieba.zp5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public void z(q47 q47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, q47Var) == null) {
            this.c = q47Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            hy hyVar = new hy(this.b.getPageActivity());
            hyVar.y(1);
            hyVar.w();
            hyVar.z(this.b);
            bVar.h(hyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    public final void y(o46 o46Var) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, o46Var) == null) && o46Var != null && (threadData = o46Var.a) != null && threadData.getThreadRecommendInfoDataList() != null) {
            StatisticItem statisticItem = new StatisticItem("c14686");
            if (!TextUtils.isEmpty(((ThreadRecommendInfoData) ListUtils.getItem(o46Var.a.getThreadRecommendInfoDataList(), 0)).recommendReason)) {
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o46 o46Var, ThreadCardViewHolder<o46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o46Var, threadCardViewHolder})) == null) {
            if (o46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o46Var.a != null) {
                y(o46Var);
                o46Var.I(o46Var.position + 1);
                o46Var.a.statFloor = o46Var.n();
                threadCardViewHolder.a().q(i);
                threadCardViewHolder.a().b(this.d);
                threadCardViewHolder.e(o46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.f);
                s36.b().a(o46Var.B());
                xp5.c().a(o46Var.B());
                v47.i(o46Var.a, this.a, o46Var.n());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(View view2, o46 o46Var) {
        StatisticItem A;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, o46Var) == null) {
            int id = view2.getId();
            if (o46Var == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0921d0 && id != R.id.obfuscated_res_0x7f0921e4) {
                if (id != R.id.obfuscated_res_0x7f090aac && id != R.id.obfuscated_res_0x7f090a84) {
                    i = 0;
                } else {
                    TiebaStatic.log(o46Var.j());
                    xp5.c().i("page_recommend", "clk_", o46Var.j());
                    i = 9;
                }
            } else {
                if (o46Var.isVideoThreadType()) {
                    A = o46Var.C();
                } else {
                    A = o46Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                xp5.c().i("page_recommend", "clk_", A);
                i = 1;
                v47.b(o46Var.a, o46Var.r(), o46Var.n());
            }
            if (i != 0) {
                v47.d(o46Var.a, this.a, o46Var.n(), i);
            }
        }
    }
}
