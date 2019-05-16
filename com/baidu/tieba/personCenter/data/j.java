package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId idX = BdUniqueId.gen();
    private List<c> idY;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return idX;
    }

    public void setData(List<c> list) {
        this.idY = list;
    }

    public List<c> getData() {
        return this.idY;
    }
}
