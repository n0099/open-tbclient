package com.baidu.tieba.yuyinala.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public long gPZ;
    public long gQa;
    public String id;
    public String portrait;
    public long startTime;
    public int status;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.gPZ = jSONObject.optLong("sys_time");
        this.startTime = jSONObject.optLong("start_time");
        this.gQa = jSONObject.optLong("balance");
        this.status = jSONObject.optInt("status");
        this.userName = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
