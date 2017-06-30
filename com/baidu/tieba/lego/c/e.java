package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> dIA = new HashMap<>();
    public long dIy;
    public int dIz;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        dIA.put(String.valueOf(this.dIy) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return dIA.get(append.append(str).toString());
    }
}
