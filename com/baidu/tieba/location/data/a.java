package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes5.dex */
public class a {
    private ArrayList<C0462a> hkB = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0462a {
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

        public void zd(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0462a> bJJ() {
        return this.hkB;
    }

    public void am(ArrayList<C0462a> arrayList) {
        this.hkB = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0462a c0462a = new C0462a();
                c0462a.b(lbs);
                this.hkB.add(c0462a);
            }
        }
    }
}
