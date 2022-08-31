package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes6.dex */
public class xu6 extends cn<s06, CardViewHolder<qz5>> implements vl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public qz5 c;
    public String d;
    public h06 e;

    /* loaded from: classes6.dex */
    public class a extends h06<s06> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu6 b;

        public a(xu6 xu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h06
        /* renamed from: d */
        public void a(View view2, s06 s06Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, s06Var) == null) || view2 == null || this.b.c == null || this.b.c.h() == null || s06Var == null || s06Var.getThreadData() == null || StringUtils.isNull(s06Var.getThreadData().getTid())) {
                return;
            }
            tu6.b(view2, s06Var, view2 == this.b.c.M() ? 1 : 2);
            if (view2 != this.b.c.l.getCommentContainer() && view2 != this.b.c.m.getCommentContainer()) {
                if (this.b.c.M() == null || view2.getId() != this.b.c.M().getId() || s06Var.getThreadData() == null || s06Var.getThreadData().getThreadAlaInfo() == null || !s06Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                    return;
                }
                ThreadData threadData = s06Var.getThreadData();
                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                int calculateLiveType = YYLiveUtil.calculateLiveType(s06Var.getThreadData().getThreadAlaInfo());
                String str = StringUtils.isNull(s06Var.getThreadData().getThreadAlaInfo().appId) ? null : s06Var.getThreadData().getThreadAlaInfo().appId;
                if (s06Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_CLICK);
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("fname", threadData.getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_type", threadData.getYYStaticticType());
                statisticItem.param("obj_param1", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem, threadAlaInfo.mYyExtData);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c12942");
            statisticItem2.param("obj_locate", 7);
            statisticItem2.param("obj_type", 5);
            statisticItem2.param("tid", s06Var.getThreadData().getTid());
            statisticItem2.param("nid", s06Var.getThreadData().getNid());
            t95 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
            if (findPageExtraByView != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xu6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.vl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: t */
    public CardViewHolder<qz5> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            qz5 qz5Var = new qz5(this.b, this.a);
            this.c = qz5Var;
            qz5Var.Z(true);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.c);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, s06 s06Var, CardViewHolder<qz5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, s06Var, cardViewHolder})) == null) {
            if (s06Var == null || cardViewHolder == null || cardViewHolder.a() == null) {
                return null;
            }
            s06Var.I(i + 1);
            int i2 = 0;
            StatisticItem Z = s06Var.Z("c12351");
            if (s06Var.getThreadData() != null && s06Var.getThreadData().getThreadAlaInfo() != null) {
                i2 = YYLiveUtil.calculateLiveType(s06Var.getThreadData().getThreadAlaInfo());
                if (s06Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(Z, s06Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                Z.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            }
            a06.b().a(Z);
            if (cardViewHolder.a() instanceof ul5) {
                cardViewHolder.a().b(this.d);
            }
            cardViewHolder.a().i(s06Var);
            cardViewHolder.a().n(this.e);
            if (s06Var.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", s06Var.getThreadData().getFid());
                statisticItem.param("fname", s06Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", s06Var.getThreadData().getTid());
                if (s06Var.getThreadData().getThreadAlaInfo() != null) {
                    String str = StringUtils.isNull(s06Var.getThreadData().getThreadAlaInfo().appId) ? null : s06Var.getThreadData().getThreadAlaInfo().appId;
                    if (s06Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, s06Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
