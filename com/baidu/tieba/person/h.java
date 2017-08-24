package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId ffO = BdUniqueId.gen();
    public int fcy;
    public int fcz;
    public int ffP;

    public h() {
    }

    public h(int i, int i2) {
        this.fcy = i;
        this.fcz = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ffO;
    }
}
