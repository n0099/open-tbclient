package com.baidu.tieba.lego.d;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> dAe = new HashMap<>();
    public long dAc;
    public int dAd;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        dAe.put(String.valueOf(this.dAc) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e o(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return dAe.get(append.append(str).toString());
    }
}
