package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fEa = BdUniqueId.gen();
    public static final BdUniqueId fEb = BdUniqueId.gen();
    public long fEc;
    public String fEd;
    public BdUniqueId mType;
    public boolean btU = true;
    public boolean fEe = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = fEb;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }
}
