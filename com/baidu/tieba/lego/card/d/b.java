package com.baidu.tieba.lego.card.d;

import android.graphics.Color;
import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class b {
    public static int fv(String str) {
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

    public static boolean DN(int i) {
        if (i == Integer.MAX_VALUE) {
            return true;
        }
        return false;
    }
}
