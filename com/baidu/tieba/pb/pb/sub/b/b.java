package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class b implements q {
    public static final BdUniqueId kEc = BdUniqueId.gen();
    private int aoJ = 0;

    public void setReplyNum(int i) {
        this.aoJ = i;
    }

    public int getReplyNum() {
        return this.aoJ;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kEc;
    }
}
