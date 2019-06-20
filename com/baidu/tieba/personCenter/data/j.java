package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId ieb = BdUniqueId.gen();
    private List<c> iec;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ieb;
    }

    public void setData(List<c> list) {
        this.iec = list;
    }

    public List<c> getData() {
        return this.iec;
    }
}
