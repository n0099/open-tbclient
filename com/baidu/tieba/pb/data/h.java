package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fIq = BdUniqueId.gen();
    public static final BdUniqueId fIr = BdUniqueId.gen();
    public long fIs;
    public String fIt;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fIu = "";
    public boolean fIv = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fIr;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
