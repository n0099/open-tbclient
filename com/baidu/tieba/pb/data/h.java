package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fdF = BdUniqueId.gen();
    public static final BdUniqueId fdG = BdUniqueId.gen();
    public long fdH;
    public String fdI;
    public BdUniqueId mType;
    public boolean isNew = true;
    public boolean fdJ = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = fdG;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType;
    }
}
