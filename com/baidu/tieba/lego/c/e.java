package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> dXQ = new HashMap<>();
    public long dXO;
    public int dXP;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        dXQ.put(this.dXO + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return dXQ.get(append.append(str).toString());
    }
}
