package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId flr = BdUniqueId.gen();
    public String avatar;
    public String bOC;
    public boolean bOJ;
    public boolean bwa;
    public String deN;
    public String fls;
    public int flt;
    public long forumId;
    public boolean isAttention;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return flr;
    }
}
