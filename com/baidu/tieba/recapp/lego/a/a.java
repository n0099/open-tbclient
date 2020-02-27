package com.baidu.tieba.recapp.lego.a;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes13.dex */
public class a {
    public static boolean aq(Activity activity) {
        Resources resources;
        int identifier;
        if (!ccb() || (identifier = (resources = activity.getResources()).getIdentifier("config_showNavigationBar", "bool", PraiseDataPassUtil.KEY_FROM_OS)) <= 0) {
            return false;
        }
        return resources.getBoolean(identifier);
    }

    public static boolean ccb() {
        return ccc() >= 14;
    }

    public static int ccc() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
