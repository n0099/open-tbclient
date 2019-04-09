package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class h implements m {
    public static final BdUniqueId hku = BdUniqueId.gen();
    public static final BdUniqueId hkv = BdUniqueId.gen();
    public long hkw;
    public String hkx;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hky = "";
    public boolean hkz = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = hkv;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
