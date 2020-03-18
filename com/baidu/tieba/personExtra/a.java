package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class a {
    private List<SmartApp> jll;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jll = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> cwg() {
        return this.jll;
    }
}
