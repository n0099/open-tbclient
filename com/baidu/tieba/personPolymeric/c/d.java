package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId mBN = BdUniqueId.gen();
    public String iBE;
    public String iBF;
    public boolean iBL;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mBN;
    }
}
