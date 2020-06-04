package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.card.data.b implements o {
    public static BdUniqueId kmL = BdUniqueId.gen();
    private List<c> kmM;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kmL;
    }

    public void setData(List<c> list) {
        this.kmM = list;
    }

    public List<c> getData() {
        return this.kmM;
    }
}
