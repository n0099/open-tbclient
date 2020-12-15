package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes24.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId mrP = BdUniqueId.gen();
    public String inT;
    public String inU;
    public boolean ioa;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mrP;
    }
}
