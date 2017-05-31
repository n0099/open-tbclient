package com.baidu.tieba.lego.d;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> dzO = new HashMap<>();
    public long dzM;
    public int dzN;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        dzO.put(String.valueOf(this.dzM) + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder(String.valueOf(j)).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return dzO.get(append.append(str).toString());
    }
}
