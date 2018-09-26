package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> fbo = new HashMap<>();
    public long fbm;
    public int fbn;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        fbo.put(this.fbm + "_" + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e o(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append("_");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return fbo.get(append.append(str).toString());
    }
}
