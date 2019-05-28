package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hBX = BdUniqueId.gen();
    public static final BdUniqueId hBY = BdUniqueId.gen();
    public long hBZ;
    public String hCa;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hCb = "";
    public boolean hCc = false;

    public i(BdUniqueId bdUniqueId) {
        this.mType = hBY;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
