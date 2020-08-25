package com.baidu.tieba.tbadvert.a;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class b {
    public int ecy;
    public long endTime;
    public int id;
    public String linkUrl;
    public String mjh;
    public long showTime = IMConnection.RETRY_DELAY_TIMES;
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
            this.ecy = jSONObject.optInt("show_status", 0);
            this.mjh = jSONObject.optString("resource_url");
            this.linkUrl = jSONObject.optString("link_url");
        }
    }

    public boolean dyf() {
        return this.showType == 1;
    }

    public boolean bcy() {
        return this.showType == 3 || this.showType == 4;
    }

    public boolean isFullScreen() {
        return this.showType == 2 || this.showType == 4;
    }
}
