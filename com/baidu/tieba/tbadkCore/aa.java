package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
/* loaded from: classes.dex */
public class aa extends bi {
    public static final BdUniqueId ftP = BdUniqueId.gen();
    private String fortune_desc;
    private boolean ftQ;
    private q ftR;

    public boolean biW() {
        return this.ftQ;
    }

    public void kL(boolean z) {
        this.ftQ = z;
    }

    public String biX() {
        return this.fortune_desc;
    }

    public void rh(String str) {
        this.fortune_desc = str;
    }

    public q biY() {
        return this.ftR;
    }

    public void b(q qVar) {
        this.ftR = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ftP;
    }
}
