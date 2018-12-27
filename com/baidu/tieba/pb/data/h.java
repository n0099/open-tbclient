package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fTw = BdUniqueId.gen();
    public static final BdUniqueId fTx = BdUniqueId.gen();
    public long fTy;
    public String fTz;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fTA = "";
    public boolean fTB = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fTx;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
