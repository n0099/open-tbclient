package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> emF = new HashMap<>();
    public long emD;
    public int emE;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        emF.put(this.emD + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e n(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return emF.get(append.append(str).toString());
    }
}
