package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fhR = BdUniqueId.gen();
    private int fhS = 0;

    public int aYp() {
        return this.fhS;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fhR;
    }
}
