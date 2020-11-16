package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes23.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId mdD = BdUniqueId.gen();
    public String avatar;
    public long forumId;
    public String icT;
    public String icU;
    public boolean ida;
    public boolean isAttention;
    public boolean isHost;
    public String jxU;
    public int mdE;
    public int postNum;
    public int sex;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdD;
    }
}
