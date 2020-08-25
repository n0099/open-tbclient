package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes18.dex */
public class a {
    private List<SmartApp> lhu;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.lhu = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dhj() {
        return this.lhu;
    }
}
