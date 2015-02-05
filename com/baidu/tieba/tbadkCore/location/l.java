package com.baidu.tieba.tbadkCore.location;

import tbclient.Lbs;
/* loaded from: classes.dex */
public class l {
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

    public void io(String str) {
        this.screatString = str;
    }
}
