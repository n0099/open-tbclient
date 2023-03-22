package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class s07 extends ew6<mz4, AutoVideoCardViewHolder<ThreadData>> implements jf6, e77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public c77 n;
    public boolean o;
    public lf6<ThreadData> p;

    @Override // com.baidu.tieba.jf6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends lf6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s07 b;

        public a(s07 s07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        b77.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        b77.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        b77.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.share_num_container) {
                        b77.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        b77.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        b77.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                    } else {
                        b77.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                    }
                } else {
                    b77.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_card_root) {
                        if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                            String d = threadData.getTaskInfoData().d();
                            if (StringUtils.isNull(d)) {
                                d = threadData.getTaskInfoData().g();
                            }
                            String str = d;
                            String valueOf = String.valueOf(threadData.getFid());
                            String forum_name = threadData.getForum_name();
                            String i = threadData.getTaskInfoData().i();
                            hc9.c("frs", "CLICK", valueOf, forum_name, i, "tieba.baidu.com/p/" + threadData.getTaskInfoData().i(), str);
                            String g = threadData.getTaskInfoData().g();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", g);
                            TiebaStatic.log(statisticItem);
                        }
                        d77.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                d77.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s07 a;

        public b(s07 s07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s07Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) gnVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((hw4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s07(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.n = new c77();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.jf6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.ew6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public final ey8 S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            ey8 ey8Var = new ey8();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                ey8Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                ey8Var.a = str;
            }
            ey8Var.d = this.n.c;
            ey8Var.c = threadData.getTid();
            ey8Var.f = threadData.mRecomSource;
            ey8Var.g = threadData.mRecomReason;
            ey8Var.h = threadData.mRecomWeight;
            ey8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                ey8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return ey8Var;
        }
        return (ey8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: T */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.c.getPageActivity());
            rw rwVar = new rw(this.c.getPageActivity());
            rwVar.f(696);
            rwVar.x(this.mPageId);
            bVar.o(rwVar);
            ix ixVar = new ix(this.c.getPageActivity());
            ixVar.F(this.o);
            bVar.n(ixVar);
            my myVar = new my(this.c.getPageActivity());
            myVar.B(this.c);
            myVar.A(3);
            bVar.h(myVar);
            fx fxVar = new fx(this.c.getPageActivity());
            fxVar.B(this.c);
            fxVar.A(1);
            bVar.h(fxVar);
            ex exVar = new ex(this.c.getPageActivity());
            exVar.C(1);
            bVar.h(exVar);
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.B(this.o);
            cxVar.A("frs");
            bVar.h(cxVar);
            ey eyVar = new ey(this.c.getPageActivity());
            nw4 nw4Var = new nw4();
            if (100 == t().tabType) {
                nw4Var.b = 25;
                eyVar.B(19);
                eyVar.G(14);
            } else {
                nw4Var.b = 2;
                eyVar.B(2);
                eyVar.G(1);
            }
            nw4Var.h = 2;
            eyVar.z(nw4Var);
            eyVar.C(this.m);
            eyVar.f(16);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.q(this.p);
            k.s(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ew6, com.baidu.tieba.tm
    /* renamed from: U */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            char c = 1;
            if (this.n != null) {
                int i2 = 0;
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    i2 = frsViewData.getTopThreadSize();
                }
                mz4Var.t.statFloor = (i + 1) - i2;
            }
            d77.k().c(this.n, mz4Var.t);
            b77.o(mz4Var.t, this.mPageId, this.n, t());
            kz4 taskInfoData = mz4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String g = taskInfoData.g();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.g();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof qx6) {
                    qx6 qx6Var = (qx6) this.c.getOrignalPage();
                    if (this.l.add(g)) {
                        String w = qx6Var.w();
                        String v = qx6Var.v();
                        String i3 = taskInfoData.i();
                        hc9.c("frs", "VIEW_TRUE", w, v, i3, "tieba.baidu.com/p/" + mz4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", mz4Var.t.getFid());
                statisticItem.param("tid", mz4Var.t.getTid());
                statisticItem.param("obj_id", g);
                statisticItem.param("thread_type", mz4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (mz4Var != null) {
                mz4Var.t.updateShowStatus();
                if (mz4Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.u(S(mz4Var.t));
                }
                autoVideoCardViewHolder.a().f().f(32);
                autoVideoCardViewHolder.e(mz4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().q(this.p);
                dw6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.e77
    public c77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (c77) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ew6
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.x();
            this.l.clear();
        }
    }
}
