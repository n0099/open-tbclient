package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eCc = BdUniqueId.gen();
    private int eCd = 0;

    public int aRm() {
        return this.eCd;
    }

    public void oZ(int i) {
        this.eCd = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eCc;
    }
}
