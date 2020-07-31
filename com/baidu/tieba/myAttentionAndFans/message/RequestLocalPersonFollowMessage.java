package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes17.dex */
public class RequestLocalPersonFollowMessage extends CustomMessage<Object> {
    private boolean isFollow;
    private String uid;

    public RequestLocalPersonFollowMessage() {
        super(CmdConfigCustom.CMD_READ_PERSON_LIST);
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
