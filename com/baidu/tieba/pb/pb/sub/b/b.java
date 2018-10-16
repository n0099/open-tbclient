package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId gbp = BdUniqueId.gen();
    private int abl = 0;

    public void setReplyNum(int i) {
        this.abl = i;
    }

    public int getReplyNum() {
        return this.abl;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gbp;
    }
}
