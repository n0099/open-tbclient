package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class j implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId fEv = BdUniqueId.gen();
    public static final BdUniqueId fEw = BdUniqueId.gen();
    public long fEx;
    public String fEy;
    public BdUniqueId mType;
    public boolean bud = true;
    public boolean fEz = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = fEw;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.mType;
    }
}
