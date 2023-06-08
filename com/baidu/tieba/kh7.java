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
import com.baidu.tieba.jz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.uz;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class kh7 extends id7<n45, ThreadCardViewHolder<ThreadData>> implements eo6, oo7, f56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public boolean n;
    public int o;
    public mo7 p;
    public go6<ThreadData> q;
    public NEGFeedBackView.b r;

    @Override // com.baidu.tieba.eo6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends go6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 b;

        public a(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        lo7.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                        er7.g(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        lo7.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        lo7.e(threadData, 12, this.b.mPageId, this.b.p, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        lo7.e(threadData, 13, this.b.mPageId, this.b.p, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.q.a instanceof Boolean) {
                            if (((Boolean) this.b.q.a).booleanValue()) {
                                lo7.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                            } else {
                                lo7.e(threadData, 3, this.b.mPageId, this.b.p, this.b.t());
                            }
                        }
                        er7.g(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        lo7.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                        er7.g(threadData, this.b.b, 1);
                    } else {
                        lo7.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                        er7.g(threadData, this.b.b, 1);
                    }
                } else {
                    lo7.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else {
                        no7.k().h(this.b.p, threadData, 7);
                        return;
                    }
                }
                no7.k().h(this.b.p, threadData, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(g35 g35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g35Var, compoundButton, z) == null) {
            }
        }

        public b(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
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
        public void a(ArrayList<Integer> arrayList, String str, g35 g35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, g35Var) == null) && arrayList != null && g35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", g35Var.c()).param("tid", g35Var.f()).param("nid", g35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", g35Var.l).param("weight", g35Var.k).param("ab_tag", g35Var.p).param("extra", g35Var.m).param("card_type", g35Var.o).param(TiebaStatic.Params.OBJ_FLOOR, g35Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(g35 g35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g35Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", g35Var.c()).param("tid", g35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.xx.b
        public void a(h15 h15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, h15Var, view2) == null) && h15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    h15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    h15Var.objType = 4;
                } else {
                    h15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh7 a;

        public d(kh7 kh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kh7Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof n45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((n45) vnVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((h15) threadData, view2.getContext(), this.a.o, false);
                threadCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new mo7();
        this.q = new a(this);
        this.r = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.f56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.eo6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.id7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.l.getPageActivity());
            xx xxVar = new xx(this.l.getPageActivity());
            xxVar.z(this.mPageId);
            xxVar.f(4272);
            xxVar.y(new c(this));
            bVar.o(xxVar);
            bVar.n(new sy(this.l.getPageActivity()));
            jy jyVar = new jy(this.l.getPageActivity());
            jyVar.D(this.n);
            jyVar.C("frs");
            bVar.h(jyVar);
            lz lzVar = new lz(this.l.getPageActivity());
            n15 n15Var = new n15();
            if (100 == t().tabType) {
                n15Var.b = 25;
                lzVar.D(19);
            } else {
                n15Var.b = 2;
                lzVar.D(2);
            }
            n15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !ui.isEmpty(this.b.getForum().getId())) {
                n15Var.j = this.b.getForum().getId();
            }
            lzVar.B(n15Var);
            lzVar.I(this.o);
            lzVar.E(this.o);
            lzVar.f(48);
            bVar.m(lzVar);
            jz j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.s(this.o);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.n();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.id7, com.baidu.tieba.in
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n45 n45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n45Var, threadCardViewHolder})) == null) {
            if (n45Var != null && threadCardViewHolder != null && threadCardViewHolder.a() != null) {
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) n45Var, (n45) threadCardViewHolder);
                if (threadCardViewHolder.a() instanceof e56) {
                    threadCardViewHolder.a().b(this.m);
                }
                hd7.i(threadCardViewHolder.a().f(), this.b);
                int i2 = 0;
                if (n45Var.t.getAuthor() != null && n45Var.t.getAuthor().getUserId() != null && n45Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (n45Var.t.isSmartFrsThread() && n45Var.t.getFeedBackReasonMap() != null && !z) {
                    zy p = threadCardViewHolder.p(true);
                    p.s(this.r);
                    p.a(n45Var.t.getNegFeedBackData());
                }
                threadCardViewHolder.s();
                threadCardViewHolder.e(n45Var.t);
                threadCardViewHolder.h(this.q);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                if (this.p != null) {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null) {
                        i2 = frsViewData.getTopThreadSize();
                    }
                    n45Var.t.statFloor = (n45Var.position + 1) - i2;
                }
                no7.k().c(this.p, n45Var.t);
                lo7.p(n45Var.t, this.mPageId, this.p, t());
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null && frsViewData2.getForum() != null) {
                    lo7.n(n45Var.t, t());
                    lo7.o(n45Var.t, this.b.getForum().getId());
                }
                if (n45Var != null) {
                    n45Var.t.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.oo7
    public mo7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (mo7) invokeV.objValue;
    }
}
