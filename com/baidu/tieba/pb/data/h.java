package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fUu = BdUniqueId.gen();
    public static final BdUniqueId fUv = BdUniqueId.gen();
    public long fUw;
    public String fUx;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fUy = "";
    public boolean fUz = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fUv;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
