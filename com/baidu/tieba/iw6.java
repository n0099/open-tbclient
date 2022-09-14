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
/* loaded from: classes4.dex */
public class iw6 extends qn<j26, CardViewHolder<e16>> implements go5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public e16 c;
    public String d;
    public v16 e;

    /* loaded from: classes4.dex */
    public class a extends v16<j26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw6 b;

        public a(iw6 iw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, j26 j26Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, j26Var) == null) || view2 == null || this.b.c == null || this.b.c.h() == null || j26Var == null || j26Var.getThreadData() == null || StringUtils.isNull(j26Var.getThreadData().getTid())) {
                return;
            }
            ew6.b(view2, j26Var, view2 == this.b.c.M() ? 1 : 2);
            if (view2 != this.b.c.l.getCommentContainer() && view2 != this.b.c.m.getCommentContainer()) {
                if (this.b.c.M() == null || view2.getId() != this.b.c.M().getId() || j26Var.getThreadData() == null || j26Var.getThreadData().getThreadAlaInfo() == null || !j26Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                    return;
                }
                ThreadData threadData = j26Var.getThreadData();
                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                int calculateLiveType = YYLiveUtil.calculateLiveType(j26Var.getThreadData().getThreadAlaInfo());
                String str = StringUtils.isNull(j26Var.getThreadData().getThreadAlaInfo().appId) ? null : j26Var.getThreadData().getThreadAlaInfo().appId;
                if (j26Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
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
            statisticItem2.param("tid", j26Var.getThreadData().getTid());
            statisticItem2.param("nid", j26Var.getThreadData().getNid());
            bc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    public iw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.go5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: t */
    public CardViewHolder<e16> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            e16 e16Var = new e16(this.b, this.a);
            this.c = e16Var;
            e16Var.Z(true);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.c);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, j26 j26Var, CardViewHolder<e16> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, j26Var, cardViewHolder})) == null) {
            if (j26Var == null || cardViewHolder == null || cardViewHolder.a() == null) {
                return null;
            }
            j26Var.I(i + 1);
            int i2 = 0;
            StatisticItem Z = j26Var.Z("c12351");
            if (j26Var.getThreadData() != null && j26Var.getThreadData().getThreadAlaInfo() != null) {
                i2 = YYLiveUtil.calculateLiveType(j26Var.getThreadData().getThreadAlaInfo());
                if (j26Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(Z, j26Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                Z.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            }
            o16.b().a(Z);
            if (cardViewHolder.a() instanceof fo5) {
                cardViewHolder.a().b(this.d);
            }
            cardViewHolder.a().i(j26Var);
            cardViewHolder.a().n(this.e);
            if (j26Var.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", j26Var.getThreadData().getFid());
                statisticItem.param("fname", j26Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", j26Var.getThreadData().getTid());
                if (j26Var.getThreadData().getThreadAlaInfo() != null) {
                    String str = StringUtils.isNull(j26Var.getThreadData().getThreadAlaInfo().appId) ? null : j26Var.getThreadData().getThreadAlaInfo().appId;
                    if (j26Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, j26Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
