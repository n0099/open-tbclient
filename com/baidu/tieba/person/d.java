package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public class d implements m {
    public static final BdUniqueId jfT = BdUniqueId.gen();
    public int backgroundId;
    public int jcZ;
    public int jda;

    public d() {
    }

    public d(int i, int i2) {
        this.jcZ = i;
        this.jda = i2;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfT;
    }
}
