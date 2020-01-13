package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes7.dex */
public class c implements m {
    public static final BdUniqueId jeZ = BdUniqueId.gen();
    private int jfa = 0;

    public int ctC() {
        return this.jfa;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jeZ;
    }
}
