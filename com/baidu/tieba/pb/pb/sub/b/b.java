package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes6.dex */
public class b implements m {
    public static final BdUniqueId iRH = BdUniqueId.gen();
    private int RE = 0;

    public void setReplyNum(int i) {
        this.RE = i;
    }

    public int getReplyNum() {
        return this.RE;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iRH;
    }
}
