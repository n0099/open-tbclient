package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class c implements n {
    public static final BdUniqueId mjr = BdUniqueId.gen();
    private int mjs = 0;

    public int dug() {
        return this.mjs;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mjr;
    }
}
