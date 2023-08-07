package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes6.dex */
public class j8c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2, CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65536, null, i, i2, cancelType) == null) {
            if (cancelType == CancelType.BUTTOM_AREA_CLICK) {
                f9c.b(i, i2, PayUIEventType.purchaseclose_bt);
                RLog.info("PayDialogStatistic", PayUIEventType.purchaseclose_bt);
            } else if (cancelType == CancelType.EMPTY_AREA_CLICK) {
                f9c.b(i, i2, PayUIEventType.purchaseclose_transparent);
                RLog.info("PayDialogStatistic", PayUIEventType.purchaseclose_transparent);
            }
        }
    }

    public static void b(int i, int i2, CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65537, null, i, i2, cancelType) == null) {
            if (cancelType == CancelType.BUTTOM_AREA_CLICK) {
                f9c.b(i, i2, PayUIEventType.paypageclose_bt);
                RLog.info("PayDialogStatistic", PayUIEventType.paypageclose_bt);
            } else if (cancelType == CancelType.EMPTY_AREA_CLICK) {
                f9c.b(i, i2, PayUIEventType.paypageclose_transparent);
                RLog.info("PayDialogStatistic", PayUIEventType.paypageclose_transparent);
            }
        }
    }
}
