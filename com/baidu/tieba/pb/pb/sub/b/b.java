package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes9.dex */
public class b implements q {
    public static final BdUniqueId kvj = BdUniqueId.gen();
    private int aoN = 0;

    public void setReplyNum(int i) {
        this.aoN = i;
    }

    public int getReplyNum() {
        return this.aoN;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kvj;
    }
}
