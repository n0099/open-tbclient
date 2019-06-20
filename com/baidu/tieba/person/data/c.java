package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class c implements m {
    public static final BdUniqueId ict = BdUniqueId.gen();
    private int icu = 0;

    public int bYh() {
        return this.icu;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ict;
    }
}
