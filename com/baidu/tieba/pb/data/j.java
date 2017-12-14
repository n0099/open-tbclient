package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId ePV = BdUniqueId.gen();
    public static final BdUniqueId ePW = BdUniqueId.gen();
    public long ePX;
    public String ePY;
    public BdUniqueId mType;
    public boolean aFP = true;
    public boolean ePZ = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = ePW;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
