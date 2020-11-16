package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes22.dex */
public class a {
    private ArrayList<C0787a> kLC = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C0787a {
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

        public void Nt(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0787a> day() {
        return this.kLC;
    }

    public void aN(ArrayList<C0787a> arrayList) {
        this.kLC = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0787a c0787a = new C0787a();
                c0787a.b(lbs);
                this.kLC.add(c0787a);
            }
        }
    }
}
