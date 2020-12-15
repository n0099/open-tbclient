package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes22.dex */
public class c implements q {
    public static final BdUniqueId miO = BdUniqueId.gen();
    private int miP = 0;

    public int dyi() {
        return this.miP;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return miO;
    }
}
