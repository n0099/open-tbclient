package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
            this.userName = jSONObject.optString("user_name");
            this.userId = jSONObject.optLong("user_id");
            this.ip = jSONObject.optString("ip");
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
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
