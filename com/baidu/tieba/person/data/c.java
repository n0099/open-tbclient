package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fhv = BdUniqueId.gen();
    private int fhw = 0;

    public int aYh() {
        return this.fhw;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhv;
    }
}
