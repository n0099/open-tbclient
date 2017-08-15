package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId ffM = BdUniqueId.gen();
    public int fcw;
    public int fcx;
    public int ffN;

    public h() {
    }

    public h(int i, int i2) {
        this.fcw = i;
        this.fcx = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ffM;
    }
}
