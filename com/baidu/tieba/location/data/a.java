package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes5.dex */
public class a {
    private ArrayList<C0368a> hmF = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0368a {
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

        public void AJ(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0368a> bMI() {
        return this.hmF;
    }

    public void ai(ArrayList<C0368a> arrayList) {
        this.hmF = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0368a c0368a = new C0368a();
                c0368a.b(lbs);
                this.hmF.add(c0368a);
            }
        }
    }
}
