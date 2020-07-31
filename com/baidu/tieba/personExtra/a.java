package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes18.dex */
public class a {
    private List<SmartApp> kRC;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.kRC = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> cWm() {
        return this.kRC;
    }
}
