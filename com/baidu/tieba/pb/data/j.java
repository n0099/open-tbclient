package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fCA = BdUniqueId.gen();
    public static final BdUniqueId fCB = BdUniqueId.gen();
    public long fCC;
    public String fCD;
    public BdUniqueId mType;
    public boolean btL = true;
    public boolean fCE = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = fCB;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }
}
