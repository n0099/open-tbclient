package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iCP = BdUniqueId.gen();
    public static final BdUniqueId iCQ = BdUniqueId.gen();
    public BdUniqueId Ag;
    public long iCR;
    public String iCS;
    public boolean isDynamic;
    public boolean isNew = true;
    public int sortType = 0;
    public String iCT = "";
    public boolean iCU = false;

    public j(BdUniqueId bdUniqueId) {
        this.Ag = iCQ;
        this.Ag = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }
}
