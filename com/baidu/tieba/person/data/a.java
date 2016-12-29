package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eon = BdUniqueId.gen();
    private int eoo = 0;

    public int aOz() {
        return this.eoo;
    }

    public void oh(int i) {
        this.eoo = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eon;
    }
}
