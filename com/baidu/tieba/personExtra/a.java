package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes24.dex */
public class a {
    private List<SmartApp> lYb;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lYb = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dui() {
        return this.lYb;
    }
}
