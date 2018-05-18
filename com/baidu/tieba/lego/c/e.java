package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> eAT = new HashMap<>();
    public long eAR;
    public int eAS;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        eAT.put(this.eAR + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return eAT.get(append.append(str).toString());
    }
}
