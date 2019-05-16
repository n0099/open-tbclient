package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iXw = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iXx;
    private m iXy;

    public boolean clM() {
        return this.iXx;
    }

    public void qH(boolean z) {
        this.iXx = z;
    }

    public String clN() {
        return this.fortune_desc;
    }

    public void DN(String str) {
        this.fortune_desc = str;
    }

    public m clO() {
        return this.iXy;
    }

    public void a(m mVar) {
        this.iXy = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iXw;
    }
}
