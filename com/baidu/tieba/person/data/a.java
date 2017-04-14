package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId ezM = BdUniqueId.gen();
    private int ezN = 0;

    public int aQl() {
        return this.ezN;
    }

    public void oT(int i) {
        this.ezN = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ezM;
    }
}
