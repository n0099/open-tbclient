package com.baidu.tieba.pb.pb.sub.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId mdO = BdUniqueId.gen();
    private int iAj = 0;

    public void setReplyNum(int i) {
        this.iAj = i;
    }

    public int getReplyNum() {
        return this.iAj;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mdO;
    }
}
