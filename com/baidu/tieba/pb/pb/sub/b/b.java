package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes9.dex */
public class b implements o {
    public static final BdUniqueId kap = BdUniqueId.gen();
    private int anv = 0;

    public void setReplyNum(int i) {
        this.anv = i;
    }

    public int getReplyNum() {
        return this.anv;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kap;
    }
}
