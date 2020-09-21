package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class b implements q {
    public static final BdUniqueId lcw = BdUniqueId.gen();
    private int aul = 0;

    public void setReplyNum(int i) {
        this.aul = i;
    }

    public int getReplyNum() {
        return this.aul;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lcw;
    }
}
