package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static BdUniqueId faq = BdUniqueId.gen();
    public UserData eyy;
    public int fam;
    public int fan;
    public int fao;
    public boolean fap;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return faq;
    }
}
