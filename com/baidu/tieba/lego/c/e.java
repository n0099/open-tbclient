package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> ebb = new HashMap<>();
    public long eaZ;
    public int eba;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        ebb.put(this.eaZ + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return ebb.get(append.append(str).toString());
    }
}
