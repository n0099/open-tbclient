package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes4.dex */
public class c implements m {
    public static final BdUniqueId iiL = BdUniqueId.gen();
    private int iiM = 0;

    public int caW() {
        return this.iiM;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iiL;
    }
}
