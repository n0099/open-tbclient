package com.baidu.tieba.memberCenter.tail.data;

import tbclient.SetTail.ResData;
/* loaded from: classes9.dex */
public class f {
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
