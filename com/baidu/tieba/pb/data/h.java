package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fHH = BdUniqueId.gen();
    public static final BdUniqueId fHI = BdUniqueId.gen();
    public long fHJ;
    public String fHK;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fHL = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fHI;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }
}
