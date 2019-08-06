package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hJe = BdUniqueId.gen();
    public static final BdUniqueId hJf = BdUniqueId.gen();
    public long hJg;
    public String hJh;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hJi = "";
    public boolean hJj = false;

    public i(BdUniqueId bdUniqueId) {
        this.mType = hJf;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
