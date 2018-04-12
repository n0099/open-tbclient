package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public class d implements h {
    public static final BdUniqueId fCp = BdUniqueId.gen();
    public int aIp;
    public int fyH;
    public int fyI;

    public d() {
    }

    public d(int i, int i2) {
        this.fyH = i;
        this.fyI = i2;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCp;
    }
}
