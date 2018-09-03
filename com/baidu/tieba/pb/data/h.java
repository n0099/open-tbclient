package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fta = BdUniqueId.gen();
    public static final BdUniqueId ftb = BdUniqueId.gen();
    public long ftc;
    public String ftd;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fte = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = ftb;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
