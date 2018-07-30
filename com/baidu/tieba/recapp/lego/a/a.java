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
        if (!aRv() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean aRv() {
        return aRw() >= 14;
    }

    public static int aRw() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
