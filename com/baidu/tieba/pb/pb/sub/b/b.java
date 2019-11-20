package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class b implements m {
    public static final BdUniqueId icv = BdUniqueId.gen();
    private int Li = 0;

    public void setReplyNum(int i) {
        this.Li = i;
    }

    public int getReplyNum() {
        return this.Li;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return icv;
    }
}
