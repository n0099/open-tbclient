package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class b implements m {
    public static final BdUniqueId hDE = BdUniqueId.gen();
    private int adv = 0;

    public void setReplyNum(int i) {
        this.adv = i;
    }

    public int getReplyNum() {
        return this.adv;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hDE;
    }
}
