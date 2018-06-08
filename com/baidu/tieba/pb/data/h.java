package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fpb = BdUniqueId.gen();
    public static final BdUniqueId fpc = BdUniqueId.gen();
    public long fpd;
    public String fpe;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fpf = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fpc;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
