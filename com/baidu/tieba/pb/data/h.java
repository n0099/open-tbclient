package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fcB = BdUniqueId.gen();
    public static final BdUniqueId fcC = BdUniqueId.gen();
    public long fcD;
    public String fcE;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fcF = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fcC;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
