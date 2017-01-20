package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class a implements v {
    public static final BdUniqueId eyg = BdUniqueId.gen();
    private int eyh = 0;

    public int aQz() {
        return this.eyh;
    }

    public void oZ(int i) {
        this.eyh = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eyg;
    }
}
