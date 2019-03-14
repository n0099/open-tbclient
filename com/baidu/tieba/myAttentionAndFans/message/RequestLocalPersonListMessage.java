package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes5.dex */
public class RequestLocalPersonListMessage extends CustomMessage<Object> {
    private boolean isFollow;
    private String uid;

    public RequestLocalPersonListMessage() {
        super(2001188);
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public void setFollow(boolean z) {
        this.isFollow = z;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
