package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId ime = BdUniqueId.gen();
    private List<c> imf;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ime;
    }

    public void setData(List<c> list) {
        this.imf = list;
    }

    public List<c> getData() {
        return this.imf;
    }
}
