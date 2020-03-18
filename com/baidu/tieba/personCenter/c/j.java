package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jjy = BdUniqueId.gen();
    private List<c> jjz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jjy;
    }

    public void setData(List<c> list) {
        this.jjz = list;
    }

    public List<c> getData() {
        return this.jjz;
    }
}
