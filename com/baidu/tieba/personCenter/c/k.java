package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes16.dex */
public class k extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId kPD = BdUniqueId.gen();
    private List<c> kPE;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kPD;
    }

    public void setData(List<c> list) {
        this.kPE = list;
    }

    public List<c> getData() {
        return this.kPE;
    }
}
