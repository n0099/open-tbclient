package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import java.util.List;
/* loaded from: classes21.dex */
public class k extends com.baidu.tieba.card.data.b implements q {
    public static BdUniqueId loy = BdUniqueId.gen();
    private List<c> loz;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return loy;
    }

    public void setData(List<c> list) {
        this.loz = list;
    }

    public List<c> getData() {
        return this.loz;
    }
}
