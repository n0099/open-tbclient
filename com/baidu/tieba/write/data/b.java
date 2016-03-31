package com.baidu.tieba.write.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class b {
    private ArrayList<a> eIg = new ArrayList<>();

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

        public void oQ(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<a> aZy() {
        return this.eIg;
    }

    public void ar(ArrayList<a> arrayList) {
        this.eIg = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                a aVar = new a();
                aVar.b(lbs);
                this.eIg.add(aVar);
            }
        }
    }
}
