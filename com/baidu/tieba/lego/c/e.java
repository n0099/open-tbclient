package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> ezL = new HashMap<>();
    public long ezJ;
    public int ezK;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        ezL.put(this.ezJ + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return ezL.get(append.append(str).toString());
    }
}
