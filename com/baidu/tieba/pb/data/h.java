package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fJO = BdUniqueId.gen();
    public static final BdUniqueId fJP = BdUniqueId.gen();
    public long fJQ;
    public String fJR;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fJS = "";
    public boolean fJT = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fJP;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
