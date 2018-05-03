package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fcy = BdUniqueId.gen();
    public static final BdUniqueId fcz = BdUniqueId.gen();
    public long fcA;
    public String fcB;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fcC = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fcz;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
