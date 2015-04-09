package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class l {
    private ArrayList<m> cpM = new ArrayList<>();

    public ArrayList<m> anz() {
        return this.cpM;
    }

    public void Y(ArrayList<m> arrayList) {
        this.cpM = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                m mVar = new m();
                mVar.b(lbs);
                this.cpM.add(mVar);
            }
        }
    }
}
