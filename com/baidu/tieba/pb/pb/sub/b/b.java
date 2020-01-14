package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes7.dex */
public class b implements m {
    public static final BdUniqueId iVp = BdUniqueId.gen();
    private int RH = 0;

    public void setReplyNum(int i) {
        this.RH = i;
    }

    public int getReplyNum() {
        return this.RH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iVp;
    }
}
