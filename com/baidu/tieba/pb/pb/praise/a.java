package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.a, k {
    private String mUserId = null;
    private String acU = null;
    private String mPortrait = null;
    private String bMW = null;
    private long bMX = 0;

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.acU;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String abQ() {
        return this.bMW;
    }

    public long abR() {
        return this.bMX;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        this.mUserId = jSONObject.optString("id");
        this.acU = jSONObject.optString("name");
        this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.bMW = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.bMX = jSONObject.optLong("zan_time") * 1000;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }
}
