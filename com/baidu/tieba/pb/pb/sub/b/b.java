package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class b implements q {
    public static final BdUniqueId lrN = BdUniqueId.gen();
    private int auU = 0;

    public void setReplyNum(int i) {
        this.auU = i;
    }

    public int getReplyNum() {
        return this.auU;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lrN;
    }
}
