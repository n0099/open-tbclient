package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eBG = BdUniqueId.gen();
    private int eBH = 0;

    public int aQc() {
        return this.eBH;
    }

    public void oV(int i) {
        this.eBH = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eBG;
    }
}
