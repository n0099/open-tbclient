package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eHi = BdUniqueId.gen();
    public static final BdUniqueId eHj = BdUniqueId.gen();
    public long eHk;
    public String eHl;
    public BdUniqueId mType;
    public boolean aFk = true;
    public boolean eHm = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eHj;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
