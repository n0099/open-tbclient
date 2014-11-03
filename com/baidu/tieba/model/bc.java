package com.baidu.tieba.model;

import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
public class bc {
    private String Gp = BarDetailForDirSwitchStatic.BAR_DETAIL_DIR;
    private bd bqc;

    public void setFrom(String str) {
        this.Gp = str;
    }

    public void a(bd bdVar) {
        this.bqc = bdVar;
    }

    public void g(String str, long j) {
        new be(str, j, this.Gp, this.bqc).execute(new Integer[0]);
    }
}
