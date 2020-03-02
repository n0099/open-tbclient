package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iCD = BdUniqueId.gen();
    public static final BdUniqueId iCE = BdUniqueId.gen();
    public BdUniqueId Ag;
    public long iCF;
    public String iCG;
    public boolean isDynamic;
    public boolean isNew = true;
    public int sortType = 0;
    public String iCH = "";
    public boolean iCI = false;

    public j(BdUniqueId bdUniqueId) {
        this.Ag = iCE;
        this.Ag = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }
}
