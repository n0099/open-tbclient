package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.util.az;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Profile.CommonLocation;
/* loaded from: classes.dex */
public class DistanceInfo implements Serializable {
    private static final long serialVersionUID = -2579395459420338655L;
    private String distance;
    private long time;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.distance = jSONObject.optString("distance");
            this.time = jSONObject.optLong("time");
        }
    }

    public void parseProto(CommonLocation commonLocation) {
        if (commonLocation != null) {
            this.distance = commonLocation.distance;
            this.time = commonLocation.time.longValue();
        }
    }

    public String getDistance() {
        return this.distance;
    }

    public long getTime() {
        return this.time;
    }

    public String getTimeFormat() {
        return this.time != 0 ? az.i(this.time) : "";
    }
}
