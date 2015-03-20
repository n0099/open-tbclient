package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.a, k {
    private String mUserId = null;
    private String acM = null;
    private String mPortrait = null;
    private String bMG = null;
    private long bMH = 0;

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.acM;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String abB() {
        return this.bMG;
    }

    public long abC() {
        return this.bMH;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        this.mUserId = jSONObject.optString("id");
        this.acM = jSONObject.optString("name");
        this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.bMG = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.bMH = jSONObject.optLong("zan_time") * 1000;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }
}
