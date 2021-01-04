package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes2.dex */
public class c implements n {
    public static final BdUniqueId mnW = BdUniqueId.gen();
    private int mnX = 0;

    public int dxX() {
        return this.mnX;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mnW;
    }
}
