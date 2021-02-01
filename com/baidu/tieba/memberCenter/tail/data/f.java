package com.baidu.tieba.memberCenter.tail.data;

import tbclient.SetTail.ResData;
/* loaded from: classes9.dex */
public class f {
    private int lrN;

    public void a(ResData resData) {
        if (resData != null && resData.tailId != null) {
            this.lrN = resData.tailId.intValue();
        }
    }

    public int dfM() {
        return this.lrN;
    }
}
