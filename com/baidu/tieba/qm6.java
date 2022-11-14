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
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class qm6 extends gj6<ThreadData, ThreadCardViewHolder<ThreadData>> implements j46, eu6, lq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public String m;
    public l46<ThreadData> n;
    public NEGFeedBackView.b o;

    @Override // com.baidu.tieba.j46
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.gj6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends l46<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm6 b;

        public a(qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                e46.b().d(true);
                jq5.c().h("page_recommend", "show_");
                if (view2 != null && threadData != null && !StringUtils.isNull(threadData.getTid())) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921dd) {
                        du6.k().h(eu6.p0, threadData, 13);
                    }
                    if (view2.getId() != R.id.obfuscated_res_0x7f092505 && view2.getId() != R.id.obfuscated_res_0x7f0924d7) {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            bu6.e(threadData, 15, this.b.mPageId, eu6.p0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                bu6.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0921f1) {
                            bu6.e(threadData, 5, this.b.mPageId, eu6.p0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                bu6.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091eee) {
                            bu6.e(threadData, 14, this.b.mPageId, eu6.p0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f090ef6) {
                            bu6.e(threadData, 12, this.b.mPageId, eu6.p0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f090f0f) {
                            bu6.e(threadData, 13, this.b.mPageId, eu6.p0, this.b.t());
                            return;
                        } else {
                            bu6.e(threadData, 1, this.b.mPageId, eu6.p0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                bu6.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        }
                    }
                    bu6.e(threadData, 2, this.b.mPageId, eu6.p0, this.b.t());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(pt4 pt4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pt4Var, compoundButton, z) == null) {
            }
        }

        public b(qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, pt4 pt4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, pt4Var) == null) && arrayList != null && pt4Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", pt4Var.c()).param("tid", pt4Var.f()).param("nid", pt4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", pt4Var.l).param("weight", pt4Var.k).param("ab_tag", pt4Var.p).param("extra", pt4Var.m).param("card_type", pt4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, pt4Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(pt4 pt4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pt4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", pt4Var.c()).param("tid", pt4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm6 a;

        public c(qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) {
                return;
            }
            this.a.W(view2, xnVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qm6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    @Override // com.baidu.tieba.lq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.j46
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public final void W(View view2, xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, xnVar) == null) && (xnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) xnVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((sr4) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).a().o(new zy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.x(this.mPageId);
            dxVar.z(this.c);
            bVar.o(dxVar);
            bVar.n(new bx(this.c.getPageActivity()));
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
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !xi.isEmpty(this.b.getForum().getId())) {
                yr4Var.j = this.b.getForum().getId();
            }
            qyVar.z(yr4Var);
            qyVar.C(3);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gj6, com.baidu.tieba.kn
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, threadData, threadCardViewHolder);
            if (threadData != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                du6.k().c(eu6.p0, threadData);
                threadCardViewHolder.a().b(this.m);
                threadCardViewHolder.a().q(i);
                if (this.l == 1) {
                    threadCardViewHolder.o(true).s(this.o);
                }
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.e(threadData);
                threadCardViewHolder.a().p(this.n);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.eu6
    public cu6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return eu6.p0;
        }
        return (cu6) invokeV.objValue;
    }
}
