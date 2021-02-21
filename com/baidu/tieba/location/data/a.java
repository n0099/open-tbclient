package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<C0786a> lik = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0786a {
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

        public void NP(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0786a> ddL() {
        return this.lik;
    }

    public void aJ(ArrayList<C0786a> arrayList) {
        this.lik = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0786a c0786a = new C0786a();
                c0786a.b(lbs);
                this.lik.add(c0786a);
            }
        }
    }
}
