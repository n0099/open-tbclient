package com.baidu.tieba.pb.history;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class RequestPbHistoryWriteMessage extends CustomMessage<Object> {
    private boolean isClear;

    public RequestPbHistoryWriteMessage() {
        super(2001191);
        this.isClear = false;
    }

    public boolean isClear() {
        return this.isClear;
    }

    public void setClear(boolean z) {
        this.isClear = z;
    }
}
