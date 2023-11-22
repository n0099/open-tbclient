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
import com.baidu.tieba.bu;
import com.baidu.tieba.mu;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class pu7 extends qp7<ThreadData, AutoVideoCardViewHolder<ThreadData>> implements wl6, d18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public b18 n;
    public boolean o;
    public yl6<ThreadData> p;

    @Override // com.baidu.tieba.wl6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends yl6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu7 b;

        public a(pu7 pu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yl6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        a18.e(threadData, 5, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        a18.e(threadData, 3, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        a18.e(threadData, 15, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2.getId() == R.id.share_num_container) {
                        a18.e(threadData, 14, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2.getId() == R.id.img_agree) {
                        a18.e(threadData, 12, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2.getId() == R.id.img_disagree) {
                        a18.e(threadData, 13, this.b.mPageId, this.b.n, this.b.u());
                    } else {
                        a18.e(threadData, 1, this.b.mPageId, this.b.n, this.b.u());
                    }
                } else {
                    a18.e(threadData, 2, this.b.mPageId, this.b.n, this.b.u());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_card_root) {
                        if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                            String e = threadData.getTaskInfoData().e();
                            if (StringUtils.isNull(e)) {
                                e = threadData.getTaskInfoData().h();
                            }
                            String str = e;
                            String valueOf = String.valueOf(threadData.getFid());
                            String forum_name = threadData.getForum_name();
                            String k = threadData.getTaskInfoData().k();
                            bsa.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        c18.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                c18.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu7 a;

        public b(pu7 pu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu7Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = (ThreadData) oiVar;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((bw4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new b18();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.wl6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.qp7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public final g9a S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            g9a g9aVar = new g9a();
            String str = "3";
            if (100 == u().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                g9aVar.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                g9aVar.a = str;
            }
            g9aVar.d = this.n.c;
            g9aVar.c = threadData.getTid();
            g9aVar.f = threadData.mRecomSource;
            g9aVar.g = threadData.mRecomReason;
            g9aVar.h = threadData.mRecomWeight;
            g9aVar.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                g9aVar.m = threadData.getThreadVideoInfo().video_md5;
            }
            return g9aVar;
        }
        return (g9a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: T */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.c.getPageActivity());
            qs qsVar = new qs(this.c.getPageActivity());
            qsVar.b(696);
            qsVar.o(this.mPageId);
            bVar.o(qsVar);
            jt jtVar = new jt(this.c.getPageActivity());
            jtVar.E(this.o);
            bVar.n(jtVar);
            ct ctVar = new ct(this.c.getPageActivity());
            ctVar.C(this.o);
            ctVar.B("frs");
            bVar.h(ctVar);
            du duVar = new du(this.c.getPageActivity());
            hw4 hw4Var = new hw4();
            if (100 == u().tabType) {
                hw4Var.b = 25;
                duVar.E(19);
                duVar.J(14);
            } else {
                hw4Var.b = 2;
                duVar.E(2);
                duVar.J(1);
            }
            hw4Var.h = 2;
            duVar.C(hw4Var);
            duVar.F(this.m);
            duVar.b(16);
            bVar.m(duVar);
            bu i = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
            autoVideoCardViewHolder.i(this.mPageId);
            i.r(this.p);
            i.t(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.p();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qp7, com.baidu.tieba.bi
    /* renamed from: U */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, autoVideoCardViewHolder})) == null) {
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
                threadData.statFloor = (i + 1) - i2;
            }
            c18.k().c(this.n, threadData);
            a18.p(threadData, this.mPageId, this.n, u());
            fz4 taskInfoData = threadData.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof cr7) {
                    cr7 cr7Var = (cr7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = cr7Var.w();
                        String v = cr7Var.v();
                        String k = taskInfoData.k();
                        bsa.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + threadData.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", threadData.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (threadData != null) {
                threadData.updateShowStatus();
                if (threadData.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.z(S(threadData));
                }
                autoVideoCardViewHolder.a().f().b(32);
                autoVideoCardViewHolder.e(threadData);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().r(this.p);
                pp7.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.d18
    public b18 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (b18) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qp7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.y();
            this.l.clear();
        }
    }
}
