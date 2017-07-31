package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fdT = BdUniqueId.gen();
    public int faD;
    public int faE;
    public int fdU;

    public h() {
    }

    public h(int i, int i2) {
        this.faD = i;
        this.faE = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fdT;
    }
}
