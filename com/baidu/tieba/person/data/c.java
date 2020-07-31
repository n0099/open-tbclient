package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes16.dex */
public class c implements q {
    public static final BdUniqueId kNM = BdUniqueId.gen();
    private int kNN = 0;

    public int cVv() {
        return this.kNN;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNM;
    }
}
