package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> gKX = new HashMap<>();
    public long gKV;
    public int gKW;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        gKX.put(this.gKV + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e o(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return gKX.get(append.append(str).toString());
    }
}
