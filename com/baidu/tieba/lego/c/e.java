package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> efF = new HashMap<>();
    public long efD;
    public int efE;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        efF.put(this.efD + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return efF.get(append.append(str).toString());
    }
}
