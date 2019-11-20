package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class a {
    private List<SmartApp> imZ;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.imZ = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> bZO() {
        return this.imZ;
    }
}
