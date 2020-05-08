package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jTO = BdUniqueId.gen();
    private List<c> jTP;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jTO;
    }

    public void setData(List<c> list) {
        this.jTP = list;
    }

    public List<c> getData() {
        return this.jTP;
    }
}
