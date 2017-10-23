package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eyN = BdUniqueId.gen();
    public static final BdUniqueId eyO = BdUniqueId.gen();
    public long eyP;
    public BdUniqueId mType;
    public boolean aEt = true;
    public boolean eyQ = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eyO;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
