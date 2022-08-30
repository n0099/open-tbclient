package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ey;
import com.baidu.tieba.py;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sj6 extends cf6<kr4, ThreadCardViewHolder<ThreadData>> implements h06, hq6, xl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public j06<ThreadData> p;

    /* loaded from: classes5.dex */
    public class a extends j06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sj6 b;

        public a(sj6 sj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (this.b.i != null) {
                this.b.i.b(view2, threadData, this.b.getType());
            }
            if ("c13010".equals(this.b.l)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092459 && view2.getId() != R.id.obfuscated_res_0x7f09242b) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092141) {
                    eq6.e(threadData, 5, this.b.mPageId, hq6.p0, this.b.t());
                    pr6.g(threadData, this.b.b, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e45) {
                    eq6.e(threadData, 14, this.b.mPageId, hq6.p0, this.b.t());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.p.a instanceof Boolean) {
                        if (((Boolean) this.b.p.a).booleanValue()) {
                            eq6.e(threadData, 1, this.b.mPageId, hq6.p0, this.b.t());
                        } else {
                            eq6.e(threadData, 3, this.b.mPageId, hq6.p0, this.b.t());
                        }
                    }
                    pr6.g(threadData, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    eq6.e(threadData, 15, this.b.mPageId, hq6.p0, this.b.t());
                    pr6.g(threadData, this.b.b, 1);
                } else {
                    eq6.e(threadData, 1, this.b.mPageId, hq6.p0, this.b.t());
                    pr6.g(threadData, this.b.b, 1);
                }
            } else {
                eq6.e(threadData, 2, this.b.mPageId, hq6.p0, this.b.t());
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f092459 && view2.getId() != R.id.obfuscated_res_0x7f09242b) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0904f3) {
                    pr6.a(hq6.p0, threadData.getRecomReason());
                    return;
                } else if (view2 instanceof TbImageView) {
                    if (this.b.p.a instanceof Boolean) {
                        if (((Boolean) this.b.p.a).booleanValue()) {
                            gq6.k().h(hq6.p0, threadData, 1);
                            return;
                        } else {
                            gq6.k().h(hq6.p0, threadData, 3);
                            return;
                        }
                    }
                    return;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09053c) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    return;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09212f) {
                    gq6.k().h(hq6.p0, threadData, 5);
                    return;
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().V() != null && threadData.getTopAgreePost().V().B() != null && threadData.getTopAgreePost().V().B().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    gq6.k().h(hq6.p0, threadData, i);
                    return;
                } else {
                    gq6.k().h(hq6.p0, threadData, 1);
                    return;
                }
            }
            gq6.k().h(hq6.p0, threadData, 2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sj6 a;

        public b(sj6 sj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sj6Var;
        }

        @Override // com.baidu.tieba.zn
        public void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (pnVar instanceof kr4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((kr4) pnVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((ho4) threadData, view2.getContext(), 3, false);
                threadCardViewHolder.a().o(new py.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sj6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new a(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: U */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            ey.b bVar = new ey.b(this.c.getPageActivity(), false);
            rx rxVar = new rx(this.c.getPageActivity());
            rxVar.r("frs");
            rxVar.s(this.n);
            if (this.o == 502) {
                rxVar.t(false);
            } else {
                rxVar.t(true);
            }
            bVar.n(rxVar);
            ey k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            threadCardViewHolder.n(false);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cf6, com.baidu.tieba.cn
    /* renamed from: V */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kr4 kr4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kr4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, kr4Var, threadCardViewHolder);
            if (kr4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.a().b(this.m);
            threadCardViewHolder.a().q(i);
            bf6.i(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                kr4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.e(kr4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.p);
            kr4Var.t.updateShowStatus();
            rx rxVar = (rx) threadCardViewHolder.a().g();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rxVar.f.d.getLayoutParams();
            layoutParams.width = kr4Var.u;
            layoutParams.height = kr4Var.v;
            if (rxVar.f.d.getVisibility() != 8) {
                rxVar.f.d.setLayoutParams(layoutParams);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? hq6.p0 : (fq6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h06
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.cf6
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.baidu.tieba.cf6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.n = z;
        }
    }
}
