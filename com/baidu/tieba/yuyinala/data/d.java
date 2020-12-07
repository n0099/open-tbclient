package com.baidu.tieba.yuyinala.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long gIR;
    public long gIS;
    public String id;
    public String portrait;
    public long startTime;
    public int status;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.gIR = jSONObject.optLong("sys_time");
        this.startTime = jSONObject.optLong("start_time");
        this.gIS = jSONObject.optLong("balance");
        this.status = jSONObject.optInt("status");
        this.userName = jSONObject.optString("user_name");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
