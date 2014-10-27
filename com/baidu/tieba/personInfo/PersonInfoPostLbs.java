package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.LbsInfo;
/* loaded from: classes.dex */
public class PersonInfoPostLbs implements Serializable {
    private static final long serialVersionUID = -7394758328613546085L;
    private String lat;
    private String lon;
    private String town;

    public String getLat() {
        return this.lat;
    }

    public String getLon() {
        return this.lon;
    }

    public String getTown() {
        return this.town;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lat = jSONObject.optString("lat");
            this.lon = jSONObject.optString("lon");
            this.town = jSONObject.optString("town");
        }
    }

    public void parseProto(LbsInfo lbsInfo) {
        if (lbsInfo != null) {
            this.lat = lbsInfo.lat;
            this.lon = lbsInfo.lon;
            this.town = lbsInfo.town;
        }
    }
}
