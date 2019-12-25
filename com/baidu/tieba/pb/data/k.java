package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ixe = BdUniqueId.gen();
    public static final BdUniqueId ixf = BdUniqueId.gen();
    public boolean isDynamic;
    public long ixg;
    public String ixh;
    public BdUniqueId zJ;
    public boolean isNew = true;
    public int sortType = 0;
    public String ixi = "";
    public boolean ixj = false;

    public k(BdUniqueId bdUniqueId) {
        this.zJ = ixf;
        this.zJ = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.zJ;
    }
}
