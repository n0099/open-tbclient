package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes7.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jgR = BdUniqueId.gen();
    private List<c> jgS;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgR;
    }

    public void setData(List<c> list) {
        this.jgS = list;
    }

    public List<c> getData() {
        return this.jgS;
    }
}
