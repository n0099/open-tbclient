package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class xk6 extends qg6<ot4, ThreadCardViewHolder<ThreadData>> implements t16, pr6, go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public nr6 r;
    public v16<ThreadData> s;
    public NEGFeedBackView.b t;

    /* loaded from: classes6.dex */
    public class a extends v16<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk6 b;

        public a(xk6 xk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if ("c13010".equals(this.b.o)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0924b4 && view2.getId() != R.id.obfuscated_res_0x7f092486) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092192) {
                    mr6.e(threadData, 5, this.b.mPageId, this.b.r, this.b.t());
                    if (this.b.b != null && this.b.b.getForum() != null) {
                        mr6.c(threadData, this.b.b.getForum().getId());
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e95) {
                    mr6.e(threadData, 14, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec6) {
                    mr6.e(threadData, 12, this.b.mPageId, this.b.r, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090edf) {
                    mr6.e(threadData, 13, this.b.mPageId, this.b.r, this.b.t());
                } else {
                    if (view2 instanceof ThreadGodReplyLayout) {
                        mr6.e(threadData, 15, this.b.mPageId, this.b.r, this.b.t());
                    } else {
                        mr6.e(threadData, 1, this.b.mPageId, this.b.r, this.b.t());
                    }
                    if (this.b.b != null && this.b.b.getForum() != null) {
                        mr6.c(threadData, this.b.b.getForum().getId());
                    }
                }
            } else {
                mr6.e(threadData, 2, this.b.mPageId, this.b.r, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b4 || view2.getId() == R.id.obfuscated_res_0x7f092486) {
                or6.k().h(this.b.r, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09054b) {
                or6.k().h(this.b.r, threadData, 1);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0924b4 && view2.getId() != R.id.obfuscated_res_0x7f092486) {
                if (view2 instanceof OriginalThreadCardView) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                    statisticItem.param("obj_type", "3");
                    statisticItem.param("tid", threadData.getTid());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
            statisticItem2.param("obj_type", "1");
            statisticItem2.param("tid", threadData.getTid());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xk6 xk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, is4 is4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, is4Var) == null) || arrayList == null || is4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", is4Var.c()).param("tid", is4Var.f()).param("nid", is4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", is4Var.l).param("weight", is4Var.k).param("ab_tag", is4Var.p).param("extra", is4Var.m).param("card_type", is4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, is4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(is4 is4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, is4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(is4 is4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, is4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", is4Var.c()).param("tid", is4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(xk6 xk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(lq4 lq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, lq4Var, view2) == null) || lq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b4) {
                lq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092486) {
                lq4Var.objType = 4;
            } else {
                lq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk6 a;

        public d(xk6 xk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ot4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((ot4) cdo).t;
                threadData.objType = 1;
                if (this.a.s != null) {
                    this.a.s.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((lq4) threadData, view2.getContext(), this.a.q, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = true;
        this.q = 3;
        this.r = new nr6();
        this.s = new a(this);
        this.t = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void W(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            or6.k().d(threadData, this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.l.getPageActivity());
            jx jxVar = new jx(this.l.getPageActivity());
            jxVar.c(4280);
            jxVar.u(this.mPageId);
            jxVar.t(new c(this));
            bVar.o(jxVar);
            xy xyVar = new xy(this.l.getPageActivity());
            bVar.n(xyVar);
            if (this.q == 502) {
                xyVar.u(false);
            } else {
                xyVar.u(true);
            }
            xyVar.v(3);
            ux uxVar = new ux(this.l.getPageActivity());
            uxVar.y(this.p);
            uxVar.x("frs");
            bVar.h(uxVar);
            uy uyVar = new uy(this.l.getPageActivity());
            rq4 rq4Var = new rq4();
            if (100 == t().tabType) {
                rq4Var.b = 25;
                uyVar.y(19);
            } else {
                rq4Var.b = 2;
                uyVar.y(2);
            }
            rq4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !dj.isEmpty(this.b.getForum().getId())) {
                rq4Var.j = this.b.getForum().getId();
            }
            uyVar.w(rq4Var);
            uyVar.D(3);
            uyVar.z(2);
            uyVar.c(16);
            bVar.m(uyVar);
            bVar.l().h(ej.f(this.mContext, R.dimen.tbds28));
            sy i = bVar.i();
            i.r(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qg6, com.baidu.tieba.qn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ot4 ot4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ot4Var, threadCardViewHolder})) == null) {
            if (ot4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            if (threadCardViewHolder.a() instanceof fo5) {
                threadCardViewHolder.a().b(this.n);
            }
            super.onFillViewHolder(i, view2, viewGroup, ot4Var, threadCardViewHolder);
            pg6.i(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                ot4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            boolean z = (ot4Var.t.getAuthor() == null || ot4Var.t.getAuthor().getUserId() == null || !ot4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (ot4Var.t.isSmartFrsThread() && ot4Var.t.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.o(true).u(this.t);
            }
            threadCardViewHolder.r();
            if (threadCardViewHolder.a().f() != null) {
                threadCardViewHolder.a().f().c(32);
            }
            threadCardViewHolder.e(ot4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.s);
            if (this.r != null) {
                FrsViewData frsViewData2 = this.b;
                ot4Var.t.statFloor = (ot4Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            or6.k().c(this.r, ot4Var.t);
            W(ot4Var.t);
            ot4Var.t.updateShowStatus();
            mr6.o(ot4Var.t, this.mPageId, this.r, t());
            FrsViewData frsViewData3 = this.b;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                mr6.m(ot4Var.t, t());
                mr6.n(ot4Var.t, this.b.getForum().getId());
            }
            ThreadData threadData = ot4Var.t;
            if (threadData != null) {
                threadData.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.t16
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.pr6
    public nr6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.r : (nr6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t16
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.q = i;
        }
    }

    @Override // com.baidu.tieba.qg6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.qg6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.p = z;
        }
    }
}
