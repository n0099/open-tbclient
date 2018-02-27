package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpt = BdUniqueId.gen();
    public String avatar;
    public String daC;
    public String daD;
    public boolean daK;
    public long forumId;
    public String gpu;
    public int gpv;
    public boolean isAttention;
    public boolean isHost;
    public int postNum;
    public int sex;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpt;
    }
}
