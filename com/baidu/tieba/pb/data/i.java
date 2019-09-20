package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hLb = BdUniqueId.gen();
    public static final BdUniqueId hLc = BdUniqueId.gen();
    public long hLd;
    public String hLe;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hLf = "";
    public boolean hLg = false;

    public i(BdUniqueId bdUniqueId) {
        this.mType = hLc;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
