package com.baidu.tieba.tbadvert.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public int auM;
    public long endTime;
    public String htz;
    public int id;
    public String linkUrl;
    public long showTime = 3000;
    public int showType;
    public long startTime;
    public long updateTime;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optInt("id", 0);
            this.updateTime = jSONObject.optLong("update_time", 0L);
            this.startTime = jSONObject.optLong("start_time", 0L);
            this.endTime = jSONObject.optLong("end_time", 0L);
            this.showType = jSONObject.optInt("show_type", 0);
            this.auM = jSONObject.optInt("show_status", 0);
            this.htz = jSONObject.optString("resource_url");
            this.linkUrl = jSONObject.optString("link_url");
        }
    }

    public boolean bGo() {
        return this.showType == 1;
    }

    public boolean isFullScreen() {
        return this.showType == 2 || this.showType == 4;
    }
}
