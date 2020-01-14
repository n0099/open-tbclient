package com.baidu.tieba.personExtra;

import java.util.ArrayList;
import java.util.List;
import tbclient.HistorySwan.DataRes;
import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class a {
    private List<SmartApp> jiF;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jiF = new ArrayList(dataRes.swan_list);
        }
    }

    public List<SmartApp> cur() {
        return this.jiF;
    }
}
