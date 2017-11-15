package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fjb = BdUniqueId.gen();
    public com.baidu.tieba.personCenter.c.a fjc;
    public int iconId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fjb;
    }
}
