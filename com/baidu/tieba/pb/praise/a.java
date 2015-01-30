package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.a, j {
    private String mUserId = null;
    private String mUserName = null;
    private String mPortrait = null;
    private String bFa = null;
    private long bFb = 0;

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String Zy() {
        return this.bFa;
    }

    public long Zz() {
        return this.bFb;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void c(JSONObject jSONObject) {
        this.mUserId = jSONObject.optString("id");
        this.mUserName = jSONObject.optString("name");
        this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        this.bFa = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
        this.bFb = jSONObject.optLong("zan_time") * 1000;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }
}
