package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ui6 extends af6<ThreadData, ThreadCardViewHolder<ThreadData>> implements f06, fq6, vl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public String m;
    public h06<ThreadData> n;
    public NEGFeedBackView.b o;

    /* loaded from: classes6.dex */
    public class a extends h06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui6 b;

        public a(ui6 ui6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ui6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                a06.b().d(true);
                tl5.c().h("page_recommend", "show_");
                if (view2 == null || threadData == null || StringUtils.isNull(threadData.getTid())) {
                    return;
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09212d) {
                    eq6.k().h(fq6.p0, threadData, 13);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f092459 && view2.getId() != R.id.obfuscated_res_0x7f09242b) {
                    if (view2 instanceof ThreadGodReplyLayout) {
                        cq6.e(threadData, 15, this.b.mPageId, fq6.p0, this.b.t());
                        if (this.b.b == null || this.b.b.getForum() == null) {
                            return;
                        }
                        cq6.c(threadData, this.b.b.getForum().getId());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f092141) {
                        cq6.e(threadData, 5, this.b.mPageId, fq6.p0, this.b.t());
                        if (this.b.b == null || this.b.b.getForum() == null) {
                            return;
                        }
                        cq6.c(threadData, this.b.b.getForum().getId());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091e45) {
                        cq6.e(threadData, 14, this.b.mPageId, fq6.p0, this.b.t());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090eab) {
                        cq6.e(threadData, 12, this.b.mPageId, fq6.p0, this.b.t());
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec3) {
                        cq6.e(threadData, 13, this.b.mPageId, fq6.p0, this.b.t());
                        return;
                    } else {
                        cq6.e(threadData, 1, this.b.mPageId, fq6.p0, this.b.t());
                        if (this.b.b == null || this.b.b.getForum() == null) {
                            return;
                        }
                        cq6.c(threadData, this.b.b.getForum().getId());
                        return;
                    }
                }
                cq6.e(threadData, 2, this.b.mPageId, fq6.p0, this.b.t());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ui6 ui6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, dq4Var) == null) || arrayList == null || dq4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", dq4Var.c()).param("tid", dq4Var.f()).param("nid", dq4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", dq4Var.l).param("weight", dq4Var.k).param("ab_tag", dq4Var.p).param("extra", dq4Var.m).param("card_type", dq4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, dq4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(dq4 dq4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", dq4Var.c()).param("tid", dq4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui6 a;

        public c(ui6 ui6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.W(view2, pnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ui6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.n = new a(this);
        this.o = new b(this);
        this.c = tbPageContext;
    }

    public final void W(View view2, pn pnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, pnVar) == null) && (pnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) pnVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((go4) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new py.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity());
            vw vwVar = new vw(this.c.getPageActivity());
            vwVar.u(this.mPageId);
            vwVar.w(this.c);
            bVar.o(vwVar);
            bVar.n(new tw(this.c.getPageActivity()));
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
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !qi.isEmpty(this.b.getForum().getId())) {
                mo4Var.j = this.b.getForum().getId();
            }
            gyVar.w(mo4Var);
            gyVar.z(3);
            bVar.m(gyVar);
            ey k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.af6, com.baidu.tieba.cn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, threadData, threadCardViewHolder);
            if (threadData == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            eq6.k().c(fq6.p0, threadData);
            threadCardViewHolder.a().b(this.m);
            threadCardViewHolder.a().q(i);
            if (this.l == 1) {
                threadCardViewHolder.o(true).u(this.o);
            }
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.e(threadData);
            threadCardViewHolder.a().p(this.n);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.f06
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.vl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.fq6
    public dq6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? fq6.p0 : (dq6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f06
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    @Override // com.baidu.tieba.af6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }
}
