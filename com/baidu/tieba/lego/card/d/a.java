package com.baidu.tieba.lego.card.d;

import android.graphics.Color;
import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class a {
    public static int parseColor(String str) {
        if (str == null || str.length() == 0) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static boolean re(int i) {
        if (i == Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
}
