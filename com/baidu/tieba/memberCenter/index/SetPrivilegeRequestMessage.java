package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes3.dex */
public class SetPrivilegeRequestMessage extends HttpMessage {
    public int propsID;

    public SetPrivilegeRequestMessage() {
        super(CmdConfigHttp.CMD_SET_PRIVILEGE);
    }

    public int getPropsID() {
        return this.propsID;
    }

    public void setPropsID(int i2) {
        this.propsID = i2;
    }
}
