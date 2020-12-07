package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes23.dex */
public class a {
    private ArrayList<C0803a> kYT = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0803a {
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

        public void OA(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0803a> dfK() {
        return this.kYT;
    }

    public void aP(ArrayList<C0803a> arrayList) {
        this.kYT = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0803a c0803a = new C0803a();
                c0803a.b(lbs);
                this.kYT.add(c0803a);
            }
        }
    }
}
