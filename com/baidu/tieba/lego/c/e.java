package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> dDK = new HashMap<>();
    public long dDI;
    public int dDJ;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        dDK.put(String.valueOf(this.dDI) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e s(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return dDK.get(append.append(str).toString());
    }
}
