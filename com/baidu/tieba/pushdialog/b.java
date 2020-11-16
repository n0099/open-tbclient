package com.baidu.tieba.pushdialog;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.media.ExifInterface;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes20.dex */
public class b {
    public static boolean dyB() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        return !StringUtils.isNull(systemProperty) && com.baidu.adp.lib.f.b.toInt(systemProperty.replace(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ""), 0) >= 9;
    }

    public static boolean dyC() {
        PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
        try {
            if (packageManager.getActivityInfo(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.ScreenLockedActionControlActivity"), 0) != null) {
                return true;
            }
        } catch (PackageManager.NameNotFoundException e) {
            try {
                if (packageManager.getActivityInfo(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.StartBgActivityControlActivity"), 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        return false;
    }
}
