package com.baidu.tieba.tbadkCore.location;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetPoisByLocation.DataRes;
import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes.dex */
public class a {
    private String formatted_address;
    private List<b> poi_info;
    private String sn;

    public String ahu() {
        return this.formatted_address;
    }

    public List<b> ahv() {
        return this.poi_info;
    }

    public void ih(String str) {
        this.formatted_address = str;
    }

    public String ahw() {
        return this.sn;
    }

    public void ii(String str) {
        this.sn = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.formatted_address = dataRes.formatted_address;
            List<PoiInfo> list = dataRes.poi_info;
            if (list != null) {
                this.poi_info = new ArrayList();
                for (PoiInfo poiInfo : list) {
                    b bVar = new b();
                    bVar.a(poiInfo);
                    this.poi_info.add(bVar);
                }
            }
        }
    }
}
