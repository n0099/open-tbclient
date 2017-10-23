package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId fam = BdUniqueId.gen();
    public com.baidu.tieba.personCenter.d.a fan;
    public int iconId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fam;
    }
}
