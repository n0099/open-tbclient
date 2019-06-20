package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> hcj = new HashMap<>();
    public long hch;
    public int hci;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        hcj.put(this.hch + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e m(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return hcj.get(append.append(str).toString());
    }
}
