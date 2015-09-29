package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends i {
    private Hot_Thread cIp;

    public c(Hot_Thread hot_Thread, String str) {
        this.cIp = hot_Thread;
        kZ(str);
    }

    public Hot_Thread aqb() {
        return this.cIp;
    }
}
