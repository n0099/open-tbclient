package com.baidu.tieba;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
            if (StringUtils.isNull(systemProperty) || tg.e(systemProperty.replace(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ""), 0) < 9) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
            try {
                try {
                } catch (PackageManager.NameNotFoundException unused) {
                    if (packageManager.getActivityInfo(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.StartBgActivityControlActivity"), 0) != null) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (packageManager.getActivityInfo(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.ScreenLockedActionControlActivity"), 0) != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
