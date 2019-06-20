package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hBY = BdUniqueId.gen();
    public static final BdUniqueId hBZ = BdUniqueId.gen();
    public long hCa;
    public String hCb;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hCc = "";
    public boolean hCd = false;

    public i(BdUniqueId bdUniqueId) {
        this.mType = hBZ;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
