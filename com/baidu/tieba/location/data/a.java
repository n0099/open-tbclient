package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<C0785a> lhW = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0785a {
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

        public void NO(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0785a> ddE() {
        return this.lhW;
    }

    public void aJ(ArrayList<C0785a> arrayList) {
        this.lhW = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0785a c0785a = new C0785a();
                c0785a.b(lbs);
                this.lhW.add(c0785a);
            }
        }
    }
}
