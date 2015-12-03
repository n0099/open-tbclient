package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.core.data.z {
    public static final BdUniqueId dyo = BdUniqueId.gen();
    private boolean dyp;
    private q dyq;
    private String fortune_desc;

    public boolean aCs() {
        return this.dyp;
    }

    public void hj(boolean z) {
        this.dyp = z;
    }

    public String aCt() {
        return this.fortune_desc;
    }

    public void ms(String str) {
        this.fortune_desc = str;
    }

    public q aCu() {
        return this.dyq;
    }

    public void b(q qVar) {
        this.dyq = qVar;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dyo;
    }
}
