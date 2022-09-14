package com.baidu.tieba;

import android.app.Dialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class n4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Dialog dialog, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, dialog, payDialogType) == null) {
            RLog.info("DialogUtils", "onPayFlow closeDialogAndContinueFlow payDialogType:" + payDialogType);
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        }
    }

    public static void b(Dialog dialog, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, dialog, payDialogType) == null) {
            RLog.info("DialogUtils", "onPayFlow closeDialogAndInterrupteFlow payDialogType:" + payDialogType);
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.cancel();
        }
    }
}
