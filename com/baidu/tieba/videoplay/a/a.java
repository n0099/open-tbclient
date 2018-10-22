package com.baidu.tieba.videoplay.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int dXD = -1;
    private int dXA = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dXB = new HashSet();

    public void vV(int i) {
        this.dXB.add(Integer.valueOf(i));
        if (this.dXA == this.dXB.size()) {
            this.dXD = i;
        }
    }

    public int aGC() {
        return this.dXD;
    }

    public boolean hj(boolean z) {
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
                return hk(z);
            case 3:
                return hl(z);
            default:
                return false;
        }
    }

    private boolean hk(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean hl(boolean z) {
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
