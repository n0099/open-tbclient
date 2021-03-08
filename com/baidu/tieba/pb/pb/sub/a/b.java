package com.baidu.tieba.pb.pb.sub.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId mkG = BdUniqueId.gen();
    private int iDj = 0;

    public void setReplyNum(int i) {
        this.iDj = i;
    }

    public int getReplyNum() {
        return this.iDj;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mkG;
    }
}
