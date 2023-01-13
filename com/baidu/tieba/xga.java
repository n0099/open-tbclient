package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import tv.athena.revenue.payui.view.AbsPayMessageReceiver;
/* loaded from: classes6.dex */
public class xga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            long nanoTime = System.nanoTime();
            Intent intent = new Intent("tv.athena.revenue.payui.release_all_pay_flow_ui_action");
            intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME, nanoTime);
            RLog.info("PayMessageHelper", "notifyReleaseAllPayFlowView releaseNanoTime:" + nanoTime);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            long nanoTime = System.nanoTime();
            Intent intent = new Intent("tv.athena.revenue.payui.release_all_pay_dialog_flow_ui_action");
            intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME, nanoTime);
            RLog.info("PayMessageHelper", "notifyReleaseDialogPayFlowView releaseNanoTime:" + nanoTime);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            long nanoTime = System.nanoTime();
            Intent intent = new Intent("tv.athena.revenue.payui.release_all_pay_wallet_flow_ui_action");
            intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME, nanoTime);
            RLog.info("PayMessageHelper", "notifyReleaseWalletPayFlowView releaseNanoTime:" + nanoTime);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void d(Context context, AbsPayMessageReceiver absPayMessageReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, absPayMessageReceiver) == null) {
            RLog.info("PayMessageHelper", MiPushClient.COMMAND_REGISTER);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("tv.athena.revenue.payui.release_all_pay_flow_ui_action");
            intentFilter.addAction("tv.athena.revenue.payui.release_all_pay_dialog_flow_ui_action");
            intentFilter.addAction("tv.athena.revenue.payui.release_all_pay_wallet_flow_ui_action");
            LocalBroadcastManager.getInstance(context).registerReceiver(absPayMessageReceiver, intentFilter);
        }
    }

    public static void e(Context context, AbsPayMessageReceiver absPayMessageReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, absPayMessageReceiver) == null) {
            RLog.info("PayMessageHelper", MiPushClient.COMMAND_UNREGISTER);
            LocalBroadcastManager.getInstance(context).unregisterReceiver(absPayMessageReceiver);
        }
    }
}
