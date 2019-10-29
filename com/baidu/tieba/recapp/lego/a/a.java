package com.baidu.tieba.recapp.lego.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
/* loaded from: classes3.dex */
public class a {
    public static boolean aj(Activity activity) {
        Resources resources;
        int identifier;
        if (!bIe() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", "android")) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean bIe() {
        return bIf() >= 14;
    }

    public static int bIf() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
