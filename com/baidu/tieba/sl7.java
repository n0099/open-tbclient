package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.ay;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.xx;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class sl7 extends yh7<z45, ThreadCardViewHolder<ThreadData>> implements sp6, kt7, t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public it7 r;
    public up6<ThreadData> s;
    public NEGFeedBackView.b t;

    @Override // com.baidu.tieba.sp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl7 b;

        public a(sl7 sl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2 instanceof ThreadGodReplyLayout) {
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            ht7.c(threadData, this.b.b.getForum().getId());
                        }
                        ht7.e(threadData, 15, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.thread_info_commont_container) {
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            ht7.c(threadData, this.b.b.getForum().getId());
                        }
                        ht7.e(threadData, 5, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.share_num_container) {
                        ht7.e(threadData, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        ht7.e(threadData, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        ht7.e(threadData, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else {
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            ht7.c(threadData, this.b.b.getForum().getId());
                        }
                        ht7.e(threadData, 1, this.b.mPageId, this.b.r, this.b.t());
                    }
                } else {
                    ht7.e(threadData, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else {
                        jt7.k().h(this.b.r, threadData, 1);
                    }
                } else {
                    jt7.k().h(this.b.r, threadData, 2);
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

    /* loaded from: classes7.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(s35 s35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s35Var, compoundButton, z) == null) {
            }
        }

        public b(sl7 sl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var};
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
        public void a(ArrayList<Integer> arrayList, String str, s35 s35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, s35Var) == null) && arrayList != null && s35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", s35Var.c()).param("tid", s35Var.f()).param("nid", s35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", s35Var.l).param("weight", s35Var.k).param("ab_tag", s35Var.p).param("extra", s35Var.m).param("card_type", s35Var.o).param(TiebaStatic.Params.OBJ_FLOOR, s35Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(s35 s35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s35Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", s35Var.c()).param("tid", s35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(sl7 sl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && t15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    t15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    t15Var.objType = 4;
                } else {
                    t15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ sl7 b;

        public d(sl7 sl7Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl7Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) && t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().originalThreadData != null) {
                gy5.b(3, this.b.mContext, t15Var.getThreadData(), 0, this.a.C(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ sl7 b;

        public e(sl7 sl7Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl7Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) && t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().originalThreadData != null) {
                gy5.b(3, this.b.mContext, t15Var.getThreadData(), 0, this.a.C(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c00 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ sl7 b;

        public f(sl7 sl7Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sl7Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.c00
        public void a(t15 t15Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, t15Var) == null) && t15Var != null && t15Var.getThreadData() != null && t15Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (t15Var.getThreadData().originalThreadData.r != null) {
                    if (t15Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                gy5.a(3, z, this.b.mContext, t15Var.getThreadData(), 0, this.a.C(), "from_nani_video", "frs_page", null, "frs", "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl7 a;

        public g(sl7 sl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl7Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof z45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((z45) ynVar).t;
                threadData.objType = 1;
                if (this.a.s != null) {
                    this.a.s.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), this.a.q, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sl7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.r = new it7();
        this.s = new a(this);
        this.t = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void e0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            jt7.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.sp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.q = i;
        }
    }

    @Override // com.baidu.tieba.yh7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.yh7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.p = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: f0 */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.l.getPageActivity());
            tz tzVar = new tz(this.l.getPageActivity());
            ay ayVar = new ay(this.l.getPageActivity());
            ayVar.g(4280);
            ayVar.r(this.mPageId);
            ayVar.A(new c(this));
            bVar.o(ayVar);
            hz hzVar = new hz(this.l);
            hzVar.t(Boolean.FALSE);
            hzVar.setFrom("frs");
            hzVar.E(true);
            bVar.l().i(yi.g(this.mContext, R.dimen.tbds38));
            bVar.n(hzVar);
            hz hzVar2 = new hz(this.l);
            hzVar2.t(Boolean.TRUE);
            hzVar2.setFrom("frs");
            hzVar2.E(true);
            hzVar2.F(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.h(hzVar2);
            hzVar2.D(new d(this, tzVar));
            tzVar.t(Boolean.TRUE);
            tzVar.setFrom("frs");
            tzVar.E(new e(this, tzVar));
            tzVar.F(new f(this, tzVar));
            bVar.h(tzVar);
            my myVar = new my(this.l.getPageActivity());
            myVar.F(this.p);
            myVar.E("frs");
            bVar.h(myVar);
            oz ozVar = new oz(this.l.getPageActivity());
            z15 z15Var = new z15();
            if (100 == t().tabType) {
                z15Var.b = 25;
                ozVar.F(19);
            } else {
                z15Var.b = 2;
                ozVar.F(2);
            }
            z15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !xi.isEmpty(this.b.getForum().getId())) {
                z15Var.j = this.b.getForum().getId();
            }
            ozVar.D(z15Var);
            ozVar.L(3);
            ozVar.G(2);
            ozVar.g(16);
            ozVar.O();
            bVar.m(ozVar);
            mz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new g(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
    /* renamed from: g0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, z45 z45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z45Var, threadCardViewHolder})) == null) {
            if (z45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                if (threadCardViewHolder.b() instanceof s66) {
                    threadCardViewHolder.b().b(this.n);
                }
                threadCardViewHolder.b().r(i);
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) z45Var, (z45) threadCardViewHolder);
                xh7.i(threadCardViewHolder.b().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    z45Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (z45Var.t.getAuthor() != null && z45Var.t.getAuthor().getUserId() != null && z45Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z45Var.t.isSmartFrsThread() && z45Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.q(true).s(this.t);
                }
                threadCardViewHolder.t();
                if (threadCardViewHolder.b().f() != null) {
                    threadCardViewHolder.b().f().g(32);
                }
                threadCardViewHolder.f(z45Var.t);
                threadCardViewHolder.b().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    z45Var.t.statFloor = (z45Var.position + 1) - i2;
                }
                jt7.k().c(this.r, z45Var.t);
                e0(z45Var.t);
                z45Var.t.updateShowStatus();
                ht7.p(z45Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    ht7.n(z45Var.t, t());
                    ht7.o(z45Var.t, this.b.getForum().getId());
                }
                ThreadData threadData = z45Var.t;
                if (threadData != null) {
                    threadData.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.kt7
    public it7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.r;
        }
        return (it7) invokeV.objValue;
    }
}
