package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes5.dex */
public class c implements h {
    public static final BdUniqueId gik = BdUniqueId.gen();
    private int gil = 0;

    public int bni() {
        return this.gil;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gik;
    }
}
