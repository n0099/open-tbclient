package com.baidu.tieba.memberCenter.tail.data;

import tbclient.DeleteTail.ResData;
/* loaded from: classes8.dex */
public class c {
    private int ljH;

    public void a(ResData resData) {
        if (resData != null && resData.tailId != null) {
            this.ljH = resData.tailId.intValue();
        }
    }

    public int ddM() {
        return this.ljH;
    }
}
