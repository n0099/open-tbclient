package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId irI = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int irJ;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return irI;
    }
}
