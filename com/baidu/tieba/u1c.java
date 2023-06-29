package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.searchbox.IntentConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public class u1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            if (context == null) {
                RLog.error("PayOpenTaobaoUtils", "openWebTaobao error context null", new Object[0]);
                return;
            }
            context.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
            RLog.info("PayOpenTaobaoUtils", "openTopenWebTaobaoaobao web success");
        }
    }
}
