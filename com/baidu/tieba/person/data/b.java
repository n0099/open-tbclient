package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId ehL = BdUniqueId.gen();
    private int ehM = 0;

    public int aLa() {
        return this.ehM;
    }

    public void nV(int i) {
        this.ehM = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ehL;
    }
}
