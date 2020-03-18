package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class b implements m {
    public static final BdUniqueId iYt = BdUniqueId.gen();
    private int TA = 0;

    public void setReplyNum(int i) {
        this.TA = i;
    }

    public int getReplyNum() {
        return this.TA;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iYt;
    }
}
