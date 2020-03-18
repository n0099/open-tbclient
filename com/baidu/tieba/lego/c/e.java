package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<String, e> idQ = new HashMap<>();
    public long idO;
    public int idP;
    public String itemId = "";
    public String params;
    public int rn;
    public String tag_name;

    public void refresh() {
        idQ.put(this.idO + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + (TextUtils.isEmpty(this.itemId) ? "" : this.itemId), this);
    }

    public static e p(long j, String str) {
        StringBuilder append = new StringBuilder().append(j).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return idQ.get(append.append(str).toString());
    }
}
