package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class l {
    private ArrayList<m> cpw = new ArrayList<>();

    public ArrayList<m> ank() {
        return this.cpw;
    }

    public void W(ArrayList<m> arrayList) {
        this.cpw = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                m mVar = new m();
                mVar.b(lbs);
                this.cpw.add(mVar);
            }
        }
    }
}
