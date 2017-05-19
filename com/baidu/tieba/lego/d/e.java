package com.baidu.tieba.lego.d;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> duw = new HashMap<>();
    public long duu;
    public int duv;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        duw.put(String.valueOf(this.duu) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return duw.get(append.append(str).toString());
    }
}
