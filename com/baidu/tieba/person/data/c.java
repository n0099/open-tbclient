package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eZs = BdUniqueId.gen();
    private int eZt = 0;

    public int aVj() {
        return this.eZt;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZs;
    }
}
