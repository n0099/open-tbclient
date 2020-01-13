package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iAI = BdUniqueId.gen();
    public static final BdUniqueId iAJ = BdUniqueId.gen();
    public long iAK;
    public String iAL;
    public boolean isDynamic;
    public BdUniqueId zN;
    public boolean isNew = true;
    public int sortType = 0;
    public String iAM = "";
    public boolean iAN = false;

    public k(BdUniqueId bdUniqueId) {
        this.zN = iAJ;
        this.zN = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.zN;
    }
}
