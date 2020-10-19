package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes22.dex */
public class k extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId lDL = BdUniqueId.gen();
    private List<c> lDM;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lDL;
    }

    public void setData(List<c> list) {
        this.lDM = list;
    }

    public List<c> getData() {
        return this.lDM;
    }
}
