package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes3.dex */
public class RequestLocalPersonFollowMessage extends CustomMessage<Object> {
    public boolean isFollow;
    public String uid;

    public RequestLocalPersonFollowMessage() {
        super(2001188);
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public void setFollow(boolean z) {
        this.isFollow = z;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
