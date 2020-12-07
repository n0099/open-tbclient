package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes24.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId mrJ = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String inR;
    public String inS;
    public boolean inY;
    public boolean isAttention;
    public boolean isHost;
    public String jLw;
    public int mrK;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrJ;
    }
}
