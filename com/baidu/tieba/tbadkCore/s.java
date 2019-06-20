package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iXC = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iXD;
    private m iXE;

    public boolean clP() {
        return this.iXD;
    }

    public void qI(boolean z) {
        this.iXD = z;
    }

    public String clQ() {
        return this.fortune_desc;
    }

    public void DP(String str) {
        this.fortune_desc = str;
    }

    public m clR() {
        return this.iXE;
    }

    public void a(m mVar) {
        this.iXE = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iXC;
    }
}
