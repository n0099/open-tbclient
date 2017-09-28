package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId ezb = BdUniqueId.gen();
    public static final BdUniqueId ezc = BdUniqueId.gen();
    public long ezd;
    public BdUniqueId mType;
    public boolean aEG = true;
    public boolean eze = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = ezc;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
