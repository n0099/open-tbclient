package com.baidu.tieba;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context == null || str == null) {
                return null;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    bundle = applicationInfo.metaData;
                } else {
                    bundle = null;
                }
                if (bundle == null) {
                    return null;
                }
                return bundle.getString(str);
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
