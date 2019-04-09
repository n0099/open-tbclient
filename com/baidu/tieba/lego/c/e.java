package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> gKL = new HashMap<>();
    public long gKJ;
    public int gKK;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        gKL.put(this.gKJ + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e o(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return gKL.get(append.append(str).toString());
    }
}
