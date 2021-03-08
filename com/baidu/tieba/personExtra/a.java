package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class a {
    private List<SmartApp> myz;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.myz = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> dxy() {
        return this.myz;
    }
}
