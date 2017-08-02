package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fiW = BdUniqueId.gen();
    public String avatar;
    public String bIY;
    public boolean bJf;
    public boolean bsZ;
    public String cTS;
    public String fiX;
    public int fiY;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fiW;
    }
}
