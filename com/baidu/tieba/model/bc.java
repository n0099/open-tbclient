package com.baidu.tieba.model;

import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
public class bc {
    private String Go = BarDetailForDirSwitchStatic.BAR_DETAIL_DIR;
    private bd bpO;

    public void setFrom(String str) {
        this.Go = str;
    }

    public void a(bd bdVar) {
        this.bpO = bdVar;
    }

    public void g(String str, long j) {
        new be(str, j, this.Go, this.bpO).execute(new Integer[0]);
    }
}
