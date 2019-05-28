package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes5.dex */
public class a {
    private ArrayList<C0352a> hdF = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0352a {
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

        public void zw(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0352a> bIZ() {
        return this.hdF;
    }

    public void ai(ArrayList<C0352a> arrayList) {
        this.hdF = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0352a c0352a = new C0352a();
                c0352a.b(lbs);
                this.hdF.add(c0352a);
            }
        }
    }
}
