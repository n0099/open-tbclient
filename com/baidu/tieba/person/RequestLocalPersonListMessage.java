package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestLocalPersonListMessage extends CustomMessage<Object> {
    private boolean isFollow;
    private String uid;

    public RequestLocalPersonListMessage() {
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
