package com.baidu.tieba.memberCenter.tail.data;

import tbclient.SetTail.ResData;
/* loaded from: classes8.dex */
public class f {
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
