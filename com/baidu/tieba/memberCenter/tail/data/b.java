package com.baidu.tieba.memberCenter.tail.data;

import tbclient.AddTail.ResData;
/* loaded from: classes9.dex */
public class b {
    private int lsb;

    public void a(ResData resData) {
        if (resData != null && resData.tailId != null) {
            this.lsb = resData.tailId.intValue();
        }
    }

    public int dfT() {
        return this.lsb;
    }
}
