package com.baidu.tieba.yunpush;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes2.dex */
public class k {
    public static String getMetaValue(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
