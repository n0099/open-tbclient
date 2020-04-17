package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kaG = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String gtk;
    public String gtl;
    public boolean gtr;
    public boolean isAttention;
    public boolean isHost;
    public String kaH;
    public int kaI;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kaG;
    }
}
