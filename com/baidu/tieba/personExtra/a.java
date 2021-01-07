package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class a {
    private List<SmartApp> mrM;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mrM = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dyR() {
        return this.mrM;
    }
}
