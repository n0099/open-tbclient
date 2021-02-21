package com.baidu.tieba.pb.pb.sub.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId miE = BdUniqueId.gen();
    private int iBA = 0;

    public void setReplyNum(int i) {
        this.iBA = i;
    }

    public int getReplyNum() {
        return this.iBA;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return miE;
    }
}
