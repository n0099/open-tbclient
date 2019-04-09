package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class b implements m {
    public static final BdUniqueId hDr = BdUniqueId.gen();
    private int adB = 0;

    public void setReplyNum(int i) {
        this.adB = i;
    }

    public int getReplyNum() {
        return this.adB;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hDr;
    }
}
