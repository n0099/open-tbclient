package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class b implements h {
    public static final BdUniqueId fTP = BdUniqueId.gen();
    private int WG = 0;

    public void setReplyNum(int i) {
        this.WG = i;
    }

    public int getReplyNum() {
        return this.WG;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTP;
    }
}
