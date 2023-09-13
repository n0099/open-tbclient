package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.CardPeiWanSegment;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class v18 extends pm<hq6, ThreadCardViewHolder<b15>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    @JvmField
    public BdUniqueId b;
    public in<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v18(TbPageContext<?> mPageContext, BdUniqueId bdUniqueId) {
        super(mPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPageContext, bdUniqueId};
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
        Intrinsics.checkNotNullParameter(mPageContext, "mPageContext");
        this.a = mPageContext;
    }

    public final void u(in<?> typeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, typeListView) == null) {
            Intrinsics.checkNotNullParameter(typeListView, "typeListView");
            this.c = typeListView;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public ThreadCardViewHolder<b15> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.a.getPageActivity(), false);
            CardPeiWanSegment cardPeiWanSegment = new CardPeiWanSegment(this.a);
            cardPeiWanSegment.p(this.b);
            bVar.l().j(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            cardPeiWanSegment.x(1);
            bVar.l().c(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005));
            bVar.l().g(0);
            bVar.l().f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005));
            bVar.l().e(0);
            bVar.l().i(0);
            bVar.m(cardPeiWanSegment);
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            Intrinsics.checkNotNullExpressionValue(k, "builder.build(BaseCardIn…, parent, mITypeListView)");
            ThreadCardViewHolder<b15> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hq6 hq6Var, ThreadCardViewHolder<b15> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Integer num;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hq6Var, threadCardViewHolder})) == null) {
            if (threadCardViewHolder != null) {
                threadCardViewHolder.e(hq6Var);
                oy<b15> cardView = threadCardViewHolder.a();
                if (cardView != null) {
                    Intrinsics.checkNotNullExpressionValue(cardView, "cardView");
                    cardView.r(i);
                    cardView.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
                }
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (hq6Var != null) {
                    num = Integer.valueOf(hq6Var.position);
                } else {
                    num = null;
                }
                StatisticItem addParam2 = addParam.addParam("obj_locate", String.valueOf(num));
                if (hq6Var != null) {
                    l = Long.valueOf(hq6Var.e());
                } else {
                    l = null;
                }
                StatisticItem addParam3 = addParam2.addParam(TiebaStatic.Params.OBJ_TO, String.valueOf(l));
                int i2 = 1;
                addParam3.addParam("obj_param1", (hq6Var == null || !hq6Var.d()) ? 0 : 0).eventStat();
            }
            if (threadCardViewHolder == null) {
                return null;
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
