package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.HttpMessage;
/* loaded from: classes9.dex */
public class SetPrivilegeRequestMessage extends HttpMessage {
    private int propsID;

    public SetPrivilegeRequestMessage() {
        super(1003152);
    }

    public void setPropsID(int i) {
        this.propsID = i;
    }

    public int getPropsID() {
        return this.propsID;
    }
}
