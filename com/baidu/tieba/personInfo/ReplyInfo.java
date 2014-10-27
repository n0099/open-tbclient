package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Profile.ReplyList;
/* loaded from: classes.dex */
public class ReplyInfo implements Serializable {
    private static final long serialVersionUID = -2510679095713503777L;
    private long friendId;
    private String message;
    private int time;
    private long userId;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID, 0);
            this.friendId = jSONObject.optInt("friend_id", 0);
            this.message = jSONObject.optString("message");
            this.time = jSONObject.optInt("time");
        }
    }

    public void parseProto(ReplyList replyList) {
        if (replyList != null) {
            this.userId = replyList.user_id.intValue();
            this.friendId = replyList.friend_id.intValue();
            this.message = replyList.message;
            this.time = replyList.time.intValue();
        }
    }
}
