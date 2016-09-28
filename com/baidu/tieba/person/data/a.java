package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eDZ = BdUniqueId.gen();
    private int eEa = 0;

    public int aSD() {
        return this.eEa;
    }

    public void oS(int i) {
        this.eEa = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDZ;
    }
}
