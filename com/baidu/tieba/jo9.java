package com.baidu.tieba;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, tbPageContext) == null) {
            PayPanelUtils.launchPayPanel(tbPageContext, IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING);
        }
    }
}
