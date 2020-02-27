package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iCB = BdUniqueId.gen();
    public static final BdUniqueId iCC = BdUniqueId.gen();
    public BdUniqueId Ag;
    public long iCD;
    public String iCE;
    public boolean isDynamic;
    public boolean isNew = true;
    public int sortType = 0;
    public String iCF = "";
    public boolean iCG = false;

    public j(BdUniqueId bdUniqueId) {
        this.Ag = iCC;
        this.Ag = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }
}
