package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class i implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hIQ = BdUniqueId.gen();
    public static final BdUniqueId hIR = BdUniqueId.gen();
    public long hIS;
    public String hIT;
    public BdUniqueId xl;
    public boolean isNew = true;
    public int sortType = 0;
    public String hIU = "";
    public boolean hIV = false;

    public i(BdUniqueId bdUniqueId) {
        this.xl = hIR;
        this.xl = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.xl;
    }
}
