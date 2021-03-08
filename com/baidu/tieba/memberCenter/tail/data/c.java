package com.baidu.tieba.memberCenter.tail.data;

import tbclient.DeleteTail.ResData;
/* loaded from: classes8.dex */
public class c {
    private int lue;

    public void a(ResData resData) {
        if (resData != null && resData.tailId != null) {
            this.lue = resData.tailId.intValue();
        }
    }

    public int dgc() {
        return this.lue;
    }
}
