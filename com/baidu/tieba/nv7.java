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
/* loaded from: classes7.dex */
public class nv7 extends kn<fp6, CardViewHolder<ao6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ao6 c;
    public String d;
    public qo6 e;

    /* loaded from: classes7.dex */
    public class a extends qo6<fp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv7 b;

        public a(nv7 nv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, fp6 fp6Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fp6Var) == null) && view2 != null && this.b.c != null && this.b.c.h() != null && fp6Var != null && fp6Var.getThreadData() != null && !StringUtils.isNull(fp6Var.getThreadData().getTid())) {
                int i = 1;
                if (view2 == this.b.c.M()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    i = 2;
                }
                kv7.b(view2, fp6Var, i);
                if (view2 != this.b.c.l.getCommentContainer() && view2 != this.b.c.m.getCommentContainer()) {
                    if (this.b.c.M() != null && view2.getId() == this.b.c.M().getId() && fp6Var.getThreadData() != null && fp6Var.getThreadData().getThreadAlaInfo() != null && fp6Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                        ThreadData threadData = fp6Var.getThreadData();
                        AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                        int calculateLiveType = YYLiveUtil.calculateLiveType(fp6Var.getThreadData().getThreadAlaInfo());
                        String str = null;
                        if (!StringUtils.isNull(fp6Var.getThreadData().getThreadAlaInfo().appId)) {
                            str = fp6Var.getThreadData().getThreadAlaInfo().appId;
                        }
                        if (fp6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
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
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c12942");
                statisticItem2.param("obj_locate", 7);
                statisticItem2.param("obj_type", 5);
                statisticItem2.param("tid", fp6Var.getThreadData().getTid());
                statisticItem2.param("nid", fp6Var.getThreadData().getNid());
                wr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                if (findPageExtraByView != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nv7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public CardViewHolder<ao6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ao6 ao6Var = new ao6(this.b, this.a);
            this.c = ao6Var;
            ao6Var.a0(true);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.Z(bdUniqueId);
            }
            return new CardViewHolder<>(this.c);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, fp6 fp6Var, CardViewHolder<ao6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fp6Var, cardViewHolder})) == null) {
            String str = null;
            if (fp6Var == null || cardViewHolder == null || cardViewHolder.a() == null) {
                return null;
            }
            fp6Var.B(i + 1);
            int i2 = 0;
            StatisticItem b0 = fp6Var.b0("c12351");
            if (fp6Var.getThreadData() != null && fp6Var.getThreadData().getThreadAlaInfo() != null) {
                i2 = YYLiveUtil.calculateLiveType(fp6Var.getThreadData().getThreadAlaInfo());
                if (fp6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(b0, fp6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                b0.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            }
            jo6.b().a(b0);
            if (cardViewHolder.a() instanceof o56) {
                cardViewHolder.a().b(this.d);
            }
            cardViewHolder.a().i(fp6Var);
            cardViewHolder.a().k(this.e);
            if (fp6Var.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", fp6Var.getThreadData().getFid());
                statisticItem.param("fname", fp6Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", fp6Var.getThreadData().getTid());
                if (fp6Var.getThreadData().getThreadAlaInfo() != null) {
                    if (!StringUtils.isNull(fp6Var.getThreadData().getThreadAlaInfo().appId)) {
                        str = fp6Var.getThreadData().getThreadAlaInfo().appId;
                    }
                    if (fp6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, fp6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
