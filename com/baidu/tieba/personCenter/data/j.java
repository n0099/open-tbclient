package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId ikr = BdUniqueId.gen();
    private List<c> iks;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ikr;
    }

    public void setData(List<c> list) {
        this.iks = list;
    }

    public List<c> getData() {
        return this.iks;
    }
}
