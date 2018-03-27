package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public class c implements i {
    public static final BdUniqueId gir = BdUniqueId.gen();
    private int gis = 0;

    public int biB() {
        return this.gis;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gir;
    }
}
