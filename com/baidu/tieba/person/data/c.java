package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId eZe = BdUniqueId.gen();
    private int eZf = 0;

    public int aVe() {
        return this.eZf;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eZe;
    }
}
