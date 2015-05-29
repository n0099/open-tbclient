package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends h {
    private Hot_Thread cbX;

    public c(Hot_Thread hot_Thread, String str) {
        this.cbX = hot_Thread;
        jb(str);
    }

    public Hot_Thread ahA() {
        return this.cbX;
    }
}
