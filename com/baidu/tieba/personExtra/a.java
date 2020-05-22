package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class a {
    private List<SmartApp> knx;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.knx = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> cNO() {
        return this.knx;
    }
}
