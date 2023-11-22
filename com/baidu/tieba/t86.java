package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            return NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
        }
        return invokeL.booleanValue;
    }

    public static void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, tbPageContext) == null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", tbPageContext.getPageActivity().getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", tbPageContext.getPageActivity().getApplicationInfo().uid);
                intent.putExtra("app_package", tbPageContext.getPageActivity().getPackageName());
                intent.putExtra("app_uid", tbPageContext.getPageActivity().getApplicationInfo().uid);
                tbPageContext.getPageActivity().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", tbPageContext.getPageActivity().getPackageName(), null));
                tbPageContext.getPageActivity().startActivity(intent2);
            }
        }
    }
}
