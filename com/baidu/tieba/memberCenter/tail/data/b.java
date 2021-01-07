package com.baidu.tieba.memberCenter.tail.data;

import tbclient.AddTail.ResData;
/* loaded from: classes9.dex */
public class b {
    private int loq;

    public void a(ResData resData) {
        if (resData != null && resData.tailId != null) {
            this.loq = resData.tailId.intValue();
        }
    }

    public int dhE() {
        return this.loq;
    }
}
