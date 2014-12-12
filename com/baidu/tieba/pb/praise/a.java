package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.a, j {
    private String mUserId = null;
    private String mUserName = null;
    private String mPortrait = null;
    private String bDp = null;
    private long bDq = 0;

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String YT() {
        return this.bDp;
    }

    public long YU() {
        return this.bDq;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void c(JSONObject jSONObject) {
        this.mUserId = jSONObject.optString("id");
        this.mUserName = jSONObject.optString("name");
        this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.bDp = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.bDq = jSONObject.optLong("zan_time") * 1000;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
