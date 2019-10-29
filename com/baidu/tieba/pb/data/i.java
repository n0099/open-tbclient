package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hJH = BdUniqueId.gen();
    public static final BdUniqueId hJI = BdUniqueId.gen();
    public long hJJ;
    public String hJK;
    public BdUniqueId xL;
    public boolean isNew = true;
    public int sortType = 0;
    public String hJL = "";
    public boolean hJM = false;

    public i(BdUniqueId bdUniqueId) {
        this.xL = hJI;
        this.xL = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.xL;
    }
}
