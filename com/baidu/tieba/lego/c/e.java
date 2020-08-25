package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e {
    private static final HashMap<String, e> jSH = new HashMap<>();
    public String itemId = "";
    public long jSF;
    public int jSG;
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        jSH.put(this.jSF + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e r(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return jSH.get(append.append(str).toString());
    }
}
