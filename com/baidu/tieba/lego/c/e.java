package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> doN = new HashMap<>();
    public long doL;
    public int doM;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        doN.put(String.valueOf(this.doL) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e p(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return doN.get(append.append(str).toString());
    }
}
