package com.baidu.tieba.tbadkCore.location;

import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes.dex */
public class b {
    private String addr;
    private String name;
    private String sn;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String aph() {
        return this.addr;
    }

    public String apg() {
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
