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
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class xj6 extends af6<ThreadData, AutoVideoCardViewHolder<ThreadData>> implements f06, fq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public dq6 n;
    public boolean o;
    public h06<ThreadData> p;

    /* loaded from: classes6.dex */
    public class a extends h06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj6 b;

        public a(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092459 && view2.getId() != R.id.obfuscated_res_0x7f09242b) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092141) {
                    cq6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ecd) {
                    cq6.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    cq6.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e45) {
                    cq6.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eab) {
                    cq6.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec3) {
                    cq6.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                } else {
                    cq6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                }
            } else {
                cq6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092459 || view2.getId() == R.id.obfuscated_res_0x7f09242b) {
                eq6.k().h(this.b.n, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    ml8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                eq6.k().h(this.b.n, threadData, 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj6 a;

        public b(xj6 xj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = (ThreadData) pnVar;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((go4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new dq6();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    public final e98 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            e98 e98Var = new e98();
            if (100 == t().tabType) {
                e98Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                e98Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            e98Var.d = this.n.c;
            e98Var.c = threadData.getTid();
            e98Var.f = threadData.mRecomSource;
            e98Var.g = threadData.mRecomReason;
            e98Var.h = threadData.mRecomWeight;
            e98Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                e98Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return e98Var;
        }
        return (e98) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: R */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity());
            vw vwVar = new vw(this.c.getPageActivity());
            vwVar.c(696);
            vwVar.u(this.mPageId);
            bVar.o(vwVar);
            kx kxVar = new kx(this.c.getPageActivity());
            kxVar.B(this.o);
            bVar.n(kxVar);
            gx gxVar = new gx(this.c.getPageActivity());
            gxVar.y(this.o);
            gxVar.x("frs");
            bVar.h(gxVar);
            gy gyVar = new gy(this.c.getPageActivity());
            mo4 mo4Var = new mo4();
            if (100 == t().tabType) {
                mo4Var.b = 25;
                gyVar.y(19);
                gyVar.D(14);
            } else {
                mo4Var.b = 2;
                gyVar.y(2);
                gyVar.D(1);
            }
            mo4Var.h = 2;
            gyVar.w(mo4Var);
            gyVar.z(this.m);
            gyVar.c(16);
            bVar.m(gyVar);
            ey i = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
            autoVideoCardViewHolder.i(this.mPageId);
            i.p(this.p);
            i.r(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.af6, com.baidu.tieba.cn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.n != null) {
                FrsViewData frsViewData = this.b;
                threadData.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            eq6.k().c(this.n, threadData);
            cq6.o(threadData, this.mPageId, this.n, t());
            hr4 taskInfoData = threadData.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof kg6) {
                    kg6 kg6Var = (kg6) this.c.getOrignalPage();
                    if (this.l.add(f)) {
                        String d2 = kg6Var.d();
                        String c = kg6Var.c();
                        String g = taskInfoData.g();
                        ml8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + threadData.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", threadData.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (threadData != null) {
                threadData.updateShowStatus();
                if ((threadData.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.u(Q(threadData));
                }
                autoVideoCardViewHolder.a().f().c(32);
                autoVideoCardViewHolder.e(threadData);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().p(this.p);
                ze6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.f06
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.fq6
    public dq6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (dq6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f06
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.af6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.baidu.tieba.af6
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.v();
            this.l.clear();
        }
    }
}
