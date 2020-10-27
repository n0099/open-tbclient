package com.baidu.tieba.write.c;

import android.text.TextUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes3.dex */
public class b {
    private static boolean nCU = false;

    public static void dRB() {
        nCU = true;
    }

    public static boolean dRC() {
        return d.bft();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dRC() || nCU || dRD() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dSe();
            dRB();
            aq.BF("c13996").boK();
        }
    }

    private static int dRD() {
        return com.baidu.tbadk.core.sharedPref.b.bnH().getInt("show_write_title_tip_count", 0);
    }

    public static void f(WriteData writeData) {
        if (writeData != null && dRC() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("show_write_title_tip_count", dRD() + 1);
        }
    }
}
