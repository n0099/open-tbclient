package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jdj = BdUniqueId.gen();
    private List<c> jdk;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jdj;
    }

    public void setData(List<c> list) {
        this.jdk = list;
    }

    public List<c> getData() {
        return this.jdk;
    }
}
