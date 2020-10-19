package com.baidu.tieba.write.c;

import android.text.TextUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes3.dex */
public class b {
    private static boolean nqv = false;

    public static void dOt() {
        nqv = true;
    }

    public static boolean dOu() {
        return d.bdA();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dOu() || nqv || dOv() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dOW();
            dOt();
            aq.Bm("c13996").bmR();
        }
    }

    private static int dOv() {
        return com.baidu.tbadk.core.sharedPref.b.blO().getInt("show_write_title_tip_count", 0);
    }

    public static void f(WriteData writeData) {
        if (writeData != null && dOu() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.blO().putInt("show_write_title_tip_count", dOv() + 1);
        }
    }
}
