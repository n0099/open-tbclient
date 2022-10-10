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
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class ol6 extends dh6<bu4, AutoVideoCardViewHolder<ThreadData>> implements g26, ds6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public bs6 n;
    public boolean o;
    public i26<ThreadData> p;

    /* loaded from: classes5.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol6 b;

        public a(ol6 ol6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0924b7 && view2.getId() != R.id.obfuscated_res_0x7f092489) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092195) {
                    as6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ee8) {
                    as6.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    as6.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e98) {
                    as6.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec6) {
                    as6.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090edf) {
                    as6.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                } else {
                    as6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                }
            } else {
                as6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b7 || view2.getId() == R.id.obfuscated_res_0x7f092489) {
                cs6.k().h(this.b.n, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092181) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    pn8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                cs6.k().h(this.b.n, threadData, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol6 a;

        public b(ol6 ol6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof bu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((bu4) cdo).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((yq4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new bs6();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    public final ab8 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            ab8 ab8Var = new ab8();
            if (100 == t().tabType) {
                ab8Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                ab8Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            ab8Var.d = this.n.c;
            ab8Var.c = threadData.getTid();
            ab8Var.f = threadData.mRecomSource;
            ab8Var.g = threadData.mRecomReason;
            ab8Var.h = threadData.mRecomWeight;
            ab8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                ab8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return ab8Var;
        }
        return (ab8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: R */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.c(696);
            jxVar.u(this.mPageId);
            bVar.o(jxVar);
            yx yxVar = new yx(this.c.getPageActivity());
            yxVar.B(this.o);
            bVar.n(yxVar);
            ux uxVar = new ux(this.c.getPageActivity());
            uxVar.y(this.o);
            uxVar.x("frs");
            bVar.h(uxVar);
            uy uyVar = new uy(this.c.getPageActivity());
            er4 er4Var = new er4();
            if (100 == t().tabType) {
                er4Var.b = 25;
                uyVar.y(19);
                uyVar.D(14);
            } else {
                er4Var.b = 2;
                uyVar.y(2);
                uyVar.D(1);
            }
            er4Var.h = 2;
            uyVar.w(er4Var);
            uyVar.z(this.m);
            uyVar.c(16);
            bVar.m(uyVar);
            sy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
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
    @Override // com.baidu.tieba.dh6, com.baidu.tieba.qn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.n != null) {
                FrsViewData frsViewData = this.b;
                bu4Var.t.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            cs6.k().c(this.n, bu4Var.t);
            as6.o(bu4Var.t, this.mPageId, this.n, t());
            zt4 taskInfoData = bu4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof oi6) {
                    oi6 oi6Var = (oi6) this.c.getOrignalPage();
                    if (this.l.add(f)) {
                        String d2 = oi6Var.d();
                        String c = oi6Var.c();
                        String g = taskInfoData.g();
                        pn8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + bu4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", bu4Var.t.getFid());
                statisticItem.param("tid", bu4Var.t.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", bu4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (bu4Var != null) {
                bu4Var.t.updateShowStatus();
                if ((bu4Var.t.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.u(Q(bu4Var.t));
                }
                autoVideoCardViewHolder.a().f().c(32);
                autoVideoCardViewHolder.e(bu4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().p(this.p);
                ch6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.g26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ds6
    public bs6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (bs6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.dh6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.baidu.tieba.dh6
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.v();
            this.l.clear();
        }
    }
}
