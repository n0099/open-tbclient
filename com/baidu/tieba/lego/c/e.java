package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> fiX = new HashMap<>();
    public long fiV;
    public int fiW;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        fiX.put(this.fiV + BaseRequestAction.SPLITE + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e o(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append(BaseRequestAction.SPLITE);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return fiX.get(append.append(str).toString());
    }
}
