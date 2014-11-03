package com.baidu.tieba.location;

import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes.dex */
public class b {
    private String addr;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String Sq() {
        return this.addr;
    }

    public void a(PoiInfo poiInfo) {
        if (poiInfo != null) {
            this.name = poiInfo.name;
            this.addr = poiInfo.addr;
        }
    }
}
