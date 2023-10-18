package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p08 extends lh<rk6, ThreadCardViewHolder<rk6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ei c;

    /* loaded from: classes7.dex */
    public class a implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts a;

        public a(p08 p08Var, ts tsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p08Var, tsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tsVar;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            rk6 rk6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = yhVar instanceof rk6;
                int i2 = 0;
                if (z && (rk6Var = (rk6) yhVar) != null && rk6Var.u && (threadData = rk6Var.a) != null && threadData.getItem() != null) {
                    int intValue = rk6Var.a.getItem().button_link_type.intValue();
                    if (rk6Var.a.getItem().apk_detail != null) {
                        i2 = rk6Var.a.getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = i55.a(intValue, i2);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(rk6Var.a.getItem());
                    ItemCardHelper.q(this.a.B(), rk6Var.a.getItem().item_id.longValue(), this.a.A(itemData), rk6Var.a.getTid(), a, "", 2);
                    ItemClickJumpUtil.itemClickJump(rk6Var.a.getItem().forum_name, String.valueOf(rk6Var.a.getItem().item_id), 1, 1);
                } else if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    rk6 rk6Var2 = (rk6) yhVar;
                    rk6Var2.f = 1;
                    ThreadCardUtils.jumpToPB((jv4) rk6Var2, view2.getContext(), 4, false);
                    ((ThreadCardViewHolder) view2.getTag()).a().q(new vt.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    public void u(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eiVar) == null) {
            this.c = eiVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: s */
    public ThreadCardViewHolder<rk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            ts tsVar = new ts(this.b.getPageActivity());
            tsVar.D(true);
            tsVar.G(1);
            tsVar.z();
            bVar.h(tsVar);
            kt k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.t(2);
            ThreadCardViewHolder<rk6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new a(this, tsVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, rk6 rk6Var, ThreadCardViewHolder<rk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, rk6Var, threadCardViewHolder})) == null) {
            if (rk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && rk6Var.a != null) {
                rk6Var.A(rk6Var.position + 1);
                rk6Var.a.statFloor = rk6Var.h();
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.e(rk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
