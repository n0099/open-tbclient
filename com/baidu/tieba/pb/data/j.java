package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eFF = BdUniqueId.gen();
    public static final BdUniqueId eFG = BdUniqueId.gen();
    public long eFH;
    public BdUniqueId mType;
    public boolean aFm = true;
    public boolean eFI = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eFG;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
