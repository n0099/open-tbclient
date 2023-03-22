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
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.rw;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class o07 extends ew6<mz4, ThreadCardViewHolder<ThreadData>> implements jf6, e77, jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public c77 r;
    public lf6<ThreadData> s;
    public NEGFeedBackView.b t;

    @Override // com.baidu.tieba.jf6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends lf6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o07 b;

        public a(o07 o07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        b77.e(threadData, 5, this.b.mPageId, this.b.r, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            b77.c(threadData, this.b.b.getForum().getId());
                        }
                    } else if (view2.getId() == R.id.share_num_container) {
                        b77.e(threadData, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        b77.e(threadData, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        b77.e(threadData, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            b77.e(threadData, 15, this.b.mPageId, this.b.r, this.b.t());
                        } else {
                            b77.e(threadData, 1, this.b.mPageId, this.b.r, this.b.t());
                        }
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            b77.c(threadData, this.b.b.getForum().getId());
                        }
                    }
                } else {
                    b77.e(threadData, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else {
                        d77.k().h(this.b.r, threadData, 1);
                    }
                } else {
                    d77.k().h(this.b.r, threadData, 2);
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
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
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(fy4 fy4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy4Var, compoundButton, z) == null) {
            }
        }

        public b(o07 o07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o07Var};
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
        public void a(ArrayList<Integer> arrayList, String str, fy4 fy4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, fy4Var) == null) && arrayList != null && fy4Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", fy4Var.c()).param("tid", fy4Var.f()).param("nid", fy4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", fy4Var.l).param("weight", fy4Var.k).param("ab_tag", fy4Var.p).param("extra", fy4Var.m).param("card_type", fy4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, fy4Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(fy4 fy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fy4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", fy4Var.c()).param("tid", fy4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(o07 o07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw.b
        public void a(hw4 hw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, hw4Var, view2) == null) && hw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    hw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    hw4Var.objType = 4;
                } else {
                    hw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o07 a;

        public d(o07 o07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o07Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) gnVar).t;
                threadData.objType = 1;
                if (this.a.s != null) {
                    this.a.s.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((hw4) threadData, view2.getContext(), this.a.q, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new c77();
        this.s = new a(this);
        this.t = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void Y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            d77.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.jf6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.q = i;
        }
    }

    @Override // com.baidu.tieba.ew6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.ew6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.p = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.l.getPageActivity());
            rw rwVar = new rw(this.l.getPageActivity());
            rwVar.f(4280);
            rwVar.x(this.mPageId);
            rwVar.w(new c(this));
            bVar.o(rwVar);
            hy hyVar = new hy(this.l.getPageActivity());
            bVar.n(hyVar);
            hyVar.x(true);
            hyVar.y(3);
            cx cxVar = new cx(this.l.getPageActivity());
            cxVar.B(this.p);
            cxVar.A("frs");
            bVar.h(cxVar);
            ey eyVar = new ey(this.l.getPageActivity());
            nw4 nw4Var = new nw4();
            if (100 == t().tabType) {
                nw4Var.b = 25;
                eyVar.B(19);
            } else {
                nw4Var.b = 2;
                eyVar.B(2);
            }
            nw4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !gi.isEmpty(this.b.getForum().getId())) {
                nw4Var.j = this.b.getForum().getId();
            }
            eyVar.z(nw4Var);
            eyVar.G(3);
            eyVar.C(2);
            eyVar.f(16);
            bVar.m(eyVar);
            bVar.l().i(hi.g(this.mContext, R.dimen.tbds28));
            cy i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ew6, com.baidu.tieba.tm
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, threadCardViewHolder})) == null) {
            if (mz4Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                if (threadCardViewHolder.a() instanceof ix5) {
                    threadCardViewHolder.a().b(this.n);
                }
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mz4Var, (mz4) threadCardViewHolder);
                dw6.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    mz4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (mz4Var.t.getAuthor() != null && mz4Var.t.getAuthor().getUserId() != null && mz4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (mz4Var.t.isSmartFrsThread() && mz4Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.o(true).s(this.t);
                }
                threadCardViewHolder.r();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().f(32);
                }
                threadCardViewHolder.e(mz4Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    mz4Var.t.statFloor = (mz4Var.position + 1) - i2;
                }
                d77.k().c(this.r, mz4Var.t);
                Y(mz4Var.t);
                mz4Var.t.updateShowStatus();
                b77.o(mz4Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    b77.m(mz4Var.t, t());
                    b77.n(mz4Var.t, this.b.getForum().getId());
                }
                ThreadData threadData = mz4Var.t;
                if (threadData != null) {
                    threadData.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.e77
    public c77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (c77) invokeV.objValue;
    }
}
