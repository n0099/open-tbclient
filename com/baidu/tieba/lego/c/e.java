package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> faH = new HashMap<>();
    public long faF;
    public int faG;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        faH.put(this.faF + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e l(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return faH.get(append.append(str).toString());
    }
}
