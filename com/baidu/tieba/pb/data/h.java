package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fHX = BdUniqueId.gen();
    public static final BdUniqueId fHY = BdUniqueId.gen();
    public long fHZ;
    public String fIa;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fIb = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fHY;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }
}
