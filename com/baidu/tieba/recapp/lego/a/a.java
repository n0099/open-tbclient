package com.baidu.tieba.recapp.lego.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.ar.util.Constants;
/* loaded from: classes3.dex */
public class a {
    public static boolean D(Activity activity) {
        Resources resources;
        int identifier;
        if (!aKS() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", Constants.OS_TYPE_VALUE)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean aKS() {
        return aKT() >= 14;
    }

    public static int aKT() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
