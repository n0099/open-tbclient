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
import com.baidu.tieba.dy;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class j87 extends y47<ThreadData, ThreadCardViewHolder<ThreadData>> implements vg6, zf7, py5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;
    public String m;
    public xg6<ThreadData> n;
    public NEGFeedBackView.b o;

    @Override // com.baidu.tieba.vg6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.y47
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends xg6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j87 b;

        public a(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                qg6.b().d(true);
                ny5.c().h("page_recommend", "show_");
                if (view2 != null && threadData != null && !StringUtils.isNull(threadData.getTid())) {
                    if (view2.getId() == R.id.thread_card_root) {
                        yf7.k().h(zf7.q0, threadData, 13);
                    }
                    if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            wf7.e(threadData, 15, this.b.mPageId, zf7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                wf7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.thread_info_commont_container) {
                            wf7.e(threadData, 5, this.b.mPageId, zf7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                wf7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        } else if (view2.getId() == R.id.share_num_container) {
                            wf7.e(threadData, 14, this.b.mPageId, zf7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_agree) {
                            wf7.e(threadData, 12, this.b.mPageId, zf7.q0, this.b.t());
                            return;
                        } else if (view2.getId() == R.id.img_disagree) {
                            wf7.e(threadData, 13, this.b.mPageId, zf7.q0, this.b.t());
                            return;
                        } else {
                            wf7.e(threadData, 1, this.b.mPageId, zf7.q0, this.b.t());
                            if (this.b.b != null && this.b.b.getForum() != null) {
                                wf7.c(threadData, this.b.b.getForum().getId());
                                return;
                            }
                            return;
                        }
                    }
                    wf7.e(threadData, 2, this.b.mPageId, zf7.q0, this.b.t());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(hy4 hy4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hy4Var, compoundButton, z) == null) {
            }
        }

        public b(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
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
        public void a(ArrayList<Integer> arrayList, String str, hy4 hy4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, hy4Var) == null) && arrayList != null && hy4Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", hy4Var.c()).param("tid", hy4Var.f()).param("nid", hy4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", hy4Var.l).param("weight", hy4Var.k).param("ab_tag", hy4Var.p).param("extra", hy4Var.m).param("card_type", hy4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, hy4Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(hy4 hy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hy4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", hy4Var.c()).param("tid", hy4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements rn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j87 a;

        public c(j87 j87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j87Var;
        }

        @Override // com.baidu.tieba.rn
        public void b(View view2, hn hnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, hnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) {
                return;
            }
            this.a.Y(view2, hnVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j87(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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

    @Override // com.baidu.tieba.py5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.vg6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public final void Y(View view2, hn hnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, hnVar) == null) && (hnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = (ThreadData) hnVar;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((jw4) threadData, view2.getContext(), 3, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new oy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.c.getPageActivity());
            sw swVar = new sw(this.c.getPageActivity());
            swVar.x(this.mPageId);
            swVar.z(this.c);
            bVar.o(swVar);
            bVar.n(new qw(this.c.getPageActivity()));
            fy fyVar = new fy(this.c.getPageActivity());
            pw4 pw4Var = new pw4();
            if (100 == t().tabType) {
                pw4Var.b = 25;
                fyVar.B(19);
                fyVar.G(14);
            } else {
                pw4Var.b = 2;
                fyVar.B(2);
                fyVar.G(1);
            }
            pw4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !hi.isEmpty(this.b.getForum().getId())) {
                pw4Var.j = this.b.getForum().getId();
            }
            fyVar.z(pw4Var);
            fyVar.C(3);
            bVar.m(fyVar);
            dy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            k.s(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y47, com.baidu.tieba.um
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) threadData, (ThreadData) threadCardViewHolder);
            if (threadData != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                yf7.k().c(zf7.q0, threadData);
                threadCardViewHolder.a().b(this.m);
                threadCardViewHolder.a().r(i);
                if (this.l == 1) {
                    threadCardViewHolder.o(true).s(this.o);
                }
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.e(threadData);
                threadCardViewHolder.a().q(this.n);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.zf7
    public xf7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return zf7.q0;
        }
        return (xf7) invokeV.objValue;
    }
}
