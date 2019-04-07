package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class b implements m {
    public static final BdUniqueId hDq = BdUniqueId.gen();
    private int adA = 0;

    public void setReplyNum(int i) {
        this.adA = i;
    }

    public int getReplyNum() {
        return this.adA;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hDq;
    }
}
