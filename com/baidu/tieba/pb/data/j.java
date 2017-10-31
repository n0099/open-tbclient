package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eGO = BdUniqueId.gen();
    public static final BdUniqueId eGP = BdUniqueId.gen();
    public long eGQ;
    public String eGR;
    public BdUniqueId mType;
    public boolean aFc = true;
    public boolean eGS = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eGP;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
