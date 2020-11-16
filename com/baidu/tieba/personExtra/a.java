package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes23.dex */
public class a {
    private List<SmartApp> lYt;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lYt = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dtI() {
        return this.lYt;
    }
}
