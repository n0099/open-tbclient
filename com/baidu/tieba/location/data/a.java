package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes5.dex */
public class a {
    private ArrayList<C0351a> hjT = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0351a {
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

        public void Aj(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0351a> bLH() {
        return this.hjT;
    }

    public void ai(ArrayList<C0351a> arrayList) {
        this.hjT = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0351a c0351a = new C0351a();
                c0351a.b(lbs);
                this.hjT.add(c0351a);
            }
        }
    }
}
