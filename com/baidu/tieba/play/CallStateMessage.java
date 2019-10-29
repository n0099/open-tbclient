package com.baidu.tieba.play;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class CallStateMessage extends CustomResponsedMessage {
    private int mState;

    public CallStateMessage(int i) {
        super(CmdConfigCustom.CMD_CALL_STATE_CHANGED);
        this.mState = 0;
        this.mState = i;
    }

    public int getCallState() {
        return this.mState;
    }
}
