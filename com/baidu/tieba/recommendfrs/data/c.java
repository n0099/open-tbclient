package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends i {
    private Hot_Thread cIO;

    public c(Hot_Thread hot_Thread, String str) {
        this.cIO = hot_Thread;
        lc(str);
    }

    public Hot_Thread aqh() {
        return this.cIO;
    }
}
