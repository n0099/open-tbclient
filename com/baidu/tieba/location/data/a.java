package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes23.dex */
public class a {
    private ArrayList<C0784a> kLn = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C0784a {
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

        public void NV(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0784a> dbb() {
        return this.kLn;
    }

    public void aM(ArrayList<C0784a> arrayList) {
        this.kLn = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0784a c0784a = new C0784a();
                c0784a.b(lbs);
                this.kLn.add(c0784a);
            }
        }
    }
}
