package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetPoisByLocation.DataRes;
import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes.dex */
public class a {
    private String formatted_address;
    private List<C0391a> poi_info;
    private String sn;

    public String ceS() {
        return this.formatted_address;
    }

    public List<C0391a> ceT() {
        return this.poi_info;
    }

    public void CC(String str) {
        this.formatted_address = str;
    }

    public String ceU() {
        return this.sn;
    }

    public void CD(String str) {
        this.sn = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.formatted_address = dataRes.formatted_address;
            List<PoiInfo> list = dataRes.poi_info;
            if (list != null) {
                this.poi_info = new ArrayList();
                for (PoiInfo poiInfo : list) {
                    C0391a c0391a = new C0391a();
                    c0391a.a(poiInfo);
                    this.poi_info.add(c0391a);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.tbadkCore.location.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0391a {
        private String addr;
        private String name;
        private String sn;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getAddr() {
            return this.addr;
        }

        public String ceU() {
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
