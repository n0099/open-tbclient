package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fQE = BdUniqueId.gen();
    public static final BdUniqueId fQF = BdUniqueId.gen();
    public long fQG;
    public String fQH;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fQI = "";
    public boolean fQJ = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fQF;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
