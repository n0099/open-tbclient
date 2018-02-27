package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> feN = new HashMap<>();
    public long feL;
    public int feM;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        feN.put(this.feL + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e l(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return feN.get(append.append(str).toString());
    }
}
