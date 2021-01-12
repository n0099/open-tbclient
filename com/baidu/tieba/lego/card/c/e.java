package com.baidu.tieba.lego.card.c;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes8.dex */
public class e {
    public static boolean ay(Activity activity) {
        Resources resources;
        int identifier;
        if (!cZO() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean cZO() {
        return cZP() >= 14;
    }

    public static int cZP() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
