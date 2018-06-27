package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> eQd = new HashMap<>();
    public long eQb;
    public int eQc;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        eQd.put(this.eQb + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return eQd.get(append.append(str).toString());
    }
}
