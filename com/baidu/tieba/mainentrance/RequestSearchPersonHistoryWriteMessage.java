package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes3.dex */
public class RequestSearchPersonHistoryWriteMessage extends CustomMessage<Object> {
    public boolean isclear;

    public RequestSearchPersonHistoryWriteMessage() {
        super(2001190);
        this.isclear = false;
    }

    public boolean isClear() {
        return this.isclear;
    }

    public void setClear(boolean z) {
        this.isclear = z;
    }
}
