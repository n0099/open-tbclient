package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: int  reason: not valid java name */
    private List<SmartApp> f0int;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.f0int = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> ccb() {
        return this.f0int;
    }
}
