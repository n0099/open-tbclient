package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class i {
    private ArrayList<a> cSQ = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a {
        private String lat;
        private String lng;
        private String name;
        private String screatString;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void b(Lbs lbs) {
            if (lbs != null) {
                this.name = lbs.name;
                this.lat = lbs.lat;
                this.lng = lbs.lng;
                this.screatString = lbs.sn;
            }
        }

        public String getScreatString() {
            return this.screatString;
        }

        public void ld(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<a> auZ() {
        return this.cSQ;
    }

    public void af(ArrayList<a> arrayList) {
        this.cSQ = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                a aVar = new a();
                aVar.b(lbs);
                this.cSQ.add(aVar);
            }
        }
    }
}
