package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends i {
    private Hot_Thread cBn;

    public c(Hot_Thread hot_Thread, String str) {
        this.cBn = hot_Thread;
        kB(str);
    }

    public Hot_Thread anJ() {
        return this.cBn;
    }
}
