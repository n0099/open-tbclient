package com.baidu.tieba.recapp.lego.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
/* loaded from: classes3.dex */
public class a {
    public static boolean ao(Activity activity) {
        Resources resources;
        int identifier;
        if (!bHM() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", "android")) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean bHM() {
        return bHN() >= 14;
    }

    public static int bHN() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
