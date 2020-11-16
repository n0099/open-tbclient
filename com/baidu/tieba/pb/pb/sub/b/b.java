package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes21.dex */
public class b implements q {
    public static final BdUniqueId lKA = BdUniqueId.gen();
    private int icP = 0;

    public void setReplyNum(int i) {
        this.icP = i;
    }

    public int getReplyNum() {
        return this.icP;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lKA;
    }
}
