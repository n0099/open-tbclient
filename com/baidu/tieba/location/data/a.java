package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<C0229a> fkv = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0229a {
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

        public void qI(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0229a> aYk() {
        return this.fkv;
    }

    public void ab(ArrayList<C0229a> arrayList) {
        this.fkv = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0229a c0229a = new C0229a();
                c0229a.b(lbs);
                this.fkv.add(c0229a);
            }
        }
    }
}
