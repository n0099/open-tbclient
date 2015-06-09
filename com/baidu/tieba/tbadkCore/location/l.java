package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class l {
    private ArrayList<m> ctO = new ArrayList<>();

    public ArrayList<m> apr() {
        return this.ctO;
    }

    public void U(ArrayList<m> arrayList) {
        this.ctO = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                m mVar = new m();
                mVar.b(lbs);
                this.ctO.add(mVar);
            }
        }
    }
}
