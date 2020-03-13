package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes9.dex */
public class b implements m {
    public static final BdUniqueId iWS = BdUniqueId.gen();
    private int Tq = 0;

    public void setReplyNum(int i) {
        this.Tq = i;
    }

    public int getReplyNum() {
        return this.Tq;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iWS;
    }
}
