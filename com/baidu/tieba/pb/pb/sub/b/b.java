package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class b implements q {
    public static final BdUniqueId kTS = BdUniqueId.gen();
    private int atJ = 0;

    public void setReplyNum(int i) {
        this.atJ = i;
    }

    public int getReplyNum() {
        return this.atJ;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kTS;
    }
}
