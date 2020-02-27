package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jhK = BdUniqueId.gen();
    private List<c> jhL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhK;
    }

    public void setData(List<c> list) {
        this.jhL = list;
    }

    public List<c> getData() {
        return this.jhL;
    }
}
