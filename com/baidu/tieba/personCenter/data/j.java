package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes7.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jgM = BdUniqueId.gen();
    private List<c> jgN;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgM;
    }

    public void setData(List<c> list) {
        this.jgN = list;
    }

    public List<c> getData() {
        return this.jgN;
    }
}
