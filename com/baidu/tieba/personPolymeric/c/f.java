package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes18.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kWL = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String forumName;
    public int kWM;
    public int sex;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kWL;
    }
}
