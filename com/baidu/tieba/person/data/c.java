package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class c implements m {
    public static final BdUniqueId ikw = BdUniqueId.gen();
    private int ikx = 0;

    public int bZe() {
        return this.ikx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ikw;
    }
}
