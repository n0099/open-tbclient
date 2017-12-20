package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class c implements f {
    public static final BdUniqueId frN = BdUniqueId.gen();
    private int frO = 0;

    public int aZY() {
        return this.frO;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return frN;
    }
}
