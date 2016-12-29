package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class z extends bg {
    public static final BdUniqueId ffh = BdUniqueId.gen();
    private boolean ffi;
    private p ffj;
    private String fortune_desc;

    public boolean bfl() {
        return this.ffi;
    }

    public void kT(boolean z) {
        this.ffi = z;
    }

    public String bfm() {
        return this.fortune_desc;
    }

    public void qf(String str) {
        this.fortune_desc = str;
    }

    public p bfn() {
        return this.ffj;
    }

    public void b(p pVar) {
        this.ffj = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ffh;
    }
}
