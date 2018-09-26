package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fAN = BdUniqueId.gen();
    public static final BdUniqueId fAO = BdUniqueId.gen();
    public long fAP;
    public String fAQ;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String fAR = "";
    public boolean fAS = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fAO;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
