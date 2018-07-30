package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fth = BdUniqueId.gen();
    public static final BdUniqueId fti = BdUniqueId.gen();
    public long ftj;
    public String ftk;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean ftl = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fti;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
