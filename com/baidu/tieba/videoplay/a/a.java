package com.baidu.tieba.videoplay.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private int efu = -1;
    private int efr = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> efs = new HashSet();

    public void wL(int i) {
        this.efs.add(Integer.valueOf(i));
        if (this.efr == this.efs.size()) {
            this.efu = i;
        }
    }

    public int aHM() {
        return this.efu;
    }

    public boolean hv(boolean z) {
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
                return hw(z);
            case 3:
                return hx(z);
            default:
                return false;
        }
    }

    private boolean hw(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean hx(boolean z) {
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
