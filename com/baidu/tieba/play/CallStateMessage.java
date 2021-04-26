package com.baidu.tieba.play;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class CallStateMessage extends CustomResponsedMessage {
    public int mState;

    public CallStateMessage(int i2) {
        super(2016503);
        this.mState = 0;
        this.mState = i2;
    }

    public int getCallState() {
        return this.mState;
    }
}
