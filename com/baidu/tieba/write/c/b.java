package com.baidu.tieba.write.c;

import android.text.TextUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.TitleTipView;
/* loaded from: classes3.dex */
public class b {
    private static boolean nIO = false;

    public static void dUb() {
        nIO = true;
    }

    public static boolean dUc() {
        return d.bhT();
    }

    public static void a(TitleTipView titleTipView) {
        if (titleTipView != null) {
            if (!dUc() || nIO || dUd() > 0) {
                titleTipView.setVisibility(8);
                return;
            }
            titleTipView.dUE();
            dUb();
            aq.BT("c13996").brk();
        }
    }

    private static int dUd() {
        return com.baidu.tbadk.core.sharedPref.b.bqh().getInt("show_write_title_tip_count", 0);
    }

    public static void f(WriteData writeData) {
        if (writeData != null && dUc() && !TextUtils.isEmpty(writeData.getTitle())) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("show_write_title_tip_count", dUd() + 1);
        }
    }
}
