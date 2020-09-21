package com.baidu.tieba.write.c;

import android.text.TextUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes3.dex */
public class b {
    private static boolean naW = false;

    public static void dKH() {
        naW = true;
    }

    public static boolean dKI() {
        return d.baS();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dKI() || naW || dKJ() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dLk();
            dKH();
            aq.AA("c13996").bki();
        }
    }

    private static int dKJ() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt("show_write_title_tip_count", 0);
    }

    public static void f(WriteData writeData) {
        if (writeData != null && dKI() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("show_write_title_tip_count", dKJ() + 1);
        }
    }
}
