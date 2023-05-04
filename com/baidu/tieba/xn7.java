package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xn7 extends vm<xi6, CardViewHolder<sh6>> implements qz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public sh6 c;
    public String d;
    public ji6 e;

    /* loaded from: classes7.dex */
    public class a extends ji6<xi6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn7 b;

        public a(xn7 xn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ji6
        /* renamed from: d */
        public void a(View view2, xi6 xi6Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xi6Var) == null) && view2 != null && this.b.c != null && this.b.c.h() != null && xi6Var != null && xi6Var.getThreadData() != null && !StringUtils.isNull(xi6Var.getThreadData().getTid())) {
                int i = 1;
                if (view2 == this.b.c.N()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    i = 2;
                }
                vn7.b(view2, xi6Var, i);
                if (view2 == this.b.c.l.getCommentContainer() || view2 == this.b.c.m.getCommentContainer()) {
                    StatisticItem statisticItem = new StatisticItem("c12942");
                    statisticItem.param("obj_locate", 7);
                    statisticItem.param("obj_type", 5);
                    statisticItem.param("tid", xi6Var.getThreadData().getTid());
                    statisticItem.param("nid", xi6Var.getThreadData().getNid());
                    zl5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                    if (findPageExtraByView != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xn7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.qz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: t */
    public CardViewHolder<sh6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            sh6 sh6Var = new sh6(this.b, this.a);
            this.c = sh6Var;
            sh6Var.V(true);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.U(bdUniqueId);
            }
            return new CardViewHolder<>(this.c);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xi6 xi6Var, CardViewHolder<sh6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xi6Var, cardViewHolder})) == null) {
            if (xi6Var != null && cardViewHolder != null && cardViewHolder.a() != null) {
                xi6Var.B(i + 1);
                StatisticItem Z = xi6Var.Z("c12351");
                if (xi6Var.getThreadData() != null && xi6Var.getThreadData().getThreadAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(xi6Var.getThreadData().getThreadAlaInfo());
                    if (xi6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(Z, xi6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    }
                    Z.param(TiebaStatic.Params.OBJ_PARAM3, calculateLiveType);
                }
                ci6.b().a(Z);
                if (cardViewHolder.a() instanceof pz5) {
                    cardViewHolder.a().b(this.d);
                }
                cardViewHolder.a().i(xi6Var);
                cardViewHolder.a().k(this.e);
                if (xi6Var.getThreadData() != null && xi6Var.getThreadData().getThreadAlaInfo() != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_param1", xi6Var.getThreadData().getThreadAlaInfo().live_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                }
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
