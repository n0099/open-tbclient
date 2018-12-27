package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId gmv = BdUniqueId.gen();
    private int abj = 0;

    public void setReplyNum(int i) {
        this.abj = i;
    }

    public int getReplyNum() {
        return this.abj;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gmv;
    }
}
