package com.baidu.tieba.write.c;

import android.text.TextUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes3.dex */
public class b {
    private static boolean nKp = false;

    public static void dUa() {
        nKp = true;
    }

    public static boolean dUb() {
        return d.bhl();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dUb() || nKp || dUc() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dUD();
            dUa();
            ar.Bs("c13996").bqy();
        }
    }

    private static int dUc() {
        return com.baidu.tbadk.core.sharedPref.b.bpu().getInt("show_write_title_tip_count", 0);
    }

    public static void f(WriteData writeData) {
        if (writeData != null && dUb() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("show_write_title_tip_count", dUc() + 1);
        }
    }
}
