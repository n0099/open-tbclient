package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class a {
    private List<SmartApp> ifW;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ifW = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> bYT() {
        return this.ifW;
    }
}
