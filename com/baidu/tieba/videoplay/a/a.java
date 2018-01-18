package com.baidu.tieba.videoplay.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int dTd = -1;
    private int dTa = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dTb = new HashSet();

    public void xb(int i) {
        this.dTb.add(Integer.valueOf(i));
        if (this.dTa == this.dTb.size()) {
            this.dTd = i;
        }
    }

    public int azo() {
        return this.dTd;
    }

    public boolean gj(boolean z) {
        boolean z2 = b.getInstance().getBoolean("nani_key_is_show_download_nani_panel", true);
        boolean z3 = b.getInstance().getBoolean("nani_key_is_activate_app", false);
        String string = b.getInstance().getString("nani_key_download_link_url", null);
        if (!z2 || z3 || TextUtils.isEmpty(string)) {
            return false;
        }
        switch (b.getInstance().getInt("nani_key_download_show_rate", 2)) {
            case 1:
                return true;
            case 2:
                return gk(z);
            case 3:
                return gl(z);
            default:
                return false;
        }
    }

    private boolean gk(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gl(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        if (j <= 0) {
            return true;
        }
        return false;
    }
}
