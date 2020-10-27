package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId lEm = BdUniqueId.gen();
    private int auV = 0;

    public void setReplyNum(int i) {
        this.auV = i;
    }

    public int getReplyNum() {
        return this.auV;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lEm;
    }
}
