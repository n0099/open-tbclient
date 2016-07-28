package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> drV = new HashMap<>();
    public long drT;
    public int drU;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        drV.put(String.valueOf(this.drT) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e p(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return drV.get(append.append(str).toString());
    }
}
