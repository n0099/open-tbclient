package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class h implements m {
    public static final BdUniqueId hkt = BdUniqueId.gen();
    public static final BdUniqueId hku = BdUniqueId.gen();
    public long hkv;
    public String hkw;
    public BdUniqueId mType;
    public boolean isNew = true;
    public int sortType = 0;
    public String hkx = "";
    public boolean hky = false;

    public h(BdUniqueId bdUniqueId) {
        this.mType = hku;
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType;
    }
}
