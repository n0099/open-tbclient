package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes9.dex */
public class k extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId kGC = BdUniqueId.gen();
    private List<c> kGD;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kGC;
    }

    public void setData(List<c> list) {
        this.kGD = list;
    }

    public List<c> getData() {
        return this.kGD;
    }
}
