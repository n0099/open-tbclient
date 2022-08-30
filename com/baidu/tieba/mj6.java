package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class mj6 extends cf6<kr4, ThreadCardViewHolder<ThreadData>> implements h06, hq6, xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public boolean n;
    public int o;
    public fq6 p;
    public j06<ThreadData> q;
    public NEGFeedBackView.b r;

    /* loaded from: classes5.dex */
    public class a extends j06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mj6 b;

        public a(mj6 mj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092459 && view2.getId() != R.id.obfuscated_res_0x7f09242b) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092141) {
                    eq6.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                    pr6.g(threadData, this.b.b, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e45) {
                    eq6.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090eab) {
                    eq6.e(threadData, 12, this.b.mPageId, this.b.p, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec3) {
                    eq6.e(threadData, 13, this.b.mPageId, this.b.p, this.b.t());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.q.a instanceof Boolean) {
                        if (((Boolean) this.b.q.a).booleanValue()) {
                            eq6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                        } else {
                            eq6.e(threadData, 3, this.b.mPageId, this.b.p, this.b.t());
                        }
                    }
                    pr6.g(threadData, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    eq6.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                    pr6.g(threadData, this.b.b, 1);
                } else {
                    eq6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                    pr6.g(threadData, this.b.b, 1);
                }
            } else {
                eq6.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092459 || view2.getId() == R.id.obfuscated_res_0x7f09242b) {
                gq6.k().h(this.b.p, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09053c) {
                gq6.k().h(this.b.p, threadData, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(mj6 mj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, eq4 eq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, eq4Var) == null) || arrayList == null || eq4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", eq4Var.c()).param("tid", eq4Var.f()).param("nid", eq4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", eq4Var.l).param("weight", eq4Var.k).param("ab_tag", eq4Var.p).param("extra", eq4Var.m).param("card_type", eq4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, eq4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(eq4 eq4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eq4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(eq4 eq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", eq4Var.c()).param("tid", eq4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements vw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(mj6 mj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vw.b
        public void a(ho4 ho4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, ho4Var, view2) == null) || ho4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092459) {
                ho4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09242b) {
                ho4Var.objType = 4;
            } else {
                ho4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mj6 a;

        public d(mj6 mj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mj6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof kr4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((kr4) pnVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((ho4) threadData, view2.getContext(), this.a.o, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.n = true;
        this.o = 3;
        this.p = new fq6();
        this.q = new a(this);
        this.r = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: V */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.l.getPageActivity());
            vw vwVar = new vw(this.l.getPageActivity());
            vwVar.u(this.mPageId);
            vwVar.c(4272);
            vwVar.t(new c(this));
            bVar.o(vwVar);
            bVar.n(new mx(this.l.getPageActivity()));
            gx gxVar = new gx(this.l.getPageActivity());
            gxVar.y(this.n);
            gxVar.x("frs");
            bVar.h(gxVar);
            gy gyVar = new gy(this.l.getPageActivity());
            no4 no4Var = new no4();
            if (100 == t().tabType) {
                no4Var.b = 25;
                gyVar.y(19);
            } else {
                no4Var.b = 2;
                gyVar.y(2);
            }
            no4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !qi.isEmpty(this.b.getForum().getId())) {
                no4Var.j = this.b.getForum().getId();
            }
            gyVar.w(no4Var);
            gyVar.D(this.o);
            gyVar.z(this.o);
            gyVar.c(48);
            bVar.m(gyVar);
            ey j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.r(this.o);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cf6, com.baidu.tieba.cn
    /* renamed from: W */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kr4 kr4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kr4Var, threadCardViewHolder})) == null) {
            if (kr4Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            super.onFillViewHolder(i, view2, viewGroup, kr4Var, threadCardViewHolder);
            if (threadCardViewHolder.a() instanceof wl5) {
                threadCardViewHolder.a().b(this.m);
            }
            bf6.i(threadCardViewHolder.a().f(), this.b);
            boolean z = (kr4Var.t.getAuthor() == null || kr4Var.t.getAuthor().getUserId() == null || !kr4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (kr4Var.t.isSmartFrsThread() && kr4Var.t.getFeedBackReasonMap() != null && !z) {
                ux o = threadCardViewHolder.o(true);
                o.u(this.r);
                o.a(kr4Var.t.getNegFeedBackData());
            }
            threadCardViewHolder.r();
            threadCardViewHolder.e(kr4Var.t);
            threadCardViewHolder.h(this.q);
            threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            if (this.p != null) {
                FrsViewData frsViewData = this.b;
                kr4Var.t.statFloor = (kr4Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            gq6.k().c(this.p, kr4Var.t);
            eq6.o(kr4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                eq6.m(kr4Var.t, t());
                eq6.n(kr4Var.t, this.b.getForum().getId());
            }
            if (kr4Var != null) {
                kr4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.h06
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.xl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.hq6
    public fq6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : (fq6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h06
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.cf6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }
}
