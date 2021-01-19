package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes7.dex */
public class a {
    private ArrayList<C0783a> kZS = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0783a {
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

        public void Na(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0783a> dbG() {
        return this.kZS;
    }

    public void aK(ArrayList<C0783a> arrayList) {
        this.kZS = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0783a c0783a = new C0783a();
                c0783a.b(lbs);
                this.kZS.add(c0783a);
            }
        }
    }
}
