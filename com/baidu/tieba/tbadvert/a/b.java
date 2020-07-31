package com.baidu.tieba.tbadvert.a;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class b {
    public int dTc;
    public long endTime;
    public int id;
    public String lRu;
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
            this.showType = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.dTc = jSONObject.optInt("show_status", 0);
            this.lRu = jSONObject.optString("resource_url");
            this.linkUrl = jSONObject.optString("link_url");
        }
    }

    public boolean dmJ() {
        return this.showType == 1;
    }

    public boolean btf() {
        return this.showType == 3 || this.showType == 4;
    }

    public boolean isFullScreen() {
        return this.showType == 2 || this.showType == 4;
    }
}
