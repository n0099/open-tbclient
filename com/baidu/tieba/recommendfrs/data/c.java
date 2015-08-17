package com.baidu.tieba.recommendfrs.data;

import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class c extends i {
    private Hot_Thread csV;

    public c(Hot_Thread hot_Thread, String str) {
        this.csV = hot_Thread;
        jW(str);
    }

    public Hot_Thread ajD() {
        return this.csV;
    }
}
