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
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class sn6 extends gj6<wu4, AutoVideoCardViewHolder<ThreadData>> implements j46, eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public cu6 n;
    public boolean o;
    public l46<ThreadData> p;

    @Override // com.baidu.tieba.j46
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends l46<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn6 b;

        public a(sn6 sn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921f1) {
                        bu6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090f18) {
                        bu6.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        bu6.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091eee) {
                        bu6.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090ef6) {
                        bu6.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090f0f) {
                        bu6.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                    } else {
                        bu6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                    }
                } else {
                    bu6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921dd) {
                        if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                            String d = threadData.getTaskInfoData().d();
                            if (StringUtils.isNull(d)) {
                                d = threadData.getTaskInfoData().g();
                            }
                            String str = d;
                            String valueOf = String.valueOf(threadData.getFid());
                            String forum_name = threadData.getForum_name();
                            String i = threadData.getTaskInfoData().i();
                            qp8.c("frs", "CLICK", valueOf, forum_name, i, "tieba.baidu.com/p/" + threadData.getTaskInfoData().i(), str);
                            String g = threadData.getTaskInfoData().g();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", g);
                            TiebaStatic.log(statisticItem);
                        }
                        du6.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                du6.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn6 a;

        public b(sn6 sn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof wu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((wu4) xnVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((sr4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sn6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new cu6();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.j46
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.gj6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public final fd8 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            fd8 fd8Var = new fd8();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                fd8Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                fd8Var.a = str;
            }
            fd8Var.d = this.n.c;
            fd8Var.c = threadData.getTid();
            fd8Var.f = threadData.mRecomSource;
            fd8Var.g = threadData.mRecomReason;
            fd8Var.h = threadData.mRecomWeight;
            fd8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                fd8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return fd8Var;
        }
        return (fd8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: R */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.f(696);
            dxVar.x(this.mPageId);
            bVar.o(dxVar);
            ux uxVar = new ux(this.c.getPageActivity());
            uxVar.E(this.o);
            bVar.n(uxVar);
            yy yyVar = new yy(this.c.getPageActivity());
            yyVar.B(this.c);
            yyVar.A(3);
            bVar.h(yyVar);
            rx rxVar = new rx(this.c.getPageActivity());
            rxVar.B(this.c);
            rxVar.A(1);
            bVar.h(rxVar);
            qx qxVar = new qx(this.c.getPageActivity());
            qxVar.C(1);
            bVar.h(qxVar);
            ox oxVar = new ox(this.c.getPageActivity());
            oxVar.B(this.o);
            oxVar.A("frs");
            bVar.h(oxVar);
            qy qyVar = new qy(this.c.getPageActivity());
            yr4 yr4Var = new yr4();
            if (100 == t().tabType) {
                yr4Var.b = 25;
                qyVar.B(19);
                qyVar.G(14);
            } else {
                yr4Var.b = 2;
                qyVar.B(2);
                qyVar.G(1);
            }
            yr4Var.h = 2;
            qyVar.z(yr4Var);
            qyVar.C(this.m);
            qyVar.f(16);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.p(this.p);
            k.r(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gj6, com.baidu.tieba.kn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wu4 wu4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wu4Var, autoVideoCardViewHolder})) == null) {
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
                wu4Var.t.statFloor = (i + 1) - i2;
            }
            du6.k().c(this.n, wu4Var.t);
            bu6.o(wu4Var.t, this.mPageId, this.n, t());
            uu4 taskInfoData = wu4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String g = taskInfoData.g();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.g();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof rk6) {
                    rk6 rk6Var = (rk6) this.c.getOrignalPage();
                    if (this.l.add(g)) {
                        String k = rk6Var.k();
                        String c2 = rk6Var.c();
                        String i3 = taskInfoData.i();
                        qp8.c("frs", "VIEW_TRUE", k, c2, i3, "tieba.baidu.com/p/" + wu4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", wu4Var.t.getFid());
                statisticItem.param("tid", wu4Var.t.getTid());
                statisticItem.param("obj_id", g);
                statisticItem.param("thread_type", wu4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (wu4Var != null) {
                wu4Var.t.updateShowStatus();
                if (wu4Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.u(Q(wu4Var.t));
                }
                autoVideoCardViewHolder.a().f().f(32);
                autoVideoCardViewHolder.e(wu4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().p(this.p);
                fj6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.eu6
    public cu6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (cu6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gj6
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.v();
            this.l.clear();
        }
    }
}
