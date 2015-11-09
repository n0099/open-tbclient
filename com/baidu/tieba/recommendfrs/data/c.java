package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends i {
    private Hot_Thread cKk;

    public c(Hot_Thread hot_Thread, String str) {
        this.cKk = hot_Thread;
        lg(str);
    }

    public Hot_Thread aqJ() {
        return this.cKk;
    }
}
