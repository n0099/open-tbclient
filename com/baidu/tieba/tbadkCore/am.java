package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.be;
/* loaded from: classes.dex */
public class am extends az {
    public static final BdUniqueId eWB = BdUniqueId.gen();
    private bb eWC;
    private be eWD;
    private boolean eWE = false;

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eWB;
    }

    public boolean bbz() {
        return this.eWE;
    }

    public void kj(boolean z) {
        this.eWE = z;
    }

    public bb bbA() {
        return this.eWC;
    }

    public void a(bb bbVar) {
        this.eWC = bbVar;
    }

    public be bbB() {
        return this.eWD;
    }

    public void a(be beVar) {
        this.eWD = beVar;
    }
}
