package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eEL = BdUniqueId.gen();
    public static final BdUniqueId eEM = BdUniqueId.gen();
    public long eEN;
    public BdUniqueId mType;
    public boolean aFp = true;
    public boolean eEO = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eEM;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
