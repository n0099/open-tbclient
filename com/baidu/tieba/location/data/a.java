package com.baidu.tieba.location.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes10.dex */
public class a {
    private ArrayList<C0664a> jfd = new ArrayList<>();

    /* renamed from: com.baidu.tieba.location.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0664a {
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

        public void HF(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<C0664a> cvm() {
        return this.jfd;
    }

    public void az(ArrayList<C0664a> arrayList) {
        this.jfd = arrayList;
    }

    public void a(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                C0664a c0664a = new C0664a();
                c0664a.b(lbs);
                this.jfd.add(c0664a);
            }
        }
    }
}
