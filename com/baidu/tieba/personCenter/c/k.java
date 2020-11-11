package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class k extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId lWd = BdUniqueId.gen();
    private List<c> lWe;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lWd;
    }

    public void setData(List<c> list) {
        this.lWe = list;
    }

    public List<c> getData() {
        return this.lWe;
    }
}
