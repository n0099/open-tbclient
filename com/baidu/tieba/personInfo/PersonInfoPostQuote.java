package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Quote;
/* loaded from: classes.dex */
public class PersonInfoPostQuote implements Serializable {
    private static final long serialVersionUID = 7580620472323060187L;
    private String content;
    private String ip;
    private long postId;
    private long userId;
    private String userName;

    public long getPostId() {
        return this.postId;
    }

    public String getUserName() {
        return this.userName;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getIp() {
        return this.ip;
    }

    public String getContent() {
        return this.content;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.postId = jSONObject.optLong("post_id");
            this.userName = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
            this.userId = jSONObject.optLong(com.baidu.tbadk.core.frameworkData.a.USER_ID);
            this.ip = jSONObject.optString("ip");
            this.content = jSONObject.optString("content");
        }
    }

    public void parseProto(Quote quote) {
        if (quote != null) {
            this.postId = quote.post_id.longValue();
            this.userName = quote.user_name;
            this.userId = quote.user_id.longValue();
            this.ip = quote.ip;
            this.content = quote.content;
        }
    }
}
