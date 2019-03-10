package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class h implements m {
    public static final BdUniqueId hkH = BdUniqueId.gen();
    public static final BdUniqueId hkI = BdUniqueId.gen();
    public long hkJ;
    public String hkK;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hkL = "";
    public boolean hkM = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = hkI;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
