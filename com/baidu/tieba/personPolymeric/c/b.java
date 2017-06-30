package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWv = BdUniqueId.gen();
    public String avatar;
    public String bEM;
    public boolean bET;
    public boolean boT;
    public String cLo;
    public String eWw;
    public int eWx;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eWv;
    }
}
