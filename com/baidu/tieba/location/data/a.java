package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes17.dex */
public class a {
    private ArrayList<C0739a> jUY = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0739a {
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

        public void LO(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0739a> cOb() {
        return this.jUY;
    }

    public void aH(ArrayList<C0739a> arrayList) {
        this.jUY = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0739a c0739a = new C0739a();
                c0739a.b(lbs);
                this.jUY.add(c0739a);
            }
        }
    }
}
