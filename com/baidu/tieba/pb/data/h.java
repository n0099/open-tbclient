package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fIp = BdUniqueId.gen();
    public static final BdUniqueId fIq = BdUniqueId.gen();
    public long fIr;
    public String fIs;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fIt = "";
    public boolean fIu = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fIq;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
