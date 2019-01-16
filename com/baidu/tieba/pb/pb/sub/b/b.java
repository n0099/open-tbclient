package com.baidu.tieba.pb.pb.sub.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId gny = BdUniqueId.gen();
    private int abt = 0;

    public void setReplyNum(int i) {
        this.abt = i;
    }

    public int getReplyNum() {
        return this.abt;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gny;
    }
}
