package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends h {
    private Hot_Thread cbY;

    public c(Hot_Thread hot_Thread, String str) {
        this.cbY = hot_Thread;
        jb(str);
    }

    public Hot_Thread ahB() {
        return this.cbY;
    }
}
