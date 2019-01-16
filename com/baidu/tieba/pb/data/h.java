package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fUt = BdUniqueId.gen();
    public static final BdUniqueId fUu = BdUniqueId.gen();
    public long fUv;
    public String fUw;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fUx = "";
    public boolean fUy = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fUu;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
