package com.baidu.tieba.memberCenter.tail.data;

import tbclient.UpdateTail.ResData;
/* loaded from: classes9.dex */
public class g {
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
