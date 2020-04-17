package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jow = BdUniqueId.gen();
    public static final BdUniqueId jox = BdUniqueId.gen();
    public BdUniqueId Tv;
    public boolean isDynamic;
    public long joy;
    public String joz;
    public boolean isNew = true;
    public int sortType = 0;
    public String joA = "";
    public boolean joB = false;

    public j(BdUniqueId bdUniqueId) {
        this.Tv = jox;
        this.Tv = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Tv;
    }
}
