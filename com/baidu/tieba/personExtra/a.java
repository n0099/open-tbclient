package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class a {
    private List<SmartApp> jiA;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jiA = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> cup() {
        return this.jiA;
    }
}
