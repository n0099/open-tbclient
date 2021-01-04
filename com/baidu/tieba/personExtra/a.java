package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class a {
    private List<SmartApp> mrN;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mrN = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dyQ() {
        return this.mrN;
    }
}
