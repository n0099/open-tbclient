package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes23.dex */
public class a {
    private List<SmartApp> lqw;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lqw = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dkP() {
        return this.lqw;
    }
}
