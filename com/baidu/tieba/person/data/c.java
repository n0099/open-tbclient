package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class c implements i {
    public static final BdUniqueId ggD = BdUniqueId.gen();
    private int ggE = 0;

    public int bhr() {
        return this.ggE;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ggD;
    }
}
