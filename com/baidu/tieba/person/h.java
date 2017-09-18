package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId feY = BdUniqueId.gen();
    public int aGX;
    public int fbJ;
    public int fbK;

    public h() {
    }

    public h(int i, int i2) {
        this.fbJ = i;
        this.fbK = i2;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return feY;
    }
}
