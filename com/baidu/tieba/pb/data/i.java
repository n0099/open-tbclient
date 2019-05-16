package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hBU = BdUniqueId.gen();
    public static final BdUniqueId hBV = BdUniqueId.gen();
    public long hBW;
    public String hBX;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hBY = "";
    public boolean hBZ = false;

    public i(BdUniqueId bdUniqueId) {
        this.mType = hBV;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
