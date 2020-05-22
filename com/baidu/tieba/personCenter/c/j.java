package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.card.data.b implements o {
    public static BdUniqueId klF = BdUniqueId.gen();
    private List<c> klG;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return klF;
    }

    public void setData(List<c> list) {
        this.klG = list;
    }

    public List<c> getData() {
        return this.klG;
    }
}
