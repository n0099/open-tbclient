package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fHS = BdUniqueId.gen();
    public static final BdUniqueId fHT = BdUniqueId.gen();
    public long fHU;
    public String fHV;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fHW = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fHT;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }
}
