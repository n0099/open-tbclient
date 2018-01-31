package com.baidu.tieba.videoplay.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private int dTy = -1;
    private int dTv = b.getInstance().getInt("nani_key_download_show_position", 3);
    private Set<Integer> dTw = new HashSet();

    public void xb(int i) {
        this.dTw.add(Integer.valueOf(i));
        if (this.dTv == this.dTw.size()) {
            this.dTy = i;
        }
    }

    public int azt() {
        return this.dTy;
    }

    public boolean gl(boolean z) {
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
                return gm(z);
            case 3:
                return gn(z);
            default:
                return false;
        }
    }

    private boolean gm(boolean z) {
        long j;
        if (z) {
            j = b.getInstance().getLong("key_vertical_shown_time", -1L);
        } else {
            j = b.getInstance().getLong("key_horizontal_shown_time", -1L);
        }
        return j <= 0 || System.currentTimeMillis() - j >= 86400000;
    }

    private boolean gn(boolean z) {
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
