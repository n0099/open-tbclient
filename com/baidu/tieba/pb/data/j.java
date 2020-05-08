package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId joA = BdUniqueId.gen();
    public static final BdUniqueId joB = BdUniqueId.gen();
    public BdUniqueId Ty;
    public boolean isDynamic;
    public long joC;
    public String joD;
    public boolean isNew = true;
    public int sortType = 0;
    public String joE = "";
    public boolean joF = false;

    public j(BdUniqueId bdUniqueId) {
        this.Ty = joB;
        this.Ty = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.Ty;
    }
}
