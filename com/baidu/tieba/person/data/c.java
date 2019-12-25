package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes6.dex */
public class c implements m {
    public static final BdUniqueId jbw = BdUniqueId.gen();
    private int jbx = 0;

    public int csv() {
        return this.jbx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jbw;
    }
}
