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
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ld8 extends bi<om6, ThreadCardViewHolder<om6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ui c;

    /* loaded from: classes7.dex */
    public class a implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt a;

        public a(ld8 ld8Var, kt ktVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld8Var, ktVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ktVar;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            om6 om6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = oiVar instanceof om6;
                int i2 = 0;
                if (z && (om6Var = (om6) oiVar) != null && om6Var.u && (threadData = om6Var.a) != null && threadData.getItem() != null) {
                    int intValue = om6Var.a.getItem().button_link_type.intValue();
                    if (om6Var.a.getItem().apk_detail != null) {
                        i2 = om6Var.a.getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = d65.a(intValue, i2);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(om6Var.a.getItem());
                    ItemCardHelper.q(this.a.z(), om6Var.a.getItem().item_id.longValue(), this.a.y(itemData), om6Var.a.getTid(), a, "", 2);
                    ItemClickJumpUtil.itemClickJump(om6Var.a.getItem().forum_name, String.valueOf(om6Var.a.getItem().item_id), 1, 1);
                } else if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    om6 om6Var2 = (om6) oiVar;
                    om6Var2.f = 1;
                    ThreadCardUtils.jumpToPB((bw4) om6Var2, view2.getContext(), 4, false);
                    ((ThreadCardViewHolder) view2.getTag()).a().q(new mu.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ld8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void x(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uiVar) == null) {
            this.c = uiVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: t */
    public ThreadCardViewHolder<om6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.b.getPageActivity(), false);
            kt ktVar = new kt(this.b.getPageActivity());
            ktVar.B(true);
            ktVar.E(1);
            ktVar.x();
            bVar.h(ktVar);
            bu k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.t(2);
            ThreadCardViewHolder<om6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new a(this, ktVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, om6 om6Var, ThreadCardViewHolder<om6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, om6Var, threadCardViewHolder})) == null) {
            if (om6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && om6Var.a != null) {
                om6Var.A(om6Var.position + 1);
                om6Var.a.statFloor = om6Var.h();
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.e(om6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
