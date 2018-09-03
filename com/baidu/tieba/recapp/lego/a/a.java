package com.baidu.tieba.recapp.lego.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes3.dex */
public class a {
    public static boolean F(Activity activity) {
        Resources resources;
        int identifier;
        if (!aRs() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean aRs() {
        return aRt() >= 14;
    }

    public static int aRt() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
