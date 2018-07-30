package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetPoisByLocation.DataRes;
import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes.dex */
public class a {
    private String formatted_address;
    private List<C0238a> poi_info;
    private String sn;

    public String bwJ() {
        return this.formatted_address;
    }

    public List<C0238a> bwK() {
        return this.poi_info;
    }

    public void tO(String str) {
        this.formatted_address = str;
    }

    public String bwL() {
        return this.sn;
    }

    public void tP(String str) {
        this.sn = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.formatted_address = dataRes.formatted_address;
            List<PoiInfo> list = dataRes.poi_info;
            if (list != null) {
                this.poi_info = new ArrayList();
                for (PoiInfo poiInfo : list) {
                    C0238a c0238a = new C0238a();
                    c0238a.a(poiInfo);
                    this.poi_info.add(c0238a);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0238a {
        private String addr;
        private String name;
        private String sn;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String bwM() {
            return this.addr;
        }

        public String bwL() {
            return this.sn;
        }

        public void a(PoiInfo poiInfo) {
            if (poiInfo != null) {
                this.name = poiInfo.name;
                this.addr = poiInfo.addr;
                this.sn = poiInfo.sn;
            }
        }
    }
}
