package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> emB = new HashMap<>();
    public int emA;
    public long emz;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        emB.put(this.emz + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e n(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return emB.get(append.append(str).toString());
    }
}
