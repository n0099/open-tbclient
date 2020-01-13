package com.baidu.tieba.recapp.lego.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes11.dex */
public class a {
    public static boolean ap(Activity activity) {
        Resources resources;
        int identifier;
        if (!caA() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", PraiseDataPassUtil.KEY_FROM_OS)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean caA() {
        return caB() >= 14;
    }

    public static int caB() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
