package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId fgi = BdUniqueId.gen();
    private int fgj = 0;

    public int aXF() {
        return this.fgj;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgi;
    }
}
