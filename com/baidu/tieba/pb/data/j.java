package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iEq = BdUniqueId.gen();
    public static final BdUniqueId iEr = BdUniqueId.gen();
    public BdUniqueId Ag;
    public long iEs;
    public String iEt;
    public boolean isDynamic;
    public boolean isNew = true;
    public int sortType = 0;
    public String iEu = "";
    public boolean iEv = false;

    public j(BdUniqueId bdUniqueId) {
        this.Ag = iEr;
        this.Ag = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ag;
    }
}
