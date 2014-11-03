package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.i;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.a, i {
    private String mUserId = null;
    private String mUserName = null;
    private String mPortrait = null;
    private String bzt = null;
    private long bzu = 0;

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String Yv() {
        return this.bzt;
    }

    public long Yw() {
        return this.bzu;
    }

    @Override // com.baidu.tbadk.mvc.b.i
    public void d(JSONObject jSONObject) {
        this.mUserId = jSONObject.optString("id");
        this.mUserName = jSONObject.optString("name");
        this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.bzt = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.bzu = jSONObject.optLong("zan_time") * 1000;
    }

    @Override // com.baidu.tbadk.mvc.b.i
    public void a(Message message) {
    }
}
