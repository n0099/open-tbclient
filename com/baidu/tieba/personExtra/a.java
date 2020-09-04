package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes18.dex */
public class a {
    private List<SmartApp> lhB;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lhB = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dhk() {
        return this.lhB;
    }
}
