package com.baidu.tieba.lego.card.c;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes9.dex */
public class e {
    public static boolean ar(Activity activity) {
        Resources resources;
        int identifier;
        if (!dbM() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean dbM() {
        return dbN() >= 14;
    }

    public static int dbN() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
