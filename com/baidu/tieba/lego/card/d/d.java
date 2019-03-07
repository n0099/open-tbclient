package com.baidu.tieba.lego.card.d;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
/* loaded from: classes2.dex */
public class d {
    public static boolean al(Activity activity) {
        Resources resources;
        int identifier;
        if (!bAb() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", "android")) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean bAb() {
        return bAc() >= 14;
    }

    public static int bAc() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
