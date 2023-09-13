package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wda extends pm<yda, CardViewHolder<pea>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public mp6<yda> b;

    /* loaded from: classes8.dex */
    public class a extends mp6<yda> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wda b;

        public a(wda wdaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wdaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wdaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, yda ydaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ydaVar) == null) && ydaVar != null && (this.b.a.getPageActivity() instanceof ForumSquareActivity)) {
                String className = ((ForumSquareActivity) this.b.a.getPageActivity()).o1().getClassName();
                if (!"推荐".equals(className)) {
                    StatisticItem statisticItem = new StatisticItem("c13652");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("fid", ydaVar.a);
                    statisticItem.param("resource_id", className);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c13643");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("fid", ydaVar.a);
                statisticItem2.param("obj_locate", 3);
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wda(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), yda.h);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.b = new a(this);
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public CardViewHolder<pea> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            pea peaVar = new pea(this.a);
            peaVar.l(this.mPageId);
            return new CardViewHolder<>(peaVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yda ydaVar, CardViewHolder<pea> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ydaVar, cardViewHolder})) == null) {
            if (ydaVar != null && cardViewHolder != null && cardViewHolder.a() != null) {
                cardViewHolder.a().i(ydaVar);
                cardViewHolder.a().k(this.b);
                if (this.a.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.a.getPageActivity()).o1().getClassName();
                    if (!"推荐".equals(className)) {
                        StatisticItem statisticItem = new StatisticItem("c13651");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", ydaVar.a);
                        statisticItem.param("resource_id", className);
                        TiebaStatic.log(statisticItem);
                    } else {
                        StatisticItem statisticItem2 = new StatisticItem("c13642");
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("fid", ydaVar.d());
                        statisticItem2.param("obj_locate", 3);
                        TiebaStatic.log(statisticItem2);
                    }
                }
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
