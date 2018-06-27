package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fsV = BdUniqueId.gen();
    public static final BdUniqueId fsW = BdUniqueId.gen();
    public long fsX;
    public String fsY;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fsZ = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fsW;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
