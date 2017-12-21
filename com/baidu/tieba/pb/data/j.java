package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eQa = BdUniqueId.gen();
    public static final BdUniqueId eQb = BdUniqueId.gen();
    public long eQc;
    public String eQd;
    public BdUniqueId mType;
    public boolean aFS = true;
    public boolean eQe = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eQb;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
