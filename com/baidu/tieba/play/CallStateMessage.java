package com.baidu.tieba.play;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class CallStateMessage extends CustomResponsedMessage {
    private int mState;

    public CallStateMessage(int i) {
        super(2016503);
        this.mState = 0;
        this.mState = i;
    }

    public int getCallState() {
        return this.mState;
    }
}
