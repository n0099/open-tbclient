package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class c implements m {
    public static final BdUniqueId ilM = BdUniqueId.gen();
    private int ilN = 0;

    public int ccc() {
        return this.ilN;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ilM;
    }
}
