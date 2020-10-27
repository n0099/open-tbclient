package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes23.dex */
public class a {
    private ArrayList<C0769a> kFr = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0769a {
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

        public void NE(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0769a> cYz() {
        return this.kFr;
    }

    public void aM(ArrayList<C0769a> arrayList) {
        this.kFr = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0769a c0769a = new C0769a();
                c0769a.b(lbs);
                this.kFr.add(c0769a);
            }
        }
    }
}
