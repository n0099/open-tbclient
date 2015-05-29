package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.a, k {
    private String mUserId = null;
    private String aec = null;
    private String mPortrait = null;
    private String bOU = null;
    private long bOV = 0;

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.aec;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String acI() {
        return this.bOU;
    }

    public long acJ() {
        return this.bOV;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        this.mUserId = jSONObject.optString("id");
        this.aec = jSONObject.optString("name");
        this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
        this.bOU = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW);
        this.bOV = jSONObject.optLong("zan_time") * 1000;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }
}
