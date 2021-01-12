package com.baidu.tieba.pb.pb.sub.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId lZh = BdUniqueId.gen();
    private int ivC = 0;

    public void setReplyNum(int i) {
        this.ivC = i;
    }

    public int getReplyNum() {
        return this.ivC;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lZh;
    }
}
