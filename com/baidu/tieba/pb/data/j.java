package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eOS = BdUniqueId.gen();
    public static final BdUniqueId eOT = BdUniqueId.gen();
    public long eOU;
    public String eOV;
    public BdUniqueId mType;
    public boolean aFL = true;
    public boolean eOW = false;

    public j(BdUniqueId bdUniqueId) {
        this.mType = eOT;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mType;
    }
}
