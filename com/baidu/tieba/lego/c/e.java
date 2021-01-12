package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> kXC = new HashMap<>();
    public String itemId = "";
    public long kXA;
    public int kXB;
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        kXC.put(this.kXA + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e u(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return kXC.get(append.append(str).toString());
    }
}
