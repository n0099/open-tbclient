package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iXy = BdUniqueId.gen();
    private String fortune_desc;
    private m iXA;
    private boolean iXz;

    public boolean clO() {
        return this.iXz;
    }

    public void qH(boolean z) {
        this.iXz = z;
    }

    public String clP() {
        return this.fortune_desc;
    }

    public void DN(String str) {
        this.fortune_desc = str;
    }

    public m clQ() {
        return this.iXA;
    }

    public void a(m mVar) {
        this.iXA = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iXy;
    }
}
