package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId fdb = BdUniqueId.gen();
    private int fdc = 0;

    public int aWS() {
        return this.fdc;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fdb;
    }
}
