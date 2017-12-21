package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class c implements f {
    public static final BdUniqueId frS = BdUniqueId.gen();
    private int frT = 0;

    public int aZZ() {
        return this.frT;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return frS;
    }
}
