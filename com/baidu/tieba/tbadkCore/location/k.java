package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class k {
    private ArrayList<l> bYB = new ArrayList<>();

    public ArrayList<l> ahH() {
        return this.bYB;
    }

    public void Q(ArrayList<l> arrayList) {
        this.bYB = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                l lVar = new l();
                lVar.b(lbs);
                this.bYB.add(lVar);
            }
        }
    }
}
