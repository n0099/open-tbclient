package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class b implements m {
    public static final BdUniqueId hVr = BdUniqueId.gen();
    private int abo = 0;

    public void setReplyNum(int i) {
        this.abo = i;
    }

    public int getReplyNum() {
        return this.abo;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hVr;
    }
}
