package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes17.dex */
public class a {
    private ArrayList<C0688a> jFH = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0688a {
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

        public void IW(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0688a> cDk() {
        return this.jFH;
    }

    public void aB(ArrayList<C0688a> arrayList) {
        this.jFH = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0688a c0688a = new C0688a();
                c0688a.b(lbs);
                this.jFH.add(c0688a);
            }
        }
    }
}
