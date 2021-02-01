package com.baidu.tieba.pb.pb.sub.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class b implements n {
    public static final BdUniqueId mip = BdUniqueId.gen();
    private int iBm = 0;

    public void setReplyNum(int i) {
        this.iBm = i;
    }

    public int getReplyNum() {
        return this.iBm;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mip;
    }
}
